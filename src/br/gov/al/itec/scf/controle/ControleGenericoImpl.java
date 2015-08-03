package br.gov.al.itec.scf.controle;

import java.util.Collection;

import org.hibernate.criterion.DetachedCriteria;

import br.gov.al.itec.controle.Controle;
import br.gov.al.itec.geral.controle.ControleGenerico;
import br.gov.al.itec.negocio.CatalogoRegraNegocio;
import br.gov.al.itec.util.Entidade;

public class ControleGenericoImpl extends Controle implements ControleGenerico {

	public ControleGenericoImpl(CatalogoRegraNegocio catalogoRegraNegocio) {
		super(catalogoRegraNegocio);
	}

	@SuppressWarnings("unchecked")
	public Collection<Entidade> obterListaEntidade(DetachedCriteria criteria) {
		return (Collection<Entidade>)getHibernateTemplate().findByCriteria(criteria);
	}
	

}
