/*******************************************************************************
 * Descrição.: formata um campo do formulário de acordo com a máscara
 * informada... Parâmetros: - objForm (o Objeto Form) - strField (string
 * contendo o nome do textbox) - sMask (mascara que define o formato que o dado
 * será apresentado, usando o algarismo "9" para definir números e o símbolo "!"
 * para qualquer caracter... - evtKeyPress (evento) Uso.......: <input
 * type="textbox" name="xxx"..... onkeypress="return
 * txtBoxFormat(document.rcfDownload, 'str_cep', '99999-999', event);">
 * Observação: As máscaras podem ser representadas como os exemplos abaixo: CEP ->
 * 99.999-999 CPF -> 999.999.999-99 CNPJ -> 99.999.999/9999-99 Data ->
 * 99/99/9999 Tel Resid -> (99) 999-9999 Tel Cel -> (99) 9999-9999 Processo ->
 * 99.999999999/999-99 C/C -> 999999-! E por aí vai...
 ******************************************************************************/

function txtBoxFormat(objForm, strField, sMask, evtKeyPress) {
	var i, nCount, sValue, fldLen, mskLen, bolMask, sCod, nTecla;

	if (document.all) { // Internet Explorer
		nTecla = evtKeyPress.keyCode;
	} else if (document.layers) { // Nestcape
		nTecla = evtKeyPress.which;
	}

	sValue = objForm[strField].value;

	// Limpa todos os caracteres de formatação que
	// já estiverem no campo.
	sValue = sValue.toString().replace("-", "");
	sValue = sValue.toString().replace("-", "");
	sValue = sValue.toString().replace(".", "");
	sValue = sValue.toString().replace(".", "");
	sValue = sValue.toString().replace("/", "");
	sValue = sValue.toString().replace("/", "");
	sValue = sValue.toString().replace("(", "");
	sValue = sValue.toString().replace("(", "");
	sValue = sValue.toString().replace(")", "");
	sValue = sValue.toString().replace(")", "");
	sValue = sValue.toString().replace(" ", "");
	sValue = sValue.toString().replace(" ", "");
	fldLen = sValue.length;
	mskLen = sMask.length;

	i = 0;
	nCount = 0;
	sCod = "";
	mskLen = fldLen;

	while (i <= mskLen) {
		bolMask = ((sMask.charAt(i) == "-") || (sMask.charAt(i) == ".") || (sMask
				.charAt(i) == "/"));
		bolMask = bolMask
				|| ((sMask.charAt(i) == "(") || (sMask.charAt(i) == ")") || (sMask
						.charAt(i) == " "));

		if (bolMask) {
			sCod += sMask.charAt(i);
			mskLen++;
		} else {
			sCod += sValue.charAt(nCount);
			nCount++;
		}

		i++;
	}

	objForm[strField].value = sCod;

	if (nTecla != 8) { // backspace
		if (sMask.charAt(i - 1) == "9") { // apenas números...
			return ((nTecla > 47) && (nTecla < 58));
		} // números de 0 a 9
		else { // qualquer caracter...
			return true;
		}
	} else {
		return true;
	}
}

var deleteClick;
var globalLink;

function assignDeleteClick(link) {
	globalLink = link;
	if (globalLink.onclick == confirmDelete) {
		return;
	}

	deleteClick = globalLink.onclick;
	globalLink.onclick = confirmDelete;
}

function confirmDelete() {
	var ans = confirm("Confirma a exclus\u00E3o do registro selecionado?");

	if (ans == true) {
		return deleteClick();
	} else {
		globalLink.onclick = deleteClick;
		return false;
	}
}

function confirmDelete(msgConfirmaExclusao,entidade) {
	return confirm(msgConfirmaExclusao+" "+entidade+" ?");

	
}

var countSubmit = false;
function carregando(botao) {
	if (countSubmit) {
		jQuery(botao).click(function() {
			return false;
		});
	} else {
		countSubmit = true;
	}
}

jQuery(function() {
	jQuery('input').keypress(function(e) {
		var code = null;
		code = (e.keyCode ? e.keyCode : e.which);
		return (code == 13) ? false : true;
	});
});

function Mascara_Numero(data) {
	var numero = data.value;
	if (numero.length > 0) {
		var ultChar = numero.charAt(numero.length - 1);
		if (isNaN(ultChar)) {
			numero = numero.substr(0, numero.length - 1);
			data.value = numero;
		}
	}
}

function Mascara_Placa(data) {
	var lPlaca = data.value;
	if (lPlaca.length > 0) {
		var ultChar = lPlaca.charAt(lPlaca.length - 1);
		if (lPlaca.length < 4) {
			if (!isNaN(ultChar)) {
				lPlaca = lPlaca.substr(0, lPlaca.length - 1);
				data.value = lPlaca;
			}
		} else {
			if (isNaN(ultChar)) {
				lPlaca = lPlaca.substr(0, lPlaca.length - 1);
				data.value = lPlaca;
			}
		}
	}
}

