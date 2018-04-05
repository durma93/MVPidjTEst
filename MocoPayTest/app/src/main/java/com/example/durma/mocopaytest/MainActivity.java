package com.example.durma.mocopaytest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ch.nth.payment.AsyncError;
import ch.nth.payment.DisplayType;
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

    private Payment mPayment;
    private boolean mSetupDone;
    public String mSessionId;

    private static final String TAG = "greskau";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PaymentConfig config = new PaymentConfig.Builder(
                "http://payment.mocopay.com/v1/payment/", // get this from your MoCoPay control box
                "6NGTBFHU38WDLCVM7RQEJP4Z2KX9YA",
                "HUZRQG2W36F7PC9BXLVAN8D4YKTMEJ"
        ).build();

        mPayment = new Payment(this, config);
        mPayment.startSetup(listener);

        Button button = (Button) findViewById(R.id.buy_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeThePurchase();
                Log.d(TAG, "Purchase POCEO");
            }
        });
        button.invalidate();
    }

    private OnSetupFinishedListener listener = new OnSetupFinishedListener() {
        @Override
        public void onSetupFinished() {
            // our Payment object is now ready!
            mSetupDone = true;

            Log.d(TAG, "Gotov setup");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSetupDone = false;
        mPayment.dispose(); // important
    }

    private void makeThePurchase() {
        if (!mSetupDone) {
            // wait for the setup to finish
            Log.d(TAG, "Ceka se zavrsetak Setup-a!!!");
            return;
        }

        PaymentRequest request = new PaymentRequest.Builder("PP23760859")
                .build();

        mPayment.startPayment(request, new PaymentListener() {
            @Override
            public void onSuccess(PaymentData data) {
                // we have the sessionId – we should verify the session status!
                mSessionId = data.getSessionId();
                verifyThePurchase();
            }

            @Override
            public void onError(PaymentError error) {
                // an irrecoverable error was detected

                Log.d(TAG, "an irrecoverable error was detected");
                Log.d(TAG, error.toString());
                Toast.makeText(MainActivity.this, error.toString(),Toast.LENGTH_LONG).show();
            }
        }, DisplayType.NATIVE);
    }

    private void verifyThePurchase() {
        mPayment.verifyPayment(mSessionId, new VerifyPaymentListener() {
            @Override
            public void onSuccess(VerifyPaymentResponse response) {
                // inspect the "response" object to find out
                // more information about the payment session
                // for example you can get the status enum like this:
                PaymentSessionStatus status = PaymentSessionStatus.from(response);
                Log.d(TAG, "Response successefull");
            }

            @Override
            public void onError(AsyncError error) {
                // the network call failed or there was a server
                // side error – note that this does not
                // reflect the payment session status
                Log.d(TAG, "async error");
            }
        });
    }
}
