package br.com.serintegral.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;

import java.math.BigDecimal;

import br.com.serintegral.MainActivity;
import br.com.serintegral.R;
import br.com.serintegral.currencyedittext.CurrencyEditText;
import br.com.serintegral.util.Constantes;
import br.com.serintegral.util.Util;

public class PaypalFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    static final int COD_PAGTO = 123;

    private TextView textProverbio;

    private CurrencyEditText currencyValor;

    private PayPalConfiguration payPalConfig = new PayPalConfiguration()
            .environment(Constantes.PAYPAL_ENV)
            .clientId(Constantes.PAYPAL_CLIENT_ID)
            .languageOrLocale("pt_BR");

    public static PaypalFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        PaypalFragment f = new PaypalFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Setando o titulo no toolbar.
        ((MainActivity) getActivity())
                .setActionBarTitle(R.string.opcao_paypal);

        View view = inflater.inflate(R.layout.paypal_fragment, container, false);

        textProverbio = (TextView) view.findViewById(R.id.txtProverbio);
        currencyValor = (CurrencyEditText) view.findViewById(R.id.currencyValor);

        final String textoEmHtml =
                "<html><body lang=\"pt-BR\" dir=\"ltr\">\n" +
                        "<p align=\"left\" style=\"margin-bottom: 0cm; font-variant: normal; letter-spacing: normal; font-style: normal; font-weight: normal; line-height: 0.53cm; orphans: 2; widows: 2\">\n" +
                        "<font color=\"#000000\">“<font face=\"URW Chancery L\"><font size=\"6\" style=\"font-size: 24pt\">E\n" +
                        "quem der, mesmo que seja apenas um copo de água fria a um destes\n" +
                        "pequeninos, por ser este meu discípulo, com toda a certeza vos\n" +
                        "afirmo que de modo algum perderá a sua recompensa”.</font></font></font></p>\n" +
                        "</body></html>";

        textProverbio.setText(Html.fromHtml(textoEmHtml, null, null));

        Button btDoar = (Button) view.findViewById(R.id.doar);

        btDoar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executarPagtoPayPal(v);
            }
        });

        return view;
    }

    private void executarPagtoPayPal(View v) {
        // Retirar o simbolo da moeda.
        String valor = currencyValor.getText().toString().replace("R$", "");

        if (valor.length() == 0) {
            currencyValor.setError("Campo obrigatório!");
            return;
        }

        // Conversao p/ Double
        Double val = Util.converteStringToDouble(valor);

        PayPalPayment pagto = montarPagtoFinal(val);

        Intent intent = new Intent(getContext(), PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfig);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, pagto);

        startActivityForResult(intent, COD_PAGTO);
    }

    private PayPalPayment montarPagtoFinal(Double valor) {

        PayPalPayment payPalPayment =
                new PayPalPayment(new BigDecimal(valor), Constantes.PAYPAL_CURRENCY, "Instituto Ser Integral", Constantes.PAYPAL_INTENT);

        payPalPayment.custom("Doação - Instituto Ser Integral");

        return payPalPayment;
    }

    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent intent) {
        super.onActivityResult(requestCode, responseCode, intent);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext(), R.style.AlertDialogStyle);

        alertDialogBuilder.setTitle("Informação");
        alertDialogBuilder.setIcon(R.drawable.ic_information);

        if (requestCode == COD_PAGTO) {
            if (responseCode == Activity.RESULT_OK) {
                alertDialogBuilder.setMessage("Doação realizada com sucesso!");
            } else {
                alertDialogBuilder.setMessage("Algum problema com a doação verificar a sua conta no paypal.");
            }

            alertDialogBuilder.setPositiveButton(" Ok ", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Limpar campo, verificar ?
                    // currencyValor.setCurrency(null);
                    //currencyValor.setText("");
                    dialog.dismiss();
                }
            });

            alertDialogBuilder.show();
        }
    }
}

