package br.gov.al.itec.scf.veiculo.struts;

import org.apache.struts.upload.FormFile;

import br.gov.al.itec.controle.ValidacaoException;
import br.gov.al.itec.util.Entidade;
import br.gov.al.itec.util.Utilidades;
import br.gov.al.itec.util.struts.AbstractActionForm;

public class ArquivoActionForm extends AbstractActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7199901816911508578L;
	/**
	 * 
	 */
	private FormFile arquivo;
	@Override
	public void setEntidade(Entidade entidade) {

	}

	@Override
	public void validar() {
		if(Utilidades.isEmpty( getArquivo().getFileName())){
			throw new ValidacaoException("O campo Arquivo é obrigatório.");
		}

	}

	public FormFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(FormFile arquivo) {
		this.arquivo = arquivo;
	}
	

}
