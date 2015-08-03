

<%@ include file="/geral/header.jsp"%>
<script>
	function salvar(){
		if (validar()){
			document.forms['cadastrarCategoriaCondutor'].acao.value = 'salvar';
			document.forms['cadastrarCategoriaCondutor'].action = 'cadastrarCategoriaCondutor.do';
			document.forms['cadastrarCategoriaCondutor'].enviaForm.click();
		}

	}
	function pesquisar(){
		document.forms['cadastrarCategoriaCondutor'].acao.value = 'pesquisar';
		document.forms['cadastrarCategoriaCondutor'].action = 'pesquisarCategoriaCondutor.do';
		document.forms['cadastrarCategoriaCondutor'].submit();

	}
	function novoRegistro(){
				document.forms['cadastrarCategoriaCondutor'].acao.value = 'novo';
				document.forms['cadastrarCategoriaCondutor'].action = 'cadastrarCategoriaCondutor.do';
				document.forms['cadastrarCategoriaCondutor'].submit();

	}
	function validar(){
		var retorno = true;
		if (document.forms['cadastrarCategoriaCondutor'].codigoCategoriaCondutor.value==''){
			retorno = false;
			alert('O campo <bean:message bundle="labels" key="CategoriaCondutor.codigoCategoriaCondutor"/> é obrigatório!');
		}
		return retorno;
	}
</script>

<div class="breadcrumbs">
	<a href="./" >Home</a> &gt; <a href="#" onclick="javascript:pesquisar()" >Lista de <bean:message bundle="labels" key="pluralCategoriaCondutor"/></a> &gt; Cadastro de <bean:message bundle="labels" key="CategoriaCondutor"/>
</div>

<div id="content" class="colM">
<div id="content-main"> 



	<html:form action="cadastrarCategoriaCondutor" method="post" styleId='cadastrarCategoriaCondutor'>
	<input type="hidden" name="acao" value="pesquisar"/>
	<input type="submit" name="enviaForm" id="enviaForm" style="display:none" />
	<h2>Cadastro de <bean:message bundle="labels" key="CategoriaCondutor"/></h2>
	<h3>Adicione/Altere os dados de um(a) <bean:message bundle="labels" key="CategoriaCondutor"/></h3>
	
	<div class="object-tools" style="position: relative;"><input id="btnVoltar" name="btnVoltar" type="button" value="Voltar" title="Voltar" onclick="javascript:pesquisar()" class="margem_button"></div>
	

<fieldset class="module aligned wide">
					
<!-- identificadorCategoriaCondutor -->
<div class="form-row">
	<label  for="identificadorCategoriaCondutor" class="  labelCadastro"><bean:message bundle="labels" key="CategoriaCondutor.identificadorCategoriaCondutor"/></label>
	<html:text property="identificadorCategoriaCondutor" styleId="identificadorCategoriaCondutor"  readonly='true'   styleClass="campoCadastro campoIdentificador " titleKey="CategoriaCondutor.identificadorCategoriaCondutor"  />
</div>
<!-- codigoCategoriaCondutor -->
<div class="form-row">
	<label  for="codigoCategoriaCondutor" class=" required  labelCadastro"><bean:message bundle="labels" key="CategoriaCondutor.codigoCategoriaCondutor"/></label>
	<html:text property="codigoCategoriaCondutor" styleId="codigoCategoriaCondutor"  styleClass="campoCadastro " titleKey="CategoriaCondutor.codigoCategoriaCondutor"  maxlength='4'  />
</div>
<!-- descricaoCategoriaCondutor -->
<div class="form-row">
	<label  for="descricaoCategoriaCondutor" class="  labelCadastro"><bean:message bundle="labels" key="CategoriaCondutor.descricaoCategoriaCondutor"/></label>
	<html:text property="descricaoCategoriaCondutor" styleId="descricaoCategoriaCondutor"  styleClass="campoCadastro " titleKey="CategoriaCondutor.descricaoCategoriaCondutor"  maxlength='300'  />
</div>

</fieldset>

<%@ include file="/geral/menuCadastro.jsp"%>

<%@ include file="/geral/mensagens.jsp"%>

	</html:form>
</div>
<br>&nbsp;<br>
</div>