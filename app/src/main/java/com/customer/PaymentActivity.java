package com.customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentActivity extends AppCompatActivity {

    @BindView(R.id.ll)
    View ll;

    @BindView(R.id.ll1)
    View ll1;
    @BindView(R.id.ll2)
    View ll2;
    @BindView(R.id.ll3)
    View ll3;


    ImageView iv;

    ImageView iv1;
    ImageView iv2;
    ImageView iv3;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);
        iv = (ImageView) ll.findViewById(R.id.iv);
        iv1 = (ImageView) ll1.findViewById(R.id.iv);
        iv2 = (ImageView) ll2.findViewById(R.id.iv);
        iv3 = (ImageView) ll3.findViewById(R.id.iv);
        radioButton1 = (RadioButton) ll.findViewById(R.id.radioPaypal);
        radioButton2 = (RadioButton) ll1.findViewById(R.id.radioPaypal);
        radioButton3 = (RadioButton) ll2.findViewById(R.id.radioPaypal);
        radioButton4 = (RadioButton) ll3.findViewById(R.id.radioPaypal);
        iv.setImageDrawable(getResources().getDrawable(R.drawable.paypal));
        iv1.setImageDrawable(getResources().getDrawable(R.drawable.creditcard));
        iv2.setImageDrawable(getResources().getDrawable(R.drawable.applepay));
        iv3.setImageDrawable(getResources().getDrawable(R.drawable.bank));
        radioButton1.setText("Paypal");
        radioButton2.setText("Credit Card");
        radioButton3.setText("Apple Pay");
        radioButton4.setText("On Bank Account");
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeChecked(true, false, false, false);
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeChecked(false, true, false, false);
            }
        });
        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeChecked(false, false, true, false);
            }
        });
        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeChecked(false, false, false, true);
            }
        });

    }

    private void changeChecked(boolean b, boolean b1, boolean b2, boolean b3) {
        radioButton1.setChecked(b);
        radioButton2.setChecked(b1);
        radioButton3.setChecked(b2);
        radioButton4.setChecked(b3);
    }


    @OnClick({R.id.ll, R.id.ll1, R.id.ll2, R.id.ll3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll:
            case R.id.ll1:
            case R.id.ll2:
            case R.id.ll3:
                startActivity(new Intent(PaymentActivity.this, ThanksActivity.class));

                break;


        }
    }
}
