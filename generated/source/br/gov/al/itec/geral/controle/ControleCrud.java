package br.gov.al.itec.geral.controle;
/**
     Atencao:   
     - Codigo gerado, nao modifique manualmente.
     - controleCrud.vsl

*/

import br.gov.al.itec.negocio.CatalogoRegraNegocio;
import br.gov.al.itec.controle.Controle;
import br.gov.al.itec.controle.ValidacaoException;
import br.gov.al.itec.controle.TransacaoException;
import static br.gov.al.itec.util.Utilidades.*;

import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateAccessor;


;
@SuppressWarnings({ "rawtypes", "unused" })
public class ControleCrud extends Controle{

	/*Auto-implemented by superclass*/

	public ControleCrud(CatalogoRegraNegocio catalogoRegraNegocio){
		super(catalogoRegraNegocio);
	}

}
