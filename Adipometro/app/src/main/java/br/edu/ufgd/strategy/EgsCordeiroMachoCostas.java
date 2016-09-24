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

        double egs = -3.57 + 0.675 * peso - 1.255 * prega - 0.01061 * Math.pow(peso, 2) + 0.0805 * Math.pow(prega, 2);

        setEgs(egs);
        setStrFormulaUtilizada(Constantes.FORMULA_CORDEIRO_MARCHO_COSTAS);

        Log.i(TAG, getClassName() + ".CalcularEgs(): " + egs);

        return egs;
    }
}
