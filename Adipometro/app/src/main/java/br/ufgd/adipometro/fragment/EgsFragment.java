package br.ufgd.adipometro.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.ufgd.adipometro.R;
import br.ufgd.adipometro.strategy.Egs;

public class EgsFragment extends Fragment {
    protected static final String TAG = "Adipometro";
    private static final String FORMULA = "formula";
    private static final String EGS = "egs";

    public static EgsFragment novaInstancia(Egs egs) {
        Bundle params = new Bundle();
        params.putString(FORMULA, egs.getStrFormulaUtilizada());
        params.putDouble(EGS, egs.getEgs());

        EgsFragment fragment = new EgsFragment();

        fragment.setArguments(params);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.egs_fragment, container, false);

        Bundle params = getArguments();

        String formula = params.getString(FORMULA);
        double egs = params.getDouble(EGS);

        setBackground(formula, egs, layout);

        return layout;
    }

    /**
     * Intervalos da variavel egs setando as cores.
     *
     * @param egs
     * @param formula
     * @param layout
     */
    public void setBackground(String formula, Double egs, View layout) {

        // Setando os labels na tela.
        TextView txFormula = (TextView) layout.findViewById(R.id.tFormula);
        txFormula.setText(formula);

        TextView txEgs = (TextView) layout.findViewById(R.id.tEgs);

        txEgs.setText("EGS = " + egs);

        LinearLayout ll = (LinearLayout) layout.findViewById(R.id.llResultado);

        if (egs < 1) {
            txFormula.setTextColor(Color.WHITE);
            txEgs.setTextColor(Color.WHITE);
            ll.setBackgroundResource(R.drawable.background_laranja);
        } else if (egs >= 1 && egs < 2) {
            txFormula.setTextColor(Color.BLACK);
            txEgs.setTextColor(Color.BLACK);
            ll.setBackgroundResource(R.drawable.background_amarelo);
        } else if (egs >=2 && egs < 3) {
            txFormula.setTextColor(Color.BLACK);
            txEgs.setTextColor(Color.BLACK);
            ll.setBackgroundResource(R.drawable.background_verde);
        } else if (egs >= 3) {
            txFormula.setTextColor(Color.WHITE);
            txEgs.setTextColor(Color.WHITE);
            ll.setBackgroundResource(R.drawable.background_vermelho);
        }
    }
}