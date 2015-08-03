<%@ taglib uri="/tlds/ajaxtags.tld" prefix="ajax" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="/tlds/struts-tiles.tld" prefix="tiles" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Language" content="pt-br" />
<meta http-equiv="expires" content="Mon, 06 Jan 1990 00:00:01 GMT" />
<meta http-equiv="imagetoolbar" content="no"/>
<link href="./geral/css/ajaxtags.css"	rel="stylesheet" type="text/css" />
<link href="./geral/css/displaytag.css"	rel="stylesheet" type="text/css" />
<link href="./geral/css/datepicker.css"	rel="stylesheet" type="text/css" />
<style type="">
.campoIdentificador{
	text-align: right;
	background-color:#EEE;
}
.campoNumero{
	text-align: right;	
}

.somenteLeitura{
	background-color:#EEE;
}
.colunaIdentificador{
	width: 80px;
	text-align: right;
}
.colunaNumero{
	width: 100px;
	text-align: right;
}
.campoGrande{
width: 320px;
}
.campoMedio{
width: 160px;
}
.campoPequeno{
width: 80px;
}
.datefield{
width: 60px;
}
.timefield{
width: 60px;
}
.mensagemErro{
color: red;
 
}
.colunaExcluir{
	width: 40px;
}
.registroInativo{
	background-color: #FFCCCC;
}

#fundoPopup{

}

#divPopup{


}
.ocultaTransbordo{
	white-space: nowrap;
	overflow: hidden;
}
.labelPesquisa{
min-width: 18em !important;
}

input[type="file"]{
padding: 3px 4px 4px !important;
    height: 24px;
    color: #555; font-weight: bold; line-height: 16px;
    border: 1px solid #bbb;
    border-color: #ddd #bbb #bbb #ddd !important;
  }
</style>
<tiles:insert attribute="scripts"/>

<script type="text/javascript" src="./geral/js/prototype.js" ></script>

<script type="text/javascript" src="./geral/js/scriptaculous.js"  ></script>
<script type="text/javascript" src="./geral/js/overlibmws.js"  ></script>
<script type="text/javascript" src="./geral/js/ajaxtags.js"  ></script>
<script type="text/javascript" src="./geral/js/datepicker.js"  ></script>
<script type="text/javascript" src="./geral/js/datepicker.init.js"  ></script>
<script type="text/javascript" src="./geral/js/scripts_scf.js"  ></script>

<title><tiles:getAsString name="titulo"/> </title>
</head>
<body >

	<div id="container">
		<div id="header">
			<tiles:insert attribute="cabecalhoItec" />
		</div>
		<tiles:insert attribute="corpo" />
		<div id="footer">
			<span id="progressMsg" class="indicator"
				style="display: none; background-color: red">.</span> <span
				id="indicator" class="indicator" style="display: none;">indicador</span>
			<tiles:insert attribute="rodape" />
		</div>
		<div id="fundoPopup" class="fundoPopup"
			style="display: none; position: fixed; top: 0; left: 0; right: 0; bottom:0;  border: 0; margin: 0; padding: 0; border-style: none; background-color: #999; filter: alpha(opacity =90); opacity: .9;z-index: 10; ">

			<div id='divPopup'
				style="position:absolute ; z-index: 1000; border: 1px solid #000; background-color: #FFFFFF; cursor: pointer; padding: 10px; display: none; left: 300px; top: 100px; filter: alpha(opacity = 100); opacity: 1.0;">
				
			</div>
		</div>
	</div>


	<input id="campoTemporario" name="campoTemporario" type="hidden"/>
<script>
jQuery('form').attr("autocomplete","off");

</script>

</body>
</html>  