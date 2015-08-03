
package br.gov.al.itec.geral.controle;
/**
     Atencao:   
     - Codigo gerado, nao modifique manualmente.
     - Controle: ControleGenerico
     - controle.vsl

 * 
*/

import java.util.Collection;
import org.hibernate.criterion.DetachedCriteria;

@SuppressWarnings({ "rawtypes"})
public interface ControleGenerico {
    public Collection obterListaEntidade(DetachedCriteria criteria) ;

}
