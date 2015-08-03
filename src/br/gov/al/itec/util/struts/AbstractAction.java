package br.gov.al.itec.util.struts;

import static br.gov.al.itec.util.Utilidades.dynamicConversion;
import static br.gov.al.itec.util.Utilidades.hasAttribute;
import static br.gov.al.itec.util.Utilidades.isEmpty;
import static br.gov.al.itec.util.Utilidades.isField;
import static br.gov.al.itec.util.Utilidades.string2Timestamp;
import static br.gov.al.itec.util.Utilidades.string2long;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.gov.al.itec.controle.PermissaoException;
import br.gov.al.itec.controle.ValidacaoException;
import br.gov.al.itec.negocio.Fachada;
import br.gov.al.itec.util.Entidade;
import br.gov.al.itec.web.PesquisaBaseActionForm;
import br.gov.al.itec.web.PesquisaIntervaloActionForm;
import br.gov.al.itec.web.session.WebUtils;


public abstract class AbstractAction extends DispatchAction{
	private static final String USUARIO_SEM_PERMISSAO_PARA_ACESSAR_ESTA_FUNCIONALIDADE = "Usuário sem permissão para acessar esta funcionalidade.";
	private static final String USUARIO_SEM_PERMISSAO_DE_ALTERACAO_NESTA_TELA = "Usuário sem permissão de alteração nesta tela.";
	public static final String PERMISSAO_ESCRITA = "permissaoEscrita";
	public static final String SERVIDOR_PRODUCAO = "servidorProducao";
	public final  static String ALTERAR = "ALTERAR";
	public final  static String SELECIONAR = "SELECIONAR";
	public final  static String VAZIO = "";
	public static final String USUARIO_LOGADO = "usuarioLogado";
	public static final String UNIDADE_ADMINISTRATIVA_LOGADA = "unidadeAdministrativaLogada";
	
	protected static final String LISTA_MENSAGENS = "listaMensagens";
	protected static final String MAPA_PERMISSOES = "mapaPermissoes";
	protected static final String ERRO_AUTENTICACAO = "erroAutenticacao";
	protected static final String MENSAGEM_SALVO_SUCESSO = "Registro salvo com sucesso";
	protected static final String SESSAO_EXPIRADA_EFETUE_UM_NOVO_LOGON = "Sessão Expirada, efetue um novo logon.";
	
	private static final String ATRIBUTO_ATIVO = "ativo";
	private static final String LISTA_ERROS = "listaErros";
	private HttpServletRequest request;
	private boolean permissaoAlterar=false;
	
	/**
	 * Métotodo responsável por executar todas as requisições struts. 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		setRequest(request);
		
		try {
			//Caso seja o action de autenticação então não deve dar mensagem de Sessão Expirada
			
			ActionForward retorno = super.execute(mapping, form, request, response);
			return retorno;
			
		} catch (Exception e){
			request.setAttribute("exception", e);
			e.printStackTrace();
			return mapping.findForward("erroGeral");
		}
	}
	
	public Fachada getFachada() {
		return WebUtils.getFachada(getServlet().getServletContext());
	}
	
	public String getNomeServidorProducao() {
		return WebUtils.getNomeServidorProducao(getServlet().getServletContext());
	}
	
	public HttpSession getSession() {
		return getRequest().getSession();
	}

	public HttpServletRequest getRequest() {
		return request;
	}
	
	public boolean isPermissaoAlterar() {
		return permissaoAlterar;
	}

	
	/**
	 * Salva as mensagens no request para que sejam recuparadas no JSP
	 * @param listaMensagem
	 */
	protected void salvaMensagens(List<String> listaMensagem) {
		getRequest().setAttribute(LISTA_MENSAGENS,listaMensagem);
	}
	
	protected void salvaErros(List<String> listaMensagem) {
		getRequest().setAttribute(LISTA_ERROS,listaMensagem);
	}
	/**
	 * Atribui uma lista de registros ao request, com base na entidade informada
	 * @param request
	 * @param nomeLista
	 * @param clazz
	 * @param ordem
	 */
	protected void setListaAtribbute(HttpServletRequest request, String nomeLista, Class<? extends Entidade> clazz,String ordem) {
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		if(isField(clazz, ATRIBUTO_ATIVO)){
			criteria.add(Restrictions.eq(ATRIBUTO_ATIVO, true));
		}
		
		if(ordem!=null){ 
			criteria.addOrder(Order.asc(ordem));
		}
		request.setAttribute(nomeLista, getFachada().obterListaEntidade(criteria));
	}
	
	protected void setListaAtribbute(HttpServletRequest request, String nomeLista, Class<? extends Entidade> clazz) {
		setListaAtribbute(request, nomeLista, clazz, null);
	}
	
	
	
	private void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	
}
