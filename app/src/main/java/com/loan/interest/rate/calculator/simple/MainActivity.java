package com.loan.interest.rate.calculator.simple;
//Jai Swami narayan
//Started on 27/12/22
//Flaticon is used for all icons.
//Beta version published on 08/03/23 on the special occasion of Holi in presence of Jija Ji and Didi in Prayagraj.
//Ads were introduced from 20-04-23
// In App purchase billing library version 5 added successfully from 18-04-23 to 23-04-23(was messed up badly).
// GitHud link is :- https://github.com/wicaodian/Google-In-App-Billing-Library-V5-Example.git

import static com.loan.interest.rate.calculator.simple.CalculatorFragment.btnSimpleCompoundStatus;
import static com.loan.interest.rate.calculator.simple.CalculatorFragment.numberFormatterWithSymbol;
import static com.loan.interest.rate.calculator.simple.CalculatorFragment.spinnerCompoundingFrequency;
import static com.loan.interest.rate.calculator.simple.CalculatorFragment.spinnerInterestRateTypeYMWDHQBI;
import static com.loan.interest.rate.calculator.simple.RecordFragment.isRecordVisible;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchasesParams;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.hbb20.CountryCodePicker;
import com.robinhood.ticker.TickerView;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,NavigationView.OnNavigationItemSelectedListener {


    ///////////////////////////////////////////////////////
    //                                                   //
    private final String PRODUCT_PREMIUM = "remove_ads_easy";
    //India & Rest - 129 ₹  and USA - 4.49 $ (23-04-23)  //
    ///////////////////////////////////////////////////////


    Prefs prefs;

    private ArrayList<String> purchaseItemIDs = new ArrayList<String>() {{
        add(PRODUCT_PREMIUM);
    }};

    private String TAG = "iapSample";

    private BillingClient billingClient;

    Snackbar snackbar;

    private InterstitialAd interstitial;
    Boolean adLoaded = false;
    Boolean adLoaded2nd = false;
    LinearLayout dividerNativeAd1,dividerNativeAd2,dividerNativeAd3;
    LinearLayout dividerNativeAd4,dividerNativeAd5,dividerNativeAd6;
    TemplateView template,template2;
    LinearLayout textViewResultTopBar;
    LinearLayout linearLayoutTotalAmount;
    boolean isKeyboardShowing = false;
    AdView mAdView;
    static boolean holderSimpleRecalculatePressed = false;
    static boolean btnSCCalRecStatus;
    ImageView imageViewNotFound;
    static int compoundArrayListSize;
    static int simpleArrayListSize;
    AlertDialog alertDialog;
    MaterialAlertDialogBuilder alertDialoBuider;
    private CountDownTimer countDownTimer;
    static boolean imOnCalculation = true;
    BottomNavigationView mBottomNavigation;
    private ViewPagerAdapter mViewPagerAdapter;
    private ViewPager viewPager;
    Menu menu;
    DrawerLayout drawerLayout;
    private MaterialButton btnSimpleInterest;
    private MaterialButton btnCompoundInterest;
    NavigationView navigationView;
    private TickerView textViewFooterTotalAmount;
    CountryCodePicker ccp;
    TextView textViewCurrencySymbol;
    LinearLayout LinearLayoutAdsContainer;
    RelativeLayout relativeLayoutRootForKeyBoard;
    BottomNavigationView bottomNavigationViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        // it is used after getting feedback of a user on total paisa;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        viewPager = findViewById(R.id.view_pager);
        mBottomNavigation = findViewById(R.id.bottom_navigation);
        drawerLayout = findViewById(R.id.drawer);
        btnSimpleInterest = findViewById(R.id.btn_simple_interest);
        btnCompoundInterest = findViewById(R.id.btn_compound_interest);
        navigationView = findViewById(R.id.navigation_view);
        textViewFooterTotalAmount = findViewById(R.id.text_view_footer_total_amount);
        drawerLayout = findViewById(R.id.drawer);
        imageViewNotFound = findViewById(R.id.image_view_not_found);
        relativeLayoutRootForKeyBoard = findViewById(R.id.rlMain);
        LinearLayoutAdsContainer = findViewById(R.id.linear_layout_ads_container);
        bottomNavigationViewMain = findViewById(R.id.bottom_navigation);
        linearLayoutTotalAmount = findViewById(R.id.controller1);
        textViewResultTopBar = findViewById(R.id.textViewResultTopBar);

        isRecordVisible = false;

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


        prefs = new Prefs(this);

////////////////////////////// All ADs  //////////////////////////////////////////////////////////////////



//----------------------------Banner Ad------------------------------------------------



        if(!prefs.isRemoveAd()){

            MobileAds.initialize(this, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(InitializationStatus initializationStatus) {
                }
            });
        }




        mAdView = findViewById(R.id.adView);


        if(!prefs.isRemoveAd()) {


                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);


        }
        else {

            try {
                LinearLayoutAdsContainer.setVisibility(View.GONE);
            }catch (NullPointerException ignored) {}

        }

