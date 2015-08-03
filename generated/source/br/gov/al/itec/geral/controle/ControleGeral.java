
package br.gov.al.itec.geral.controle;
/**
     Atencao:   
     - Codigo gerado, nao modifique manualmente.
     - controleGeral.vsl
*/

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.gov.al.itec.acesso.entidade.GrupoParametro;
import br.gov.al.itec.acesso.entidade.Parametro;
import br.gov.al.itec.acesso.entidade.ParametroRelatorio;
import br.gov.al.itec.acesso.entidade.ProventoDesconto;
import br.gov.al.itec.acesso.entidade.Relatorio;
import br.gov.al.itec.controle.Controle;
import br.gov.al.itec.negocio.CatalogoRegraNegocio;

@SuppressWarnings({ "unchecked","rawtypes", "unused" })
public class ControleGeral extends Controle{

	public ControleGeral(CatalogoRegraNegocio catalogoRegraNegocio){
		super(catalogoRegraNegocio);
	}
	public Relatorio obterRelatorio(Long codigoRelatorio){
		return (Relatorio)getHibernateTemplate().get(Relatorio.class,codigoRelatorio);
	}
	
	public List<Relatorio> obterRelatorio(DetachedCriteria detachedCriteria){
		return getHibernateTemplate().findByCriteria(detachedCriteria);
	}
	
	public ParametroRelatorio obterParametroRelatorio(Long codigoParametroRelatorio){
		return (ParametroRelatorio)getHibernateTemplate().get(ParametroRelatorio.class,codigoParametroRelatorio);
	}
	
	public List<ParametroRelatorio> obterParametroRelatorio(DetachedCriteria detachedCriteria){
		return getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	public Relatorio obterRelatorio(String string) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Relatorio.class);
		criteria.add(Restrictions.eq(Relatorio.NOME_ARQUIVO, string));
		return obterRelatorio(criteria).get(0);
	}

	public List<ProventoDesconto> obterListaProventoDesconto(
			DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public ProventoDesconto obterProventoDesconto(Long identificador) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProventoDesconto.class);
		criteria.add(Restrictions.eq(ProventoDesconto.ID, identificador));
		return obterListaProventoDesconto(criteria).get(0);
	}

	public Object salvarGrupoParametro(GrupoParametro grupoParametro) {
		getHibernateTemplate().saveOrUpdate(grupoParametro);
		getHibernateTemplate().saveOrUpdateAll(grupoParametro.getListaParametro());
		
		return null;
	}
	public List<GrupoParametro> obterListaGrupoParametro(String parametroPesquisa) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GrupoParametro.class);
		if(parametroPesquisa!=null){
			criteria.add(Restrictions.like("nomeGrupoParametro", parametroPesquisa.toUpperCase()+"%"));
		}

		criteria.addOrder(Order.asc("nomeGrupoParametro"));
		
		return getHibernateTemplate().findByCriteria(criteria);
	}
	public List<Parametro> obterListaParametro(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}
}
