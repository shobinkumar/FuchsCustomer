package com.customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ThanksActivity extends AppCompatActivity {

    TextView tvBackToHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);
        ImageView imageView = (ImageView) findViewById(R.id.ivDrawer);


        tvBackToHome=(TextView)findViewById(R.id.tvBackToHome);
        tvBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThanksActivity.this,MainActivity.class));
            }
        });
    }
}
