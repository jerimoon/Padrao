package br.gov.al.itec.apresentacao.relatorio;

import static br.gov.al.itec.util.Utilidades.string2Boolean;
import static br.gov.al.itec.util.Utilidades.string2Timestamp;
import static br.gov.al.itec.util.Utilidades.string2double;
import static br.gov.al.itec.util.Utilidades.string2long;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;

import org.hibernate.Session;

import br.gov.al.itec.acesso.entidade.ParametroRelatorio;
import br.gov.al.itec.acesso.entidade.Relatorio;
import br.gov.al.itec.negocio.Fachada;
import br.gov.al.itec.web.session.SessionFilter;
import br.gov.al.itec.web.session.WebUtils;

public class ServletJasper extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7935959425253207857L;

	/**
	 * executa um relatorio passado como argumento e uma lista de parametros
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	
	protected void executeRelatorio(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// obtendo a fachada do sistema
		String chave;
		Map<String, String> mapaParametro = new HashMap<String, String>(); 
		@SuppressWarnings("unchecked")
		Enumeration<String> enumChave = (Enumeration<String>)request.getParameterNames();
		while (enumChave.hasMoreElements()) {
			chave = (String) enumChave.nextElement();
			mapaParametro.put(chave, request.getParameter(chave));
		}

		imprimirListaRelatorio(response, mapaParametro);
	}

	private void imprimirListaRelatorio(HttpServletResponse response, Map<String,String> mapParametroRequest) throws Exception
	{

		Relatorio relatorio = getFachada().obterRelatorio(mapParametroRequest.get("nomeRelatorio"));
		ParametroRelatorio parametro;
		HashMap<String,Object> mapaParametro = new HashMap<String,Object>(); 
		for (Iterator<ParametroRelatorio> iterator = relatorio.getListaParametro().iterator(); iterator.hasNext();) {
			parametro = iterator.next();
			mapaParametro.put(parametro.getNomeParametro(), getValorParametro(parametro, mapParametroRequest));
		}
		mapaParametro.put("nomeEmpresa",mapParametroRequest.get("nomeEmpresa"));
		mapaParametro.put("nomeUsuario",mapParametroRequest.get("nomeUsuario"));
		mapaParametro.put("nomeRelatorio",relatorio.getNomeArquivo().substring(0, relatorio.getNomeArquivo().lastIndexOf('.')));
		mapaParametro.put("rodapeRelatorio",mapParametroRequest.get("nomeUsuario"));
		
		Map<String,Object > map =  SessionFilter.getThreadLocal().get();
		Session session =(Session) map.get("session");
	   
	    InputStream reportTemplateInputStream = this.getClass().getResourceAsStream("/"+relatorio.getNomeArquivo());
	    byte[] bytes = JasperRunManager.runReportToPdf(reportTemplateInputStream, mapaParametro, session.connection());   
		    
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);    
        ServletOutputStream ouputStream = response.getOutputStream();    
        ouputStream.write(bytes, 0, bytes.length);    
        ouputStream.flush();    
        ouputStream.close(); 
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try
		{
			executeRelatorio(request, response);
		}
		catch (Exception e)
		{
			e.printStackTrace(response.getWriter());
			new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
	private Fachada getFachada(){
		return WebUtils.getFachada(getServletContext());
		
	}
	private Object getValorParametro(ParametroRelatorio parametro, Map<String,String> mapValores){
		Object retorno = null;
		if ("D".equals(parametro.getTipoParametro())){
			retorno = string2Timestamp(mapValores.get(parametro.getNomeParametro()), parametro.getMascaraParametro());
		}else if ("I".equals(parametro.getTipoParametro())){
			retorno = string2long(mapValores.get(parametro.getNomeParametro()));
		}else if ("R".equals(parametro.getTipoParametro())){
			retorno = string2double(mapValores.get(parametro.getNomeParametro()));
		}else if ("B".equals(parametro.getTipoParametro())){
			retorno = string2Boolean(mapValores.get(parametro.getNomeParametro()));
		}
		
		else{
			retorno = mapValores.get(parametro.getNomeParametro());
		}
		return retorno;
	}

}
