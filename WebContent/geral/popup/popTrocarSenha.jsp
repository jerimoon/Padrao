<%@ include file="/geral/header.jsp"%>
<div id="divTrocaSenha" style="min-width: 200px;"> 
<form action="trocarSenha.do" method="post" name="formTrocaSenha" id="formTrocaSenha">
	<input type="hidden" name="acao" value="trocar"/>
	<input type="submit" name="enviaForm" id="enviaForm" style="display:none" />
	<h2>Troca de Senha</h2>
	<h3>Usuário:${usuarioLogado.nomeUsuario}</h3>
	
<c:choose>	
	<c:when test="${sucessoAlteracaoSenha}">
		<br>
		<h4>Senha alterada com sucesso</h4>
		<br>
		<br>
		<div class="submit-row">
		<input type="button" value="Fechar" onclick="javascript:hidePopup()" class="default">
		</div>
	</c:when>
	<c:otherwise>
		<fieldset class="module aligned wide">
				
		
		<div class="form-row">
			<label  for="senhaAtual" class="  labelCadastro">Senha Atual</label>
			<input id="senhaAtual" name="senhaAtual" type="password" >
		</div>
		<div class="form-row">
			<label  for="novaSenha" class="  labelCadastro">Senha Nova</label>
			<input id="novaSenha" name="novaSenha" type="password" >
		</div>
		<div class="form-row">
			<label  for="senhaNova" class="  labelCadastro">Confirmação Senha</label>
			<input id="senhaNova" name="senhaNova" type="password" >
		</div>
		
		
		<div class="submit-row">
			<input id="btnSalvar" name="btnSalvar" type="button" value="Confirmar"
						onclick="javascript:trocarSenhaUsuario()" title="Confirmar alteração da senha" class="default">
			<input type="button" value="Fechar" onclick="javascript:hidePopup()" class="default">
		</div>
		
		
		</fieldset>
		
	</c:otherwise>
</c:choose>
</form>


<%@ include file="/geral/mensagens.jsp"%>


</div>
<ajax:submit source="formTrocaSenha" target="divTrocaSenha"/>
