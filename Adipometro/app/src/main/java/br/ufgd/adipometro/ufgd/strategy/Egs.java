package br.ufgd.adipometro.ufgd.strategy;

public abstract class Egs {
    protected double peso;
    protected double ca;
    protected double cc;

    protected boolean checkedTipoPlicometro;

    protected String strFormulaUtilizada;

    protected static final String TAG = "Ovigorificopinca";

    public double CalcularEgs() {
        return 0;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCa() {
        return ca;
    }

    public void setCa(double ca) {
        this.ca = ca;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public boolean isCheckedTipoPlicometro() {
        return checkedTipoPlicometro;
    }

    public void setCheckedTipoPlicometro(boolean checkedTipoPlicometro) {
        this.checkedTipoPlicometro = checkedTipoPlicometro;
    }

    public String getStrFormulaUtilizada() {
        return strFormulaUtilizada;
    }

    public void setStrFormulaUtilizada(String strFormulaUtilizada) {
        this.strFormulaUtilizada = strFormulaUtilizada;
    }

    public String getClassName() {
        // Retorna o nome da classe sem o pacote
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }
}
