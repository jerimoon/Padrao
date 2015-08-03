package br.gov.al.itec.controle;


import java.util.List;
import java.util.Map;

public class ValidacaoException extends ITECException{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7584875122906127729L;
	public ValidacaoException(String message){
		super(message);
	}
	public ValidacaoException(List<String> messageList) {
		super(messageList);

	}
	public ValidacaoException(Map<String, String> mapErros) {
		super(mapErros);
	}

	
	
	

	
}