function Mascara_Data(data) {
	var mydata = '';
	mydata = mydata + data.value;
	if (mydata.length == 2) {
		mydata = mydata + '/';
		data.value = mydata;
	}
	if (mydata.length == 5) {
		mydata = mydata + '/';
		data.value = mydata;
	}
	if (mydata.length == 10) {
		Verifica_Data(data);
	}
}

function Verifica_Data(data) {
	var erro = false;
	var strdata = data.value;

	if (strdata == "__/__/____") {
		return;
	}
	// Verifica a quantidade de digitos informada esta correta.
	if (strdata.length != 10) {
		erro = true;
		data.value = "";
	}
	// Verifica máscara da data
	if ("/" != strdata.substr(2, 1) || "/" != strdata.substr(5, 1)) {
		erro = true;
		data.value = "";
	} else {
		dia = strdata.substr(0, 2);
		mes = strdata.substr(3, 2);
		ano = strdata.substr(6, 4);
		// Verifica o dia
		if (isNaN(dia) || dia > 31 || dia < 1) {
			erro = true;
			data.value = "";
		}
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if (dia == "31") {
				erro = true;
				data.value = "";
			}
		}
		if (mes == "02") {
			bissexto = ano % 4;
			if (bissexto == 0) {
				if (dia > 29) {
					erro = true;
					data.value = "";
				}
			} else {
				if (dia > 28) {
					erro = true;
					data.value = "";
				}
			}
		}
		// Verifica o mês
		if (isNaN(mes) || mes > 12 || mes < 1) {
			erro = true;
			data.value = "";
		}
		// Verifica o ano
		if (isNaN(ano)) {
			erro = true;
			data.value = "";
		}
	}
	if (erro) {
		alert("\"" + strdata + "\" - Data Invalida!");
	}
}

function setMask_cpf_cnpj() {
	var campo = document.getElementById("frmDadosCondutor:cpfCnpj");
	var valor = jQuery(campo).val();
	valor = valor.replace(/\D/g, ""); // Remove tudo o que não é dígito
	if (valor.length < 12) {
		jQuery(campo).mask('999.999.999-99');
	} else {
		jQuery(campo).mask('99.999.999/9999-99');
	}
}

function removeMask(campo) {
	jQuery(campo).unmask();
}

/**
 * Aplica a máscara no campo e muda os valores da tecla pressionadas.
 */
function MascaraMoedaUltimoCampo(campo, event) {
	var charCode = (event.which) ? event.which : event.keyCode;
	if (charCode != 9) {
		transformaMoeda(campo);
	}

	mudaTecla(event);
}

/* Máscara para formatação de valor monetário. */
function transformaMoeda(z) {
	v = z.value;

	v = v.replace(/\D/g, ""); // permite digitar apenas números

	// remove os zeros iniciais
	if (v.substring(0, 2) == "00") {
		v = v.substring(2);
	}
	if (v.substring(0, 1) == "0") {
		v = v.substring(1);
	}

	switch (v.length) {
	case 1: // acrescenta os 00 iniciais
		v = "00" + v;
		break;
	case 2: // acrescenta o 0 inicial
		v = "0" + v;
		break;

	default: // do nothing
		break;
	}

	v = v.replace(/[0-9]{12}/, "inválido"); // limita pra máximo 999.999.999,99
	v = v.replace(/(\d{1})(\d{8})$/, "$1.$2"); // coloca ponto antes dos
	// últimos 8 digitos
	v = v.replace(/(\d{1})(\d{5})$/, "$1.$2"); // coloca ponto antes dos
	// últimos 5 digitos
	v = v.replace(/(\d{1})(\d{1,2})$/, "$1,$2");// coloca virgula antes dos
	// últimos 2 digitos

	z.value = v;
}

/**
 * Altera o valor da tecla pressionada e tecla <SHIFT>.
 */
function mudaTecla(event) {
	teclaPressionada = event.keyCode;
	shiftKey = event.shiftKey;
}

function esconderMensagem() {
	var msg = document.getElementById("messagelist");
	jQuery(msg).hide();
}

function limitTextArea(element, limit) {

	if (element.value.length > limit) {
		element.value = element.value.substring(0, limit);
	}

}

function abrirJanela(link) {
	window.open(link, '');
}

// Remove caracteres
function remove(str, sub) {
	i = str.indexOf(sub);
	r = "";
	if (i == -1)
		return str;
	r += str.substring(0, i) + remove(str.substring(i + sub.length), sub);
	return r;
}

function removeMascara(object) {
	valor = document.getElementById(object).value;
	semMascara = remove(valor, ".");
	semMascara = remove(semMascara, "-");
	semMascara = remove(semMascara, "/");
	semMascara = remove(semMascara, "(");
	semMascara = remove(semMascara, ")");
	return semMascara;
}

