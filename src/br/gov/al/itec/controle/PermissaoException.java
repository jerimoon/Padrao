package br.gov.al.itec.controle;

import java.util.List;
import java.util.Map;

public class PermissaoException extends ITECException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3412059841322162475L;
	public PermissaoException(String message){
		super(message);
	}
	public PermissaoException(List<String> messageList) {
		super(messageList);

	}
	public PermissaoException(Map<String, String> mapErros) {
		super(mapErros);
	}

}
