<%@ include file="/geral/header.jsp"%>

<script >
			function pesquisar(){
				document.forms['pesquisarDeclaracaoControladoria'].acao.value = 'pesquisar';
				document.forms['pesquisarDeclaracaoControladoria'].action = 'pesquisarDeclaracaoControladoria.do';
				document.forms['pesquisarDeclaracaoControladoria'].submit();
			
			}
			function excluir(codigo,descritor){
				if (confirm("Confirma a exclusão do registro '"+codigo+" - "+descritor+"'?")){
					document.forms['pesquisarDeclaracaoControladoria'].acao.value = 'excluir';
					document.forms['pesquisarDeclaracaoControladoria'].identificadorDeclaracaoControladoria.value = codigo;
					document.forms['pesquisarDeclaracaoControladoria'].action = 'pesquisarDeclaracaoControladoria.do';
					document.forms['pesquisarDeclaracaoControladoria'].submit();
				}
			
			}
			function novoRegistro(){
				document.forms['pesquisarDeclaracaoControladoria'].acao.value = 'novo';
				document.forms['pesquisarDeclaracaoControladoria'].action = 'cadastrarDeclaracaoControladoria.do';
				document.forms['pesquisarDeclaracaoControladoria'].submit();

			}
			function alterar(codigo){
				document.forms['pesquisarDeclaracaoControladoria'].acao.value = 'alterar';
				document.forms['pesquisarDeclaracaoControladoria'].action = 'cadastrarDeclaracaoControladoria.do';
				document.forms['pesquisarDeclaracaoControladoria'].identificadorDeclaracaoControladoria.value = codigo;
				document.forms['pesquisarDeclaracaoControladoria'].submit();

			}
			
</script>
<div class="breadcrumbs">
	<a href="./" >Home</a> &gt; Lista de <bean:message bundle="labels" key="pluralDeclaracaoControladoria"/>
</div>
<div id="content" class="colM">
<div id="content-main"> 


		<html:form action="pesquisarDeclaracaoControladoria" method="post" styleId='pesquisarDeclaracaoControladoria' >
		
		<h2><bean:message bundle="labels" key="DeclaracaoControladoria"/></h2>
		<h3>Lista de <bean:message bundle="labels" key="pluralDeclaracaoControladoria"/></h3>
		<div id="changelist" class="module">
		<%@ include file="/geral/menuPesquisa.jsp"%>
		
		<div class="gridArea">
			<div class="labelPesquisa">Pesquisar por:<html:select  property="atributoPesquisa" style="width: 200px" size="1">
			<html:option value="identificadorDeclaracaoControladoria"  bundle="labels" key="DeclaracaoControladoria.identificadorDeclaracaoControladoria"    />
			<html:option value="dataInicio"  bundle="labels" key="DeclaracaoControladoria.dataInicio"    />
			<html:option value="dataConclusao"  bundle="labels" key="DeclaracaoControladoria.dataConclusao"    />
			<html:option value="statusEdicao"  bundle="labels" key="DeclaracaoControladoria.statusEdicao"    />
	<html:option value="unidadeAdministrativa#alias_unidadeAdministrativa.nomeUnidadeAdministrativa"><bean:message bundle="labels" key="DeclaracaoControladoria.unidadeAdministrativa" /></html:option>
	</html:select>
		</div>
			<html:text property="valorAtributoPesquisa" style="width: 300px;" title="Parâmetro Pesquisa"/>
			<input id="btnPesquisar" name="btnPesquisar" type="button" value="Pesquisar" title="Pesquisar" onclick="javascript:pesquisar();">
			<div style="clear: both;"></div>
		</div>								
		
		<input type="hidden" name="opcao" value="<%=request.getParameter("opcao")!=null?request.getParameter("opcao"):request.getAttribute("opcao")%>"/>		
		<input type="hidden" name="acao" value="pesquisar"/>
		<input type="hidden" name="identificadorDeclaracaoControladoria" value=""/>
<display:table name="listaRegistros" id="row" pagesize="10" 	requestURI="pesquisarDeclaracaoControladoria.do"  style="width:100%">
 	<display:column titleKey="DeclaracaoControladoria.identificadorDeclaracaoControladoria"  style='width: 80px;text-align: right;'  headerClass='colunaIdentificador'    sortable="true" sortProperty="identificadorDeclaracaoControladoria">
			<a href="#" onclick="javascript:alterar(${row.id})" >${row.identificadorDeclaracaoControladoria}</a>
    	</display:column>
 	<display:column titleKey="DeclaracaoControladoria.dataInicio"   sortable="true" sortProperty="dataInicio">
	    	<a href="#" onclick="javascript:alterar(${row.id})" ><fmt:formatDate value="${row.dataInicio}" pattern="dd/MM/yyyy"/></a>
    	</display:column>
 	<display:column titleKey="DeclaracaoControladoria.dataConclusao"   sortable="true" sortProperty="dataConclusao">
	    	<a href="#" onclick="javascript:alterar(${row.id})" ><fmt:formatDate value="${row.dataConclusao}" pattern="dd/MM/yyyy"/></a>
    	</display:column>
 	<display:column titleKey="DeclaracaoControladoria.statusEdicao"   sortable="true" sortProperty="statusEdicao">
			<a href="#" onclick="javascript:alterar(${row.id})" >${row.statusEdicao}</a>
    	</display:column>
    <display:column titleKey="DeclaracaoControladoria.unidadeAdministrativa" sortable="true" sortProperty="unidadeAdministrativa.nomeUnidadeAdministrativa">
    	<a href="#" onclick="javascript:alterar(${row.id})" >${row.unidadeAdministrativa.nomeUnidadeAdministrativa}</a>
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