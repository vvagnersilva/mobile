package br.ufgd.adipometro.strategy;

public abstract class Egs {
    protected static final String TAG = "Ovigorificopinca";
    protected double peso;
    protected double prega;
    protected String strFormulaUtilizada;
    public String spCategoria;

    public double CalcularEgs() {
        return 0;
    }

    public String getStrFormulaUtilizada() {
        return strFormulaUtilizada;
    }

    public String getClassName() {
        // Retorna o nome da classe sem o pacote
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrega() {
        return prega;
    }

    public void setPrega(double prega) {
        this.prega = prega;
    }
}
