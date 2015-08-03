<%@ include file="/geral/header.jsp"%>
<div id="divTrocaSenha" style="min-width: 200px;"> 
<form action="trocarSenha.do" method="post" name="formTrocaSenha" id="formTrocaSenha">
	<input type="hidden" name="acao" value="trocar"/>
	<input type="submit" name="enviaForm" id="enviaForm" style="display:none" />
	<h2>Cadastro de Parâmetros:</h2>
Nome de Referência:	
<input  name="tempNomeGrupoParametro" id="tempNomeGrupoParametro" />
				<br>
				<input type="button" class="btn" value="Salvar"
								onclick="salvarParametros();" />
				<input type="button" class="btn" value="Voltar"
								onclick="hidePopup();" />
</form>


<%@ include file="/geral/mensagens.jsp"%>


</div>
<ajax:submit source="formTrocaSenha" target="divTrocaSenha"/>
