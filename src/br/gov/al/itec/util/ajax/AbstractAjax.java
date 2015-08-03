package br.gov.al.itec.util.ajax;

import static br.gov.al.itec.util.Utilidades.isEmpty;
import static br.gov.al.itec.util.Utilidades.string2long;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sourceforge.ajaxtags.struts.BaseAjaxAction;
import net.sourceforge.ajaxtags.xml.AjaxXmlBuilder;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.gov.al.itec.negocio.Fachada;
import br.gov.al.itec.util.Entidade;
import br.gov.al.itec.util.struts.AbstractAction;
import br.gov.al.itec.web.session.WebUtils;


public abstract  class AbstractAjax extends BaseAjaxAction{


	private HttpServletRequest request;
	private String SEPARADOR_VALORES = ";";
	protected Fachada getFachada(){
		
		return WebUtils.getFachada(getServlet().getServletContext());
		
	}
	private final String getMethod(
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		Object newTarget = null;
			String localProperty = request.getParameter("acao");
			setRequest(request);
			if(isUsuarioLogado()){
				newTarget = this.getClass().getMethod(localProperty, new Class[] {HttpServletRequest.class,HttpServletResponse.class}).invoke(this, new Object[] {request,response});
			}
			return (String)newTarget;
	
	}
	
	@Override
	public String getXmlContent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try{
			return getMethod(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
			AjaxXmlBuilder ajax = new AjaxXmlBuilder();
			ajax.addItem("-1", e.getMessage());
			return ajax.toString();
		}
	}
	
	protected DetachedCriteria preparaCriteria(
			Class<? extends Entidade> classe, String atributoPesquisa,
			String valor, String atributoOrdenacao) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(classe);
			if (!isEmpty(atributoPesquisa)) {
				// Quando tem "#", então trata-se de uma propriedade de uma
				String[] alias = atributoPesquisa.split("#");
				// associação
				if (!isEmpty(valor)||(alias.length > 1)) {
					if (alias.length > 1) {
						detachedCriteria.createAlias(alias[0], "alias");
						detachedCriteria.add(Restrictions.eq(alias[1], string2long( valor)));
					} else {
						detachedCriteria.add(Restrictions.like(atributoPesquisa,
								valor.toUpperCase()+"%"));
					}
				}

			}
			if (!isEmpty(atributoOrdenacao)) {
				detachedCriteria.addOrder(Order
						.asc(atributoOrdenacao));
			}
		/*}*/
		return detachedCriteria;

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
	protected boolean isUsuarioLogado(){
		return true;
	}
	

	protected String montaValoresRetorno(String ...valores){
		String retorno = valores[0];
		for (int i = 1; i < valores.length; i++) {
			
			retorno +=SEPARADOR_VALORES+valores[i];
		}
		return retorno;
	}

}