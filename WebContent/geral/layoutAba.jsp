<%@ taglib uri="/tlds/struts-tiles.tld" prefix="tiles" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<meta http-equiv="Content-Language" content="pt-BR" />
<tiles:insert attribute="corpo"/>
<script>
try {

jQuery('form').attr("autocomplete","off");
} catch (e) {
	// TODO: handle exception
}
</script>