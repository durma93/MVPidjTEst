package com.example.durma.mocopay;

import ch.nth.payment.PaymentConfig;

/**
 * Created by durma on 22.1.18..
 */

public class Payment {

    PaymentConfig config = new PaymentConfig.Builder(
            "http://payment.mocopay.com/v1/payment",
            "LNEC3TDWAYVUF982PMRZ46XHKBJQ7G",
            "KJZNMLCWY2R3H8GADBX9U4TP67QEVF")
            .build();
}
