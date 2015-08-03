package br.gov.al.itec.acesso.entidade;
/**
     Atencao:   
     - Codigo gerado, nao modifique manualmente.
     - Entidade: ParametroRelatorio
     - entidadeBean.vsl

 * 
*/

import static br.gov.al.itec.util.Utilidades.object2String;
import java.util.Set;
import java.util.LinkedHashSet;
import java.io.Serializable;

import java.util.List;
import java.util.LinkedList;
import br.gov.al.itec.util.Entidade;

import net.sourceforge.ajaxtags.xml.AjaxXmlBuilder;

import java.lang.Long;
import java.lang.String;
import br.gov.al.itec.acesso.entidade.Relatorio;



@SuppressWarnings("unused")
public class ParametroRelatorio  implements Entidade, Serializable,AjaxXmlBuilder.PropertyReader, Comparable<Entidade> {
	/**
	* Serial version necessaria para serializacao.
    */
    private static final long serialVersionUID = 8357004637234752780L;

	private int collectionPosition = 0;

	public int getCollectionPosition(){
		if(getCodigoParametroRelatorio()!=null){
			return getCodigoParametroRelatorio().intValue();
		}
		else{
			return collectionPosition;
		}
	}
	
	public void setCollectionPosition(int collectionPosition){
		this.collectionPosition = collectionPosition;
	}

	public Long getId(){
		return this.getCodigoParametroRelatorio();
	}
	public String getDescritor(){
		return "ERRO: Descritor não definido para a entidade ParametroRelatorio Informe ao administrador do sistema.";

	}
	
	
	public String getName(){
		return this.getDescritor();
	}
	public String getValue(){
		return this.getId().toString();
	}
	public boolean isCData(){
		return false;
	}

    public static final String CODIGO_PARAMETRO_RELATORIO = "codigoParametroRelatorio";
    public static final String NOME_PARAMETRO = "nomeParametro";
    public static final String TIPO_PARAMETRO = "tipoParametro";
    public static final String MASCARA_PARAMETRO = "mascaraParametro";
    public static final String RELATORIO = "relatorio";
    
	    private Long codigoParametroRelatorio ;
	    private String nomeParametro ;
	    private String tipoParametro ;
	    private String mascaraParametro ;


    private Relatorio relatorio;
        public Long getCodigoParametroRelatorio(){
        return this.codigoParametroRelatorio;
    }

    public void setCodigoParametroRelatorio(Long codigoParametroRelatorio){
        this.codigoParametroRelatorio = codigoParametroRelatorio;
    }
        public String getNomeParametro(){
        return this.nomeParametro;
    }

    public void setNomeParametro(String nomeParametro){
        this.nomeParametro = nomeParametro;
    }
        public String getTipoParametro(){
        return this.tipoParametro;
    }

    public void setTipoParametro(String tipoParametro){
        this.tipoParametro = tipoParametro;
    }
        public String getMascaraParametro(){
        return this.mascaraParametro;
    }

    public void setMascaraParametro(String mascaraParametro){
        this.mascaraParametro = mascaraParametro;
    }


    
    public Relatorio getRelatorio(){
        return this.relatorio;
    }
    public void setRelatorio(Relatorio relatorio){
        this.relatorio = relatorio;
    }

    public boolean equals(Object object){
            if (this == object){
            return true;  
        }
        if (object != null && object instanceof ParametroRelatorio ){
        
			if (((ParametroRelatorio) object).getCollectionPosition() != 0){
				if (getCollectionPosition() == ((ParametroRelatorio) object).getCollectionPosition())
	        		return true;
			}
			else
	        	if (getCodigoParametroRelatorio() != null){
		        	ParametroRelatorio parametroRelatorio = (ParametroRelatorio) object;
					if (this.getCodigoParametroRelatorio().equals(parametroRelatorio.getCodigoParametroRelatorio()))
		        		return true;
		        }
        }
        return false;
        }

        
    public void copiaAtributosNaoIdentificadores(ParametroRelatorio parametroRelatorio){
						    				    		parametroRelatorio.setNomeParametro(this.getNomeParametro());
    			    				    		parametroRelatorio.setTipoParametro(this.getTipoParametro());
    			    				    		parametroRelatorio.setMascaraParametro(this.getMascaraParametro());
    			    									parametroRelatorio.setRelatorio(this.getRelatorio());			
					    }

	
	
	@Override
    public int hashCode(){
		if (getCollectionPosition()!=0 || getCodigoParametroRelatorio() == null)
	    	return getCollectionPosition();
	    else
	    	return getCodigoParametroRelatorio().intValue();

    }
    
    public String getDebugString(){
    	StringBuffer buffer = new StringBuffer();
				buffer.append("  codigoParametroRelatorio : "+codigoParametroRelatorio);
	    		buffer.append("  nomeParametro : "+nomeParametro);
	    		buffer.append("  tipoParametro : "+tipoParametro);
	    		buffer.append("  mascaraParametro : "+mascaraParametro);
	    							buffer.append("  relatorio : "+relatorio);
							return buffer.toString();
    }

	public int compareTo(Entidade object){
		if (object instanceof ParametroRelatorio){
			ParametroRelatorio parametroRelatorio = (ParametroRelatorio) object;
			if (parametroRelatorio != null && parametroRelatorio.getCodigoParametroRelatorio() != null && this.getCodigoParametroRelatorio() != null){
				return (int) (this.getCodigoParametroRelatorio() - parametroRelatorio.getCodigoParametroRelatorio()); 
			}
		}
		return -1;
	}

	public boolean isEmpty(){
		if (codigoParametroRelatorio != null){
			return false;
		}
		if (nomeParametro != null){
			return false;
		}
		if (tipoParametro != null){
			return false;
		}
		if (mascaraParametro != null){
			return false;
		}
	
		if (relatorio != null){
			return false;	
		}
		return true;
	}
	
}