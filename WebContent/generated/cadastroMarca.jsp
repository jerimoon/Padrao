

<%@ include file="/geral/header.jsp"%>
<script>
	function salvar(){
		if (validar()){
			document.forms['cadastrarMarca'].acao.value = 'salvar';
			document.forms['cadastrarMarca'].action = 'cadastrarMarca.do';
			document.forms['cadastrarMarca'].enviaForm.click();
		}

	}
	function pesquisar(){
		document.forms['cadastrarMarca'].acao.value = 'pesquisar';
		document.forms['cadastrarMarca'].action = 'pesquisarMarca.do';
		document.forms['cadastrarMarca'].submit();

	}
	function novoRegistro(){
				document.forms['cadastrarMarca'].acao.value = 'novo';
				document.forms['cadastrarMarca'].action = 'cadastrarMarca.do';
				document.forms['cadastrarMarca'].submit();

	}
	function validar(){
		var retorno = true;
		if (document.forms['cadastrarMarca'].nomeMarca.value==''){
			retorno = false;
			alert('O campo <bean:message bundle="labels" key="Marca.nomeMarca"/> é obrigatório!');
		}
		if (document.forms['cadastrarMarca'].ativo.value==''){
			retorno = false;
			alert('O campo <bean:message bundle="labels" key="Marca.ativo"/> é obrigatório!');
		}
		return retorno;
	}
</script>

<div class="breadcrumbs">
	<a href="./" >Home</a> &gt; <a href="#" onclick="javascript:pesquisar()" >Lista de <bean:message bundle="labels" key="pluralMarca"/></a> &gt; Cadastro de <bean:message bundle="labels" key="Marca"/>
</div>

<div id="content" class="colM">
<div id="content-main"> 



	<html:form action="cadastrarMarca" method="post" styleId='cadastrarMarca'>
	<input type="hidden" name="acao" value="pesquisar"/>
	<input type="submit" name="enviaForm" id="enviaForm" style="display:none" />
	<h2>Cadastro de <bean:message bundle="labels" key="Marca"/></h2>
	<h3>Adicione/Altere os dados de um(a) <bean:message bundle="labels" key="Marca"/></h3>
	
	<div class="object-tools" style="position: relative;"><input id="btnVoltar" name="btnVoltar" type="button" value="Voltar" title="Voltar" onclick="javascript:pesquisar()" class="margem_button"></div>
	

<fieldset class="module aligned wide">
					
<!-- identificadorMarca -->
<div class="form-row">
	<label  for="identificadorMarca" class="  labelCadastro"><bean:message bundle="labels" key="Marca.identificadorMarca"/></label>
	<html:text property="identificadorMarca" styleId="identificadorMarca"  readonly='true'   styleClass="campoCadastro campoIdentificador " titleKey="Marca.identificadorMarca"  />
</div>
<!-- nomeMarca -->
<div class="form-row">
	<label  for="nomeMarca" class=" required  labelCadastro"><bean:message bundle="labels" key="Marca.nomeMarca"/></label>
	<html:text property="nomeMarca" styleId="nomeMarca"  styleClass="campoCadastro " titleKey="Marca.nomeMarca"  maxlength='60'  />
</div>
<!-- ativo -->
<div class="form-row">
	<label  for="ativo" class=" required  labelCadastro"><bean:message bundle="labels" key="Marca.ativo"/></label>
	<html:checkbox property="ativo" styleClass="checkCadastro" value="true" titleKey="Marca.ativo">	</html:checkbox>
</div>

</fieldset>

<%@ include file="/geral/menuCadastro.jsp"%>

<%@ include file="/geral/mensagens.jsp"%>

	</html:form>
</div>
<br>&nbsp;<br>
</div>