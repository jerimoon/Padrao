package br.gov.al.itec.scf.veiculo.struts;

import br.gov.al.itec.util.Entidade;
import br.gov.al.itec.util.struts.AbstractActionForm;

public class RelatorioActionForm extends AbstractActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2027301595747280882L;
	private String tipoItemProvento;
	private String numeroGrupo;
	private String[] listaProventoSelecionado;
	private String nomeGrupoParametro;
	private String numeroLote;

	@Override
	public void setEntidade(Entidade entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validar() {
		// TODO Auto-generated method stub

	}

	public String getTipoItemProvento() {
		return tipoItemProvento;
	}

	public void setTipoItemProvento(String tipoItemProvento) {
		this.tipoItemProvento = tipoItemProvento;
	}

	public String getNumeroGrupo() {
		return numeroGrupo;
	}

	public void setNumeroGrupo(String numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
	}

	public String[] getListaProventoSelecionado() {
		return listaProventoSelecionado;
	}

	public void setListaProventoSelecionado(String[] listaProventoSelecionado) {
		this.listaProventoSelecionado = listaProventoSelecionado;
	}

	public String getNomeGrupoParametro() {
		return this.nomeGrupoParametro;
	}

	public void setNomeGrupoParametro(String nomeGrupoParametro) {
		this.nomeGrupoParametro = nomeGrupoParametro;
	}

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String possuiGrupo) {
		this.numeroLote = possuiGrupo;
	}

}
