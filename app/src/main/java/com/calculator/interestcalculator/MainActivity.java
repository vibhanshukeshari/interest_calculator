package com.calculator.interestcalculator;
//Jai Swami narayan
//Started on 27/12/22


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView mBottomNavigation;
    private ViewPagerAdapter mViewPagerAdapter;
    private ViewPager viewPager;
    private LinearLayout bottomLinearLayout;
    Menu menu;
    private MaterialButton btnSimpleInterest;
    private MaterialButton btnCompoundInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);





        viewPager = findViewById(R.id.view_pager);
        mBottomNavigation = findViewById(R.id.bottom_navigation);
        bottomLinearLayout = findViewById(R.id.controller);
        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        btnSimpleInterest = findViewById(R.id.btn_simple_interest);
        btnCompoundInterest = findViewById(R.id.btn_compound_interest);



        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

        menu = navigationView.getMenu();



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

        btnSimpleInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    btnSimpleInterest.setBackgroundColor(Color.parseColor("#1da1f3"));
                    btnSimpleInterest.setTextColor(Color.parseColor("#ffffff"));
                    btnSimpleInterest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.simple_icon, 0, 0, 0);



                    btnCompoundInterest.setBackgroundColor(Color.parseColor("#15202b"));
                    btnCompoundInterest.setTextColor(Color.parseColor("#8899a6"));
                    btnCompoundInterest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.compound_icon_unchecked, 0, 0, 0);



                } catch (NullPointerException ignored){}


            }
        });

        btnCompoundInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    btnCompoundInterest.setBackgroundColor(Color.parseColor("#1da1f3"));
                    btnCompoundInterest.setTextColor(Color.parseColor("#ffffff"));
                    btnCompoundInterest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.compound_icon, 0, 0, 0);


                    btnSimpleInterest.setBackgroundColor(Color.parseColor("#15202b"));
                    btnSimpleInterest.setTextColor(Color.parseColor("#8899a6"));
                    btnSimpleInterest.setCompoundDrawablesWithIntrinsicBounds(R.drawable.simple_icon_unchecked, 0, 0, 0);

                }catch (NullPointerException ignored){}

            }
        });





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