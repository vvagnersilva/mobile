package serintegral.com.br.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.text.NumberFormat;

import serintegral.com.br.MainActivity;
import serintegral.com.br.R;

public class PaypalFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";
    private EditText edValor;

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

        View layout = inflater.inflate(R.layout.paypal_fragment, container, false);

        edValor = (EditText) layout.findViewById(R.id.edValor);

        edValor.addTextChangedListener(new TextWatcher() {
            NumberFormat currencyFormat = NumberFormat.getNumberInstance();
            private String current = "";

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().equals(current)) {
                    edValor.removeTextChangedListener(this);

                    int selection = edValor.getSelectionStart();

                    // We strip off the currency symbol
                    String replaceable = String.format("[%s,\\s]", NumberFormat.getCurrencyInstance().getCurrency().getSymbol());
                    String cleanString = s.toString().replaceAll(replaceable, "");

                    double price;

                    // Parse the string
                    try {
                        price = Double.parseDouble(cleanString);
                    } catch (java.lang.NumberFormatException e) {
                        price = 0;
                    }

                    // If we don't see a decimal, then the user must have deleted it.
                    // In that case, the number must be divided by 100, otherwise 1
                    int shrink = 1;
                    if (!(s.toString().contains("."))) {
                        shrink = 100;
                    }

                    // Reformat the number
                    String formated = currencyFormat.format((price / shrink));

                    current = formated;
                    edValor.setText(formated);
                    edValor.setSelection(Math.min(selection, edValor.getText().length()));

                    edValor.addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return layout;
    }
}

