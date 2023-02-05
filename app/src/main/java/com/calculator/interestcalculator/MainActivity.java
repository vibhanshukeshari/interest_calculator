package com.calculator.interestcalculator;
//Jai Swami narayan
//Started on 27/12/22

import static com.calculator.interestcalculator.CalculatorFragment.btnSimpleCompoundStatus;
import static com.calculator.interestcalculator.CalculatorFragment.spinnerCompoundingFrequency;
import static com.calculator.interestcalculator.CalculatorFragment.spinnerInterestRateTypeYMWDHQBI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.hbb20.CountryCodePicker;
import com.robinhood.ticker.TickerView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{



    AlertDialog alertDialog;
    MaterialAlertDialogBuilder alertDialoBuider;
    private CountDownTimer countDownTimer;
    static boolean imOnCalculation = true;
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

//                        Toast.makeText(MainActivity.this, "true hai yar", Toast.LENGTH_SHORT).show();

                        imOnCalculation = true;

                        mBottomNavigation.getMenu().findItem(R.id.menu_calculator).setChecked(true);

                        break;



                    case 1:

                        mBottomNavigation.getMenu().findItem(R.id.menu_record).setChecked(true);

                        imOnCalculation = false;
//
//                        dbHandler.addNewRecords("50","100","1000","500","500","500","500","500","500","500","500","500");
//                        dbHandler.close();

//                        RecyclerView rvRecords = findViewById(R.id.RVRecords);
//                        if (rvRecords.getVisibility() != View.VISIBLE) {
//                            rvRecords.setVisibility(View.VISIBLE);
//                        }


                 break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();

//        if(btnSimpleInterest.isChecked()){
//            btnSimpleCompoundStatus = true;
//
//        } else{
//            btnSimpleCompoundStatus = false;
//
//        }




        SharedPreferences SC = getSharedPreferences("SimpleCompoundStatus", MODE_PRIVATE);

        CalculatorFragment.btnSimpleCompoundStatus = SC.getBoolean("interestStatus", true);

//        Toast.makeText(this, String.valueOf(CalculatorFragment.btnSimpleCompoundStatus), Toast.LENGTH_SHORT).show();

        if(CalculatorFragment.btnSimpleCompoundStatus){

//            CalculatorFragment.btnSimpleCompoundStatus = true;

            btnSimpleInterest.performClick();


        } else {

//            CalculatorFragment.btnSimpleCompoundStatus = false;

            btnCompoundInterest.performClick();

        }
    }

    @Override
    protected void onPause() {
        super.onPause();


        SharedPreferences sharedPreferencesSC = getSharedPreferences("SimpleCompoundStatus", MODE_PRIVATE);
        SharedPreferences.Editor myEditSC = sharedPreferencesSC.edit();

        myEditSC.clear();
        myEditSC.putBoolean("interestStatus", Boolean.parseBoolean(String.valueOf(CalculatorFragment.btnSimpleCompoundStatus)));
        myEditSC.apply();

//        Toast.makeText(this, String.valueOf(CalculatorFragment.btnSimpleCompoundStatus), Toast.LENGTH_SHORT).show();
//        CalculatorFragment.btnSimpleCompoundStatus = true;


//        if(btnSimpleInterest.isChecked()){
//            btnSimpleCompoundStatus = true;
//
//        } else{
//            btnSimpleCompoundStatus = false;
//
//        }





    }

    @Override
    public void onBackPressed() {

        if (this.drawerLayout.isDrawerOpen(navigationView)) {
            this.drawerLayout.closeDrawer(navigationView);

        } else {

            MaterialAlertDialogBuilder alertDialoBuider = new MaterialAlertDialogBuilder(MainActivity.this,R.style.alertDialog);
            alertDialoBuider.setTitle("Confirm Exit !");
            alertDialoBuider.setIcon(R.drawable.alert_24);
            alertDialoBuider.setMessage("Are you sure you want to exit ?");

            alertDialoBuider.setPositiveButton("Exit !", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    MainActivity.super.onBackPressed();
                }

            });

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

    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_calculator:
                viewPager.setCurrentItem(0);


