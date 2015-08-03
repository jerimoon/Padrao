<%@ include file="/geral/header.jsp"%>
<c:forEach var="mensagem" items="${listaMensagens}">
	<h4>${mensagem}</h4>
</c:forEach>
<c:forEach var="erro" items="${listaErros}" >
	<h4 class="mensagemErro">${erro}</h4>
</c:forEach>
<c:if test="${listaErros ne null}">
 <br><br>
</c:if>

