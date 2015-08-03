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
public class ProventoDesconto  implements Entidade, Serializable,AjaxXmlBuilder.PropertyReader, Comparable<Entidade> {
	/**
	* Serial version necessária para serializacao.
    */
    private static final long serialVersionUID = 7316857686036598356L;

    public final static String ID = "codigoProventoDesconto";    
		

	public Long getId(){
		return this.getCodigoProventoDesconto();
	}
	public String getDescritor(){
		return this.getCodigoProventoDesconto()+" - "+getNomeProventoDesconto();

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

	    private Long codigoProventoDesconto ;
	    private String nomeProventoDesconto ;
	    private String tipoProventoDesconto ;



		public Long getCodigoProventoDesconto() {
			return codigoProventoDesconto;
		}
		public void setCodigoProventoDesconto(Long codigoProventoDesconto) {
			this.codigoProventoDesconto = codigoProventoDesconto;
		}
		public String getNomeProventoDesconto() {
			return nomeProventoDesconto;
		}
		public void setNomeProventoDesconto(String nomeProventoDesconto) {
			this.nomeProventoDesconto = nomeProventoDesconto;
		}
		public String getTipoProventoDesconto() {
			return tipoProventoDesconto;
		}
		public void setTipoProventoDesconto(String tipoProventoDesconto) {
			this.tipoProventoDesconto = tipoProventoDesconto;
		}
		@Override
		public int compareTo(Entidade arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public String getDebugString() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}



	
	
	



	
}