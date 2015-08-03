package br.gov.al.itec.negocio;
/**
     Atencao:   
     - Codigo gerado, nao modifique manualmente.
     Templates
*/
import org.hibernate.criterion.DetachedCriteria;
import java.util.List;


import java.util.Collection;
import org.hibernate.criterion.DetachedCriteria;

import br.gov.al.itec.acesso.entidade.GrupoParametro;
import br.gov.al.itec.acesso.entidade.Parametro;
import br.gov.al.itec.acesso.entidade.ProventoDesconto;
import 	br.gov.al.itec.acesso.entidade.Relatorio;
import 	br.gov.al.itec.acesso.entidade.ParametroRelatorio;

import br.gov.al.itec.controle.ValidacaoException;
@SuppressWarnings({ "rawtypes", "unused" })
public interface Fachada{
	public Collection obterListaEntidade(DetachedCriteria criteria) ;






public Relatorio obterRelatorio(Long codigoRelatorio);

public List<Relatorio> obterListaRelatorio(DetachedCriteria detachedCriteria);



public ParametroRelatorio obterParametroRelatorio(Long codigoParametroRelatorio);

public List<ParametroRelatorio> obterListaParametroRelatorio(DetachedCriteria detachedCriteria);
public List<ProventoDesconto> obterListaProventoDesconto(DetachedCriteria detachedCriteria);






public Relatorio obterRelatorio(String string);






public ProventoDesconto obterProventoDesconto(Long identificador);






public void salvarGrupoParametro(GrupoParametro grupoParametro);






public List<GrupoParametro> obterListaGrupoParametro(String parametroPesquisa);






public List<Parametro> obterListaParametro(DetachedCriteria criteria);









}
