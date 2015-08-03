package br.gov.al.itec.util.struts;

import static br.gov.al.itec.util.Utilidades.getMessageBundle;
import static br.gov.al.itec.util.Utilidades.isBigDecimal;
import static br.gov.al.itec.util.Utilidades.isEmpty;
import static br.gov.al.itec.util.Utilidades.isLong;
import static br.gov.al.itec.util.Utilidades.isTimestamp;

import java.util.List;

import org.apache.struts.action.ActionForm;

import br.gov.al.itec.negocio.Fachada;
import br.gov.al.itec.util.Entidade;
import br.gov.al.itec.web.session.WebUtils;

public abstract class AbstractActionForm extends ActionForm{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3727073715017438616L;
	private String acao;
    private String botao;
   
    public String getAcao(){
        return acao;
    }

    public void setAcao(String acao){
        this.acao = acao;
    }

    public String getBotao(){
        return botao;
    }

    public void setBotao(String botao){
        this.botao = botao;
    }
    
    public abstract void setEntidade(Entidade entidade);
    public abstract void validar();
    @SuppressWarnings("rawtypes")
	protected void validarCampo(List<String> listaErros,String nomeCampo, String valorCampo, boolean obrigatorio, Class classe,String mascara) {
    	if(!isEmpty(valorCampo)){
    		if("Timestamp".equals(classe.getSimpleName())&&!isTimestamp(valorCampo, mascara) ){
    			listaErros.add( "O campo '"+getMessageBundle(nomeCampo,"labels")+"' deve ser preenchido com um valor no formato:"+mascara);
    		}else if("BigDecimal".equals(classe.getSimpleName())&&!isBigDecimal(valorCampo)){
    			listaErros.add( "O campo '"+getMessageBundle(nomeCampo,"labels")+"' deve ser preenchido com um número decimal válido.");
    		}else if("Long".equals(classe.getSimpleName())&&!isLong(valorCampo)){
    			listaErros.add( "O campo '"+getMessageBundle(nomeCampo,"labels")+"' deve ser preenchido com um  número inteiro válido.");
    		}
    		/**
    		 * Campos booleanos quando não são preenchidos recebem valor falso, logo não são nulos nunca.
    		 */
		}else if(obrigatorio&&!"Boolean".equals(classe.getSimpleName())){
			listaErros.add( "O campo '"+getMessageBundle(nomeCampo,"labels")+"' é obrigatório");
		}
		
	}
    public Fachada getFachada(){
		return WebUtils.getFachada(getServlet().getServletContext());
	}
    
}