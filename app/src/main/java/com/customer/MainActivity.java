package com.customer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.customer.fragment.HomeFragment;
import com.customer.fragment.MyAccountFragment;
import com.customer.fragment.OffersFragment;
import com.customer.fragment.OrderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigationView)
    NavigationView nv;


    @BindView(R.id.llHomeMain)
    LinearLayout llHomeMain;
    @BindView(R.id.llHome)
    LinearLayout llHome;
    @BindView(R.id.tvHome)
    TextView tvHome;


    @BindView(R.id.ivDrawer)
    ImageView ivDrawer;


    @BindView(R.id.llOffersMain)
    LinearLayout llOffersMain;
    @BindView(R.id.llOffers)
    LinearLayout llOffers;
    @BindView(R.id.tvOffers)
    TextView tvOffers;

    @BindView(R.id.llOrdersMain)
    LinearLayout llOrdersMain;
    @BindView(R.id.llOrders)
    LinearLayout llOrders;
    @BindView(R.id.tvOrders)
    TextView tvOrders;

    @BindView(R.id.llAccountMain)
    LinearLayout llAccountMain;
    @BindView(R.id.llAccount)
    LinearLayout llAccount;
    @BindView(R.id.tvAccount)
    TextView tvAccount;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initOtherViews();

    }

    private void initOtherViews() {

        ButterKnife.bind(this);
        changeFragment(new HomeFragment());
        changeFragments(getResources().getDrawable(R.drawable.circle_red), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));


    }

    @OnClick({R.id.llHomeMain, R.id.llOffersMain, R.id.llOrdersMain, R.id.llAccountMain, R.id.ivDrawer, R.id.tvLogout})
    public void pickDoor(View view) {
        if (view.getId() == R.id.llHomeMain) {
            changeFragment(new HomeFragment());
            changeFragments(getResources().getDrawable(R.drawable.circle_red), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));
        } else if (view.getId() == R.id.llOffersMain) {
            changeFragment(new OffersFragment());
            changeFragments(getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_red), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

        } else if (view.getId() == R.id.llOrdersMain) {
            changeFragment(new OrderFragment());
            changeFragments(getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_red), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

        } else if (view.getId() == R.id.llAccountMain) {
            changeFragment(new MyAccountFragment());
            changeFragments(getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_red), getResources().getDrawable(R.drawable.circle_blue), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

        } else if (view.getId() == R.id.ivDrawer) {
            drawerLayout.openDrawer(Gravity.START);
        } else if (view.getId() == R.id.tvLogout) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
            startActivity(intent);
            finish();

        }

    }

    private void changeFragments(Drawable drawable, Drawable drawable1, Drawable drawable2, Drawable drawable3, Drawable drawable4, int color, int color1, int color2, int color3, int color4) {
        llHome.setBackground(drawable);
        llOffers.setBackground(drawable1);
        llOrders.setBackground(drawable2);
        llAccount.setBackground(drawable3);
        tvHome.setTextColor(color);
        tvOffers.setTextColor(color1);
        tvOrders.setTextColor(color2);
        tvAccount.setTextColor(color3);


    }

    void changeFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout, fragment);
            ft.commit();
            drawerLayout.closeDrawers();
        }
    }



}
