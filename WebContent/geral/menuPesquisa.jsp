<%@ include file="/geral/header.jsp"%>
	<div class="object-tools" style="position: relative;">
		<c:if test="${permissaoEscrita}">
			<input id="btnIncluir" name="btnIncluir" type="button"
				onclick="javascript:novoRegistro();" value="Incluir" title="Incluir"
				class="default">
		</c:if>
	</div>