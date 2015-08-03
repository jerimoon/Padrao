window.initProgress = function() {
        Element.show('progressMsg');
        document.getElementById('progressMsg').style.display = 'none';
    };

    window.resetProgress = function(request) {
        Effect.Fade('progressMsg');
        document.getElementById('progressMsg').style.display = 'none';
    };

    window.reportError = function() {
        $("errorMsg").update("AjaxTags busted!").show();
        Effect.DropOut.delay(2.5, "errorMsg");
    };
    
    if (!String.prototype.trim) {
    	 String.prototype.trim = function() {
    	  return this.replace(/^\s+|\s+$/g,'');
    	 };
    }
    
	function trocaUnidade(unidade){
		document.forms["form_troca_unidade"].submit();
	}
	function trocarSenhaUsuario(){
		document.forms["formTrocaSenha"].enviaForm.click();
	}

    function showPopup() {
        var mask = $('fundoPopup');
        var popup  = $('divPopup');
        mask.style.display= 'block';
        popup.style.display= 'block';
        
    }
    function limpaCampos(campoOrigem,destinos){
    	if( campoOrigem.value==null || campoOrigem.value.trim()==''){
    		campoOrigem.value = '';
    		for ( var i = 0; i < destinos.length; i++) {
				$(destinos[i]).value = '';
			}
    	}
    }
    function displaytagform(nomeForm,arrayParametros){
    	var campo;
    	var form = $(nomeForm);
    	 campo = new Element('input', { 
  			type			: 'submit',
  			name 	: 'btnEnvia',
  			id 	: 'btnEnvia',
  			style 		: 'display:none' });
     		form.appendChild(campo);
    	
    	for ( var i = 0; i < arrayParametros.length; i++) {
    		if(arrayParametros[i]['f']!='btnEnvia'){
	    	 campo = new Element('input', { 
	 			type			: 'hidden',
	 			name 	: arrayParametros[i]['f'],
	 			id 	: arrayParametros[i]['f']});
	 			campo.value =arrayParametros[i]['v'] ;
	    		form.appendChild(campo);
    		}
		}
    	form.btnEnvia.click();
    }
    
    function hidePopup() {
        var mask = $('fundoPopup');
        var popup  = $('divPopup');
        mask.style.display= 'none';
        popup.style.display= 'none';
        
    }
    function retornarLov(arrayRetorno){
    	for( k in arrayRetorno){
    		try{
    	   		$(k).value = arrayRetorno[k];
    		}catch(e){
    			alert('Erro na atribuição da lov:'+k);
    		}
    	}
    	hidePopup();
    }
   
  
    
Element.addMethods('iframe', {
    document: function(element) {
    element = $(element);
    if (element.contentWindow)
        return element.contentWindow.document;
    else if (element.contentDocument)
        return element.contentDocument;
    else
        return null;
},
$: function(element, frameElement) { 
    element = $(element);
    var frameDocument = element.document();
    if (arguments.length > 2) {
        for (var i = 1, frameElements = [], length = arguments.length; i < length; i++)
            frameElements.push(element.$(arguments[i]));
        return frameElements;
    }
    if (Object.isString(frameElement))
        frameElement = frameDocument.getElementById(frameElement);
    return frameElement || element;
}
});
    
	function closeIframe(nomeDivForm) {
    	var iframeUpload = $("iframe_upload");
		if (iframeUpload) {
			var divFilho = iframeUpload.$(nomeDivForm);
			if (divFilho==null){
				divFilho = iframeUpload.contentDocument.getElementById(nomeDivForm);
			}
			$(nomeDivForm).update(divFilho.innerHTML);
		} 
	}
	function uploadArquivo(nomeFormulario,nomeDivForm) {
		//cria um iframe, escondido
		var iframeUpload = new Element("iframe", {
			name : "iframe_upload",
			id : "iframe_upload",
			style : "display:none",
			onload : "closeIframe('"+nomeDivForm+"')"
		});
		//insere na página o iframe
		var formArquivo =document.getElementById(nomeFormulario);
		document.body.insert(iframeUpload);
		//muda o target do form, apontando para o iframe
		formArquivo.target = iframeUpload.name;
		//mostra a mensagem
		formArquivo.submit();
	}
	  function excluirArquivo(identificador,nome){
		  if (confirm("Confirma a exclusão do documento "+identificador+'-'+nome+"?")){
			  var nomeFormulario = "formArquivoVeiculo";
			  new AjaxJspTag.Submit({source: nomeFormulario, target: "divFormArquivoVeiculo"});
			  $("identificadorArquivo").value = identificador;
			  $("acao").value = "excluirArquivo";
			  $("enviaForm").click();
		  }
			
	    }
	    function baixarArquivo(identificador){
	    	window.open("./arquivo.file?identificadorArquivo="+identificador,"arquivo","directories=no,location=no,menubar=no,scrollbars=no,status=no,toolbar=no,resizable=no,width=50,height=50");
	    }
	    function getSelectedLabel(id){
	    	var e = $(id);
	    	return e.options[e.selectedIndex].text;
	    }
