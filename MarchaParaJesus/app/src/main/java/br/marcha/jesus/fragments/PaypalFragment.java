package br.marcha.jesus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import br.marcha.jesus.R;

import br.marcha.jesus.util.CustomOnItemSelectedListener;

public class PaypalFragment extends Fragment {
    private Spinner spinner1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         View view = inflater.inflate(R.layout.paypal_fragment, container, false);

        addListenerOnSpinnerItemSelection(view);

        return view;
    }

    public void addListenerOnSpinnerItemSelection( View view){
        spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
}