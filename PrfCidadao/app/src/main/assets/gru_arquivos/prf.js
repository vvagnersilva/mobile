/**
 * Implementado por Marcelo Barros
 */
$(function() {
	
	/**
	 * Nome do sistema
	 * 
	 * Define o nome do sistema e instancia o valor nos demais lugares em que for usado.
	 */
	
		// ID do objeto que armazena o nome do sistema.
		var selectorDataNomeSistema = "#data-nome-sistema";
		// Seletor que define o alvo onde será colocado o nome do sistema.
		var selectorClasseNomeSistema = "[class^='nome-sistema-']";
		
		// Localiza o nome do sistema.
		var $dataNomeSistema = $(selectorDataNomeSistema);
		if ($dataNomeSistema.length == 1) {

			// Substitui o texto em todos os objetos e no titulo da página com o nome do sistema.
			var tituloSistema = $dataNomeSistema.text();
			$(selectorClasseNomeSistema).text(tituloSistema);
			document.title = "PRF - " + tituloSistema;
		}
});