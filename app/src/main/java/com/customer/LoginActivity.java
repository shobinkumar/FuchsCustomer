package com.customer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity {
    @BindView(R.id.fb)
    ImageView fb;

    @BindView(R.id.google)
    ImageView google;
    @BindView(R.id.button)
    Button button;

    @BindView(R.id.btnSignUp)
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    public void loginMethod(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    @OnClick({R.id.fb, R.id.google,R.id.btnSignUp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb:
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                break;

            case R.id.google:
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                break;
            case R.id.btnSignUp:
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
                break;
        }
    }

    @OnClick(R.id.button)
    public void clickToButton(View view){
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }

}
