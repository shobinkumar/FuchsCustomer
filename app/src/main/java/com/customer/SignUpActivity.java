package com.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.tvSignUp)
    TextView tvSignUp;

    @BindView(R.id.tvLogin)
    TextView tvLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.tvSignUp,R.id.tvLogin})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.tvSignUp:
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
            case R.id.tvLogin:
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
        }
    }
}
