package br.edu.pantaneiro.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class Constantes {
    public static final String HIFEN = "-";
    public static final String TIL = "~";
    public static final String UNDERSCORE = "_";
    public static final String BARRA = "/";
    public static final String ESPACO_HTML = "&nbsp";
    public static final String STRING_ESPACO = " ";
    public static final String STRING_VAZIA = "";
    public static final String VIRGULA = ",";
    public static final String ASPAS_SIMPLES = "'";
    public static final String PONTO_E_VIRGULA = ";";
    public static final String ARROBA = "@";

    public static final String PERCENT = "%";
    public static final int CEM = 100;
    public static final String SIM = "S";
    public static final String NAO = "N";

    public static final String ABRE_PARENTESES = "(";
    public static final String FECHA_PARENTESES = ")";
    public static final String ABRE_COLCHETES = "[";
    public static final String FECHA_COLCHETES = "]";

    public static DateFormat DATE_SQL = new SimpleDateFormat("yyyy-MM-dd");
    public static DateFormat DATE_HOUR_SQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static DateFormat DATE_BR = new SimpleDateFormat("dd-MM-yyyy");
    public static DateFormat DATE_BR_YY = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    public static DateFormat DATE_BR_FULL = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static DateFormat TIME = new SimpleDateFormat("HH:mm:ss");
    public static DateFormat DATE_DAY = new SimpleDateFormat("dd");


    public static NumberFormat NF_DEC = new DecimalFormat("#,##0.00");
    public static NumberFormat NF_NDEC = new DecimalFormat("#,##0");


    public static NumberFormat NF_5DIG = new DecimalFormat("00000");
    public static NumberFormat NF_6DIG = new DecimalFormat("000000");

    public static NumberFormat NF_4DEC = new DecimalFormat("0.0000");

    public static NumberFormat NF_2DEC2 = new DecimalFormat("#,###.##");
}
