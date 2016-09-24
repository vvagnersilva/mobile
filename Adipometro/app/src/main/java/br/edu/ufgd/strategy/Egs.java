package br.edu.ufgd.strategy;

public abstract class Egs {
    protected static final String TAG = "Ovigorificopinca";
    public String spCategoria;
    protected double egs;
    protected double peso;
    protected double prega;
    protected String strFormulaUtilizada;

    public double CalcularEgs() {
        return 0;
    }

    public String getStrFormulaUtilizada() {
        return strFormulaUtilizada;
    }

    public void setStrFormulaUtilizada(String strFormulaUtilizada) {
        this.strFormulaUtilizada = strFormulaUtilizada;
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

    public double getEgs() {
        return egs;
    }

    public void setEgs(double egs) {
        this.egs = egs;
    }

    public String getClassName() {
        // Retorna o nome da classe sem o pacote
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }
}
