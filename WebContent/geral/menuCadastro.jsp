<%@ include file="/geral/header.jsp"%>
<c:if test="${permissaoEscrita}">
	<span id="salvar:botoest" style="font-size: 13px">
		<div class="submit-row">
			<input id="btnSalvar" name="btnSalvar" type="button" value="Salvar"
				onclick="javascript:salvar()" title="Salvar" class="default">
		</div>

	</span>

</c:if>

