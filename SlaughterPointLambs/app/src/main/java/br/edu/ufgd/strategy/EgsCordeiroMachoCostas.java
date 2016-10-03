package br.edu.ufgd.strategy;

import android.util.Log;

import br.edu.ufgd.utils.Constantes;

public class EgsCordeiroMachoCostas extends Egs {

    public EgsCordeiroMachoCostas(double peso, double prega, String spCategoria) {
        this.peso = peso;
        this.prega = prega;
        this.spCategoria = spCategoria;
    }

    public double CalcularEgs() {

        double egs = -4.16 + (0.717 * peso) - (1.257 * prega) - 0.01133 * Math.pow(peso, 2) + 0.0805 * Math.pow(prega, 2);

        setEgs(egs);

        setStrFormulaUtilizada(Constantes.FORMULA_CORDEIRO_MARCHO_COSTAS);

        Log.i(TAG, getClassName() + ".CalcularEgs(): " + egs);

        return egs;
    }
}
