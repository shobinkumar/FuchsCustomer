package com.customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailActivity extends AppCompatActivity {

    @BindView(R.id.tvBuyNow)
    TextView tvBuyNow;

    @BindView(R.id.tvAddToCart)
    TextView tvAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.tvBuyNow, R.id.tvAddToCart,R.id.llActivityToolbar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvBuyNow:
                startActivity(new Intent(this,PaymentActivity.class));
                break;
            case R.id.tvAddToCart:
                break;
            case R.id.llActivityToolbar:
                finish();
                break;
        }
    }

}
