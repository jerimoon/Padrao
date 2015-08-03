

<%@ include file="/geral/header.jsp"%>
<script>
	function salvar(){
		if (validar()){
			document.forms['cadastrarDeclaracaoControladoria'].acao.value = 'salvar';
			document.forms['cadastrarDeclaracaoControladoria'].action = 'cadastrarDeclaracaoControladoria.do';
			document.forms['cadastrarDeclaracaoControladoria'].enviaForm.click();
		}

	}
	function pesquisar(){
		document.forms['cadastrarDeclaracaoControladoria'].acao.value = 'pesquisar';
		document.forms['cadastrarDeclaracaoControladoria'].action = 'pesquisarDeclaracaoControladoria.do';
		document.forms['cadastrarDeclaracaoControladoria'].submit();

	}
	function novoRegistro(){
				document.forms['cadastrarDeclaracaoControladoria'].acao.value = 'novo';
				document.forms['cadastrarDeclaracaoControladoria'].action = 'cadastrarDeclaracaoControladoria.do';
				document.forms['cadastrarDeclaracaoControladoria'].submit();

	}
	function validar(){
		var retorno = true;
		if (document.forms['cadastrarDeclaracaoControladoria'].dataInicio.value==''){
			retorno = false;
			alert('O campo <bean:message bundle="labels" key="DeclaracaoControladoria.dataInicio"/> é obrigatório!');
		}
		if (document.forms['cadastrarDeclaracaoControladoria'].dataConclusao.value==''){
			retorno = false;
			alert('O campo <bean:message bundle="labels" key="DeclaracaoControladoria.dataConclusao"/> é obrigatório!');
		}
		if (document.forms['cadastrarDeclaracaoControladoria'].statusEdicao.value==''){
			retorno = false;
			alert('O campo <bean:message bundle="labels" key="DeclaracaoControladoria.statusEdicao"/> é obrigatório!');
		}
		return retorno;
	}
</script>

<div class="breadcrumbs">
	<a href="./" >Home</a> &gt; <a href="#" onclick="javascript:pesquisar()" >Lista de <bean:message bundle="labels" key="pluralDeclaracaoControladoria"/></a> &gt; Cadastro de <bean:message bundle="labels" key="DeclaracaoControladoria"/>
</div>

<div id="content" class="colM">
<div id="content-main"> 



	<html:form action="cadastrarDeclaracaoControladoria" method="post" styleId='cadastrarDeclaracaoControladoria'>
	<input type="hidden" name="acao" value="pesquisar"/>
	<input type="submit" name="enviaForm" id="enviaForm" style="display:none" />
	<h2>Cadastro de <bean:message bundle="labels" key="DeclaracaoControladoria"/></h2>
	<h3>Adicione/Altere os dados de um(a) <bean:message bundle="labels" key="DeclaracaoControladoria"/></h3>
	
	<div class="object-tools" style="position: relative;"><input id="btnVoltar" name="btnVoltar" type="button" value="Voltar" title="Voltar" onclick="javascript:pesquisar()" class="margem_button"></div>
	

<fieldset class="module aligned wide">
					
<!-- identificadorDeclaracaoControladoria -->
<div class="form-row">
	<label  for="identificadorDeclaracaoControladoria" class="  labelCadastro"><bean:message bundle="labels" key="DeclaracaoControladoria.identificadorDeclaracaoControladoria"/></label>
	<html:text property="identificadorDeclaracaoControladoria" styleId="identificadorDeclaracaoControladoria"  readonly='true'   styleClass="campoCadastro campoIdentificador " titleKey="DeclaracaoControladoria.identificadorDeclaracaoControladoria"  />
</div>
<!-- dataInicio -->
<div class="form-row">
	<label  for="dataInicio" class=" required  labelCadastro"><bean:message bundle="labels" key="DeclaracaoControladoria.dataInicio"/></label>
	<html:text property="dataInicio" styleId="dataInicio"  styleClass="campoCadastro  datefield " titleKey="DeclaracaoControladoria.dataInicio"  />
</div>
<!-- dataConclusao -->
<div class="form-row">
	<label  for="dataConclusao" class=" required  labelCadastro"><bean:message bundle="labels" key="DeclaracaoControladoria.dataConclusao"/></label>
	<html:text property="dataConclusao" styleId="dataConclusao"  styleClass="campoCadastro  datefield " titleKey="DeclaracaoControladoria.dataConclusao"  />
</div>
<!-- statusEdicao -->
<div class="form-row">
	<label  for="statusEdicao" class=" required  labelCadastro"><bean:message bundle="labels" key="DeclaracaoControladoria.statusEdicao"/></label>
	<html:text property="statusEdicao" styleId="statusEdicao"  styleClass="campoCadastro " titleKey="DeclaracaoControladoria.statusEdicao"  maxlength='60'  />
</div>

<!-- unidadeAdministrativa -->
	<div class="form-row">
		<label for="unidadeAdministrativa" class=" required  labelCadastro" ><bean:message bundle="labels" key="DeclaracaoControladoria.unidadeAdministrativa"/></label>
		<html:select  property="unidadeAdministrativa" styleId="unidadeAdministrativa" style="width: 200px" size="1" titleKey="DeclaracaoControladoria.unidadeAdministrativa">
			<html:option value="">Escolha um(a) <bean:message bundle="labels" key="DeclaracaoControladoria.unidadeAdministrativa"/></html:option>
			<html:options collection="unidadeAdministrativaLista" property="id" labelProperty="descritor" />
		</html:select>
	</div>										
</fieldset>

<%@ include file="/geral/menuCadastro.jsp"%>

<%@ include file="/geral/mensagens.jsp"%>

	</html:form>
</div>
<br>&nbsp;<br>
</div>