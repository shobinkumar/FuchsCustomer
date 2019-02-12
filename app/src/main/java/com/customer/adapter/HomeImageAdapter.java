package com.customer.adapter;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.customer.ProductListActivity;
import com.customer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeImageAdapter extends RecyclerView.Adapter<HomeImageAdapter.MyHolder> {
    Activity activity;

    public HomeImageAdapter(Activity activity) {
        this.activity = activity;

    }

    @NonNull
    @Override
    public HomeImageAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_image, parent, false);

        return new HomeImageAdapter.MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeImageAdapter.MyHolder myHolder, int pos) {
        myHolder.iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (pos == 0) {
            myHolder.iv.setImageDrawable(activity.getResources().getDrawable(R.drawable.engine_oil));
        } else if (pos == 1) {
            myHolder.iv.setImageDrawable(activity.getResources().getDrawable(R.drawable.automatic_transmission));
        } else if (pos == 2) {
            myHolder.iv.setImageDrawable(activity.getResources().getDrawable(R.drawable.coolent));
        } else if (pos == 3) {
            myHolder.iv.setImageDrawable(activity.getResources().getDrawable(R.drawable.grease));
        } else if (pos == 4) {
            myHolder.iv.setImageDrawable(activity.getResources().getDrawable(R.drawable.manualtransmission));
        }
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, ProductListActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
