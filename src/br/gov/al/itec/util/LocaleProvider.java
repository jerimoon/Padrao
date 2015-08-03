package br.gov.al.itec.util;





import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import org.displaytag.localization.I18nResourceProvider;


public class LocaleProvider implements I18nResourceProvider {

    /**
     * prefix/suffix for missing entries.
     */
    public static final String UNDEFINED_KEY = "???"; //$NON-NLS-1$

	@Override
	public String getResource(String arg0, String arg1, Tag arg2,
			PageContext arg3) {
		
		return Utilidades.getMessageBundle( arg0,  "labels");
	}

 
 

}