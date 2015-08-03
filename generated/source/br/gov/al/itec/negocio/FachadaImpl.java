
package br.gov.al.itec.negocio;
/**
     Atencao:   
     - Codigo gerado, nao modifique manualmente.
*/
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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
public class FachadaImpl implements Fachada{
	public CatalogoRegraNegocio catalogoRegraNegocio;

	private static int instanceCount = 0;
	private int instanceNumber;
	
	private void showInstanceNumber(){
		System.out.println("Numero da instancia - ("+instanceNumber+")");
	}
	
	public void close(){
		showInstanceNumber();
		System.out.println("Fachada - Fechando... ("+instanceCount+")");
	}

	public CatalogoRegraNegocio getCatalogoRegraNegocio(){
		return catalogoRegraNegocio;
	}

	public void setCatalogoRegraNegocio(CatalogoRegraNegocio catalogoRegraNegocio){
		this.catalogoRegraNegocio = catalogoRegraNegocio;
	}

	public FachadaImpl(){
		instanceNumber = instanceCount++;
		System.out.println("Fachada - Inicializando... ("+instanceCount+")");
	}

	public Collection obterListaEntidade(DetachedCriteria criteria) {
		return getCatalogoRegraNegocio().getControleGenerico().obterListaEntidade(criteria);
	}


public Relatorio obterRelatorio(Long codigoRelatorio){
	return getCatalogoRegraNegocio().getControleGeral().obterRelatorio(codigoRelatorio);
}

public List<Relatorio> obterListaRelatorio(DetachedCriteria detachedCriteria){
	return getCatalogoRegraNegocio().getControleGeral().obterRelatorio(detachedCriteria);
}
public ParametroRelatorio obterParametroRelatorio(Long codigoParametroRelatorio){
	return getCatalogoRegraNegocio().getControleGeral().obterParametroRelatorio(codigoParametroRelatorio);
}

public List<ParametroRelatorio> obterListaParametroRelatorio(DetachedCriteria detachedCriteria){
	return getCatalogoRegraNegocio().getControleGeral().obterParametroRelatorio(detachedCriteria);
}

@Override
public Relatorio obterRelatorio(String string) {
	
	return getCatalogoRegraNegocio().getControleGeral().obterRelatorio(string);
}

@Override
public List<ProventoDesconto> obterListaProventoDesconto(
		DetachedCriteria criteria) {
	
	return getCatalogoRegraNegocio().getControleGeral().obterListaProventoDesconto(criteria);
}

@Override
public ProventoDesconto obterProventoDesconto(Long identificador) {
	return getCatalogoRegraNegocio().getControleGeral().obterProventoDesconto(identificador);
	
}

@Override
public void salvarGrupoParametro(GrupoParametro grupoParametro) {
	 getCatalogoRegraNegocio().getControleGeral().salvarGrupoParametro(grupoParametro);
	
}

@Override
public List<GrupoParametro> obterListaGrupoParametro(String parametroPesquisa) {
	return getCatalogoRegraNegocio().getControleGeral().obterListaGrupoParametro(parametroPesquisa);
}

@Override
public List<Parametro> obterListaParametro(DetachedCriteria criteria) {
	return getCatalogoRegraNegocio().getControleGeral().obterListaParametro(criteria);
}


}
