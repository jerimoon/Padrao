package br.gov.al.itec.controle;

import java.util.List;

public class AutenticacaoException extends ITECException {

	public AutenticacaoException(List<String> messageList) {
		super(messageList);
	}
	public AutenticacaoException(String message) {
		super(message);
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6646773108099384717L;

	

}
