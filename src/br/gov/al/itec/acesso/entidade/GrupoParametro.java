package br.gov.al.itec.acesso.entidade;

import java.sql.Timestamp;
import java.util.Collection;

import br.gov.al.itec.util.Entidade;

public class GrupoParametro implements Entidade {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2432234083954471884L;
	private Long identificadorGrupoParametro;
	private String nomeGrupoParametro;
	private Timestamp dataGrupoParametro;
	private Collection<Parametro> listaParametro;

	@Override
	public Long getId() {
		return identificadorGrupoParametro;
	}

	@Override
	public String getDescritor() {
		return nomeGrupoParametro;
	}

	@Override
	public String getDebugString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public Long getIdentificadorGrupoParametro() {
		return identificadorGrupoParametro;
	}

	public void setIdentificadorGrupoParametro(Long identificadorGrupoParametro) {
		this.identificadorGrupoParametro = identificadorGrupoParametro;
	}

	public String getNomeGrupoParametro() {
		return nomeGrupoParametro;
	}

	public void setNomeGrupoParametro(String nomeGrupoParametro) {
		this.nomeGrupoParametro = nomeGrupoParametro;
	}

	public Timestamp getDataGrupoParametro() {
		return dataGrupoParametro;
	}

	public void setDataGrupoParametro(Timestamp dataGrupoParametro) {
		this.dataGrupoParametro = dataGrupoParametro;
	}

	public Collection<Parametro> getListaParametro() {
		return listaParametro;
	}

	public void setListaParametro(Collection<Parametro> listaParametro) {
		this.listaParametro = listaParametro;
	}

}