//                Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();

                imOnCalculation = true;


                break;
            case R.id.menu_record:
                viewPager.setCurrentItem(1);


                imOnCalculation = false;



                break;

        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.Reset:

                EditText principalAmount = findViewById(R.id.edit_text_principal_amount);
                EditText interestRate = findViewById(R.id.edit_text_interest_rate);
                EditText years = findViewById(R.id.edit_text_year);
                EditText month = findViewById(R.id.edit_text_month);
                EditText day = findViewById(R.id.edit_text_day);


                try {
                    hideSoftKeyboard(MainActivity.this);
                } catch (NullPointerException ignored) {
                }


                 alertDialoBuider = new MaterialAlertDialogBuilder(MainActivity.this, R.style.alertDialog);
                alertDialoBuider.setTitle("Confirm Reset !");
                alertDialoBuider.setIcon(R.drawable.alert_24);
                alertDialoBuider.setMessage("Are you sure you want to reset ?");

                alertDialoBuider.setPositiveButton("Reset !", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {





//To be done later

//                        spinnerInterestRateTypeYMWDHQBI.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                spinnerInterestRateTypeYMWDHQBI.setSelection(0);
//                                spinnerInterestRateTypeYMWDHQBI.performClick();
//                            }
//                        });
//
//                        spinnerCompoundingFrequency.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                spinnerCompoundingFrequency.setSelection(0);
//                                spinnerCompoundingFrequency.
//                            }
//                        });

//                        spinnerInterestRateTypeYMWDHQBI.setSelection(0);
//                        spinnerCompoundingFrequency.setSelection(0);

                        if(!principalAmount.getText().toString().equals("")){

                            principalAmount.setText("");
                        }


                        if(!interestRate.getText().toString().equals("")){
                            interestRate.setText("");
                        }

                        if(!years.getText().toString().equals("")) {
                            years.setText("");
                        }

                        if(!month.getText().toString().equals("")) {
                            month.setText("");
                        }

                        if(!day.getText().toString().equals("")) {
                            day.setText("");
                        }





                        if(principalAmount.isFocused()){
                            principalAmount.clearFocus();
//
                        }
                        if(interestRate.isFocused()){
                            interestRate.clearFocus();

                        }

                        if(years.isFocused()){
                            years.clearFocus();

                        }
                        if(month.isFocused()){
                            month.clearFocus();

                        }
                        if(day.isFocused()){
                            day.clearFocus();

                        }


                        NestedScrollView calculationScrollView = findViewById(R.id.calculation_scroll_view);




                        calculationScrollView.post(new Runnable() {
                            public void run() {

                                calculationScrollView.fullScroll(View.FOCUS_UP);

                            }
                        });

                    }

                });

                alertDialoBuider.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });

                 alertDialog = alertDialoBuider.create();
                alertDialog.show();
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.highlight_blue));
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.light_white));











                break;


            case R.id.deleteAll:





                if(btnSimpleCompoundStatus){








                 alertDialoBuider = new MaterialAlertDialogBuilder(MainActivity.this, R.style.alertDialog);
                alertDialoBuider.setTitle("Confirm Erase !");
                alertDialoBuider.setIcon(R.drawable.erase_all_icon);
                alertDialoBuider.setMessage("Are you sure you want to erase all the simple interest records ?");


                alertDialoBuider.setPositiveButton("Erase All !", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {















                       Snackbar snackbar = Snackbar.make(navigationView, "", 6000);

                        snackbar.setAction("Cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                countDownTimer.cancel();

                            }
                        });

                        snackbar.setActionTextColor(Color.parseColor("#3bd16f"));
                        snackbar.setTextColor(Color.parseColor("#ffffff"));
                        snackbar.setBackgroundTint(Color.parseColor("#10171f"));

                        countDownTimer = new CountDownTimer(6000, 1000) {
                            public void onTick(long millisUntilFinished) {

                                if ((millisUntilFinished / 1000 == 1) || (millisUntilFinished / 1000 == 0)) {
                                    snackbar.setText("Erasing all data in  " + millisUntilFinished / 1000 + "  Second.");
                                    snackbar.setTextColor(Color.parseColor("#ff0000"));
                                } else {
                                    snackbar.setText("Erasing all data in  " + millisUntilFinished / 1000 + "  Seconds.");
                                }

                            }

                            @Override
                            public void onFinish() {

//                                save_button_was_pressed = true;

                                deleteDatabase("recorddbsimple");
//                                RecyclerView rvCurrency = findViewById(R.id.RVRecords);
//                                rvCurrency.setVisibility(View.GONE);

                                if(!imOnCalculation){
                                    FragmentManager fm = getSupportFragmentManager();

                                    RecordFragment fragment = (RecordFragment) (RecordFragment) fm.getFragments().get(1);
                                    fragment.mySimple();

                                }

                                Toast toast = Toast.makeText(MainActivity.this, "Simple interest records has been deleted.", Toast.LENGTH_SHORT);
                                View view1 = toast.getView();

                                try {

                                    TextView textView = toast.getView().findViewById(android.R.id.message);
                                    textView.setTextColor(Color.parseColor("#ffffff"));

                                } catch (NullPointerException ignored) {
                                }

                                try {
                                    assert view1 != null;
                                    view1.getBackground().setColorFilter(Color.parseColor("#10171f"), PorterDuff.Mode.SRC_IN);
                                } catch (NullPointerException ignored) {
                                }
                                toast.show();


                            }
                        }.start();

                        snackbar.show();





























                    }

                });

                alertDialoBuider.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });

                 alertDialog = alertDialoBuider.create();
                alertDialog.show();
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#A52121"));
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#8899a6"));


                } else {








                    alertDialoBuider = new MaterialAlertDialogBuilder(MainActivity.this, R.style.alertDialog);
                    alertDialoBuider.setTitle("Confirm Erase !");
                    alertDialoBuider.setIcon(R.drawable.erase_all_icon);
                    alertDialoBuider.setMessage("Are you sure you want to erase all the compound interest records ?");


                    alertDialoBuider.setPositiveButton("Erase All !", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {















                            Snackbar snackbar = Snackbar.make(navigationView, "", 6000);

                            snackbar.setAction("Cancel", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    countDownTimer.cancel();

                                }
                            });

                            snackbar.setActionTextColor(Color.parseColor("#3bd16f"));
                            snackbar.setTextColor(Color.parseColor("#ffffff"));
                            snackbar.setBackgroundTint(Color.parseColor("#10171f"));

                            countDownTimer = new CountDownTimer(6000, 1000) {
                                public void onTick(long millisUntilFinished) {

                                    if ((millisUntilFinished / 1000 == 1) || (millisUntilFinished / 1000 == 0)) {
                                        snackbar.setText("Erasing all data in  " + millisUntilFinished / 1000 + "  Second.");
                                        snackbar.setTextColor(Color.parseColor("#ff0000"));
                                    } else {
                                        snackbar.setText("Erasing all data in  " + millisUntilFinished / 1000 + "  Seconds.");
                                    }

                                }

                                @Override
                                public void onFinish() {

//                                save_button_was_pressed = true;

                                    deleteDatabase("recorddbcompound");
//                                RecyclerView rvCurrency = findViewById(R.id.RVRecords);
//                                rvCurrency.setVisibility(View.GONE);

                                    if(!imOnCalculation){
                                        FragmentManager fm = getSupportFragmentManager();

                                        RecordFragment fragment = (RecordFragment) (RecordFragment) fm.getFragments().get(1);
                                        fragment.mySimple();

                                    }

                                    Toast toast = Toast.makeText(MainActivity.this, "Compound interest records has been deleted.", Toast.LENGTH_SHORT);
                                    View view1 = toast.getView();

                                    try {

                                        TextView textView = toast.getView().findViewById(android.R.id.message);
                                        textView.setTextColor(Color.parseColor("#ffffff"));

                                    } catch (NullPointerException ignored) {
                                    }

                                    try {
                                        assert view1 != null;
                                        view1.getBackground().setColorFilter(Color.parseColor("#10171f"), PorterDuff.Mode.SRC_IN);
                                    } catch (NullPointerException ignored) {
                                    }
                                    toast.show();


                                }
                            }.start();

                            snackbar.show();





























                        }

                    });

                    alertDialoBuider.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();

                        }
                    });

                    alertDialog = alertDialoBuider.create();
                    alertDialog.show();
                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#A52121"));
                    alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#8899a6"));

















                }














               break;
        }









        return super.onOptionsItemSelected(item);
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}