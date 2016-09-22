package br.ufgd.adipometro.strategy;

import android.util.Log;

import br.ufgd.adipometro.utils.Constantes;

public class EgsCordeiroMachoPeito extends Egs {

    public EgsCordeiroMachoPeito(double peso, double prega, String spCategoria) {
        this.peso = peso;
        this.prega = prega;
        this.spCategoria = spCategoria;
    }

    public double CalcularEgs() {

        double egs = -3.23 + 0.550 * peso - 0.776 * prega - 0.00891 * Math.pow(peso, 2) + 0.0506 * Math.pow(prega, 2);

        setEgs(egs);
        strFormulaUtilizada = Constantes.PEITO;

        Log.i(TAG, getClassName() + ".CalcularEgs(): " + egs);

        return egs;
    }
}
