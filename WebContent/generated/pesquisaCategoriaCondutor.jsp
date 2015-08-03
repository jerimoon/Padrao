<%@ include file="/geral/header.jsp"%>

<script >
			function pesquisar(){
				document.forms['pesquisarCategoriaCondutor'].acao.value = 'pesquisar';
				document.forms['pesquisarCategoriaCondutor'].action = 'pesquisarCategoriaCondutor.do';
				document.forms['pesquisarCategoriaCondutor'].submit();
			
			}
			function excluir(codigo,descritor){
				if (confirm("Confirma a exclusão do registro '"+codigo+" - "+descritor+"'?")){
					document.forms['pesquisarCategoriaCondutor'].acao.value = 'excluir';
					document.forms['pesquisarCategoriaCondutor'].identificadorCategoriaCondutor.value = codigo;
					document.forms['pesquisarCategoriaCondutor'].action = 'pesquisarCategoriaCondutor.do';
					document.forms['pesquisarCategoriaCondutor'].submit();
				}
			
			}
			function novoRegistro(){
				document.forms['pesquisarCategoriaCondutor'].acao.value = 'novo';
				document.forms['pesquisarCategoriaCondutor'].action = 'cadastrarCategoriaCondutor.do';
				document.forms['pesquisarCategoriaCondutor'].submit();

			}
			function alterar(codigo){
				document.forms['pesquisarCategoriaCondutor'].acao.value = 'alterar';
				document.forms['pesquisarCategoriaCondutor'].action = 'cadastrarCategoriaCondutor.do';
				document.forms['pesquisarCategoriaCondutor'].identificadorCategoriaCondutor.value = codigo;
				document.forms['pesquisarCategoriaCondutor'].submit();

			}
			
</script>
<div class="breadcrumbs">
	<a href="./" >Home</a> &gt; Lista de <bean:message bundle="labels" key="pluralCategoriaCondutor"/>
</div>
<div id="content" class="colM">
<div id="content-main"> 


		<html:form action="pesquisarCategoriaCondutor" method="post" styleId='pesquisarCategoriaCondutor' >
		
		<h2><bean:message bundle="labels" key="CategoriaCondutor"/></h2>
		<h3>Lista de <bean:message bundle="labels" key="pluralCategoriaCondutor"/></h3>
		<div id="changelist" class="module">
		<%@ include file="/geral/menuPesquisa.jsp"%>
		
		<div class="gridArea">
			<div class="labelPesquisa">Pesquisar por:<html:select  property="atributoPesquisa" style="width: 200px" size="1">
			<html:option value="identificadorCategoriaCondutor"  bundle="labels" key="CategoriaCondutor.identificadorCategoriaCondutor"    />
			<html:option value="codigoCategoriaCondutor"  bundle="labels" key="CategoriaCondutor.codigoCategoriaCondutor"    />
			<html:option value="descricaoCategoriaCondutor"  bundle="labels" key="CategoriaCondutor.descricaoCategoriaCondutor"    />
	</html:select>
		</div>
			<html:text property="valorAtributoPesquisa" style="width: 300px;" title="Parâmetro Pesquisa"/>
			<input id="btnPesquisar" name="btnPesquisar" type="button" value="Pesquisar" title="Pesquisar" onclick="javascript:pesquisar();">
			<div style="clear: both;"></div>
		</div>								
		
		<input type="hidden" name="opcao" value="<%=request.getParameter("opcao")!=null?request.getParameter("opcao"):request.getAttribute("opcao")%>"/>		
		<input type="hidden" name="acao" value="pesquisar"/>
		<input type="hidden" name="identificadorCategoriaCondutor" value=""/>
<display:table name="listaRegistros" id="row" pagesize="10" 	requestURI="pesquisarCategoriaCondutor.do"  style="width:100%">
 	<display:column titleKey="CategoriaCondutor.identificadorCategoriaCondutor"  style='width: 80px;text-align: right;'  headerClass='colunaIdentificador'    sortable="true" sortProperty="identificadorCategoriaCondutor">
			<a href="#" onclick="javascript:alterar(${row.id})" >${row.identificadorCategoriaCondutor}</a>
    	</display:column>
 	<display:column titleKey="CategoriaCondutor.codigoCategoriaCondutor"   sortable="true" sortProperty="codigoCategoriaCondutor">
			<a href="#" onclick="javascript:alterar(${row.id})" >${row.codigoCategoriaCondutor}</a>
    	</display:column>
 	<display:column titleKey="CategoriaCondutor.descricaoCategoriaCondutor"   sortable="true" sortProperty="descricaoCategoriaCondutor">
			<a href="#" onclick="javascript:alterar(${row.id})" >${row.descricaoCategoriaCondutor}</a>
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