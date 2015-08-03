package br.gov.al.itec.util.struts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.gov.al.itec.negocio.Fachada;
import br.gov.al.itec.web.session.WebUtils;


public abstract class AbstractFreeAction extends DispatchAction{
	protected static final String LISTA_MENSAGENS = "listaMensagens";
	private static final String LISTA_ERROS = "listaErros";
	protected static final String USUARIO_LOGADO = "usuarioLogado";
	protected static final String ERRO_AUTENTICACAO = "erroAutenticacao";
	private HttpServletRequest request;
	protected static final String UNIDADE_ADMINISTRATIVA_LOGADA = "unidadeAdministrativaLogada";
	/**
	 * Métotodo responsável por executar todas as requisições struts. 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		setRequest(request);
		try{
			
			ActionForward retorno = super.execute(mapping, form, request, response);
			return retorno;
			

		}
		catch (Exception e){
			request.setAttribute("exception", e);
			e.printStackTrace();
			return mapping.findForward("erroGeral");
		}
	}

	

	
	protected void salvaMensagens(List<String> listaMensagem){
		getRequest().setAttribute(LISTA_MENSAGENS,listaMensagem);
	}
	protected void salvaErros(List<String> listaMensagem){
		getRequest().setAttribute(LISTA_ERROS,listaMensagem);
	}

	



	public Fachada getFachada(){
		return WebUtils.getFachada(getServlet().getServletContext());
	}


	public HttpServletRequest getRequest() {
		return request;
	}
	private void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	
	

 
	
	
}
