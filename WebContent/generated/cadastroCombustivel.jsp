

<%@ include file="/geral/header.jsp"%>
<script>
	function salvar(){
		if (validar()){
			document.forms['cadastrarCombustivel'].acao.value = 'salvar';
			document.forms['cadastrarCombustivel'].action = 'cadastrarCombustivel.do';
			document.forms['cadastrarCombustivel'].enviaForm.click();
		}

	}
	function pesquisar(){
		document.forms['cadastrarCombustivel'].acao.value = 'pesquisar';
		document.forms['cadastrarCombustivel'].action = 'pesquisarCombustivel.do';
		document.forms['cadastrarCombustivel'].submit();

	}
	function novoRegistro(){
				document.forms['cadastrarCombustivel'].acao.value = 'novo';
				document.forms['cadastrarCombustivel'].action = 'cadastrarCombustivel.do';
				document.forms['cadastrarCombustivel'].submit();

	}
	function validar(){
		var retorno = true;
		if (document.forms['cadastrarCombustivel'].nomeCombustivel.value==''){
			retorno = false;
			alert('O campo <bean:message bundle="labels" key="Combustivel.nomeCombustivel"/> é obrigatório!');
		}
		if (document.forms['cadastrarCombustivel'].ativo.value==''){
			retorno = false;
			alert('O campo <bean:message bundle="labels" key="Combustivel.ativo"/> é obrigatório!');
		}
		return retorno;
	}
</script>

<div class="breadcrumbs">
	<a href="./" >Home</a> &gt; <a href="#" onclick="javascript:pesquisar()" >Lista de <bean:message bundle="labels" key="pluralCombustivel"/></a> &gt; Cadastro de <bean:message bundle="labels" key="Combustivel"/>
</div>

<div id="content" class="colM">
<div id="content-main"> 



	<html:form action="cadastrarCombustivel" method="post" styleId='cadastrarCombustivel'>
	<input type="hidden" name="acao" value="pesquisar"/>
	<input type="submit" name="enviaForm" id="enviaForm" style="display:none" />
	<h2>Cadastro de <bean:message bundle="labels" key="Combustivel"/></h2>
	<h3>Adicione/Altere os dados de um(a) <bean:message bundle="labels" key="Combustivel"/></h3>
	
	<div class="object-tools" style="position: relative;"><input id="btnVoltar" name="btnVoltar" type="button" value="Voltar" title="Voltar" onclick="javascript:pesquisar()" class="margem_button"></div>
	

<fieldset class="module aligned wide">
					
<!-- identificadorCombustivel -->
<div class="form-row">
	<label  for="identificadorCombustivel" class="  labelCadastro"><bean:message bundle="labels" key="Combustivel.identificadorCombustivel"/></label>
	<html:text property="identificadorCombustivel" styleId="identificadorCombustivel"  readonly='true'   styleClass="campoCadastro campoIdentificador " titleKey="Combustivel.identificadorCombustivel"  />
</div>
<!-- nomeCombustivel -->
<div class="form-row">
	<label  for="nomeCombustivel" class=" required  labelCadastro"><bean:message bundle="labels" key="Combustivel.nomeCombustivel"/></label>
	<html:text property="nomeCombustivel" styleId="nomeCombustivel"  styleClass="campoCadastro " titleKey="Combustivel.nomeCombustivel"  maxlength='60'  />
</div>
<!-- ativo -->
<div class="form-row">
	<label  for="ativo" class=" required  labelCadastro"><bean:message bundle="labels" key="Combustivel.ativo"/></label>
	<html:checkbox property="ativo" styleClass="checkCadastro" value="true" titleKey="Combustivel.ativo">	</html:checkbox>
</div>

</fieldset>

<%@ include file="/geral/menuCadastro.jsp"%>

<%@ include file="/geral/mensagens.jsp"%>

	</html:form>
</div>
<br>&nbsp;<br>
</div>