//------------------------End Banner Ad ------------------------------------------------


//-----------------------------Native Ad 1 ------------------------------------------

        if(!prefs.isRemoveAd()) {

            ColorDrawable colorDrawable = new ColorDrawable(getColor(R.color.light_blue));
            ColorDrawable buttonBackground =  new ColorDrawable(getColor(R.color.highlight_blue));
            AdLoader adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(NativeAd nativeAd) {

                            NativeTemplateStyle styles = new
                                    NativeTemplateStyle.Builder().
                                    withCallToActionBackgroundColor(buttonBackground).
                                    withSecondaryTextTypefaceColor(getColor(R.color.light_white)).
                                    withPrimaryTextTypefaceColor(getColor(R.color.light_white)).
                                    withMainBackgroundColor(colorDrawable).build();

                            template = findViewById(R.id.nativeAds);
                            dividerNativeAd1 = findViewById(R.id.dividerNativeAd1);
                            dividerNativeAd2 = findViewById(R.id.dividerNativeAd2);
                            dividerNativeAd3 = findViewById(R.id.dividerNativeAd3);
                            template.setStyles(styles);
                            template.setNativeAd(nativeAd);

                            try {

                                template.setVisibility(View.VISIBLE);
                                dividerNativeAd1.setVisibility(View.VISIBLE);
                                dividerNativeAd2.setVisibility(View.VISIBLE);
                                dividerNativeAd3.setVisibility(View.VISIBLE);

                            }catch (NullPointerException ignored){};


                            if (isDestroyed()) {
                                nativeAd.destroy();
                                adLoaded = false;
                                return;
                            }



                            adLoaded = true;


                        }
                    })
                    .withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {

                            try {
                                template.setVisibility(View.GONE);
                                dividerNativeAd1.setVisibility(View.GONE);
                                dividerNativeAd2.setVisibility(View.GONE);
                                dividerNativeAd3.setVisibility(View.GONE);

                            }catch (NullPointerException ignored) {}


                            adLoaded = false;
                        }
                    })
                    .withNativeAdOptions(new NativeAdOptions.Builder()
                            .build())
                    .build();
            adLoader.loadAd(new AdRequest.Builder().build());


        }


//----------------------------End Native Ad 1st----------------------------------------




//-----------------------------Native Ad 2 ------------------------------------------

        if(!prefs.isRemoveAd()){

            ColorDrawable colorDrawable2 = new ColorDrawable(getColor(R.color.light_blue));
            ColorDrawable buttonBackground2 =  new ColorDrawable(getColor(R.color.highlight_blue));
            AdLoader adLoader2 = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(NativeAd nativeAd2) {

                            NativeTemplateStyle styles2 = new
                                    NativeTemplateStyle.Builder().
                                    withCallToActionBackgroundColor(buttonBackground2).
                                    withSecondaryTextTypefaceColor(getColor(R.color.light_white)).
                                    withPrimaryTextTypefaceColor(getColor(R.color.light_white)).
                                    withMainBackgroundColor(colorDrawable2).build();

                            template2 = findViewById(R.id.nativeAds2);
                            dividerNativeAd4 = findViewById(R.id.dividerNativeAd4);
                            dividerNativeAd5 = findViewById(R.id.dividerNativeAd5);
                            dividerNativeAd6 = findViewById(R.id.dividerNativeAd6);
                            template2.setStyles(styles2);
                            template2.setNativeAd(nativeAd2);

                            try {
                                template2.setVisibility(View.VISIBLE);
                                dividerNativeAd4.setVisibility(View.VISIBLE);
                                dividerNativeAd5.setVisibility(View.VISIBLE);
                                dividerNativeAd6.setVisibility(View.VISIBLE);
                            }catch (NullPointerException ignored){};



                            if (isDestroyed()) {
                                nativeAd2.destroy();
                                adLoaded2nd = false;
                                return;
                            }

                            adLoaded2nd = true;


                        }
                    })
                    .withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {

                            try {
                                template2.setVisibility(View.GONE);
                                dividerNativeAd4.setVisibility(View.GONE);
                                dividerNativeAd5.setVisibility(View.GONE);
                                dividerNativeAd6.setVisibility(View.GONE);

                            }catch (NullPointerException ignored){};



                            adLoaded2nd = false;
                        }
                    })
                    .withNativeAdOptions(new NativeAdOptions.Builder()
                            .build())
                    .build();
            adLoader2.loadAd(new AdRequest.Builder().build());


        }

//----------------------------End Native Ad 2st-----------------------------------------


