package br.gov.serintegral.util;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;

/**
 * Created by Wagner Silva.
 */
public class Constantes {

    /**
     * Teste no ambiente de desenvolvimento.
     */
    //public static final String PAYPAL_CLIENT_ID = "AXN8bzisLLMICP9T68Xk48pC3BR0Fh_f2H1vPCS-m5Zk_3Thccwf6r6-ligP63qGK_GnwRE_RKfaX2zB";
   //public static final String PAYPAL_ENV = PayPalConfiguration.ENVIRONMENT_SANDBOX;

    /**
     * Teste no ambiente de producao.
     */
    public static final String PAYPAL_CLIENT_ID = "ARJwCBNDcv4HrdvrUgonhS5dVJnsb6Ovjm9p_vaBu5nHIssqVHgw5856Iq8trOB770eAXZ3YQSIt0c42";
    public static final String PAYPAL_ENV = PayPalConfiguration.ENVIRONMENT_PRODUCTION;

    public static final String PAYPAL_INTENT = PayPalPayment.PAYMENT_INTENT_SALE;
    public static final String PAYPAL_CURRENCY = "BRL";

}
