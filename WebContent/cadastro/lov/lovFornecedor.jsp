<%@ include file="/geral/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta http-equiv="Content-Language" content="pt-BR" />
<div id="divLovFornecedor" style="width: 500px;">

	<h3>
		Lista de
		<bean:message bundle="labels" key="pluralFornecedor" />
	</h3>
	
	<form action="./lovFornecedor.do" name="formLov" id="formLov">
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
		<display:column titleKey="Fornecedor.identificadorFornecedor"
			style='width: 80px;text-align: right;'
			 sortProperty="id">
			 <a href="#" onclick="javascript:retornarLov({'identificadorFornecedor':'${row.id}','textoNome':'${row.textoNome}'})">${row.id}</a>
		</display:column>
		<display:column titleKey="Fornecedor.textoNome" >
			<a href="#" onclick="javascript:retornarLov({'identificadorFornecedor':'${row.id}','textoNome':'${row.textoNome}'})">${row.textoNome}</a>
		</display:column>
		
	</display:table>
	<br>

</div>
<%@ include file="/geral/mensagens.jsp"%>
<ajax:submit source="formLov" target="divPopup"/>
