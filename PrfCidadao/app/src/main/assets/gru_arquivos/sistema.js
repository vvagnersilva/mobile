/**
 * Rotinas comuns à toda aplicação.
 * @author Marcelo
 */

function ajaxStart() {
	bloquearConteudo();
}

function ajaxComplete() {
	desbloquearConteudo();
}

function ajaxError() {
	alert('Erro na consulta AJAX. Por favor, recarregue a página.');
}

function ajaxSuccess() {}

if (typeof PrimeFaces !== 'undefined') {
	PrimeFaces.zindex = 1050;
	PrimeFaces.locales['pt_BR'] = {  
	        closeText: 'Fechar',  
	        prevText: 'Anterior',  
	        nextText: 'Próximo',  
	        currentText: 'Começo',  
	        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],  
	        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],  
	        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],  
	        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'],  
	        dayNamesMin: ['D','S','T','Q','Q','S','S'],  
	        weekHeader: 'Semana',  
	        firstDay: 1,  
	        isRTL: false,  
	        showMonthAfterYear: false,  
	        yearSuffix: '',  
	        timeOnlyTitle: 'Só Horas',  
	        timeText: 'Tempo',  
	        hourText: 'Hora',  
	        minuteText: 'Minuto',  
	        secondText: 'Segundo',  
	        currentText: 'Data Atual',  
	        ampm: false,  
	        month: 'Mês',  
	        week: 'Semana',  
	        day: 'Dia',  
	        allDayText : 'Todo Dia'  
	    };  
}

function mostrarFormulario(id) {
	$('#' + id).modal('show');
}

function esconderFormulario(id) {
	$('#' + id).modal('hide');
}

var camadaBloqueio = [".camada-bloqueio"];
var solicitacoesBloqueio = 0;

function bloquearConteudo() {
	$(camadaBloqueio.join()).finish().fadeIn();
	solicitacoesBloqueio++;
}

function desbloquearConteudo() {
	if (solicitacoesBloqueio > 0)
		solicitacoesBloqueio--;

	if (solicitacoesBloqueio == 0)
		$(camadaBloqueio.join()).finish().hide();
}

$(function() {
	$('.modal').on('shown.bs.modal', function () {
		var controleFoco = '.controle-foco';
		var filter = 'input,select,textarea';
		var $controleFoco = $(this).find(controleFoco);
		$controleFoco.add($controleFoco.find(filter)).filter(filter).first().focus();
	});
});

function removeEmBranco(idSelect) {
	var $select = $(document.getElementById(idSelect)).filter("select");
	if ($select.val()) $select.children("option[value=]").remove();
}

function bloco(idControleChecar, valorChecar, idBlocoControles, idControlesData, negar) {

	this.idControleChecar = idControleChecar;
	this.idBlocoControles = idBlocoControles;
	this.idControlesData = idControlesData;
	
	this.alterar = function(animar) {
		
		var valor = null;
		
		try {
			var controleChecar = document.getElementById(this.idControleChecar);
			
			if (controleChecar != null) {
				
				if (controleChecar instanceof HTMLInputElement && controleChecar.type == 'checkbox') {
					valor = controleChecar.checked;
				} else if ((controleChecar instanceof HTMLInputElement && controleChecar.type == 'text') || controleChecar instanceof HTMLSelectElement) {
					valor = $(controleChecar).val();
				}
			}
			
		} catch (e) {}
		
		var arrayData = [];
		
		if (this.idControlesData instanceof Array) {
			
			for (var i = 0; i < this.idControlesData.length; i++) {
				
				var data = PF(this.idControlesData[i]);
				
				if (data != null)
					arrayData.push(data);
			}
		}
		
		var $blocoControles = $(document.getElementById(this.idBlocoControles));

		var $inputBlocoControles = $blocoControles.find("input[type=text],select").not("[data-alterar=false]");
		for (var i = 0; i < arrayData.length ; i++)
			$inputBlocoControles = $inputBlocoControles.not(arrayData[i].input);
		
		var enable;
		
		if (valorChecar instanceof Array) {
			enable = valorIgualPeloMenosUm(valorChecar, valor);
			if (negar) enable = !enable;
		} else enable = (negar ? valor != valorChecar : valor == valorChecar);
		
		if (enable) {
			
			if (animar)
				$blocoControles.finish().slideDown();
			else
				$blocoControles.finish().show();
			
			aplicarValores($inputBlocoControles, arrayData, enable);
			
		} else {
			
			if (animar)
				$blocoControles.finish().slideUp(null, function() {
					aplicarValores($inputBlocoControles, arrayData, enable);
				});
			
			else {
				$blocoControles.finish().hide();
				aplicarValores($inputBlocoControles, arrayData, enable);
			}
			
		}
	};
	
	function aplicarValores($inputBlocoControles, arrayData, enable) {
		$inputBlocoControles.prop('disabled', !enable);
		$inputBlocoControles.prop('required', enable);
		alterarData(arrayData, enable);
		
		if (!enable)
			$inputBlocoControles.val('');
	}
	
	function alterarData(arrayData, enable) {
		
		if (arrayData instanceof Array) {
			
			for (var i = 0; i < arrayData.length; i++) {
				
				if (enable) {
					arrayData[i].enable();
				} else {
					arrayData[i].setDate('');
					arrayData[i].disable();
				}
			}
		}
	}
}

function observar(elemento, intervalo, funcao) {
	
	var idIntervalo = null;
	var inicio = true;
	var valor = null;
	
	this.iniciar = function() {
		
		if (!idIntervalo)
			idIntervalo = setInterval(function() {
				if (inicio) {
					valor = elemento.value;
					inicio = false;
				} else {
					if (elemento.value != valor) {
						valor = elemento.value;
						funcao.call(elemento);
					}
				}
			}, intervalo);
	}
	
	this.parar = function() {
		
		if (idIntervalo)
			clearInterval(idIntervalo);
		
		idIntervalo = null;
	}
}

function valorIgualPeloMenosUm(array, valor) {
	
	for (var i = 0; i < array.length; i++) {
		if (valor == array[i])
			return true;
	}
	
	return false;
}