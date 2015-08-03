<%@ include file="/geral/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta http-equiv="Content-Language" content="pt-BR" />
<div id="divLovCondutor" style="width: 600px;">

	<h3>
		Lista de
		<bean:message bundle="labels" key="pluralCondutor" />
	</h3>
	
	<form action="./lovCondutor.do" name="formLov" id="formLov">
	<fieldset class="module aligned wide">


				<div class="form-row">
		<img src="./geral/img/pesquisa.png" alt="Pesquisar"  />
		<input type="text" id="parametroPesquisa" name="parametroPesquisa" class="campoCadastro" style="width: 300px;">
		<input type="submit" value="Pesquisar">

				</div>
</fieldset>				
	</form>
	<display:table name="listaRegistros" id="row" pagesize="30"
		style="width:100%">
		<display:column titleKey="Condutor.identificadorCondutor"
			style='width: 40px;text-align: right;'
			 sortProperty="id">
			 <a href="#" onclick="javascript:retornarLov({'condutor':'${row.id}','nomeCondutor':'${row.nomeCondutor}','siglaSetor':'${row.setor.siglaSetor}'})">${row.id}</a>
		</display:column>
		<display:column titleKey="Condutor.nomeCondutor" style="width: 160px;">
			<a href="#" onclick="javascript:retornarLov({'condutor':'${row.id}','nomeCondutor':'${row.nomeCondutor}','siglaSetor':'${row.setor.siglaSetor}'})">${row.nomeCondutor}</a>
		</display:column>
		<display:column titleKey="Condutor.setor" style='width: 80px;'>
			<a href="#" onclick="javascript:retornarLov({'condutor':'${row.id}','nomeCondutor':'${row.nomeCondutor}','siglaSetor':'${row.setor.siglaSetor}'})">${row.setor.siglaSetor}</a>
		</display:column>
		<display:column titleKey="Condutor.dataValidadeCnh" style='width: 80px;'>
<c:set var="estiloValidade" value=""/>
<c:if test="${row.dataValidadeCnh lt f:dataAtual()}">
	<c:set var="estiloValidade" value="color: red !important;"/>
</c:if>		
			<a href="#" style="${estiloValidade}" onclick="javascript:retornarLov({'condutor':'${row.id}','nomeCondutor':'${row.nomeCondutor}','siglaSetor':'${row.setor.siglaSetor}'})"><fmt:formatDate value="${row.dataValidadeCnh}" pattern="dd/MM/yyyy"/></a>
		</display:column>
		
	</display:table>
	<br>

</div>
<%@ include file="/geral/mensagens.jsp"%>
<ajax:submit source="formLov" target="divPopup"/>
