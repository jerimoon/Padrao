
package br.gov.al.itec.relatorio;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.springframework.web.context.WebApplicationContext;

import br.gov.al.itec.acesso.geral.servlet.AbstractServlet;
import br.gov.al.itec.util.Utilidades;

public class RelatorioServlet extends AbstractServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 427408396012965768L;
	private static final String CONTENT_TYPE_PDF = "application/pdf";
	private static final String SUB_REPORT = "SUBREPORT_DIR";
	private static final String DIR_RELATORIO = "WEB-INF/relatorios/";
	private static final String EXT_RELATORIO = ".jasper";
	private static final String NOME_RELATORIO = "nomeRelatorio";
	private static final String CAMINHO_IMAGENS = "caminhoImagens";
	
	private static final Logger LOG = Logger.getLogger(RelatorioServlet.class
			.getName());
	
	protected void executa(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		try {
			/*
			 * Define que o conteúdo de resposta será um arquivo PDF.
			 */
			response.setContentType(CONTENT_TYPE_PDF);
			/*
			 * Obter o arquivo de relatório conforme o nome passado como
			 * parâmetro.
			 */
			String nomeRelatorio = request.getServletPath().replace(".rep", "").replace("/", "");
			String lArquivoRelatorio = getServletContext().getRealPath(DIR_RELATORIO + nomeRelatorio+EXT_RELATORIO);
			
			/*
			 * Verificar se o arquivo existe e executar o mesmo.
			 */
			
			File lArquivo = new File(lArquivoRelatorio);
			if (lArquivo.exists()) {
				/*
				 * Criar lista de parametros para que seja passado ao relatório.
				 */
				Map<String, Object> parameters = new HashMap<String, Object>();
				String lURLImg = getURLImg(request, null);
				parameters.put(CAMINHO_IMAGENS, lURLImg);
				parameters.put(JRParameter.REPORT_LOCALE, new Locale("pt","BR"));

				parameters.put(NOME_RELATORIO, nomeRelatorio);
				String[] arrayProventos =request.getParameterValues("listaProventoSelecionado");
				String numeroGrupo =request.getParameter("numeroGrupo");
				if((!Utilidades.isEmpty(numeroGrupo))&&Utilidades.isLong(numeroGrupo)){
					
					parameters.put("numeroGrupo", numeroGrupo);
				}else {
					
					parameters.put("numeroGrupo", " COALESCE(FU.NR_GRUPO,0) ");
				}
				String numeroLote =request.getParameter("numeroLote");
				if((!Utilidades.isEmpty(numeroLote))&&Utilidades.isLong(numeroLote)){
					
					parameters.put("numeroLote", numeroLote);
				}else {
					
					parameters.put("numeroLote", " F.NR_LOTE ");
				}
				StringBuffer listaProventoSelecionado =new StringBuffer("null");
				String antes=",";
				for (int i = 0; i < arrayProventos.length; i++) {
					listaProventoSelecionado.append(antes);	
					listaProventoSelecionado.append(arrayProventos[i]);	
				}
				
				
				
				parameters.put("listaProventoSelecionado", listaProventoSelecionado.toString());
				
				
				parameters.put(SUB_REPORT, getServletContext().getRealPath(DIR_RELATORIO)+"/");
				
				/*
				 * Cria o input stream para ler o arquivo.
				 */
				FileInputStream fileOutputStream = new FileInputStream(lArquivo);
				Connection connection = null;
				try {
					/*
					 * Renderiza o relatório Jasper.
					 */
					connection = getDataSource().getConnection();
					 String headerKey = "Content-Disposition";
				    String headerValue = String.format("attachment; filename=%s.pdf", nomeRelatorio);
				    response.setHeader(headerKey, headerValue);
					JasperPrint jasperPrint = JasperFillManager.fillReport(
							fileOutputStream, parameters, connection);
					/*
					 * Exporta os bytes do relatório para a requisição
					 * proveniente do Python.
					 */
					JasperExportManager.exportReportToPdfStream(jasperPrint,
							response.getOutputStream());
				} finally {
					/*
					 * Fechar a conexao com o banco de dados.
					 */
					if ((connection != null) && (!connection.isClosed())) {
						connection.close();
					}
					/*
					 * Fechar o stream de envio dos bytes do arquivo de
					 * relatório.
					 */
					fileOutputStream.close();
				}
			} else {
				/*
				 * Arquivo nao existe. Exibir mensagem de erro.
				 */
				response.sendRedirect(request.getContextPath()+"/erro/arquivoNaoExiste.html");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	private boolean hasValue(String pValue) {
		if (pValue != null) {
			return !pValue.trim().equals("");
		} else {
			return false;
		}
	}

	private String getURLImg(HttpServletRequest pRequest, String caminho) {
		StringBuilder lURL = new StringBuilder();
		lURL.append("http://");
		lURL.append(pRequest.getServerName());
		lURL.append(":");
		lURL.append(pRequest.getServerPort());
		lURL.append(pRequest.getContextPath());
		if(caminho == null){
			lURL.append("/geral/img/admin/");
		}else{
			lURL.append("/"+caminho+"/");
			}
		return lURL.toString();
	}
	public DataSource getDataSource(){
		WebApplicationContext context =
			(WebApplicationContext)	getServletContext().
		getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		
		DataSource dataSource = (DataSource) context.getBean("dataSource");
			
		return dataSource;
	}
}
