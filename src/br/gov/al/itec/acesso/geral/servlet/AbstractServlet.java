package br.gov.al.itec.acesso.geral.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.FlushMode;
import org.hibernate.Session;

import br.gov.al.itec.negocio.Fachada;
import br.gov.al.itec.util.repositorio.SingleSessionHibernateTemplate;
import br.gov.al.itec.web.session.SessionFilter;
import br.gov.al.itec.web.session.WebUtils;

public abstract class AbstractServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7233581758972228727L;
	private HttpServletRequest request;
	private static final String USUARIO_LOGADO = "usuarioLogado";
	private static final String UNIDADE_ADMINISTRATIVA_LOGADA = "unidadeAdministrativaLogada";


	public AbstractServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,			IOException {
				doPost(request, response);
			}
	
	final protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,			IOException {
		setRequest(request);
		
		executa(request, response);
	}
	public Fachada getFachada() {
		return WebUtils.getFachada(getServletContext());
	}
	public SingleSessionHibernateTemplate getHibernateTemplate(){
		Map<String,Object > map =  SessionFilter.getThreadLocal().get();
		Session session = (Session)map.get("session");
		session.setFlushMode(FlushMode.NEVER);
		return new SingleSessionHibernateTemplate(session);
	}
	abstract protected void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException,			IOException;

	public HttpServletRequest getRequest() {
		return request;
	}

	private void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	/**
	 * Método para retornar a unidade Administrativa no sistema
	 */
	
	final public HttpSession getSession() {
		return getRequest().getSession();
	}

}