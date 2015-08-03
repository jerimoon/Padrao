<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8"%>  
<%@ taglib uri="/tlds/struts-tiles.tld" prefix="tiles" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta http-equiv="Content-Language" content="pt-BR" />

<meta http-equiv="imagetoolbar" content="no"/>
<title>SCF - Sistema de Controle de Frotas</title>
<script src="./geral/js/jquery.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="./geral/css/login.css" />
<link href="./geral/css/displaytag.css"	rel="stylesheet" type="text/css" />
	

<style type="">
input[type="button"] {
	background-image: none !important;
	background-color: #104e8b !important;
	color: #fff !important;
	float: right;
	width: 140px;
	height: 34px;
	font-size: 20px !important;
	font-weight: bold;
	line-height: 16px;
	border: 1px solid #bbb;
	border-color: #ddd #bbb #bbb #ddd !important;
	padding: 4px !important;
	cursor: pointer;
	clear: both;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	margin-top: 20px;
}
</style>
<script src="./geral/js/geral.js"
	type="text/javascript"></script>
<script src="./geral/js/jquery.js"></script>
<script
	src="./geral/js/jquery.maskedinput-1.2.2.js"></script>

<script type="text/javascript">
	var jQuery = $.noConflict();
	function enter(event, div) {
		if (event.keyCode == 13) {
			document.getElementById(div).click();
		}
	}
</script>
</head>

<body class="">

	<!-- Container -->
	<div id="container">
		<center>
			<div id="content" class="colM">
				<div id="topo">
					<img
						src="./geral/img/admin/brasao.png" /><br />
					<br /> <span>Instituto de Tecnologia em Informática e
						Informação do Estado de Alagoas</span><br /> <span>SCF - Sistema de
						Controle de Frotas</span><br />
				</div>
				<div id="corpo">
					<tiles:insert attribute="corpo" />
				</div>
				<div id="creditos">
					<p>
						<strong>Desenvolvido por:</strong><br />Fábrica de Sistemas
					</p>
					<img
						src="./geral/img/admin/logo-itec.png" />
				</div>
			</div>
		</center>


	</div>
	<!-- END Container -->

</body>
</html>
