<%@ include file="/geral/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta http-equiv="Content-Language" content="pt-BR" />
<div id="divLovCondutor" style="width: 600px;">

	<h3>
		Lista de Parâmetros salvos
	</h3>
	
	<form action="./inicio.do" name="formLov" id="formLov">
	<fieldset class="module aligned wide">
				<div class="form-row">
		<img src="./geral/img/pesquisa.png" alt="Pesquisar"  />
		<input type="text" id="parametroPesquisa" name="parametroPesquisa" class="campoCadastro" style="width: 300px;">
		<input type="submit" value="Pesquisar">
		<input type="hidden" name="acao" value="listaGrupoParametro">
				</div>
				
</fieldset>				
	</form>
	<display:table name="listaGrupoParametro" id="row" pagesize="30"
		style="width:100%">
		<display:column title="Id"
			style='width: 40px;text-align: right;'
			 sortProperty="id">
			 <a href="#" onclick="javascript:carregarParametros(${row.id})">${row.id}</a>
		</display:column>
		<display:column title="Nome" style="width: 160px;">
			<a href="#" onclick="javascript:carregarParametros(${row.id})">${row.nomeGrupoParametro}</a>
		</display:column>
		<display:column title="Data" style='width: 80px;'>
			<a href="#" onclick="javascript:carregarParametros(${row.id})">
			<fmt:formatDate value="${row.dataGrupoParametro}" pattern="dd/MM/yyyy HH:mm:ss"/>
			</a>
		</display:column>
		
	</display:table>
	<br>
<input type="button" class="btn" value="Voltar"
								onclick="hidePopup();" />

</div>
<%@ include file="/geral/mensagens.jsp"%>
<ajax:submit source="formLov" target="divPopup"/>
