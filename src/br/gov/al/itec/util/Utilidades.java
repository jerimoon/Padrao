package br.gov.al.itec.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.lang.time.DateUtils;

import br.gov.al.itec.controle.ValidacaoException;


public class Utilidades{
	private static final int MAIORIDADE = 1970+18;
	private static final int DIA =24*3600000;
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
	public static String firstUpper(String value){
		
		return value.substring(0,1).toUpperCase()+value.substring(1);
	}
	
	public static String firstLower(String value){
		return value.substring(0,1).toLowerCase()+value.substring(1);
	}

	public static String clearNull(Object value){
		if (value == null)
			return null;
		else
			return value.toString().trim();
	}
	
	public static Long string2long(String value){
		try{
			return new Long(value);
		} catch (Exception e){
			return null; 
		}
	}
	public static Boolean string2Boolean(String value){
		
		return new Boolean("true".equalsIgnoreCase(value));
		
	}
	
	public static BigDecimal string2BigDecimal(String valor){
		if(isEmpty(valor)){
			return null;
		}
		
		try {
			DECIMAL_FORMAT.setParseBigDecimal(true);
			return (BigDecimal) DECIMAL_FORMAT.parse(valor);
		} catch (ParseException e) {
			throw new ValidacaoException("Formato de número inválido");
		}
	}
	
	public static Timestamp string2Timestamp(String data){
		return string2Timestamp(data, "dd/MM/yyyy");
	}
	public static Timestamp string2Timestamp(String data,String mascara){
		if(data==null || data.trim().equals(""))
			return null;
		else{
			try{
				SimpleDateFormat simpleDate = new SimpleDateFormat(mascara);
				simpleDate.setLenient(false);
				return new Timestamp((simpleDate.parse(data)).getTime());
			}
			catch(ParseException e){
				throw new ValidacaoException("O valor de data "+data+" não está no formato: " +mascara);
			}
		}
	}
	
	public static String timestamp2String(Timestamp data){
		return timestamp2String(data,  "dd/MM/yyyy");
	}
	public static String timestamp2String(Timestamp data,String mascara){
		if(data==null){
			return "";
		}else{
			if(mascara==null){
				 mascara = "dd/MM/yyyy";
			}
			SimpleDateFormat simpleDate = new SimpleDateFormat(mascara);
			return simpleDate.format(data);
		}
	}
	
	public static boolean isEmpty(Object object){
		if(object==null)
			return true;
		else if(object instanceof String && ((String)object).trim().equals(""))
			return true;
		else if(object instanceof Entidade )
			return ((Entidade)object).isEmpty();
		
		return false;
	}
	
	public static double string2double(String value){
    	if(isEmpty(value))
    		return 0D;
    	else
    	{
    		String valor = (String)value;
    		return Double.parseDouble(valor);
    	}
    }
	
	public static String double2String(Double value){
		if(value==null)
			return "";
		else
			return value.doubleValue()+"";
	}
	
	public static String long2String(Long value){
		if(value==null)
			return "";
		else
			return value.longValue()+"";
	}
	
