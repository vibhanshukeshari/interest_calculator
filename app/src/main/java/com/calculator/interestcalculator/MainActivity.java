package com.calculator.interestcalculator;
//Jai Swami narayan
//Started on 27/12/22


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.hbb20.CountryCodePicker;
import com.robinhood.ticker.TickerView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView mBottomNavigation;
    private ViewPagerAdapter mViewPagerAdapter;
    private ViewPager viewPager;
    private LinearLayout bottomLinearLayout;
    Menu menu;
    DrawerLayout drawerLayout;
    private MaterialButton btnSimpleInterest;
    private MaterialButton btnCompoundInterest;

    NavigationView navigationView;
    private TickerView textViewFooterTotalAmount;

    CountryCodePicker ccp;
    TextView textViewCurrencySymbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.view_pager);
        mBottomNavigation = findViewById(R.id.bottom_navigation);
        bottomLinearLayout = findViewById(R.id.controller);
        drawerLayout = findViewById(R.id.drawer);
        btnSimpleInterest = findViewById(R.id.btn_simple_interest);
        btnCompoundInterest = findViewById(R.id.btn_compound_interest);
        navigationView = findViewById(R.id.navigation_view);
        textViewFooterTotalAmount = findViewById(R.id.text_view_footer_total_amount);
        drawerLayout = findViewById(R.id.drawer);

        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

        menu = navigationView.getMenu();

        ccp = MenuItemCompat.getActionView(menu.findItem(R.id.currency)).findViewById(R.id.ccp);
        textViewCurrencySymbol = MenuItemCompat.getActionView(menu.findItem(R.id.currency)).findViewById(R.id.text_view_currency_symbol);

        mBottomNavigation.setOnNavigationItemSelectedListener(this);

         mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mViewPagerAdapter);
        viewPager.setOffscreenPageLimit(2);

        try {

            btnSimpleInterest.setBackgroundColor(Color.parseColor("#1da1f3"));

        } catch (NullPointerException ignored){}

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:

                        mBottomNavigation.getMenu().findItem(R.id.menu_calculator).setChecked(true);
//                        Objects.requireNonNull(getSupportActionBar()).setTitle("Cal");
//                        mBottomNavigation.getMenu().findItem(R.id.menu_seaside).setChecked(true);
//                        Objects.requireNonNull(getSupportActionBar()).setTitle("Seaside");
//                        relativeLayoutMain.setBackgroundColor(getResources().getColor(R.color.prussian_blue_0));
//                        controller.setBackgroundResource(R.drawable.controller_shape);
//                        autoPlay.setBackgroundResource(R.drawable.controller_shape);
//                        mBottomNavigation.setBackgroundColor(getResources().getColor(R.color.prussian_blue_1));
//                        getWindow().setNavigationBarColor(getResources().getColor(R.color.prussian_blue_1));
//                        getWindow().setStatusBarColor(getResources().getColor(R.color.prussian_blue_1));
//                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.prussian_blue_1)));
                        break;
                    case 1:

                        mBottomNavigation.getMenu().findItem(R.id.menu_record).setChecked(true);
//                        Objects.requireNonNull(getSupportActionBar()).setTitle("City");
//                        mBottomNavigation.getMenu().findItem(R.id.menu_city).setChecked(true);
//                        Objects.requireNonNull(getSupportActionBar()).setTitle("City");
//                        relativeLayoutMain.setBackgroundColor(getResources().getColor(R.color.arsenic_0));
//                        controller.setBackgroundResource(R.drawable.controller_shape_city);
//                        autoPlay.setBackgroundResource(R.drawable.controller_shape_city);
//                        mBottomNavigation.setBackgroundColor(getResources().getColor(R.color.arsenic_1));
//                        getWindow().setNavigationBarColor(getResources().getColor(R.color.arsenic_1));
//                        getWindow().setStatusBarColor(getResources().getColor(R.color.arsenic_1));
//                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.arsenic_1)));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();


        if (this.drawerLayout.isDrawerOpen(navigationView)) {
            this.drawerLayout.closeDrawer(navigationView);
        } else {
//            super.onBackPressed();

//            if (viewPager.getCurrentItem() == 0) {
//
//                ImageView image = new ImageView(this);
//                image.setImageResource(R.drawable.qureka1);
//
//                image.setOnClickListener(v ->
//                {
//
//                    Uri uri = Uri.parse("https://830.go.mglgamez.com");
//                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//                    startActivity(intent);
//                });

            MaterialAlertDialogBuilder alertDialoBuider = new MaterialAlertDialogBuilder(MainActivity.this,R.style.alertDialog);
            alertDialoBuider.setTitle("Confirm !");
            alertDialoBuider.setIcon(R.drawable.alert_icon);
            alertDialoBuider.setMessage("Are you sure want to exit ?");



//            alertDialoBuider.getContext().setTheme(R.style.alertDialog);
//            alertDialoBuider.get


            alertDialoBuider.setPositiveButton("Exit !", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    MainActivity.super.onBackPressed();
                }

            })/*.setView(image)*/;


            alertDialoBuider.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();

                }
            });
            AlertDialog alertDialog = alertDialoBuider.create();
            alertDialog.show();
            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.highlight_blue));
            alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.light_white));


        }
//            alertDialoBuider.show();
//
//
//
//            SweetAlertDialog sweetAlertDialog;
//            sweetAlertDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE);
//
//            sweetAlertDialog.setTitleText("Confirm Exit!");
//            sweetAlertDialog.setContentText("Are you sure want to exit?");
//            sweetAlertDialog.setConfirmText("Exit!");
//            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                @Override
//                public void onClick(SweetAlertDialog sweetAlertDialog) {
//                    sweetAlertDialog.dismissWithAnimation();
//                            MainActivity.super.onBackPressed();
//                }
//            });
//
//            sweetAlertDialog.setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
//                        @Override
//                        public void onClick(SweetAlertDialog sweetAlertDialog) {
//                            sweetAlertDialog.dismissWithAnimation();
//                        }
//                    });
//
//            sweetAlertDialog.getContext().setTheme(R.style.mytheme);
//            sweetAlertDialog.show();


//            } else {
//                viewPager.setCurrentItem(viewPager.getCurrentItem() - 2);
//            }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_calculator:
                viewPager.setCurrentItem(0);
                break;
            case R.id.menu_record:
                viewPager.setCurrentItem(1);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


}