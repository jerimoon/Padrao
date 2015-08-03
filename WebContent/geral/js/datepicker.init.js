function initDatepickers() {
	$$("*").findAll(function(node) {
		return Element.hasClassName(node,'datefield');
	}).each(function(node) {
		if ((!node.disabled)&&(!node.readOnly)&&!$(node.id+'_settoday')){
			datepickers[node.id] = new DatePicker({
				relative 			: node.id,
				language 			: 'pt',
				enableCloseEffect : false,
				enableShowEffect 	: false,
				closeEffect			: 'squish',
				showEffect			: 'appear',
				enableCloseOnBlur : true,
				closeEffectDuration	: 0.1,
				
			});
			datepickers[node.id].setDateFormat([ "dd", "mm", "yyyy" ], "/");
			jQuery("#"+node.id).mask('99/99/9999');
		}
	});
	$$("*").findAll(function(node) {
		return Element.hasClassName(node,'timefield');
	}).each(function(node) {
		if ((!node.disabled)&&!$(node.id+'_setnow')){
			var timefield =jQuery("#"+node.id);
			timefield.mask('99:99');
			try {
				var today = new Element('a',{href:'javascript:setNow("'+node.id+'")',id:node.id+"_setnow",name:node.id+"_setnow"});
				today.appendChild(document.createTextNode(" Agora"));
				document.getElementById(node.id).parentNode.appendChild(today);
			} catch (e) {
				alert(e);
			}
		}
	});
}
Event.observe(window, 'load', initDatepickers, false);
