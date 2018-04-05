package com.example.durma.mvplivesession.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.durma.mvplivesession.MainActivity;
import com.example.durma.mvplivesession.R;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private EditText username, password;
    private Button loginl;
    private ProgressBar progressBar;

    private LoginPresenter mLogingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogingPresenter = new LoginPresenterImpl(this);

        username = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);
        loginl = (Button)findViewById(R.id.buttonLogin);
        progressBar = (ProgressBar) findViewById(R.id.pb);

        loginl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLogingPresenter.valitdateCredentials(username.getText().toString().trim(),password.getText().toString().trim());

            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameErorr() {
        username.setError("Username emty");
    }

    @Override
    public void setPasswordError() {
        password.setError("Pasword emty");

    }

    @Override
    public void navigateToMainActivity() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLogingPresenter.onDestroy();
    }
}
