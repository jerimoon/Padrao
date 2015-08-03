package br.gov.al.itec.acesso.entidade;

import br.gov.al.itec.util.Entidade;

public class Parametro implements Entidade {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4266069144121364354L;
	private Long identificadorParametro; 
	private ProventoDesconto proventoDesconto;
	private GrupoParametro grupoParametro;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return identificadorParametro;
	}

	@Override
	public String getDescritor() {
		// TODO Auto-generated method stub
		return null;
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

	public Long getIdentificadorParametro() {
		return identificadorParametro;
	}

	public void setIdentificadorParametro(Long identificadorParametro) {
		this.identificadorParametro = identificadorParametro;
	}

	public ProventoDesconto getProventoDesconto() {
		return proventoDesconto;
	}

	public void setProventoDesconto(ProventoDesconto proventoDesconto) {
		this.proventoDesconto = proventoDesconto;
	}

	public GrupoParametro getGrupoParametro() {
		return grupoParametro;
	}

	public void setGrupoParametro(GrupoParametro grupoParametro) {
		this.grupoParametro = grupoParametro;
	}

}
