package br.gov.al.itec.web;

import br.gov.al.itec.util.Entidade;
import br.gov.al.itec.util.struts.AbstractActionForm;





public class PesquisaBaseActionForm extends AbstractActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2027246549975584581L;
	
	private String atributoPesquisa;
	private String valorAtributoPesquisa;
	private String opcao;
	private String situacao;
	public static final String SITUACAO_ATIVO="A";
	public static final String SITUACAO_INATIVO="I";
	public static final String SITUACAO_TODOS="T";
	
	public String getAtributoPesquisa() {
		return atributoPesquisa;
	}
	public void setAtributoPesquisa(String atributoPesquisa) {
		this.atributoPesquisa = atributoPesquisa;
	}
	public String getOpcao() {
		return opcao;
	}
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	public String getValorAtributoPesquisa() {
		return valorAtributoPesquisa;
	}
	public void setValorAtributoPesquisa(String valorAtributoPesquisa) {
		this.valorAtributoPesquisa = valorAtributoPesquisa;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	@Override
	public void setEntidade(Entidade entidade) {
		
	}
	@Override
	public void validar() {
	}
	
	
	
}
