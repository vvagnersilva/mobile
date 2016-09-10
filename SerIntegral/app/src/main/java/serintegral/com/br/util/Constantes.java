package serintegral.com.br.util;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;

/**
 * Created by Diogo Souza on 12/11/2015.
 */
public class Constantes {

    /**
     * Teste no ambiente de desenvolvimento.
     * Conta de comprador: vvagner.silva@gmail.com
     */
    public static final String PAYPAL_CLIENT_ID = "AbMzmmST4aHHIxdqab606H35RgH7dPZBeNdz1E5DM6hj9CqMjmEixqC4L5Koel7sspm5RJ_kVcqmczeH";
    public static final String PAYPAL_ENV = PayPalConfiguration.ENVIRONMENT_SANDBOX;

    /**
     * Teste no ambiente de producao.
     * Conta de vendedor: vvagner.silva@yahoo.com.br
     *
     */
    //public static final String PAYPAL_CLIENT_ID = "AWn7qozn9SYSemrJvORHIXCE2_TON6QF_JROuZ8XK9-gBZB1ctObmt_GsebemG5lqauvcus2_g_xvq9S";
    //public static final String PAYPAL_ENV = PayPalConfiguration.ENVIRONMENT_PRODUCTION;

    public static final String PAYPAL_INTENT = PayPalPayment.PAYMENT_INTENT_SALE;
    public static final String PAYPAL_CURRENCY = "BRL";

}
