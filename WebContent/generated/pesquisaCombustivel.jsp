<%@ include file="/geral/header.jsp"%>

<script >
			function pesquisar(){
				document.forms['pesquisarCombustivel'].acao.value = 'pesquisar';
				document.forms['pesquisarCombustivel'].action = 'pesquisarCombustivel.do';
				document.forms['pesquisarCombustivel'].submit();
			
			}
			function excluir(codigo,descritor){
				if (confirm("Confirma a exclusão do registro '"+codigo+" - "+descritor+"'?")){
					document.forms['pesquisarCombustivel'].acao.value = 'excluir';
					document.forms['pesquisarCombustivel'].identificadorCombustivel.value = codigo;
					document.forms['pesquisarCombustivel'].action = 'pesquisarCombustivel.do';
					document.forms['pesquisarCombustivel'].submit();
				}
			
			}
			function novoRegistro(){
				document.forms['pesquisarCombustivel'].acao.value = 'novo';
				document.forms['pesquisarCombustivel'].action = 'cadastrarCombustivel.do';
				document.forms['pesquisarCombustivel'].submit();

			}
			function alterar(codigo){
				document.forms['pesquisarCombustivel'].acao.value = 'alterar';
				document.forms['pesquisarCombustivel'].action = 'cadastrarCombustivel.do';
				document.forms['pesquisarCombustivel'].identificadorCombustivel.value = codigo;
				document.forms['pesquisarCombustivel'].submit();

			}
			
</script>
<div class="breadcrumbs">
	<a href="./" >Home</a> &gt; Lista de <bean:message bundle="labels" key="pluralCombustivel"/>
</div>
<div id="content" class="colM">
<div id="content-main"> 


		<html:form action="pesquisarCombustivel" method="post" styleId='pesquisarCombustivel' >
		
		<h2><bean:message bundle="labels" key="Combustivel"/></h2>
		<h3>Lista de <bean:message bundle="labels" key="pluralCombustivel"/></h3>
		<div id="changelist" class="module">
		<%@ include file="/geral/menuPesquisa.jsp"%>
		
		<div class="gridArea">
			<div class="labelPesquisa">Pesquisar por:<html:select  property="atributoPesquisa" style="width: 200px" size="1">
			<html:option value="identificadorCombustivel"  bundle="labels" key="Combustivel.identificadorCombustivel"    />
			<html:option value="nomeCombustivel"  bundle="labels" key="Combustivel.nomeCombustivel"    />
	</html:select>
		</div>
			<html:text property="valorAtributoPesquisa" style="width: 300px;" title="Parâmetro Pesquisa"/>
			<html:select  property="situacao" style="width: 80px; min-width:80px; vertical-align:super;"  >
				<html:option value="T" >TODOS</html:option>
				<html:option value="A">ATIVOS</html:option>
				<html:option value="I">INATIVOS</html:option>
			</html:select>
			<input id="btnPesquisar" name="btnPesquisar" type="button" value="Pesquisar" title="Pesquisar" onclick="javascript:pesquisar();">
			<div style="clear: both;"></div>
		</div>								
		
		<input type="hidden" name="opcao" value="<%=request.getParameter("opcao")!=null?request.getParameter("opcao"):request.getAttribute("opcao")%>"/>		
		<input type="hidden" name="acao" value="pesquisar"/>
		<input type="hidden" name="identificadorCombustivel" value=""/>
<display:table name="listaRegistros" id="row" pagesize="10" 	requestURI="pesquisarCombustivel.do"  style="width:100%">
 	<display:column titleKey="Combustivel.identificadorCombustivel"  style='width: 80px;text-align: right;'  headerClass='colunaIdentificador'    sortable="true" sortProperty="identificadorCombustivel">
			<a href="#" onclick="javascript:alterar(${row.id})" >${row.identificadorCombustivel}</a>
    	</display:column>
 	<display:column titleKey="Combustivel.nomeCombustivel"   sortable="true" sortProperty="nomeCombustivel">
			<a href="#" onclick="javascript:alterar(${row.id})" >${row.nomeCombustivel}</a>
    	</display:column>
 	<display:column titleKey="Combustivel.ativo" sortable="true" sortProperty="ativo"  >
		<c:set var="checked" value=""/>
		<c:if test="${row.ativo}">
			<c:set var="checked" value=" checked='checked' "/>
		</c:if>
		<a href="#" onclick="javascript:alterar(${row.id})" >
			<input type="checkbox" ${checked} readonly="readonly" contenteditable="false" >
		</a>
	</display:column>
<c:if test="${permissaoEscrita}">
	  <display:column title="Excluir"  style='width: 40px;text-align: center; '> 
		  <a href="#" onclick="javascript:excluir(${row.id},'${row.descritor}')" >
				<img src="./geral/img/delete.gif" alt="Excluir" />
		  </a>
	  </display:column>
</c:if>	  
</display:table>
<br><br><br>
</div>	
	<%@ include file="/geral/mensagens.jsp"%>
	</html:form>		
</div>
</div>