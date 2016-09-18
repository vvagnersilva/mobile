package serintegral.com.br.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.google.android.gms.common.GooglePlayServicesUtil;

public class DialogErrorFragment extends DialogFragment {

    private int codigoDoErro;
    private int erro_play_service;

    public DialogErrorFragment() {
    }

    public void setCodigoDoErro(int codigoDoErro) {
        this.codigoDoErro = codigoDoErro;
    }

    public void setErro_play_service(int erro_play_service) {
        this.erro_play_service = erro_play_service;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return GooglePlayServicesUtil.getErrorDialog(
                codigoDoErro, getActivity(), erro_play_service);
    }
}

