package br.ufgd.adipometro.ufgd.strategy;

import android.util.Log;

import br.ufgd.adipometro.ufgd.utils.Constantes;

public class Cauda extends Egs {

    public Cauda(double peso, double ca, double cc,
                 boolean checkedTipoPlicometro) {
        this.peso = peso;
        this.ca = ca;
        this.cc = cc;
        this.checkedTipoPlicometro = checkedTipoPlicometro;
    }

    public double CalcularEgs() {

        double egs = 0;

        if (checkedTipoPlicometro) { // Pinca digital
            if (this.ca > 0 && this.cc == 0 && this.peso == 0) {
                // Utilizar a formula 1
                egs = 91.9384 - 51.3428 * this.ca + 7.7725 * Math.pow(this.ca, 2);
                this.strFormulaUtilizada = Constantes.FORMULA1;
            } else if (this.ca > 0 && this.cc == 0 && this.peso > 0) {
                // Utilizar a formula 4
                egs = 28.8277 + 0.1772 * this.peso - 8.0301 * this.ca;
                this.strFormulaUtilizada = Constantes.FORMULA4;
            } else if (this.ca > 0 && this.cc > 0 && this.peso == 0) {
                // Utilizar a formula 5
                egs = 27.3338 - 0.5834 * this.cc - 5.5342 * this.ca;
                this.strFormulaUtilizada = Constantes.FORMULA5;
            } else { // Possui as 3 variaveis, entao priorizar a formula F4
                egs = 28.8277 + 0.1772 * this.peso - 8.0301 * this.ca;
                this.strFormulaUtilizada = Constantes.FORMULA4;
            }
        } else { // Pinca comum
            if (this.ca > 0 && this.cc == 0 && this.peso == 0) {
                // Utilizar a formula 8
                egs = 21.875 - 3.5212 * this.ca;
                this.strFormulaUtilizada = Constantes.FORMULA8;
            } else if (this.ca > 0 && this.cc == 0 && this.peso > 0) {
                // Utilizar a formula 13
                egs = 21.0504 + 0.1377 * this.peso - 4.2899 * this.ca;
                this.strFormulaUtilizada = Constantes.FORMULA13;
            } else if (this.ca > 0 && this.cc > 0 && this.peso == 0) {
                // Utilizar a formula 14
                egs = 21.9099 - 0.0339 * this.cc - 3.508 * this.ca;
                this.strFormulaUtilizada = Constantes.FORMULA14;
            } else { // Possui as 3 variaveis, entao priorizar a formula F13
                egs = 21.0504 + 0.1377 * this.peso - 4.2899 * this.ca;
                this.strFormulaUtilizada = Constantes.FORMULA13;
            }
        }

        Log.i(TAG, getClassName() + ".CalcularEgs() chamado: " + egs);

        return egs;
    }
}
