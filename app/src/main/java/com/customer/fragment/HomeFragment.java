package com.customer.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.customer.R;
import com.customer.adapter.HomeAdapter;
import com.customer.adapter.HomeImageAdapter;
import com.customer.adapter.SelectProgramAdapter;
import com.customer.adapter.SlidingImage_Adapter;
import com.customer.model.ProductListModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment {
    View view;
    @BindView(R.id.pager)
    ViewPager mPager;

    @BindView(R.id.rvHome)
    RecyclerView rvHOME;

    @BindView(R.id.rvHomeImages)
    RecyclerView rvHomeImages;
    RecyclerView.LayoutManager layoutManagerImage;

    RecyclerView.LayoutManager layoutManager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private Dialog dialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        init();
        initView();
        return view;
    }

    private void initView() {
        layoutManagerImage = new GridLayoutManager(getActivity(), 2);
        rvHomeImages.setLayoutManager(layoutManagerImage);

        hideImageRecycler();
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvHOME.setLayoutManager(layoutManager);
        hideImageRecycler();
    }


    @OnClick({R.id.tvCategory})
    public void onClick(View view) {
        showPictureialog();

    }

    private void init() {

        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        mPager.setAdapter(new SlidingImage_Adapter(getActivity(), ImagesArray));
        final float density = getResources().getDisplayMetrics().density;


        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);


    }


    private void showPictureialog() {
        ArrayList<ProductListModel> arrayList = new ArrayList<>();
        arrayList.add(new ProductListModel("Cars Engine Oil"));
        arrayList.add(new ProductListModel("Motorcycle & Scooter Engine Oil"));
        arrayList.add(new ProductListModel("Truck & Bus Lubricants"));
        arrayList.add(new ProductListModel("Industrial Lubricants"));
        dialog = new Dialog(getActivity(),
                android.R.style.Theme_Translucent_NoTitleBar);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.TOP;
        wlp.dimAmount = 0.70f;
        wlp.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;

        window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        dialog.setTitle(null);
        dialog.setContentView(R.layout.dialog_product_program);
        dialog.setCancelable(true);
        RecyclerView recyclerItems = (RecyclerView) dialog.findViewById(R.id.recyclerItems);
        ImageView ivClose = (ImageView) dialog.findViewById(R.id.ivClose);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerItems.setLayoutManager(manager);
        recyclerItems.setAdapter(new SelectProgramAdapter(getActivity(), arrayList, HomeFragment.this));
        dialog.show();

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageRecycler();
                dialog.dismiss();
            }
        });
    }

    public void dismissDialog() {

        showImageRecycler();
        dialog.dismiss();
    }

    void showImageRecycler()
    {
        rvHOME.setVisibility(View.GONE);
        rvHomeImages.setVisibility(View.VISIBLE);
        rvHomeImages.setAdapter(new HomeImageAdapter(getActivity()));
    }
    void hideImageRecycler()
    {
        rvHomeImages.setVisibility(View.GONE);
        rvHOME.setVisibility(View.VISIBLE);
        rvHOME.setAdapter(new HomeAdapter(getActivity()));

    }


}
