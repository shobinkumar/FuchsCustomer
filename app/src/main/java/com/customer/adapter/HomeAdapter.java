package com.customer.adapter;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.customer.ProductDetailActivity;
import com.customer.R;

public class HomeAdapter extends  RecyclerView.Adapter<HomeAdapter.MyHolder> {
    Context context;
    public HomeAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_home_iteam, parent, false);

        return new HomeAdapter.MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,ProductDetailActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
