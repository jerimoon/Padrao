package org.apache.jsp.geral;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class layoutCadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/tlds/ajaxtags.tld");
    _jspx_dependants.add("/tlds/struts-tiles.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fgetAsString_0026_005fname_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005fgetAsString_0026_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.release();
    _005fjspx_005ftagPool_005ftiles_005fgetAsString_0026_005fname_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n");
      out.write("        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"pt\" lang=\"pt\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE8\" />\r\n");
      out.write("<meta http-equiv=\"Content-Language\" content=\"pt-br\" />\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"Mon, 06 Jan 1990 00:00:01 GMT\" />\r\n");
      out.write("<meta http-equiv=\"imagetoolbar\" content=\"no\"/>\r\n");
      out.write("<link href=\"./geral/css/ajaxtags.css\"\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"./geral/css/displaytag.css\"\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"./geral/css/datepicker.css\"\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<style type=\"\">\r\n");
      out.write(".campoIdentificador{\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("\tbackground-color:#EEE;\r\n");
      out.write("}\r\n");
      out.write(".campoNumero{\r\n");
      out.write("\ttext-align: right;\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".somenteLeitura{\r\n");
      out.write("\tbackground-color:#EEE;\r\n");
      out.write("}\r\n");
      out.write(".colunaIdentificador{\r\n");
      out.write("\twidth: 80px;\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("}\r\n");
      out.write(".colunaNumero{\r\n");
      out.write("\twidth: 100px;\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("}\r\n");
      out.write(".campoGrande{\r\n");
      out.write("width: 320px;\r\n");
      out.write("}\r\n");
      out.write(".campoMedio{\r\n");
      out.write("width: 160px;\r\n");
      out.write("}\r\n");
      out.write(".campoPequeno{\r\n");
      out.write("width: 80px;\r\n");
      out.write("}\r\n");
      out.write(".datefield{\r\n");
      out.write("width: 60px;\r\n");
      out.write("}\r\n");
      out.write(".timefield{\r\n");
      out.write("width: 60px;\r\n");
      out.write("}\r\n");
      out.write(".mensagemErro{\r\n");
      out.write("color: red;\r\n");
      out.write(" \r\n");
      out.write("}\r\n");
      out.write(".colunaExcluir{\r\n");
      out.write("\twidth: 40px;\r\n");
      out.write("}\r\n");
      out.write(".registroInativo{\r\n");
      out.write("\tbackground-color: #FFCCCC;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#fundoPopup{\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#divPopup{\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write(".ocultaTransbordo{\r\n");
      out.write("\twhite-space: nowrap;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("}\r\n");
      out.write(".labelPesquisa{\r\n");
      out.write("min-width: 18em !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"file\"]{\r\n");
      out.write("padding: 3px 4px 4px !important;\r\n");
      out.write("    height: 24px;\r\n");
      out.write("    color: #555; font-weight: bold; line-height: 16px;\r\n");
      out.write("    border: 1px solid #bbb;\r\n");
      out.write("    border-color: #ddd #bbb #bbb #ddd !important;\r\n");
      out.write("  }\r\n");
      out.write("</style>\r\n");
      if (_jspx_meth_tiles_005finsert_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"./geral/js/prototype.js\" ></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"./geral/js/scriptaculous.js\"  ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"./geral/js/overlibmws.js\"  ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"./geral/js/ajaxtags.js\"  ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"./geral/js/datepicker.js\"  ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"./geral/js/datepicker.init.js\"  ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"./geral/js/scripts_scf.js\"  ></script>\r\n");
      out.write("\r\n");
      out.write("<title>");
      if (_jspx_meth_tiles_005fgetAsString_005f0(_jspx_page_context))
        return;
      out.write(" </title>\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<div id=\"header\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_tiles_005finsert_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
      if (_jspx_meth_tiles_005finsert_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t<div id=\"footer\">\r\n");
      out.write("\t\t\t<span id=\"progressMsg\" class=\"indicator\"\r\n");
      out.write("\t\t\t\tstyle=\"display: none; background-color: red\">.</span> <span\r\n");
      out.write("\t\t\t\tid=\"indicator\" class=\"indicator\" style=\"display: none;\">indicador</span>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_tiles_005finsert_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"fundoPopup\" class=\"fundoPopup\"\r\n");
      out.write("\t\t\tstyle=\"display: none; position: fixed; top: 0; left: 0; right: 0; bottom:0;  border: 0; margin: 0; padding: 0; border-style: none; background-color: #999; filter: alpha(opacity =90); opacity: .9;z-index: 10; \">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id='divPopup'\r\n");
      out.write("\t\t\t\tstyle=\"position:absolute ; z-index: 1000; border: 1px solid #000; background-color: #FFFFFF; cursor: pointer; padding: 10px; display: none; left: 300px; top: 100px; filter: alpha(opacity = 100); opacity: 1.0;\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<input id=\"campoTemporario\" name=\"campoTemporario\" type=\"hidden\"/>\r\n");
      out.write("<script>\r\n");
      out.write("jQuery('form').attr(\"autocomplete\",\"off\");\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>  ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_tiles_005finsert_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.tiles.taglib.InsertTag _jspx_th_tiles_005finsert_005f0 = (org.apache.struts.tiles.taglib.InsertTag) _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.get(org.apache.struts.tiles.taglib.InsertTag.class);
    _jspx_th_tiles_005finsert_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsert_005f0.setParent(null);
    // /geral/layoutCadastro.jsp(85,0) name = attribute type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f0.setAttribute("scripts");
    int _jspx_eval_tiles_005finsert_005f0 = _jspx_th_tiles_005finsert_005f0.doStartTag();
    if (_jspx_th_tiles_005finsert_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005fgetAsString_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:getAsString
    org.apache.struts.tiles.taglib.GetAttributeTag _jspx_th_tiles_005fgetAsString_005f0 = (org.apache.struts.tiles.taglib.GetAttributeTag) _005fjspx_005ftagPool_005ftiles_005fgetAsString_0026_005fname_005fnobody.get(org.apache.struts.tiles.taglib.GetAttributeTag.class);
    _jspx_th_tiles_005fgetAsString_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fgetAsString_005f0.setParent(null);
    // /geral/layoutCadastro.jsp(96,7) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fgetAsString_005f0.setName("titulo");
    int _jspx_eval_tiles_005fgetAsString_005f0 = _jspx_th_tiles_005fgetAsString_005f0.doStartTag();
    if (_jspx_th_tiles_005fgetAsString_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fgetAsString_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005fgetAsString_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fgetAsString_0026_005fname_005fnobody.reuse(_jspx_th_tiles_005fgetAsString_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsert_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.tiles.taglib.InsertTag _jspx_th_tiles_005finsert_005f1 = (org.apache.struts.tiles.taglib.InsertTag) _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.get(org.apache.struts.tiles.taglib.InsertTag.class);
    _jspx_th_tiles_005finsert_005f1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsert_005f1.setParent(null);
    // /geral/layoutCadastro.jsp(102,3) name = attribute type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f1.setAttribute("cabecalhoItec");
    int _jspx_eval_tiles_005finsert_005f1 = _jspx_th_tiles_005finsert_005f1.doStartTag();
    if (_jspx_th_tiles_005finsert_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f1);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsert_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.tiles.taglib.InsertTag _jspx_th_tiles_005finsert_005f2 = (org.apache.struts.tiles.taglib.InsertTag) _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.get(org.apache.struts.tiles.taglib.InsertTag.class);
    _jspx_th_tiles_005finsert_005f2.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsert_005f2.setParent(null);
    // /geral/layoutCadastro.jsp(104,2) name = attribute type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f2.setAttribute("corpo");
    int _jspx_eval_tiles_005finsert_005f2 = _jspx_th_tiles_005finsert_005f2.doStartTag();
    if (_jspx_th_tiles_005finsert_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f2);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsert_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.tiles.taglib.InsertTag _jspx_th_tiles_005finsert_005f3 = (org.apache.struts.tiles.taglib.InsertTag) _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.get(org.apache.struts.tiles.taglib.InsertTag.class);
    _jspx_th_tiles_005finsert_005f3.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsert_005f3.setParent(null);
    // /geral/layoutCadastro.jsp(109,3) name = attribute type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f3.setAttribute("rodape");
    int _jspx_eval_tiles_005finsert_005f3 = _jspx_th_tiles_005finsert_005f3.doStartTag();
    if (_jspx_th_tiles_005finsert_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fattribute_005fnobody.reuse(_jspx_th_tiles_005finsert_005f3);
    return false;
  }
}
