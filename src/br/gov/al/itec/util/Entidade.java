package br.gov.al.itec.util;


import java.io.Serializable;

public interface Entidade extends Serializable
{
	public Long getId();
	public String getDescritor();
	public String getDebugString();
	public boolean isEmpty();
	
}
