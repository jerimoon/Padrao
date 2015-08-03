<%@ include file="/geral/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta http-equiv="Content-Language" content="pt-BR" />
<div id="divLovVeiculo" style="width: 500px;">

	<h3>
		Lista de
		<bean:message bundle="labels" key="pluralVeiculo" />
	</h3>
	
	<form action="./lovVeiculo.do" name="formLov" id="formLov">
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
		<display:column titleKey="Veiculo.identificadorVeiculo"
			style='width: 80px;text-align: right;'
			 sortProperty="id">
			 <a href="#" onclick="javascript:retornarLov({'veiculo':'${row.id}','numeroPlaca':'${row.numeroPlaca}','nomeModelo':'${row.modelo.nomeModelo}'})">${row.id}</a>
		</display:column>
		<display:column titleKey="Veiculo.numeroPlaca" style="width: 80px;">
			<a href="#" onclick="javascript:retornarLov({'veiculo':'${row.id}','numeroPlaca':'${row.numeroPlaca}','nomeModelo':'${row.modelo.nomeModelo}'})">${row.numeroPlaca}</a>
		</display:column>
		<display:column titleKey="Veiculo.modelo" >
			<a href="#" onclick="javascript:retornarLov({'veiculo':'${row.id}','numeroPlaca':'${row.numeroPlaca}','nomeModelo':'${row.modelo.nomeModelo}'})">${row.modelo.nomeModelo}</a>
		</display:column>
		
	</display:table>
	<br>

</div>
<%@ include file="/geral/mensagens.jsp"%>
<ajax:submit source="formLov" target="divPopup"/>
