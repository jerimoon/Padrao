package br.gov.al.itec.acesso.entidade;
/**
     Atencao:   
     - Codigo gerado, nao modifique manualmente.
     - Entidade: Relatorio
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
import br.gov.al.itec.acesso.entidade.ParametroRelatorio;



@SuppressWarnings("unused")
public class Relatorio  implements Entidade, Serializable,AjaxXmlBuilder.PropertyReader, Comparable<Entidade> {
	/**
	* Serial version necessaria para serializacao.
    */
    private static final long serialVersionUID = 7316857686036598356L;

	private int collectionPosition = 0;

	public int getCollectionPosition(){
		if(getCodigoRelatorio()!=null){
			return getCodigoRelatorio().intValue();
		}
		else{
			return collectionPosition;
		}
	}
	
	public void setCollectionPosition(int collectionPosition){
		this.collectionPosition = collectionPosition;
	}

	public Long getId(){
		return this.getCodigoRelatorio();
	}
	public String getDescritor(){
		return "ERRO: Descritor não definido para a entidade Relatorio Informe ao administrador do sistema.";

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

    public static final String CODIGO_RELATORIO = "codigoRelatorio";
    public static final String NOME_RELATORIO = "nomeRelatorio";
    public static final String NOME_ARQUIVO = "nomeArquivo";
    public static final String DESCRICAO_RELATORIO = "descricaoRelatorio";
    public static final String LISTA_PARAMETRO = "listaParametro";
    
	    private Long codigoRelatorio ;
	    private String nomeRelatorio ;
	    private String nomeArquivo ;
	    private String descricaoRelatorio ;


	private int listaParametroCollectionCount = -100;
	    private Set<ParametroRelatorio> listaParametro = (LinkedHashSet<ParametroRelatorio>) new LinkedHashSet<ParametroRelatorio>();
	        public Long getCodigoRelatorio(){
        return this.codigoRelatorio;
    }

    public void setCodigoRelatorio(Long codigoRelatorio){
        this.codigoRelatorio = codigoRelatorio;
    }
        public String getNomeRelatorio(){
        return this.nomeRelatorio;
    }

    public void setNomeRelatorio(String nomeRelatorio){
        this.nomeRelatorio = nomeRelatorio;
    }
        public String getNomeArquivo(){
        return this.nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }
        public String getDescricaoRelatorio(){
        return this.descricaoRelatorio;
    }

    public void setDescricaoRelatorio(String descricaoRelatorio){
        this.descricaoRelatorio = descricaoRelatorio;
    }



		
    public Set<ParametroRelatorio> getListaParametro(){
        return this.listaParametro;
    }
    public void setListaParametro(Set<ParametroRelatorio> listaParametro){
        this.listaParametro = listaParametro;
    }
    
    public void addListaParametro(ParametroRelatorio parametroRelatorio){
		parametroRelatorio.setCollectionPosition(listaParametroCollectionCount--);
	    getListaParametro().add(parametroRelatorio);
    }
	
    public boolean equals(Object object){
            if (this == object){
            return true;  
        }
        if (object != null && object instanceof Relatorio ){
        
			if (((Relatorio) object).getCollectionPosition() != 0){
				if (getCollectionPosition() == ((Relatorio) object).getCollectionPosition())
	        		return true;
			}
			else
	        	if (getCodigoRelatorio() != null){
		        	Relatorio relatorio = (Relatorio) object;
					if (this.getCodigoRelatorio().equals(relatorio.getCodigoRelatorio()))
		        		return true;
		        }
        }
        return false;
        }

        
    public void copiaAtributosNaoIdentificadores(Relatorio relatorio){
						    				    		relatorio.setNomeRelatorio(this.getNomeRelatorio());
    			    				    		relatorio.setNomeArquivo(this.getNomeArquivo());
    			    				    		relatorio.setDescricaoRelatorio(this.getDescricaoRelatorio());
    			    							    }

	
	
	@Override
    public int hashCode(){
		if (getCollectionPosition()!=0 || getCodigoRelatorio() == null)
	    	return getCollectionPosition();
	    else
	    	return getCodigoRelatorio().intValue();

    }
    
    public String getDebugString(){
    	StringBuffer buffer = new StringBuffer();
				buffer.append("  codigoRelatorio : "+codigoRelatorio);
	    		buffer.append("  nomeRelatorio : "+nomeRelatorio);
	    		buffer.append("  nomeArquivo : "+nomeArquivo);
	    		buffer.append("  descricaoRelatorio : "+descricaoRelatorio);
	    									return buffer.toString();
    }

	public int compareTo(Entidade object){
		if (object instanceof Relatorio){
			Relatorio relatorio = (Relatorio) object;
			if (relatorio != null && relatorio.getCodigoRelatorio() != null && this.getCodigoRelatorio() != null){
				return (int) (this.getCodigoRelatorio() - relatorio.getCodigoRelatorio()); 
			}
		}
		return -1;
	}

	public boolean isEmpty(){
		if (codigoRelatorio != null){
			return false;
		}
		if (nomeRelatorio != null){
			return false;
		}
		if (nomeArquivo != null){
			return false;
		}
		if (descricaoRelatorio != null){
			return false;
		}
	
		if (listaParametro != null && listaParametro.size() > 0){
			return false;	
		}
		return true;
	}
	
}