//----------------------------Interstitial-----------------------------------------

        if(!prefs.isRemoveAd()){
            AdRequest adRequestInterstitial = new AdRequest.Builder().build();
            InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequestInterstitial,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                            interstitial = interstitialAd;

                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                            interstitial = null;

                        }
                    });

        } else {
            interstitial = null;
        }

//        --------------------------End of Interstitial---------------------------------------------

/////////////////////////////////////  End of all ADs /////////////////////////////////////////////////////


///////////////////////////////// Start of Remove ads //////////////////////////////////////////////////////

//        MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq1nPXl3LxA3oP9guxoSTMMa5/m4iBxvdPR8jd2jzYmr3AgysKC8XU1j42vGP3xlYvBAmYpoSTFtCdVu5KBHzyNsxBLlxmCr3ANIF3iIZO0zqN5uhTYGCN7DLOjGCR/gxyXFLOQ99SAlx9lM6/KHOyBJhCJNOp7DRs/zmb01mVXIxEnh6+9AiuSneAiSQs+CYuG7nHdSqsaLavjLi02oAGaDellG7+02T1rZ7poB8izU4Gre08WQ0j6w6gV+9JyT+nFCKh3/xo4sqTCFL1esZ5AAhUUHOjs53OKJoBrj5+2YyWWjKbKqB4dTFC96zrJ/CUA0LZKAc7+ug5xybMQV6JwIDAQAB

        billingClient = BillingClient.newBuilder(this)
                .enablePendingPurchases()
                .setListener(
                        (billingResult, list) -> {

                            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK && list != null) {
                                for (Purchase purchase : list) {

                                    Log.d(TAG, "Response is OK");
                                    handlePurchase(purchase);
                                }
                            } else {

                                Log.d(TAG, "Response NOT OK");
                            }
                        }
                ).build();

        //start the connection after initializing the billing client

        establishConnection();

        if(!prefs.isRemoveAd()){
            restorePurchases();
        }

////////////////////////////////End of Remove Ads////////////////////////////////////////////////////////////


        relativeLayoutRootForKeyBoard.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {

                        Rect r = new Rect();
                        relativeLayoutRootForKeyBoard.getWindowVisibleDisplayFrame(r);
                        int screenHeight = relativeLayoutRootForKeyBoard.getRootView().getHeight();

                        int keypadHeight = screenHeight - r.bottom;

                        if (keypadHeight > screenHeight * 0.15) {
                            // keyboard is opened
                            if (!isKeyboardShowing) {
                                isKeyboardShowing = true;
                                onKeyboardVisibilityChanged(true);
                            }
                        }
                        else {

                            // keyboard is closed
                            if (isKeyboardShowing) {
                                isKeyboardShowing = false;
                                onKeyboardVisibilityChanged(false);
                            }
                        }
                    }
                });

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

                        imOnCalculation = true;

                        mBottomNavigation.getMenu().findItem(R.id.menu_calculator).setChecked(true);

                        if(linearLayoutTotalAmount.getVisibility() == View.GONE){
                            linearLayoutTotalAmount.setVisibility(View.VISIBLE);
                            textViewResultTopBar.setVisibility(View.VISIBLE);

                        }

                        if(btnSCCalRecStatus == true){

                            if(!holderSimpleRecalculatePressed){
                                btnSimpleInterest.performClick();
                            }

                            holderSimpleRecalculatePressed = false;

                        } else {

                            if(!holderSimpleRecalculatePressed){
                                btnCompoundInterest.performClick();
                            }

                            holderSimpleRecalculatePressed = false;

                        }

                        break;

                    case 1:

//                      This is used to show the bottom navigation on when fragment to changed to record on slide(viewPager)-16/04/2023 Nanhe Birthday(Gift airdrop Boat)
                        try {

                            bottomNavigationViewMain.setVisibility(View.VISIBLE);

                        } catch (NullPointerException ignored) {

                        }


                        final Handler handler = new Handler(Looper.getMainLooper());
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                FragmentManager fm = getSupportFragmentManager();
                                CalculatorFragment fragment = (CalculatorFragment)  fm.getFragments().get(0);
                                fragment.removeBadge();


                            }
                        }, 1000);


                        mBottomNavigation.getMenu().findItem(R.id.menu_record).setChecked(true);

                        imOnCalculation = false;

                        if(linearLayoutTotalAmount.getVisibility() == View.VISIBLE){

                            linearLayoutTotalAmount.setVisibility(View.GONE);
                            textViewResultTopBar.setVisibility(View.GONE);


                        }

                        if(btnSimpleCompoundStatus == true){
                            btnSCCalRecStatus = true;
                        } else {
                            btnSCCalRecStatus = false;
                        }

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

        try {
            hideSoftKeyboard(MainActivity.this);
        }catch (NullPointerException ignored){}


        // It is used for pending purchases;
        billingClient.queryPurchasesAsync(
                QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.INAPP).build(),
                (billingResult, list) -> {
                    if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                        for (Purchase purchase : list) {
                            if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED && !purchase.isAcknowledged()) {
                                handlePurchase(purchase);
                            }
                        }
                    }
                }
        );


        // This is used only for a big issue when any view is appearing over the native ad
