package com.customer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.customer.R;
import com.customer.fragment.HomeFragment;
import com.customer.model.ProductListModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectProgramAdapter extends RecyclerView.Adapter<SelectProgramAdapter.Holder> {
    Context context;
    ArrayList<ProductListModel> arrayList;
    HomeFragment homeFragment;
    public SelectProgramAdapter(Context context, ArrayList<ProductListModel> arrayList, HomeFragment homeFragment) {
        this.context = context;
        this.arrayList = arrayList;
        this.homeFragment=homeFragment;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_product_item, parent, false);

        return new SelectProgramAdapter.Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.tvProduct.setText(arrayList.get(i).getProduct_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeFragment.dismissDialog();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
       @BindView(R.id.tvProduct)
        TextView tvProduct;


        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