	public static boolean isTimestamp(String valor, String formato){
		try{
			SimpleDateFormat simpleDate = new SimpleDateFormat(formato);
			simpleDate.setLenient(false);
			simpleDate.parse(valor);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static String getMessageBundle(String key, String bundle){
       try{
	       ResourceBundle resourceBundle = ResourceBundle.getBundle(bundle);
	       return resourceBundle.getString(key);
       }
       catch(Exception e){
    	   e.printStackTrace();
    	   return "";
       }
    }
	
	public static boolean validarConteudo(String valor, String key)
	{
		if(valor.trim().matches(getMessageBundle(key,"regex")))
        {
      	  return true;
        }
		return false;
	}

	public static String leftPad(String valor,int length, String padding){
		String retorno ="";
		for(int i =0; i<length-valor.length();i++){
			retorno+=padding.charAt(i%padding.length()
					);
			
		}
		return retorno+valor;
	}
	/**
	 * Método que atualiza o valor de atributos String para maúsculos
	 * @param objeto
	 * @param atributo
	 */
	public static void upperAttribute(Entidade objeto, String atributo){
		try {
			String valor = (String)objeto.getClass().getMethod("get"+firstUpper(atributo), new Class[] {}).invoke(objeto, new Object[] {});
			if (valor!=null){
				objeto.getClass().getMethod("set"+firstUpper(atributo), new Class[] {String.class}).invoke(objeto, new Object[] {valor.toUpperCase()});
			}
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static boolean isField(Class<? extends Entidade> clazz,String fieldName){
		try {
			clazz.getMethod("get"+firstUpper(fieldName), new Class[] {});
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * Método de conversão de string em objetos de acordo com o tipo do atributo
	 * @param classe
	 * @param atributo
	 * @param valor
	 * @return
	 */
	public static Object dynamicConversion(Class<? extends Entidade> classe, String atributo, String valor){
		Field field;
		
			 try {
				field = classe.getDeclaredField(atributo);
				if("Timestamp".equals(field.getType().getSimpleName())){
					return string2Timestamp(valor);
				}else if("BigDecimal".equals(field.getType().getSimpleName())){
					return string2BigDecimal(valor);
				}else if("Long".equals(field.getType().getSimpleName())){
					return string2long(valor);
				}else{
					return valor;
				}
				
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		
		return null;
	}
	public static boolean hasAttribute(Class<?extends Entidade> classe, String atributo){
		try {
			classe.getDeclaredField(atributo);
			return true;
			
		} catch (SecurityException e) {
		} catch (NoSuchFieldException e) {
		}
		return false;
		
	} 
	public static boolean isLong(String valor){
		if(isEmpty(valor)){
			return true;
		}
		
		return (string2long(valor)!=null);
		
	}
	public static boolean isBigDecimal(String valor){
		if(isEmpty(valor)){
			return true;
		}
		try {
			string2BigDecimal(valor);
			
		} catch (Exception e) {
			return false;
		}
		return true;
		
	}
	public static boolean isCpf(Long pNumeroCpf){
		return isCpf(pNumeroCpf+"");
	}
	public static boolean isCpf(String pNumeroCpf) {
			String numeroCpf= leftPad(pNumeroCpf.replace(".", "").replace("-", "").trim(), 11, "0");
		 
		    char dig10, dig11;
		    int sm, i, r, num, peso;
		 
		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		    try {
		// Calculo do 1o. Digito Verificador
		      sm = 0;
		      peso = 10;
		      for (i=0; i<9; i++) {             
		// converte o i-esimo caractere do CPF em um numero:
		// por exemplo, transforma o caractere '0' no inteiro 0        
		// (48 eh a posicao de '0' na tabela ASCII)        
		        num = (int)(numeroCpf.charAt(i) - 48);
		        sm = sm + (num * peso);
		        peso = peso - 1;
		      }
		 
		      r = 11 - (sm % 11);
		      if ((r == 10) || (r == 11))
		         dig10 = '0';
		      else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
		 
		// Calculo do 2o. Digito Verificador
		      sm = 0;
		      peso = 11;
		      for(i=0; i<10; i++) {
		        num = (int)(numeroCpf.charAt(i) - 48);
		        sm = sm + (num * peso);
		        peso = peso - 1;
		      }
		 
		      r = 11 - (sm % 11);
		      if ((r == 10) || (r == 11))
		         dig11 = '0';
		      else dig11 = (char)(r + 48);
		 
		// Verifica se os digitos calculados conferem com os digitos informados.
		      if ((dig10 == numeroCpf.charAt(9)) && (dig11 == numeroCpf.charAt(10)))
		         return(true);
		      else return(false);
		    } catch (InputMismatchException erro) {
		        return(false);
		    }
		  }
		 
		  public static String imprimeCPF(String pNumeroCpf) {
			  String numeroCpf= leftPad(pNumeroCpf.replaceAll("\\D", ""), 11, "0");
		    return(numeroCpf.substring(0, 3) + "." + numeroCpf.substring(3, 6) + "." +
		      numeroCpf.substring(6, 9) + "-" + numeroCpf.substring(9, 11));
		  }
		  public static String imprimeCPF(Long pNumeroCpf) {
			  return imprimeCPF(pNumeroCpf+"");
		  }
		  public static boolean isCep(String pNumeroCep){
			  if(!isEmpty(pNumeroCep)){
				  String numeroCep= pNumeroCep.replaceAll("\\D", "");
				  if(numeroCep.length()==8){
					  return true;
				  }
			  }
			  return false;
			  
		  }
		  
public static String object2String(Object value,String mask){
	if(value==null)
		return "";
	
	if (value instanceof String ) {
		return (String)value;
	} else if (value instanceof Timestamp ) {
		return timestamp2String((Timestamp)value, mask);
	} else if ((value instanceof BigDecimal )||(value instanceof Long )) {
		return value.toString();
	}
	throw new RuntimeException("ERRO: Objeto ["+value.getClass()+"] não é contemplado pelo método de conversão, informe o setor de informática");
}
public static Timestamp horaAtual(){
	return new Timestamp(System.currentTimeMillis());
	
}
public static Timestamp dataAtual(){
	Calendar horaAtual = Calendar.getInstance();
	Calendar data = DateUtils.truncate(horaAtual,Calendar.DATE);
	return new Timestamp(data.getTimeInMillis());
	
}
public static boolean isMaioridade(Timestamp dataNascimento){
	 return (string2long(timestamp2String(new Timestamp(horaAtual().getTime()- dataNascimento.getTime()),"yyyy"))>=MAIORIDADE); 
}
public static Timestamp somaDias(Timestamp time, long numeroDias){
	return new Timestamp(time.getTime()+(numeroDias*DIA));
}
public static boolean isIgual(Object a, Object b){
	if(a!=null){
		return a.equals(b);
	}
	return (b==null);
	
}

		  


	
}