//                the background of the ad is misbehaving to resoleve this setting the style again from  keyboard down and
//                 fromm onResume also it took 1 day to get this hack.(18/04/2023) Baragaon Room.
        if(adLoaded){

            nativeAdStyle();

        }

        if(adLoaded2nd){
            nativeAdStyle2();
        }
        
        SharedPreferences SC = getSharedPreferences("SimpleCompoundStatus", MODE_PRIVATE);

        CalculatorFragment.btnSimpleCompoundStatus = SC.getBoolean("interestStatus", true);

        if(CalculatorFragment.btnSimpleCompoundStatus){

            btnSimpleInterest.performClick();

        } else {

           btnCompoundInterest.performClick();

        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferencesSC = getSharedPreferences("SimpleCompoundStatus", MODE_PRIVATE);
        SharedPreferences.Editor myEditSC = sharedPreferencesSC.edit();

        myEditSC.clear();

        boolean status = Boolean.parseBoolean(String.valueOf(btnSimpleCompoundStatus));

        myEditSC.putBoolean("interestStatus", status);
        myEditSC.apply();

    }


    @Override
    public void onBackPressed() {

        if (this.drawerLayout.isDrawerOpen(navigationView)) {
            this.drawerLayout.closeDrawer(navigationView);

        } else {


            if(viewPager.getCurrentItem() == 1){

                viewPager.setCurrentItem(0);

            } else {

                MaterialAlertDialogBuilder alertDialoBuider = new MaterialAlertDialogBuilder(MainActivity.this,R.style.alertDialog);
                alertDialoBuider.setTitle("Confirm Exit !");
                alertDialoBuider.setIcon(R.drawable.alert_24);
                alertDialoBuider.setMessage("Are you sure you want to exit ?");

                alertDialoBuider.setPositiveButton("Exit !", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (interstitial != null) {
                            interstitial.show(MainActivity.this);

                            interstitial.setFullScreenContentCallback(new FullScreenContentCallback(){
                                @Override
                                public void onAdClicked() {
                                    // Called when a click is recorded for an ad.
//                                    Log.d(TAG, "Ad was clicked.");
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    // Called when ad is dismissed.
                                    interstitial = null;
                                    MainActivity.super.onBackPressed();
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(AdError adError) {
                                    // Called when ad fails to show.
                                    interstitial = null;
                                    MainActivity.super.onBackPressed();
                                }

                                @Override
                                public void onAdImpression() {
                                    // Called when an impression is recorded for an ad.
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                    // Called when ad is shown.

                                }
                            });


                        } else {

                            MainActivity.super.onBackPressed();
                     
                        }

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

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_calculator:

                viewPager.setCurrentItem(0);

                imOnCalculation = true;

                if(linearLayoutTotalAmount.getVisibility() == View.GONE){

                    linearLayoutTotalAmount.setVisibility(View.VISIBLE);
                    textViewResultTopBar.setVisibility(View.VISIBLE);

                }

                if(btnSCCalRecStatus == true){

                    if(!holderSimpleRecalculatePressed){
                        btnSimpleInterest.performClick();
                    }


                    holderSimpleRecalculatePressed = false;



                } else {

                    if(!holderSimpleRecalculatePressed){
                        btnCompoundInterest.performClick();
                    }

                    holderSimpleRecalculatePressed = false;

                }

                break;

            case R.id.menu_record:

                viewPager.setCurrentItem(1);

                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        FragmentManager fm = getSupportFragmentManager();
                        CalculatorFragment fragment = (CalculatorFragment)  fm.getFragments().get(0);
                        fragment.removeBadge();


                    }
                }, 1000);


                imOnCalculation = false;

                if(linearLayoutTotalAmount.getVisibility() == View.VISIBLE){

                    linearLayoutTotalAmount.setVisibility(View.GONE);
                    textViewResultTopBar.setVisibility(View.VISIBLE);

                }

                if(btnSimpleCompoundStatus == true){
                    btnSCCalRecStatus = true;
                } else {
                    btnSCCalRecStatus = false;
                }

                break;


            case R.id.share_app:


                StringBuilder forShareLink = new StringBuilder();
                forShareLink.append("Hey, I am using this  Easy Loan Interest Calculator app, the most flexible application available on the play store.");
                forShareLink.append('\n');
                forShareLink.append("https://play.google.com/store/apps/details?id=com.loan.interest.rate.calculator.simple");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, (Serializable) forShareLink);
                intent.setType("text/plain");
                startActivity(intent);



                break;

            case R.id.rate_us:



                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.loan.interest.rate.calculator.simple");
                 intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);



                break;

            case R.id.feedback:

                Intent feedbackEmail = new Intent(Intent.ACTION_SEND);
                feedbackEmail.setType("message/rfc822");
                feedbackEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"vibhanshu.keshari@gmail.com"});
                feedbackEmail.putExtra(Intent.EXTRA_SUBJECT, "Feedback on Interest Calculator");
                feedbackEmail.setPackage("com.google.android.gm");
                if (feedbackEmail.resolveActivity(getPackageManager()) != null) {
                    startActivity(feedbackEmail);
                } else {


                    Toast toast1 = new Toast(getApplicationContext());
                    toast1.setDuration(Toast.LENGTH_SHORT);
                    LayoutInflater inflater = (LayoutInflater) getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View view = inflater.inflate(R.layout.my_toast_gmail, null);
                    toast1.setView(view);
                    toast1.show();

                }

                break;


            case R.id.privacy:

                uri = Uri.parse("https://www.freeprivacypolicy.com/live/455a01ee-1d75-4b9e-9087-215e6abc2ba7");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                break;

            case R.id.term_and_condition:


                uri = Uri.parse("https://www.freeprivacypolicy.com/live/6dac0b1a-9f4a-47e8-a5da-f33cc268ec68");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

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

                        spinnerInterestRateTypeYMWDHQBI.setSelection(0);
                        spinnerCompoundingFrequency.setSelection(0);

                            principalAmount.setText("");

                            interestRate.setText("");

                            years.setText("");

                            month.setText("");

                            day.setText("");


                        if(principalAmount.isFocused()){
                            principalAmount.clearFocus();

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

                    if(simpleArrayListSize > 0){

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

                                        deleteDatabase("recorddbsimple");
                                        viewPager.setCurrentItem(0);

                                        if(!imOnCalculation){
                                            FragmentManager fm = getSupportFragmentManager();

                                            RecordFragment fragment = (RecordFragment) (RecordFragment) fm.getFragments().get(1);
                                            fragment.mySimple();

                                        }

                                        Toast toast1 = new Toast(getApplicationContext());
                                        toast1.setDuration(Toast.LENGTH_SHORT);
                                        LayoutInflater inflater = (LayoutInflater) getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                        View view = inflater.inflate(R.layout.my_toast_simple_record, null);
                                        toast1.setView(view);
                                        toast1.show();

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

                        Toast toast1 = new Toast(getApplicationContext());
                        toast1.setDuration(Toast.LENGTH_SHORT);
                        LayoutInflater inflater = (LayoutInflater) getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                       View view = inflater.inflate(R.layout.my_toast_already_empty, null);
                        toast1.setView(view);
                        toast1.show();

                    }

                } else {

                    if(compoundArrayListSize >0 ){

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

                                        deleteDatabase("recorddbcompound");
                                        viewPager.setCurrentItem(0);

                                        if(!imOnCalculation){
                                            FragmentManager fm = getSupportFragmentManager();

                                            RecordFragment fragment = (RecordFragment) (RecordFragment) fm.getFragments().get(1);
                                            fragment.mySimple();

                                        }

                                        Toast toast1 = new Toast(getApplicationContext());
                                        toast1.setDuration(Toast.LENGTH_SHORT);
                                        LayoutInflater inflater = (LayoutInflater) getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                        View view = inflater.inflate(R.layout.my_toast_compound_record, null);
                                        toast1.setView(view);
                                        toast1.show();

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

                        Toast toast1 = new Toast(getApplicationContext());
                        toast1.setDuration(Toast.LENGTH_SHORT);
                        LayoutInflater inflater = (LayoutInflater) getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View view = inflater.inflate(R.layout.my_toast_already_empty, null);
                        toast1.setView(view);
                        toast1.show();

                    }

                }

               break;


            case R.id.Share:






                    FragmentManager fm = getSupportFragmentManager();

                CalculatorFragment fragment = (CalculatorFragment) fm.getFragments().get(0);

                Calendar calendar = Calendar.getInstance();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                String typeS = "Simple";
                String typeC = "Compound";
                String  date = dateFormat.format(calendar.getTime());
                String myPrincipalNoFormat = fragment.getEdittextPrincipal();
                String myInterest = fragment.getEditTextInterest();
                String myInterestFrequency = fragment.getInterestFrequency();
                String myYear = fragment.getYear();
                String myMonth = fragment.getMonth();
                String myDay = fragment.getDay();
                String myCompoundingFrequency = fragment.myFrequencyCompound();
                String interestAmountNoFormat = fragment.myTtlSimpleInterestAmount();
                String totalAmountNoFormat = fragment.myTtlAmountSimple();

                String interestAmountCompoundNoFormat = fragment.myTtlCompoundInterestAmount();
                String totalAmountCompoundNoFormat = fragment.myTtlAmountCompound();

                if(btnSimpleCompoundStatus){

                    if ((!myPrincipalNoFormat.equals("") && !myInterest.equals("")) &&
                            ((!myYear.equals("") || !myMonth.equals("") ||
                                    !myDay.equals("")))) {


                        StringBuilder forShare = new StringBuilder();

                        numberFormatterWithSymbol.setNumber(Double.parseDouble(myPrincipalNoFormat));
                        String myPrincipal = String.valueOf(numberFormatterWithSymbol.getNumberAfterFormat());


                        numberFormatterWithSymbol.setNumber(Double.parseDouble(interestAmountNoFormat));
                        String interestAmount = String.valueOf(numberFormatterWithSymbol.getNumberAfterFormat());


                        numberFormatterWithSymbol.setNumber(Double.parseDouble(totalAmountNoFormat));
                        String totalAmount = String.valueOf(numberFormatterWithSymbol.getNumberAfterFormat());


                        // keep screen on feature have to use ;remember
                        forShare.append("Interest Type : ").append(typeS);
                        forShare.append('\n');
                        forShare.append("Date : ").append(date);
                        forShare.append('\n');
                        forShare.append('\n');

                        forShare.append("Principal Amount : " );
                        forShare.append(myPrincipal);
                        forShare.append('\n');
                        forShare.append("Interest Rate : ");
                        forShare.append(myInterest).append(" / ").append(myInterestFrequency);
                        forShare.append('\n');

                        forShare.append("Duration : ");

                        if(myYear.equals("")){
                            forShare.append("0Y | ");
                        } else {
                            forShare.append(myYear).append("Y | ");
                        }

                        if(myMonth.equals("")){
                            forShare.append("0M | ");
                        } else {
                            forShare.append(myMonth).append("M | ");
                        }

                        if(myDay.equals("")){
                            forShare.append(" 0D");
                        } else {
                            forShare.append(myDay).append("D");
                        }

                        forShare.append('\n');
                        forShare.append("Interest Amount : ").append(interestAmount);
                        forShare.append('\n');
                        forShare.append("Total Amount : ").append(totalAmount);
                        forShare.append('\n');
                        forShare.append('\n');
                        forShare.append("https://play.google.com/store/apps/details?id=com.loan.interest.rate.calculator.simple");
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, (Serializable) forShare);
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);

                    } else {

                        Toast toast1 = new Toast(getApplicationContext());
                        toast1.setDuration(Toast.LENGTH_SHORT);
                        LayoutInflater inflater = (LayoutInflater) getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View view = inflater.inflate(R.layout.my_toast_cant_share, null);
                        toast1.setView(view);
                        toast1.show();

                    }

                } else {

                    if ((!myPrincipalNoFormat.equals("") && !myInterest.equals("")) &&
                            ((!myYear.equals("") || !myMonth.equals("") ||
                                    !myDay.equals("")))) {

                        StringBuilder forShare = new StringBuilder();

                        numberFormatterWithSymbol.setNumber(Double.parseDouble(myPrincipalNoFormat));
                        String myPrincipal = String.valueOf(numberFormatterWithSymbol.getNumberAfterFormat());

                        numberFormatterWithSymbol.setNumber(Double.parseDouble(interestAmountCompoundNoFormat));
                        String interestAmount = String.valueOf(numberFormatterWithSymbol.getNumberAfterFormat());


                        numberFormatterWithSymbol.setNumber(Double.parseDouble(totalAmountCompoundNoFormat));
                        String totalAmount = String.valueOf(numberFormatterWithSymbol.getNumberAfterFormat());


                        forShare.append("Interest Type : ").append(typeC);
                        forShare.append('\n');
                        forShare.append("Date : ").append(date);
                        forShare.append('\n');
                        forShare.append('\n');

                        forShare.append("Principal Amount : " );
                        forShare.append(myPrincipal);
                        forShare.append('\n');
                        forShare.append("Interest Rate : ");
                        forShare.append(myInterest).append(" / ").append(myInterestFrequency);
                        forShare.append('\n');


                        forShare.append("Duration : ");

                        if(myYear.equals("")){
                            forShare.append("0Y | ");
                        } else {
                            forShare.append(myYear).append("Y | ");
                        }

                        if(myMonth.equals("")){
                            forShare.append("0M | ");
                        } else {
                            forShare.append(myMonth).append("M | ");
                        }

                        if(myDay.equals("")){
                            forShare.append("0D");
                        } else {
                            forShare.append(myDay).append("D");
                        }


                        forShare.append('\n');
                        forShare.append("Compounding Freq. : ").append(myCompoundingFrequency);
                        forShare.append('\n');
                        forShare.append("Interest Amount : ").append(interestAmount);
                        forShare.append('\n');
                        forShare.append("Total Amount : ").append(totalAmount);
                        forShare.append('\n');
                        forShare.append('\n');
                        forShare.append("https://play.google.com/store/apps/details?id=com.loan.interest.rate.calculator.simple");
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, (Serializable) forShare);
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);

                    } else {

                        Toast toast1 = new Toast(getApplicationContext());
                        toast1.setDuration(Toast.LENGTH_SHORT);
                        LayoutInflater inflater = (LayoutInflater) getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View view = inflater.inflate(R.layout.my_toast_cant_share, null);
                        toast1.setView(view);
                        toast1.show();

                    }

                }

                break;

            case R.id.Remove_ad:

                GetSingleInAppDetail();
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


    public void switchBottomNavigation(){
        viewPager.setCurrentItem(0);
    }

        void onKeyboardVisibilityChanged(boolean opened) {

            if(opened){


                if(LinearLayoutAdsContainer.getVisibility() == View.VISIBLE){
                    LinearLayoutAdsContainer.setVisibility(View.GONE);
                }

                if(bottomNavigationViewMain.getVisibility() == View.VISIBLE){

                    bottomNavigationViewMain.setVisibility(View.GONE);

                }


            } else {


                if(!prefs.isRemoveAd()){
                    if(LinearLayoutAdsContainer.getVisibility() == View.GONE){
                        LinearLayoutAdsContainer.setVisibility(View.VISIBLE);
                    }


                }


                if(bottomNavigationViewMain.getVisibility() == View.GONE){
                    bottomNavigationViewMain.setVisibility(View.VISIBLE);

                }

                    // This is used only for a big issue when any view is appearing over the native ad
//                the background of the ad is misbehaving to resoleve this setting the style again from  keyboard down and
//                 fromm onResume also it took 1 day to get this hack.(18/04/2023) Baragaon Room.
                if(adLoaded){
                    nativeAdStyle();

                }

                if(adLoaded2nd){
                    nativeAdStyle2();

                }

            }

        }

        public void nativeAdStyle(){


            ColorDrawable buttonBackground =  new ColorDrawable(getColor(R.color.highlight_blue));
            ColorDrawable colorDrawable = new ColorDrawable(getColor(R.color.light_blue));

            NativeTemplateStyle styles = new
                    NativeTemplateStyle.Builder().
                    withCallToActionBackgroundColor(buttonBackground).
                    withSecondaryTextTypefaceColor(getColor(R.color.light_white)).
                    withPrimaryTextTypefaceColor(getColor(R.color.light_white)).
                    withMainBackgroundColor(colorDrawable).build();

            if(adLoaded){
                template.setStyles(styles);

            }

        }


        public void nativeAdStyle2(){
            ColorDrawable buttonBackground2 =  new ColorDrawable(getColor(R.color.highlight_blue));
            ColorDrawable colorDrawable2 = new ColorDrawable(getColor(R.color.light_blue));

            NativeTemplateStyle styles2 = new
                    NativeTemplateStyle.Builder().
                    withCallToActionBackgroundColor(buttonBackground2).
                    withSecondaryTextTypefaceColor(getColor(R.color.light_white)).
                    withPrimaryTextTypefaceColor(getColor(R.color.light_white)).
                    withMainBackgroundColor(colorDrawable2).build();

            if(adLoaded2nd){
                template2.setStyles(styles2);
            }



        }



    void establishConnection() {
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(@NonNull BillingResult billingResult) {
                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {

                    // The BillingClient is ready. You can query purchases here.
                    //Use any of function below to get details upon successful connection

                     // GetSingleInAppDetail();
                    //GetListsInAppDetail();

                    Log.d(TAG, "Connection Established");
                }
            }

            @Override
            public void onBillingServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
                Log.d(TAG, "Connection NOT Established");
                establishConnection();
            }
        });
    }



    void GetSingleInAppDetail() {
        ArrayList<QueryProductDetailsParams.Product> productList = new ArrayList<>();

        productList.add(
                QueryProductDetailsParams.Product.newBuilder()
                        .setProductId(PRODUCT_PREMIUM)
                        .setProductType(BillingClient.ProductType.INAPP)
                        .build()
        );

        QueryProductDetailsParams params = QueryProductDetailsParams.newBuilder()
                .setProductList(productList)
                .build();

        billingClient.queryProductDetailsAsync(params, new ProductDetailsResponseListener() {
            @Override
            public void onProductDetailsResponse(@NonNull BillingResult billingResult, @NonNull List<ProductDetails> list) {

                //Do Anything that you want with requested product details

                //Calling this function here so that once products are verified we can start the purchase behavior.
                //You can save this detail in separate variable or list to call them from any other location
                //Create another function if you want to call this in establish connections' success state
                LaunchPurchaseFlow(list.get(0));


            }
        });
    }

    void GetListsInAppDetail() {
        ArrayList<QueryProductDetailsParams.Product> productList = new ArrayList<>();

        for (String ids : purchaseItemIDs) {
            productList.add(
                    QueryProductDetailsParams.Product.newBuilder()
                            .setProductId(ids)
                            .setProductType(BillingClient.ProductType.INAPP)
                            .build());
        }

        QueryProductDetailsParams params = QueryProductDetailsParams.newBuilder()
                .setProductList(productList)
                .build();

        billingClient.queryProductDetailsAsync(params, new ProductDetailsResponseListener() {
            @Override
            public void onProductDetailsResponse(@NonNull BillingResult billingResult, @NonNull List<ProductDetails> list) {

                for (ProductDetails li : list) {
                    Log.d(TAG, "IN APP item Price" + li.getOneTimePurchaseOfferDetails().getFormattedPrice());
                }
                //Do Anything that you want with requested product details
            }
        });
    }





    void LaunchPurchaseFlow(ProductDetails productDetails) {
        ArrayList<BillingFlowParams.ProductDetailsParams> productList = new ArrayList<>();

        productList.add(
                BillingFlowParams.ProductDetailsParams.newBuilder()
                        .setProductDetails(productDetails)
                        .build());

        BillingFlowParams billingFlowParams = BillingFlowParams.newBuilder()
                .setProductDetailsParamsList(productList)
                .build();

        billingClient.launchBillingFlow(this, billingFlowParams);
    }




    void handlePurchase(Purchase purchases) {
        if (!purchases.isAcknowledged()) {
            billingClient.acknowledgePurchase(AcknowledgePurchaseParams
                    .newBuilder()
                    .setPurchaseToken(purchases.getPurchaseToken())
                    .build(), billingResult -> {

                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {

                    for (String pur : purchases.getProducts()) {
                        if (pur.equalsIgnoreCase(PRODUCT_PREMIUM)) {

                            Log.d("TAG", "vibhu p success");
                            prefs.setIsRemoveAd(true);

                            final Handler handler = new Handler(Looper.getMainLooper());
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                     snackbar = Snackbar.make(findViewById(R.id.bottom_navigation), "Congratulations!, Enjoy the Ads free Experience.",
                                            Snackbar.LENGTH_INDEFINITE);
                                    snackbar.setAction("Restart!", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            triggerRebirth(getApplicationContext());

                                        }
                                    });

                                    snackbar.setActionTextColor(Color.parseColor("#3bd16f"));
                                    snackbar.setTextColor(Color.parseColor("#ffffff"));
                                    snackbar.setBackgroundTint(Color.parseColor("#10171f"));
                                    snackbar.show();


                                }
                            }, 2000);

                        }
                    }
                }
            });
        }
    }



    void restorePurchases() {

        billingClient = BillingClient.newBuilder(this).enablePendingPurchases().setListener((billingResult, list) -> {
        }).build();
        final BillingClient finalBillingClient = billingClient;
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingServiceDisconnected() {
            }

            @Override
            public void onBillingSetupFinished(@NonNull BillingResult billingResult) {

                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    finalBillingClient.queryPurchasesAsync(
                            QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.INAPP).build(), (billingResult1, list) -> {
                                if (billingResult1.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                                    if (list.size() > 0) {

                                        Log.d("TAG", "IN APP SUCCESS RESTORE: " + list);
                                        for (int i = 0; i < list.size(); i++) {

                                            if (list.get(i).getProducts().contains(PRODUCT_PREMIUM)) {

                                                prefs.setIsRemoveAd(true);
                                                Log.d("TAG", "Product id " + PRODUCT_PREMIUM + " will restore here");



                                                final Handler handler = new Handler(Looper.getMainLooper());
                                                handler.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {

                                                         snackbar = Snackbar.make(findViewById(R.id.bottom_navigation), "Welcome Back!, Enjoy the Ads Free Experience Again.",
                                                                Snackbar.LENGTH_INDEFINITE);
                                                        snackbar.setAction("Restart!", new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View view) {

                                                                triggerRebirth(getApplicationContext());

                                                            }
                                                        });

                                                        snackbar.setActionTextColor(Color.parseColor("#3bd16f"));
                                                        snackbar.setTextColor(Color.parseColor("#ffffff"));
                                                        snackbar.setBackgroundTint(Color.parseColor("#10171f"));
                                                        snackbar.show();

                                                    }
                                                }, 5000);

                                            }

                                        }
                                    } else {

                                        prefs.setIsRemoveAd(false);

                                        Log.d("TAG", "In APP Not Found To Restore");
                                    }
                                }
                            });
                }
            }
        });
    }

    public static void triggerRebirth(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());
        ComponentName componentName = intent.getComponent();
        Intent mainIntent = Intent.makeRestartActivityTask(componentName);
        context.startActivity(mainIntent);
        Runtime.getRuntime().exit(0);
    }

}




