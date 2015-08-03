<%@ taglib uri="/tlds/struts-tiles.tld" prefix="tiles" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<meta http-equiv="Content-Language" content="pt-BR" />
	<tiles:insert attribute="corpo"/>
<div class="submit-row">
	<input type="button" value="Fechar" onclick="javascript:hidePopup()" class="default">
</div>
<script  type="text/javascript"  >
        document.getElementById("parametroPesquisa").focus();
 </script> 