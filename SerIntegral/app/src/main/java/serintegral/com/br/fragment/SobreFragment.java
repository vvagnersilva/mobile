package serintegral.com.br.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import serintegral.com.br.R;

public class SobreFragment extends Fragment {
    private static final String EXTRA_TIPO = "mTipo";

    public static SobreFragment novaInstancia(String tipo) {
        Bundle params = new Bundle();
        params.putString(EXTRA_TIPO, tipo);
        SobreFragment f = new SobreFragment();
        f.setArguments(params);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sobre_fragment, container, false);

        TextView txtDesenv = (TextView) view.findViewById(R.id.txtDesenv);
        ImageView imgLogo = (ImageView) view.findViewById(R.id.imgLogo);

        final String textoEmHtml =
                "<html>\n" +
                        "<body lang=\"pt-BR\" text=\"#00000a\" dir=\"ltr\">\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\"><b>MEMBROS</b></font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\"><a href=\"mailto:destralha%40gmail.com\"><span style=\"font-variant: normal\"><font color=\"#365899\"><span style=\"text-decoration: none\"><font face=\"helvetica, arial, sans-serif\"><font size=\"2\" style=\"font-size: 9pt\"><span style=\"letter-spacing: normal\"><span style=\"font-style: normal\"><span style=\"font-weight: normal\">destralha@gmail.com</span></span></span></font></font></span></font></span></a></font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\">Ricardo Matsu – Web Designer</font></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<br/>\n" +
                        "\n" +
                        "</p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<a href=\"mailto:destralha%40gmail.com\"><span style=\"font-variant: normal\"><font color=\"#365899\"><span style=\"text-decoration: none\"><font face=\"helvetica, arial, sans-serif\"><font size=\"2\" style=\"font-size: 9pt\"><span style=\"letter-spacing: normal\"><span style=\"font-style: normal\"><span style=\"font-weight: normal\">vvagner.silva@gmail.com</span></span></span></font></font></span></font></span></a></p>\n" +
                        "<p class=\"western\" align=\"center\" style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                        "<font face=\"Purisa, serif\">Wagner Silva - Desenvolvedor</font></p>\n" +
                        "</body>\n" +
                        "</html>";

        txtDesenv.setText(Html.fromHtml(textoEmHtml, null, null));

        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = "[Instituto Ser Integral] - Fale Conosco";

                Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_CC, new String[]{"vvagner.silva@gmail.com", "ricamatsu@gmail.com"});
                //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, "");

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });

        return view;
    }
}