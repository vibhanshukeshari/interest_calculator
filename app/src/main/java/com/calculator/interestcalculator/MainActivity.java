package com.calculator.interestcalculator;
//Jai Swami narayan
//Started on 27/12/22


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.view.MenuItem;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView mBottomNavigation;
    private ViewPagerAdapter mViewPagerAdapter;
    private ViewPager viewPager;
    private LinearLayout bottomLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.light_blue)));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#15202b")));

        viewPager = findViewById(R.id.view_pager);
        mBottomNavigation = findViewById(R.id.bottom_navigation);
        bottomLinearLayout = findViewById(R.id.controller);

//        bottomLinearLayout.setVisibility(View.INVISIBLE);

        mBottomNavigation.setOnNavigationItemSelectedListener(this);

         mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mViewPagerAdapter);
        viewPager.setOffscreenPageLimit(2);




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
}