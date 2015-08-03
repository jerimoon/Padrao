package br.gov.al.itec.acesso.entidade;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.gov.al.itec.scf.veiculo.struts.RelatorioActionForm;
import br.gov.al.itec.util.Utilidades;
import br.gov.al.itec.util.struts.AbstractAction;

public class InicioAction extends AbstractAction {

	private static final String CARREGAR = "carregar";
	/**
	 * Ação que efetua a autenticação do usuário
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward entrar(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
				return actionMapping.findForward(CARREGAR);
	}
	
	public ActionForward salvarParametros(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		RelatorioActionForm form = (RelatorioActionForm) actionForm;
		List<String> listaMensagem =  new ArrayList<String>();
		if(form.getListaProventoSelecionado()==null){
			listaMensagem.add("Nenhum Parâmetro foi selecionado!");
		}
		if(Utilidades.isEmpty(form.getNomeGrupoParametro())){
			listaMensagem.add("O Nome de Referência é obrigatório!");
		}
		if(listaMensagem.isEmpty()){
			
			GrupoParametro grupoParametro = new GrupoParametro();
			grupoParametro.setDataGrupoParametro(Utilidades.horaAtual());
			grupoParametro.setNomeGrupoParametro(form.getNomeGrupoParametro().toUpperCase());
			Parametro parametro;
			ProventoDesconto proventoDesconto;
			Set<Parametro> listaParametro = new HashSet<Parametro>();
			for (int i = 0; i < form.getListaProventoSelecionado().length; i++) {
				parametro = new Parametro();
				parametro.setGrupoParametro(grupoParametro);
				proventoDesconto= getFachada().obterProventoDesconto(Utilidades.string2long(form.getListaProventoSelecionado()[i]));
				parametro.setProventoDesconto(proventoDesconto);
				listaParametro.add(parametro);
			}
			grupoParametro.setListaParametro(listaParametro);
			getFachada().salvarGrupoParametro(grupoParametro);
		}
		salvaErros(listaMensagem );
		return carregar(actionMapping, actionForm, request, response);
	}
	
	public ActionForward carregarParametros(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Parametro.class);
		Long identificadorGrupoParametro = Utilidades.string2long(request.getParameter("identificadorGrupoParametro"));
		if((!Utilidades.isEmpty(identificadorGrupoParametro))){
			criteria.createAlias("grupoParametro", "grupoParametro");
			criteria.add(Restrictions.eq("grupoParametro.identificadorGrupoParametro", identificadorGrupoParametro));
		}
		List<Parametro> listaParametro = getFachada().obterListaParametro(criteria);
		List<ProventoDesconto> listaProventoSelecionado = new ArrayList<ProventoDesconto>();
		Parametro parametro ;
		for (Iterator<Parametro> itParametro = listaParametro.iterator(); itParametro.hasNext();) {
			parametro=  itParametro.next();
			listaProventoSelecionado.add(parametro.getProventoDesconto());
			
		}
		
		DetachedCriteria criteriaProvento = DetachedCriteria.forClass(ProventoDesconto.class);
		String tipoItemProvento = request.getParameter("tipoItemProvento");
		if((!Utilidades.isEmpty(tipoItemProvento))&&Utilidades.isLong(tipoItemProvento)){
			criteriaProvento.add(Restrictions.eq("tipoProventoDesconto", tipoItemProvento));
		}
		criteriaProvento.addOrder(Order.asc("nomeProventoDesconto"));
		List<ProventoDesconto> listaProventoDesconto = getFachada().obterListaProventoDesconto(criteriaProvento);
		ProventoDesconto proventoDesconto;
		for (Iterator<ProventoDesconto> iterator = listaProventoSelecionado.iterator(); iterator
				.hasNext();) {
			proventoDesconto =  iterator
					.next();
			listaProventoDesconto.remove(proventoDesconto);
			
		}
		
		request.setAttribute("listaProventoSelecionado",listaProventoSelecionado );
		request.setAttribute("listaProventoDesconto",listaProventoDesconto );
		
		
		return actionMapping.findForward(CARREGAR);
		
	}
	public ActionForward carregar(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		RelatorioActionForm form = (RelatorioActionForm) actionForm;
		DetachedCriteria criteriaProvento = DetachedCriteria.forClass(ProventoDesconto.class);
		String tipoItemProvento = request.getParameter("tipoItemProvento");
		if((!Utilidades.isEmpty(tipoItemProvento))&&Utilidades.isLong(tipoItemProvento)){
			criteriaProvento.add(Restrictions.eq("tipoProventoDesconto", tipoItemProvento));
		}
		criteriaProvento.addOrder(Order.asc("nomeProventoDesconto"));
		List<ProventoDesconto> listaProventoDesconto = getFachada().obterListaProventoDesconto(criteriaProvento);
		List<ProventoDesconto> listaProventoSelecionado = new ArrayList<ProventoDesconto>();
 		if(form.getListaProventoSelecionado()!=null &&form.getListaProventoSelecionado().length>0){
			ProventoDesconto proventoDesconto;
			HashMap<Long, ProventoDesconto>  mapProvento= new HashMap<Long, ProventoDesconto>(); 
			for (Iterator<ProventoDesconto> itProvento = listaProventoDesconto.iterator(); itProvento
					.hasNext();) {
				proventoDesconto=  itProvento.next();
				mapProvento.put(proventoDesconto.getCodigoProventoDesconto(), proventoDesconto);
			}
			for (int i = 0; i < form.getListaProventoSelecionado().length; i++) {
				if(mapProvento.containsKey(Utilidades.string2long(form.getListaProventoSelecionado()[i]))){
					listaProventoSelecionado.add(mapProvento.get(Utilidades.string2long(form.getListaProventoSelecionado()[i])));
					listaProventoDesconto.remove(mapProvento.get(Utilidades.string2long(form.getListaProventoSelecionado()[i])));
				}
				
			}
			
		}
 		request.setAttribute("listaProventoSelecionado",listaProventoSelecionado );
 		request.setAttribute("listaProventoDesconto",listaProventoDesconto );
		
			return actionMapping.findForward(CARREGAR);
		
	}
	
	public ActionForward listaGrupoParametro(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String parametroPesquisa = request.getParameter("parametroPesquisa");
		request.setAttribute("listaGrupoParametro",getFachada().obterListaGrupoParametro(parametroPesquisa) );
		return actionMapping.findForward("listaGrupoParametro");
		
	}
	public ActionForward popUpGrupoParametroForm(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return actionMapping.findForward("popUpGrupoParametroForm");
		
	}

	
}