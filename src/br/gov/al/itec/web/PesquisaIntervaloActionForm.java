package br.gov.al.itec.web;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import br.gov.al.itec.controle.ValidacaoException;


public class PesquisaIntervaloActionForm extends PesquisaBaseActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2641488421284534923L;
	private String dataInicio;
	private String dataFim;
	private String status;
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public void validar() {
		List<String> listaErros = new LinkedList<String>();
		validarCampo(listaErros, "Pesquisa.dataInicio",getDataInicio(),false,Timestamp.class,"dd/MM/yyyy");
		validarCampo(listaErros, "Pesquisa.dataFim",getDataFim(),false,Timestamp.class,"dd/MM/yyyy");
		if (listaErros.size()>0){
			throw new ValidacaoException(listaErros);
		} 
		super.validar();
	}

}