/*********************************************/
	    function addItems() {
	        var ai = document.getElementById("availableItems"); 
	       var si = document.getElementById("listaProventoSelecionado"); 
	       for (var i=0;i<ai.options.length;i++) { 
	         if (ai.options[i].selected) { 
	           var opt = ai.options[i]; 
	           si.options[si.options.length] = new Option(opt.innerHTML, opt.value); 
	           ai.options[i] = null; i = i - 1; 
	         } 
	       } 
	     } 

	     function addAll() { 
	       var ai = document.getElementById("availableItems"); 
	       var si = document.getElementById("listaProventoSelecionado"); 
	       for (var i=0;i<ai.options.length;i++) { 
	         var opt = ai.options[i]; 
	         si.options[si.options.length] = new Option(opt.innerHTML, opt.value); 
	       } 
	       ai.options.length = 0; 
	     } 

	     function removeItems() {
	       var ai = document.getElementById("availableItems"); 
	       var si = document.getElementById("listaProventoSelecionado"); 
	       for (var i=0;i<si.options.length;i++) { 
	         if (si.options[i].selected) { 
	           var opt = si.options[i]; 
	           ai.options[ai.options.length] = new Option(opt.innerHTML, opt.value); 
	           si.options[i] = null; i = i - 1; 
	         } 
	       } 
	       sortAvailable(); 
	     } 

	     function removeAll() { 
	       var ai = document.getElementById("availableItems"); 
	       var si = document.getElementById("listaProventoSelecionado"); 
	       for (var i=0;i<si.options.length;i++) { 
	         var opt = si.options[i]; 
	         ai.options[ai.options.length] = new Option(opt.innerHTML, opt.value); 
	       } 
	       si.options.length = 0; 
	       sortAvailable(); 
	     } 

	     function moveUp() { 
	         var si = document.getElementById("listaProventoSelecionado"); 
	         var sel = si.selectedIndex; 
	         if (sel > 0) { 
	           var optHTML = si.options[sel].innerHTML; 
	           var optVal = si.options[sel].value; 
	           var opt1HTML = si.options[sel-1].innerHTML; 
	           var opt1Val = si.options[sel-1].value; 
	           si.options[sel] = new Option(opt1HTML,opt1Val); 
	           si.options[sel-1] = new Option(optHTML,optVal); si.options.selectedIndex = sel -1; 
	       } 
	     } 

	     function moveDown() { 
	       var si = document.getElementById("listaProventoSelecionado"); 
	       var sel = si.selectedIndex; 
	       if (sel < si.options.length -1) { 
	         var optHTML = si.options[sel].innerHTML; 
	         var optVal = si.options[sel].value; 
	         var opt1HTML = si.options[sel+1].innerHTML; 
	         var opt1Val = si.options[sel+1].value; 
	         si.options[sel] = new Option(opt1HTML,opt1Val); 
	         si.options[sel+1] = new Option(optHTML,optVal); 
	         si.options.selectedIndex = sel +1; 
	       } 
	     } 

	     function sortAvailable() { 
	       var ai = document.getElementById("availableItems"); 
	       var tmp = ""; 
	       for (var i=0;i<ai.options.length;i++) { 
	         if (tmp > "") tmp +=","; 
	         tmp += ai.options[i].innerHTML + "~" + ai.options[i].value; 
	       } 
	       var atmp = tmp.split(",");
	       atmp = atmp.sort(); 
	       ai.options.length = 0;
	       for (var i=0;i<atmp.length;i++) { 
	         var opt = atmp[i].split("~"); 
	         ai.options[i] = new Option(opt[0],opt[1]); 
	       } 
	     } 

	     function frmSubmit() {
	       var si = document.getElementById("listaProventoSelecionado"); 
	       for (var i=0;i<si.options.length;i++) { si.options[i].selected = true; }
	       document.relatorioForm.action = document.getElementById("nomeRelatorio").value;
	       document.relatorioForm.submit(); 
	      }
	     function carregarParametros(id){
	    	 document.relatorioForm.action = 'inicio.do';
	    	 document.relatorioForm.acao.value = 'carregarParametros';
	    	 document.relatorioForm.identificadorGrupoParametro.value = id;
	    	 document.relatorioForm.submit(); 
	    	 
	     }
	     function salvarParametros() {
	    	 var si = document.getElementById("listaProventoSelecionado"); 
	    	 for (var i=0;i<si.options.length;i++) { si.options[i].selected = true; }
	    	 document.relatorioForm.action = 'inicio.do';
	    	 document.relatorioForm.acao.value = 'salvarParametros';
	    	 document.relatorioForm.nomeGrupoParametro.value = document.getElementById("tempNomeGrupoParametro").value;
	    	 document.relatorioForm.submit(); 
	     } 
	     function recarregaItemProvento(){
	    	 document.relatorioForm.action =''; 
	    	 document.relatorioForm.submit(); 
	     } 
	    