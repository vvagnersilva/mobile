package serintegral.com.br.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    private Util() {
    }

    /*
     * Ler o arquivo do disco.
     * @param String nomeArquivo
     * @param String diretorio
     * @throws Exception
     */
    public static byte[] lerArquivo(String nomeArquivo, boolean deletar) throws FileNotFoundException, IOException {
        int tamanhoFile = 0;
        File file = new File(nomeArquivo);
        FileInputStream fis = new FileInputStream(file);
        Long tamanhoAux = new Long(file.length());
        tamanhoFile = tamanhoAux.intValue();
        byte[] ret = new byte[tamanhoFile];
        fis.read(ret, 0, tamanhoFile);
        fis.close();
        if (deletar) {
            file.delete();
        }
        return ret;
    }

    public static void apagaDiretorio(File file) throws IOException {

        if (file.isDirectory()) {

            if (file.list().length == 0) {
                file.delete();
            } else {

                String files[] = file.list();

                for (String temp : files) {
                    File fileDelete = new File(file, temp);

                    // recursive delete
                    apagaDiretorio(fileDelete);
                }

                if (file.list().length == 0) {
                    file.delete();
                }
            }

        } else {
            file.delete();
        }
    }

    public static String lerArquivo(InputStream is) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(is);
        InputStreamReader in = new InputStreamReader(bis, "UTF-8");
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result = in.read();
        while (result != -1) {
            byte b = (byte) result;
            buf.write(b);
            result = in.read();
        }
        return buf.toString();
    }

    public static byte[] lerArquivoLocalServer(URL url) throws IOException {

        InputStream bis = url.openStream();
        InputStreamReader in = new InputStreamReader(bis, "UTF-8");
        BufferedInputStream b = new BufferedInputStream(bis);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        byte[] buffer = new byte[2048];
        int length;
        while ((length = b.read(buffer)) != -1) {
            buf.write(buffer, 0, length);
        }

        bis.close();
        in.close();
        new String(buf.toByteArray());
        return buf.toByteArray();
    }

    public static Double converteStringToDouble(String valor) {
        String pattern = "#,##";
        Locale locale = new Locale("pt", "BR");
        NumberFormat numberFormatWithLocale = NumberFormat.getCurrencyInstance(locale);
        DecimalFormat decimalFormatWithLocale = (DecimalFormat) numberFormatWithLocale;
        decimalFormatWithLocale.applyPattern(pattern);
        try {
            return decimalFormatWithLocale.parse(valor).doubleValue();
        } catch (Exception e) {
            return null;
        }

    }

    public static String converteDoubleToString(Double valor) {
        String pattern = "###,##0.00";
        Locale locale = new Locale("pt", "BR");
        NumberFormat numberFormatWithLocale = NumberFormat.getCurrencyInstance(locale);
        DecimalFormat decimalFormatWithLocale = (DecimalFormat) numberFormatWithLocale;
        decimalFormatWithLocale.applyPattern(pattern);
        try {
            return decimalFormatWithLocale.format(valor);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Converte um BigDecimal para uma string com três dígitos e uma casa decimal. Ex: 100,0
     *
     * @param valor
     * @return String
     */
    public static String converteBigDecimalComUmaCasaDecimalToString(BigDecimal valor) {
        String pattern = "##0.0";
        Locale locale = new Locale("pt", "BR");
        NumberFormat numberFormatWithLocale = NumberFormat.getCurrencyInstance(locale);
        DecimalFormat decimalFormatWithLocale = (DecimalFormat) numberFormatWithLocale;
        decimalFormatWithLocale.applyPattern(pattern);
        try {
            return decimalFormatWithLocale.format(valor);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();

        if (length > Integer.MAX_VALUE) {
            throw new IOException("Arquivo muito grande.");
        }

        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;

        try {
            while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
        } catch (IOException e) {
            throw e;
        } finally {
            is.close();
        }

        if (offset < bytes.length) {
            throw new IOException("Não foi possível completar a leitura do arquivo " + file.getName());
        }
        return bytes;
    }

    public static Date getDataAtual() {
        return Calendar.getInstance().getTime();
    }

    public static String removerMascaras(String numero) {
        if (numero != null && !numero.equals("")) {
            numero = numero.replaceAll("\\p{Punct}", "").trim();
            numero = numero.replaceAll(" ", "").trim();
        }

        return numero;
    }

    /**
     * Valida se a data final é menor que a data inicial, retornando TRUE Obs: Valide se a data é válida primeiro.
     *
     * @param String dataInicial
     * @param String dataInicial
     * @return Boolean
     */
    public static Boolean isValidaDataFinalMenorInicialStr(String dataInicial, String dataFinal, String pattern) throws Exception {
        if (pattern == null) {
            pattern = "dd/mm/yyyy";
        }
        SimpleDateFormat data = new SimpleDateFormat(pattern);

        if (data.parse(dataFinal).before(data.parse(dataInicial))) {
            return true;
        } else {
            return false;
        }
    }

    public static Long extrairAnoData(Date data) {
        Calendar calendario = new GregorianCalendar();
        calendario.setTime(data);
        return new Long(calendario.get(Calendar.YEAR));
    }

    /**
     * Recupera o ano atual.
     *
     * @return int ano
     */
    public static int anoAtual() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static Boolean isValidaCPFDigitoIguais(String cpfSemMascara) throws Exception {
        if (cpfSemMascara.matches("[0]{11}") || cpfSemMascara.matches("[1]{11}") || cpfSemMascara.matches("[2]{11}") || cpfSemMascara.matches("[3]{11}")
                || cpfSemMascara.matches("[4]{11}") || cpfSemMascara.matches("[5]{11}") || cpfSemMascara.matches("[6]{11}") || cpfSemMascara.matches("[7]{11}")
                || cpfSemMascara.matches("[8]{11}") || cpfSemMascara.matches("[9]{11}")) {

            return true;
        }
        return false;
    }

    public static Integer getBytesFromKbyte(Integer tamanhoByte) throws Exception {
        return tamanhoByte / 1024;
    }

    /**
     * Retorna se a data inicio e data fim está dentro da data(compara) informada
     *
     * @param inicio
     * @param fim
     * @param compara
     * @return
     */
    public static boolean betweenDate(Date inicio, Date fim, Date compara) {
        if (compara.after(inicio) && compara.before(fim)) {
            return true;
        } else if (inicio.equals(compara)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Valida se a data final é menor que a data inicial, retornando TRUE
     *
     * @param dataInicial
     * @param dataInicial
     * @return Boolean
     */
    public static Boolean isValidaDataFinalMenorInicial(Date dataInicial, Date dataFinal) {
        if (dataFinal.before(dataInicial)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica a sobre posição de dois periodos. Retorna verdadeiro se os periodos se sobrepõem
     *
     * @param dataInicial1
     * @param dataFinal1
     * @param dataInicial2
     * @param dataFinal2
     * @return boolean
     */
    public static boolean verificaSobreposicaoPeriodos(Date dataInicial1, Date dataFinal1, Date dataInicial2, Date dataFinal2) {

        boolean retorno = false;

        if (dataFinal1 != null && dataInicial1 != null && dataFinal2 != null && dataInicial2 != null) {

            if (dataEntre(dataInicial2, dataInicial1, dataFinal2) || dataEntre(dataInicial2, dataFinal1, dataFinal2)
                    || dataEntre(dataInicial1, dataInicial2, dataFinal1) || dataEntre(dataInicial1, dataFinal2, dataFinal1)) {

                retorno = true;
            }
        } else if (dataFinal1 == null && dataInicial1 == null && dataFinal2 == null && dataInicial2 == null) {
            retorno = true;

        }

        return retorno;

    }

    /**
     * Verifica se uma data está no intervalo (inclusive) entre outras duas
     *
     * @param dataMenor
     * @param data
     * @param dataMaior
     * @return
     */
    public static boolean dataEntre(Date dataMenor, Date data, Date dataMaior) {
        boolean retorno = (data.after(dataMenor) || data.equals(dataMenor)) && (data.before(dataMaior) || data.equals(dataMaior));
        return retorno;
    }

    public static int compara(Object obj1, Object obj2, int retorno) {
        if (retorno == 0) {
            retorno = 0;
            if (obj1 != null && obj2 == null) {
                retorno = 1;
            } else if (obj1 == null && obj2 != null) {
                retorno = -1;
            } else if (obj1 != null && obj2 != null) {
                if (obj1 instanceof Comparable && obj2 instanceof Comparable) {
                    retorno = ((Comparable) obj1).compareTo((Comparable) obj2);
                } else {
                    retorno = obj1.toString().compareTo(obj2.toString());
                }
            }
            if (retorno > 0) {
                retorno = 1;
            } else if (retorno < 0) {
                retorno = -1;
            }
        }
        return retorno;
    }

    public static String getTextoRelatorioComQuebra(String textoReferencia, String texto, int tamanhoCampoReferencia, int tamanhoCampo, int tamanhoLista) {
        int tamanhoTextoReferencia = textoReferencia.length();
        int tamanhoTexto = texto.length();

        int qtdQuebraTextoRerencia = tamanhoTextoReferencia / tamanhoCampoReferencia;
        int qtdQuebraTexto = tamanhoTexto / tamanhoCampo;
        int qtdQuebra = 0;
        if (qtdQuebraTextoRerencia > qtdQuebraTexto) {
            qtdQuebra = qtdQuebraTextoRerencia - qtdQuebraTexto;
        }
        String quebra = "";
        if (qtdQuebra > 1 && qtdQuebra > tamanhoLista) {
            qtdQuebra = (qtdQuebra / 2) + 1;
        }
        for (int i = 0; i < qtdQuebra; i++) {
            quebra += "\n";
        }
        return quebra + texto + quebra;
    }

    /**
     * Retorna o valor monetário, no formato "R$ 4.500" (contêm o símbolo da moeda).
     *
     * @param valor              BigDecimal
     * @param qtdDigitosCentavos quantidade de dígitos para os centavos.
     * @return String
     */
    public static String transformaValorMonetarioComSimboloMoeda(BigDecimal valor, int qtdDigitosCentavos) {
        if (valor == null) {
            return null;
        }

        NumberFormat f = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
        f.setMaximumFractionDigits(qtdDigitosCentavos);

        return f.format(valor.doubleValue());
    }

    public static String dateToString(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        return fmt.format(date);
    }

    /**
     * Retorna o valor monetário, no formato "4.500" (sem os centavos).
     *
     * @param valor       BigDecimal
     * @param vazioSeZero boolean define se deve retornar (true) uma string vazia ("") caso o valor seja zero. Caso contrário (false) retorna a String com valor zero ("0").
     * @return
     */
    public static String transformaValorMonetarioSemSimboloMoeda(BigDecimal valor, boolean vazioSeZero) {
        DecimalFormat d = new DecimalFormat("#,##0");

        if (valor == null) {
            return vazioSeZero ? "" : d.format(0L);
        }

        if (vazioSeZero && valor.compareTo(BigDecimal.valueOf(0l)) == 0) {
            return "";
        }

        return d.format(valor.doubleValue());
    }

    public static Date stringToDate(String date) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            return fmt.parse(date);

        } catch (ParseException e) {
            return null;
        }
    }

    public static String converteBigDecimalToString(BigDecimal valor) {
        String pattern = "###,##0.00";
        Locale locale = new Locale("pt", "BR");
        NumberFormat numberFormatWithLocale = NumberFormat.getCurrencyInstance(locale);
        DecimalFormat decimalFormatWithLocale = (DecimalFormat) numberFormatWithLocale;
        decimalFormatWithLocale.applyPattern(pattern);

        try {
            return decimalFormatWithLocale.format(valor);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object copiarAtuibutosClasse(Object a, Object b) throws IllegalArgumentException, IllegalAccessException {
        Field[] fieldsFromFirstClass = a.getClass().getDeclaredFields();
        Field[] fieldsFromSecondClass = b.getClass().getDeclaredFields();

        for (Field currentFieldFromTheFirstClass : fieldsFromFirstClass) {
            for (Field currentFieldFromTheSecondClass : fieldsFromSecondClass) {
                String nameOfTheFirstField = currentFieldFromTheFirstClass.getName();
                String nameOfTheSecondField = currentFieldFromTheSecondClass.getName();

                if (!nameOfTheFirstField.equals("serialVersionUID")) {
                    if (nameOfTheFirstField.equals(nameOfTheSecondField)) {
                        currentFieldFromTheFirstClass.setAccessible(true);
                        currentFieldFromTheSecondClass.setAccessible(true);

                        currentFieldFromTheFirstClass.set(b, currentFieldFromTheSecondClass.get(a));
                    }
                }
            }
        }

        return b;
    }

    /***************************************************************************
     * ltrim - REMOVER OS ESPAÇO EM BRANCO NO INICIO DA STRING
     *
     * @param valor
     * @return String
     **************************************************************************/
    public static String ltrim(String valor) {
        return valor != null ? valor.replaceAll("^\\s+", "") : null;
    }

    /***************************************************************************
     * rtrim - REMOVER OS ESPAÇO EM BRANCO NO FINAL DA STRING
     *
     * @param valor
     * @return String
     **************************************************************************/
    public static String rtrim(String valor) {
        return valor != null ? valor.replaceAll("\\s+$", "") : null;
    }

    /***************************************************************************
     * trim - REMOVER OS ESPAÇO EM BRANCO DA STRING
     *
     * @param valor
     * @return String
     **************************************************************************/
    /**
     * remove os espaços em branco.
     *
     * @param valor
     * @return
     */
    public static String trim(String valor) {
        return valor != null ? removerEspacosDuplicados(rtrim(ltrim(valor))) : null;
    }

    /**
     * Remover os espaços duplicados entre as strings deixando somente um espaço
     *
     * @return
     * @throws Exception
     */
    public static String removerEspacosDuplicados(String str) {
        String patternStr = "\\s+";
        String replaceStr = " ";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll(replaceStr);
    }
}
