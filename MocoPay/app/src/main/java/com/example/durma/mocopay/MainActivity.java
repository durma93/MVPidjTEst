package com.example.durma.mocopay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ch.nth.payment.*;
import ch.nth.payment.Payment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MoCOPAY";

    private Payment mPayment;
    private boolean mSetupDone;
    
    private String mSessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PaymentConfig config = new PaymentConfig.Builder(
                "http://payment.mocopay.com/v1/payment",
                "LNEC3TDWAYVUF982PMRZ46XHKBJQ7G",
                "KJZNMLCWY2R3H8GADBX9U4TP67QEVF")
                .build();

        mPayment = new Payment(this, config);
        mPayment.startSetup(listener);

        Button button = (Button) findViewById(R.id.buyButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeThePurchase();
            }
        });


    }

    private OnSetupFinishedListener listener = new OnSetupFinishedListener() {
        @Override
        public void onSetupFinished() {

            Log.d(TAG, "onSetupFinished: ");

            mSetupDone = true;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mSetupDone = false;
        mPayment.dispose();
    }

    private void makeThePurchase(){
        if (!mSetupDone){
            Log.d(TAG, "wait setup to finish: ");
            return;
        }
        PaymentRequest request = new PaymentRequest.Builder("PP29178036")
                .build();

        mPayment.startPayment(request, new PaymentListener() {
            @Override
            public void onSuccess(PaymentData paymentData) {
               mSessionId = paymentData.getSessionId();
               verifyThePurchase();
            }

            @Override
            public void onError(PaymentError paymentError) {
                Log.d(TAG, "an irrecoverable error was detected");
                Log.d(TAG, paymentError.toString());
                Toast.makeText(MainActivity.this, paymentError.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void verifyThePurchase() {
        mPayment.verifyPayment(mSessionId, new VerifyPaymentListener() {
            @Override
            public void onSuccess(VerifyPaymentResponse verifyPaymentResponse) {
                // inspect the "response" object to find out
                // more information about the payment session
                // for example you can get the status enum like this:
                PaymentSessionStatus status = PaymentSessionStatus.from(verifyPaymentResponse);
            }

            @Override
            public void onError(AsyncError asyncError) {
                // the network call failed or there was a server
                // side error – note that this does not
                // reflect the payment session status
            }
        });
    }
}