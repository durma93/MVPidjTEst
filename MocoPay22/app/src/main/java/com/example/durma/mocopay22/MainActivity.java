package com.example.durma.mocopay22;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ch.nth.payment.AsyncError;
import ch.nth.payment.OnSetupFinishedListener;
import ch.nth.payment.Payment;
import ch.nth.payment.PaymentConfig;
import ch.nth.payment.PaymentData;
import ch.nth.payment.PaymentError;
import ch.nth.payment.PaymentListener;
import ch.nth.payment.PaymentRequest;
import ch.nth.payment.PaymentSessionStatus;
import ch.nth.payment.VerifyPaymentListener;
import ch.nth.payment.VerifyPaymentResponse;

public class MainActivity extends Activity {


    private static final String TAG = "greskau";

    private Payment mPayment;
    private boolean mSetupDone;

    private String mSessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PaymentConfig config = new PaymentConfig.Builder(
                "http://payment.mocopay.com/v1/payment/", // get this from your MoCoPay control box
                "6NGTBFHU38WDLCVM7RQEJP4Z2KX9YA",
                "HUZRQG2W36F7PC9BXLVAN8D4YKTMEJ")
                .build();

        mPayment = new Payment(this, config);
        mPayment.startSetup(listener);

        Button button = (Button) findViewById(R.id.buyButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeThePurchase();
                Log.d(TAG, "Purchase POCEO");
            }
        });


    }

    private OnSetupFinishedListener listener = new OnSetupFinishedListener() {
        @Override
        public void onSetupFinished() {

            Log.d(TAG, "Gotov setup");

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
        PaymentRequest request = new PaymentRequest.Builder("PP23760859")
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
