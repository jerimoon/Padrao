package br.gov.al.itec.web.session;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;

import br.gov.al.itec.negocio.Fachada;
 


public class WebUtils{
	public static Fachada getFachada(ServletContext servletContext){
		WebApplicationContext context =
			(WebApplicationContext)	servletContext.							
		getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		
		Fachada fachada = (Fachada) context.getBean("fachada");
			
		return fachada;
	}
	public static String getNomeServidorProducao(ServletContext servletContext){
		WebApplicationContext context =
				(WebApplicationContext)	servletContext.							
				getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		
		String nomeServidorProducao = (String) context.getBean("nomeServidorProducao");
		
		return nomeServidorProducao;
	}

	public static WebApplicationContext getWebApplicationContext(ServletContext servletContext){
		WebApplicationContext context =
			(WebApplicationContext)	servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		
		return context;
	}
}
