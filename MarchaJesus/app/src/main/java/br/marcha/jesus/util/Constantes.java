package br.marcha.jesus.util;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;

/**
 * Created by Diogo Souza on 12/11/2015.
 */
public class Constantes {

    //public static final String PAYPAL_CLIENT_ID = "ASHCe51uC3yqq94ci2yw2rlEEj7GBTGTuj6KpHaHEAakVO-mMXOUmdzZwc3JLZlGN-iEbax9JulbkooP";
    public static final String PAYPAL_CLIENT_ID = "ASHCe51uC3yqq94ci2yw2rlEEj7GBTGTuj6KpHaHEAakVO-mMXOUmdzZwc3JLZlGN-iEbax9JulbkooP";

    public static final String PAYPAL_ENV = PayPalConfiguration.ENVIRONMENT_SANDBOX;

    public static final String PAYPAL_INTENT = PayPalPayment.PAYMENT_INTENT_SALE;

    public static final String PAYPAL_CURRENCY = "BRL";

}
