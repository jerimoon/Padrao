package br.gov.al.itec.controle;

import java.util.List;
import java.util.Map;

public class TransacaoException extends ITECException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4641086624454995176L;
	public TransacaoException(String message){
		super(message);
	}
	public TransacaoException(List<String> messageList) {
		super(messageList);

	}
	public TransacaoException(Map<String, String> mapErros) {
		super(mapErros);
	}
}
