package br.gov.al.itec.controle;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class ITECException extends RuntimeException{
	
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3337409116445399524L;
	List<String> messageList = new LinkedList<String>();
	
	
	public ITECException(List<String> messageList){
		this.messageList.addAll(messageList);
	}
	
	public ITECException(String message){
		this.messageList = new ArrayList<String>();
		this.messageList.add(message);
		
	}


	
	
	public ITECException(Map<String, String> mapErros) {
		
		this.messageList =   new LinkedList<String>( mapErros.values());
	}

	public List<String> getMessageList()
	{
		return messageList;
		
	}


	
}
