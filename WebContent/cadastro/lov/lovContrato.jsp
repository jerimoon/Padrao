<%@ include file="/geral/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta http-equiv="Content-Language" content="pt-BR" />
<div id="divLovContrato" style="width: 500px;">

	<h3>
		Lista de
		<bean:message bundle="labels" key="pluralContrato" />
	</h3>
	
	<form action="./lovContrato.do" name="formLov" id="formLov">
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
		<display:column titleKey="Contrato.identificadorContrato"
			style='width: 80px;text-align: right;'
			 sortProperty="id">
			 <a href="#" onclick="javascript:retornarLov({'contrato':'${row.id}','textoObjeto':'${row.textoObjeto}','textoNumeroContrato':'${row.textoNumeroContrato}'})">${row.id}</a>
		</display:column>
		<display:column titleKey="Contrato.textoNumeroContrato" >
			<a href="#" onclick="javascript:retornarLov({'contrato':'${row.id}','textoObjeto':'${row.textoObjeto}','textoNumeroContrato':'${row.textoNumeroContrato}'})">${row.textoNumeroContrato}</a>
		</display:column>
		<display:column titleKey="Contrato.textoObjeto" >
			<a href="#" onclick="javascript:retornarLov({'contrato':'${row.id}','textoObjeto':'${row.textoObjeto}','textoNumeroContrato':'${row.textoNumeroContrato}'})">${row.textoObjeto}</a>
		</display:column>
		
	</display:table>
	<br>

</div>
<%@ include file="/geral/mensagens.jsp"%>
<ajax:submit source="formLov" target="divPopup"/>
 