function validaCpf(cpf) {
	var numeros, digitos, soma, i, resultado, digitos_iguais;
	digitos_iguais = 1;
	if (cpf.length < 11) {
		return false;
	}
	for (i = 0; i < cpf.length - 1; i++)
		if (cpf.charAt(i) != cpf.charAt(i + 1)) {
			digitos_iguais = 0;
			break;
		}
	if (!digitos_iguais) {
		numeros = cpf.substring(0, 9);
		digitos = cpf.substring(9);
		soma = 0;
		for (i = 10; i > 1; i--)
			soma += numeros.charAt(10 - i) * i;
		resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		if (resultado != digitos.charAt(0))
			return false;
		numeros = cpf.substring(0, 10);
		soma = 0;
		for (i = 11; i > 1; i--)
			soma += numeros.charAt(11 - i) * i;
		resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		if (resultado != digitos.charAt(1))
			return false;
		return true;
	} else
		return false;
}

function validarCPF(cpf, panelMsg) {
	validacao = true;
	// Cliente Pessoa Fisica
	cpfSemMascara = removeMascara(cpf);
	alert(cpfSemMascara);
	if (!validaCpf(cpfSemMascara)) {
		// Colocando a mensagem no h:message com id="msgCpf"
		jQuery(panelMsg).css({
			'color' : 'red',
			'font-size' : '11px',
			'font-weight' : 'bold',
			'font-style' : 'italic'
		});
		jQuery(panelMsg).text('CPF inválido. Tente novamente.');
		validacao = false;
	}
	return validacao;
}

function clearErrorMessages(pnlMsgErro) {
	var errorSpan = document.getElementById(pnlMsgErro);
	errorSpan.style.display = "none";
	errorSpan.innerHTML = "";

	focusSetted = false;
}

function validaPopupFuncionalidade(form, msg1, cboSistema, pnlMsgErro) {
	clearErrorMessages(form + ":" + pnlMsgErro);
	return validateRequiredField(form + ":" + cboSistema, msg1, form + ":"
			+ pnlMsgErro);
}

function validateRequiredField(fieldId, errorMsg, pnlMsgErro) {

	var field = document.getElementById(fieldId);

	if (field && trim(field.value) == "") {
		showErrorMessage(errorMsg, pnlMsgErro);
		// setFocusField(field);
		return false;
	}

	return true;
}

function trim(str) {
	if (str != null) {
		return str.replace(/^\s+|\s+$/, "");
	}
	return "";
}

function showErrorMessage(errorMsg, errorSpanId) {
	var errorSpan = document.getElementById(errorSpanId);

	errorSpan.innerHTML += errorMsg;

	errorSpan.style.display = "inline";
}

function validaFormPerfil(form, msg1) {
	clearErrorMessages(form + ":pnlMsgErroNome");
	clearErrorMessages(form + ":pnlMsgErroDescricao");
	clearErrorMessages(form + ":pnlMsgErroSistema");

	var retornoNome = validateRequiredField(form + ":nome", msg1, form
			+ ":pnlMsgErroNome");
	var retornoDescricao = validateRequiredField(form + ":descricao", msg1,
			form + ":pnlMsgErroDescricao");
	var retornoSistema = validateRequiredField(form + ":cboSistema", msg1, form
			+ ":pnlMsgErroSistema");

	return retornoNome && retornoDescricao && retornoSistema;
}




/*
 * Inviabiliza a digitação de digitos numericos. onkeypress="return
 * noDigits(event)"
 */
function noDigits(evt) {
	var tecla = (evt.which) ? evt.which : event.keyCode;
	if ((tecla > 47 && tecla < 58)) {
		evt.returnValue = false;
		return false;
	} else {
		return true;
	}

}

function validateRadio(form,id,errorMsg,pnlMsgErro){
	
	var radioSim = document.getElementById(form+':'+id+':0');
	var radioNao = document.getElementById(form+':'+id+':1');
	
	if(!(radioSim.checked || radioNao.checked)){
		showErrorMessage(errorMsg, form+":"+pnlMsgErro);
	}else{
		return true;
	}
	return false;
}

function setMask_cpf_cnpj_Dinamico(form, camp) {

	var campo = document.getElementById(form+':'+camp);
	
	var valor = jQuery(campo).val();
	valor = valor.replace(/\D/g, ""); // Remove tudo o que não é dígito
	if (valor.length < 12) {
		jQuery(campo).mask('999.999.999-99');
	} else {
		jQuery(campo).mask('99.999.999/9999-99');
	}
}

/*
* Inviabiliza a digitação de caracteres. onkeypress="return
* noCaracteres(event)"
*/ 
function noCaracteres(evt) {
      var tecla = (evt.which) ? evt.which : event.keyCode;
      if (!(tecla > 47 && tecla < 58)) {
            evt.returnValue = false;
            return false;
      } else {
            return true;
      }
}
