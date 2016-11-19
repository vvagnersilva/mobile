function formatarCNPJ(campo) {
	var valor = "";
    var teste = campo.value.toUpperCase();
    for (var i = 1;i<=teste.length;i++) {
        if(!isNaN(teste.charAt(i-1))) {
            valor += teste.charAt(i-1);
	        if (valor.length == 2 || valor.length == 6) {
                valor += ".";
            }
			if(valor.length == 10){
				valor += "/";
			}
            if (valor.length == 15) {
                valor += "-";
            }
        }
    }
    campo.value=valor;
}

function formatarCPF(campo) {
    var valor = "";
    var teste = campo.value.toUpperCase();
    for (var i = 1;i<=teste.length;i++) {
        if(!isNaN(teste.charAt(i-1))) {
            valor += teste.charAt(i-1);
            if (valor.length == 3 || valor.length == 7) {
                valor += ".";
            }
            if (valor.length == 11) {
                valor += "-";
            }
        }
    }
    campo.value=valor;
}

function formatarControle(campo){	
	var valor = "";
    var teste = campo.value;
    for (var i = 1;i<=teste.length;i++) {
        if(teste.charAt(i-1) != '.') {
            valor += teste.charAt(i-1);
            if (valor.length == 4 || valor.length == 9 || valor.length ==14) {
                valor += ".";
            }
        }
    }
    campo.value=valor;
}

/**
 * @author tulio.silva [NCT]
 * @since 2007-09-20
 *
 * So números, tab, <- e Enter // Criado para substituir forbidNumberOLD
 * onkeypress="return forbidNumber(event)"
 */
function forbidNumber(evtKeyPress) {
 	
 	var nTecla;
 	
 	if(document.all) { // Internet Explorer 
	    nTecla = evtKeyPress.keyCode; 
	} 
	else if(!document.all) { // Nestcape 
	    nTecla = evtKeyPress.which; 
	}
 
 	//alert(nTecla);
 	
	if (nTecla == "0" || nTecla == "8" || nTecla == "13"){   //tab , <-, Enter
		return true;
	}
 
 	var valor 	= String.fromCharCode(nTecla);

	if (valor == "0" || valor == "1" || valor == "2" || valor == "3" || valor == "4" ||
		valor == "5" || valor == "6" || valor == "7" || valor == "8" || valor == "9" ){
		 return true;
	}
	else{
		 return false;
	} 
}

function forbidNumber2(evtKeyPress) {
 	
 	var nTecla;
 	
 	alert('entrou');
 	
 	if(document.all) { // Internet Explorer 
	    nTecla = evtKeyPress.keyCode; 
	} else if(!document.all) { // Nestcape 
	    nTecla = evtKeyPress.which; 
	} else { 
	    nTecla = evtKeyPress.which; 
	    if (nTecla == 8) { 
	        return true; 
	    } 

	} 
	
        re = /[^0-9]/;
		if(nTecla != 8)
		{        
	        digito = String.fromCharCode(nTecla);
    	    if (re.test(digito)) {
                return false;
        	}
	    }    
}

//funcao de formatacao de campos
function txtBoxFormat(objForm, strField, sMask, evtKeyPress) { 
	var i, nCount, sValue, fldLen, mskLen,bolMask, sCod, nTecla; 

	if(document.all) { // Internet Explorer 
	    nTecla = evtKeyPress.keyCode; 
	} else if(!document.all) { // Nestcape 
	    nTecla = evtKeyPress.which; 
	} else { 
	    nTecla = evtKeyPress.which; 
	    if (nTecla == 8) { 
	        return true; 
	    } 

	} 

	if (nTecla == 8 || nTecla == 0) { 
	    return true; 
	} 
	else{

		sValue = objForm[strField].value; 
		// Limpa todos os caracteres de formatação que 
		// já estiverem no campo. 
		sValue = sValue.toString().replace(/\-/g, ""); 
		sValue = sValue.toString().replace(/\./g, ""); 
		sValue = sValue.toString().replace(/\//g, ""); 
		sValue = sValue.toString().replace(/\(/g, ""); 
		sValue = sValue.toString().replace(/\)/g, ""); 
		sValue = sValue.toString().replace(/\s/g, ""); 
		sValue = sValue.toString().replace(/\,/g, ""); 
		sValue = sValue.toString().replace(/\:/g, ""); 	
		fldLen = sValue.length; 
		mskLen = sMask.length; 
		
		i = 0; 
		nCount = 0; 
		sCod = ""; 
		mskLen = fldLen; 
	
		while (i <= mskLen) { 
			bolMask = ((sMask.charAt(i) == "-") || (sMask.charAt(i) == ":") || (sMask.charAt(i) == ".") || (sMask.charAt(i) == "/")) 
			bolMask = bolMask || ((sMask.charAt(i) == "(") || (sMask.charAt(i) == ")") || (sMask.charAt(i) == " ") || (sMask.charAt(i) == ","))
	
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
		    if (sMask.charAt(i-1) == "9") { // apenas números... 
		    	return ((nTecla > 47) && (nTecla < 58)); } // números de 0 a 9 
			else { // qualquer caracter... 
			    return true; 
			} 
		} else { 
		    return true; 
		} 
		
	}
}
//fim formatacao de campos