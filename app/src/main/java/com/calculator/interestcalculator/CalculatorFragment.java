package com.calculator.interestcalculator;
import static android.content.Context.MODE_PRIVATE;
import static com.calculator.interestcalculator.MainActivity.imOnCalculation;
import static com.robinhood.ticker.TickerView.ScrollingDirection.DOWN;
import static com.robinhood.ticker.TickerView.ScrollingDirection.UP;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import org.joda.time.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.util.Pair;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.StackedValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.xmlpull.v1.XmlPullParser;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import  java.time.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class CalculatorFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    //    ImageButton imgBtnMoreThreeDots;
// this declaration is used to call reCalculate method from RecordAdapterSimple;
    private static CalculatorFragment instance = null;

    private ImageView imageViewPieNotFound, imageViewBarNotFound, imageViewTableNotFound;
    DBHandler dbHandler;
    DBHandlerSimple dbHandlerSimple;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    boolean checkScrollShimmerTableVisisble = true;
    boolean checkScrollPieChartVisible = true;
    boolean checkScrollBarGraphVisible = true;

    //    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
//    private String date;

    private String myName;
    private String myTypeSorC;
    private String myDate;
    private String myPrincipalAmount;
    private String myInterestRate;
    private String myInteresRateFrequency;
    private String myYear;
    private String myMonth;
    private String myDay;
    private String myCompoundingFrequency;
    private String myInterestAmount;
    private String myTotalamount;
    private String myTimeAsUniqueId;


    static double myYearForTableAdapter;
    boolean edit = true;
    View view;
    static long myValue;
    boolean flagBarWidthFirstTime = true;
    int cursorPosition;

    boolean counter = true;

    RecyclerView recyclerViewTable;
    TableAdapter tableAdapter;


    String[] rateTypeFrequency = {"Yearly", "Monthly", "Weekly", "Daily", "Half-Yearly", "Quarterly", "Bi-Annually"};
    String[] compoundingFrequency = {"Yearly", "Monthly(12/Y)", "Weekly(52/Y)", "Daily(365/Y)", "Half-Yearly(2/Y)", "Quarterly(4/Y)", "Daily(360/Y)", "Bi-Weekly(26/Y)", "Half-Monthly(24/Y)", "Bi-Monthly(6/Y)", "Bi-Anually(0.5/Y)"};


    //    private DBHandler dbHandler;
    List<TableModel> tableModelList;
    private NestedScrollView calculationScrollView;
    private static String countryName;
    private static String countrySymbol;
    private static String countryCurrency;
    static boolean interestRatePercentageSelected = true;
    static boolean btnSimpleCompoundStatus = true;
    static boolean durationThenDate = true;
    private int interestSpinnerRateType;
    private int compoundInterestSpinnerFrequency;
    private double principalAmount;
    private double principalAmountOldValue = 0;
    private double getInterestAmount;
    private double interestAmounOldValue = 0;
    private double getTotalAmount;
    private double totalAmountOldValue = 0;
    private double getTotalFooterAmount;
    private double totalAmountFooterOldValue = 0;
    private int rateTypePA;
    private int rateTypeFrequencyYMWDHQBI;
    private LinearLayout linearLayoutVisualGraph;

    private double interestRate;
    private double duration;
    private double totalSimpleInterestAmount;
    private double totalCompoundInterestAmount;
    private int year = 0;
    private int month = 0;
    private int day = 0;
    private double fromDate;
    private double toDate;
    private DurationAndDate durationAndDate;
    private LinearLayout linearLayoutTableHeader;
    private Button saveButton;

    SimpleInterest simpleInterest;
    CompoundInterest compoundInterest;
    static NumberFormatterWithSymbol numberFormatterWithSymbol;

    PieChart pieChart;
    BarChart mChart1;

    public static boolean fromClicked = false;
    public static boolean toClicked = false;

    LinearLayout linearLayoutDate, linearLayoutDuration, linearLayoutDurationBottomLine, linearLayoutCompoundingFrequency;
    public static Spinner spinnerInterestRateTypeYMWDHQBI, spinnerCompoundingFrequency, spinnerInterestRateTypePA;
    EditText editTextPrincipalAmount, editTextInterestRate, editTextYear, editTextMonth, editTextDay, fromDateEditText, toDateEditText;
    TextView textViewResultPrincipal, textViewCompoundingFrequency, textViewInterestRateType;
    ArrayAdapter<String> aa, arrayAdapter, arrayAdapterInterestRateType;
    MaterialButton btnCompound, btnSimple;
    LinearLayout linearLayoutInterestRateType;

    FrameLayout calculationFragmentParentFarmeLayout;
    RelativeLayout rlMain;

    TextInputLayout editTextPrincipalAmountLayout;

    ShimmerFrameLayout shimmerFrameLayout;

    TextInputLayout editTextLayoutInterestRate;

    TextInputLayout fromDateEditTextLayout, toDateEditTextLayout;

    TextInputLayout editTextYearLayout, editTextMonthLayout, editTextDayLayout;

    TextView textViewLableBarGraph0;
    TextView textViewLableBarGraph;

    TextView textViewTableNoText;

    RadioButton radioButtonDuration, radioButtonDate;

    TickerView textViewPrincipalAmount, textViewInterestAmount, textViewTotalAmount, textViewFooterTotalAmount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_calculator, container, false);

        // this is very important for calling onPrepareOptionsMenu method below i.e delete all button hide ;
        setHasOptionsMenu(true);

        // this  is used to call reCalculate method from RecordAdapterSimple;
        instance = this;


        spinnerInterestRateTypeYMWDHQBI = view.findViewById(R.id.spinner_interest_rate_period);
        spinnerInterestRateTypeYMWDHQBI.setOnItemSelectedListener(this);

        spinnerCompoundingFrequency = view.findViewById(R.id.spinner_compounding_frequency);
        spinnerCompoundingFrequency.setOnItemSelectedListener(this);

        spinnerInterestRateTypePA = view.findViewById(R.id.spinner_interest_rate_type);
        spinnerInterestRateTypePA.setOnItemSelectedListener(this);

        editTextPrincipalAmount = view.findViewById(R.id.edit_text_principal_amount);
        editTextInterestRate = view.findViewById(R.id.edit_text_interest_rate);
        editTextYear = view.findViewById(R.id.edit_text_year);
        editTextMonth = view.findViewById(R.id.edit_text_month);
        editTextDay = view.findViewById(R.id.edit_text_day);
        fromDateEditText = view.findViewById(R.id.from_date_editText);
        toDateEditText = view.findViewById(R.id.to_date_editText);

        textViewLableBarGraph0 = view.findViewById(R.id.textView_lable_barGraph0);

        radioButtonDuration = view.findViewById(R.id.radio_button_duration);
        radioButtonDate = view.findViewById(R.id.radio_button_date);

        linearLayoutDate = view.findViewById(R.id.linear_layout_date);
        linearLayoutDuration = view.findViewById(R.id.linear_layout_duration);

        linearLayoutDurationBottomLine = view.findViewById(R.id.duration_bottom_line);
        linearLayoutInterestRateType = view.findViewById(R.id.interest_rate_type);

        linearLayoutCompoundingFrequency = view.findViewById(R.id.linear_layout_compounding_frequency);

        linearLayoutVisualGraph = view.findViewById(R.id.linear_layout_visualGraph);

        textViewPrincipalAmount = view.findViewById(R.id.text_view_principal_amount);
        textViewPrincipalAmount.setCharacterLists(TickerUtils.provideNumberList());

        textViewInterestAmount = view.findViewById(R.id.text_view_interest_amount);
        textViewInterestAmount.setCharacterLists(TickerUtils.provideNumberList());

        textViewTotalAmount = view.findViewById(R.id.text_view_total_amount);
        textViewTotalAmount.setCharacterLists(TickerUtils.provideNumberList());

        textViewResultPrincipal = view.findViewById(R.id.text_view_result_principal);
        textViewCompoundingFrequency = view.findViewById(R.id.text_view_compounding_frequency);
        textViewInterestRateType = view.findViewById(R.id.text_view_interest_rate_type);

        btnCompound = requireActivity().findViewById(R.id.btn_compound_interest);
        btnSimple = requireActivity().findViewById(R.id.btn_simple_interest);

        textViewFooterTotalAmount = requireActivity().findViewById(R.id.text_view_footer_total_amount);
        textViewFooterTotalAmount.setCharacterLists(TickerUtils.provideNumberList());

        saveButton = requireActivity().findViewById(R.id.save_button);

        editTextPrincipalAmountLayout = view.findViewById(R.id.editText_principal_amount_layout);

        textViewLableBarGraph = view.findViewById(R.id.textView_lable_barGraph);

        editTextLayoutInterestRate = view.findViewById(R.id.edit_text_layout_interest_rate);

        fromDateEditTextLayout = view.findViewById(R.id.from_date_editText_layout);
        toDateEditTextLayout = view.findViewById(R.id.to_date_editText_layout);

        calculationScrollView = view.findViewById(R.id.calculation_scroll_view);

        editTextYearLayout = view.findViewById(R.id.edit_text_year_layout);
        editTextMonthLayout = view.findViewById(R.id.edit_text_month_layout);
        editTextDayLayout = view.findViewById(R.id.edit_text_day_layout);

        recyclerViewTable = view.findViewById(R.id.recycler_view_table);

        linearLayoutTableHeader = view.findViewById(R.id.linear_layout_table_header);

        textViewTableNoText = view.findViewById(R.id.text_view_table_no_text);

        drawerLayout = requireActivity().findViewById(R.id.drawer);
        navigationView = requireActivity().findViewById(R.id.navigation_view);


        shimmerFrameLayout = view.findViewById(R.id.shimmer_view_table_container);

        imageViewPieNotFound = view.findViewById(R.id.image_view_pie_not_found);
        imageViewBarNotFound = view.findViewById(R.id.image_view_bar_not_found);
        imageViewTableNotFound = view.findViewById(R.id.image_view_table_not_found);


        shimmerFrameLayout.hideShimmer();

//        dbHandler = new DBHandler(getContext());


//        imgBtnMoreThreeDots = findViewById(R.id.more_three_dots);


        dbHandler = new DBHandler(getContext());
        dbHandlerSimple = new DBHandlerSimple(getContext());
//        dbHandler.addNewRecords("500","500","500","500","500","500","500","500","500","500","500","500");
//        dbHandler.close();


//        dbHandler.addNewRecords("1000","500","500","500","500","500","500","500","500","500","500","500");
//        dbHandler.close();


        calculationFragmentParentFarmeLayout = view.findViewById(R.id.calculation_fragment_parent_FrameLayout);
        rlMain = requireActivity().findViewById(R.id.rlMain);

        ArrayList<String> arrayListInterestRateType = new ArrayList<>();
        arrayListInterestRateType.add("Percentage (%)");

        pieChart = view.findViewById(R.id.pieChart);

        mChart1 = view.findViewById(R.id.bar_chart1);

        simpleInterest = new SimpleInterest();
        compoundInterest = new CompoundInterest();
        numberFormatterWithSymbol = new NumberFormatterWithSymbol();
        durationAndDate = new DurationAndDate();
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Temporary this feature id turned off, in future it might be VISIBLE.
//        Every thing is set in compound and simple java file at index of 1 PA
//        just have to put formula
        linearLayoutInterestRateType.setVisibility(View.GONE);

//////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Creating the ArrayAdapter instance having the interest rate type
        aa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, rateTypeFrequency);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerInterestRateTypeYMWDHQBI.setAdapter(aa);

        //Creating the ArrayAdapter instance having the interest rate type
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, compoundingFrequency);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerCompoundingFrequency.setAdapter(arrayAdapter);

        //Creating the ArrayAdapter instance having the interest rate type
        arrayAdapterInterestRateType = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayListInterestRateType);
        arrayAdapterInterestRateType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerInterestRateTypePA.setAdapter(arrayAdapterInterestRateType);

        linearLayoutDate.setVisibility(View.GONE);
        linearLayoutCompoundingFrequency.setVisibility(View.GONE);

        textViewCompoundingFrequency.setSelected(true);
        textViewInterestRateType.setSelected(true);

        // used to hide soft keyboard

        try {
            setupUI(calculationFragmentParentFarmeLayout);

        } catch (NullPointerException ignore) {
        }

        try {
            setupUI(rlMain);
        } catch (NullPointerException ignore) {
        }


        if (linearLayoutTableHeader.getVisibility() == View.VISIBLE) {

            linearLayoutTableHeader.setVisibility(View.GONE);

        }


        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                btnSimpleCompoundStatus = true;


//                getFragmentManager().findFragmentByTag(fragmentName);


                if (!imOnCalculation) {
                    FragmentManager fm = getFragmentManager();
                    //below i tried radomly and works perfectly; other wise i had to use interface
                    //before i was using fm.findFragmentById();
                    //04/01/2023 - 21:37pm - saturday
                    RecordFragment recordFragment = (RecordFragment) fm.getFragments().get(1);
                    recordFragment.mySimple();

                }


                if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                        ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                !editTextDay.getText().toString().equals("")) ||
                                (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {


                    textViewLableBarGraph.setText("BarGraph");
                    textViewLableBarGraph0.setText("Simple Interest");

                    shimmerFrameLayout.showShimmer(true);
                    shimmerFrameLayout.startShimmer();

                    final Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            shimmerFrameLayout.stopShimmer();
                            shimmerFrameLayout.hideShimmer();

                        }
                    }, 700);


                    getSetViews();
                    setSimmerAndAnimationTrue();

                }
                try {

                    btnSimple.setBackgroundColor(Color.parseColor("#1da1f3"));
//                    btnSimple.setBackground(getResources().getDrawable(R.drawable.year_cell));
                    btnSimple.setTextColor(Color.parseColor("#ffffff"));
                    btnSimple.setCompoundDrawablesWithIntrinsicBounds(R.drawable.simple_icon, 0, 0, 0);


                    btnCompound.setBackgroundColor(Color.parseColor("#15202b"));
                    btnCompound.setTextColor(Color.parseColor("#8899a6"));
                    btnCompound.setCompoundDrawablesWithIntrinsicBounds(R.drawable.compound_icon_unchecked, 0, 0, 0);


                    LayoutCompoundFrequencyFadeOut(linearLayoutCompoundingFrequency);


                } catch (NullPointerException ignored) {
                }

            }
        });

        btnCompound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnSimpleCompoundStatus = false;


                if (!imOnCalculation) {
                    FragmentManager fm = getFragmentManager();
                    //below i tried radomly and works perfectly; other wise i had to use interface
                    //before i was using fm.findFragmentById();
                    RecordFragment recordFragment = (RecordFragment) fm.getFragments().get(1);
                    recordFragment.myCompound();

                }


                if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                        ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                !editTextDay.getText().toString().equals("")) ||
                                (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {


                    textViewLableBarGraph.setText("BarGraph");
                    textViewLableBarGraph0.setText("Compound Interest");


                    shimmerFrameLayout.showShimmer(true);
                    shimmerFrameLayout.startShimmer();
//                    shimmerFrameLayout.startShimmer();

                    final Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            shimmerFrameLayout.stopShimmer();
                            shimmerFrameLayout.hideShimmer();

                        }
                    }, 700);


                    getSetViews();
                    setSimmerAndAnimationTrue();


                }

                try {

                    btnCompound.setBackgroundColor(Color.parseColor("#1da1f3"));
                    btnCompound.setTextColor(Color.parseColor("#ffffff"));
                    btnCompound.setCompoundDrawablesWithIntrinsicBounds(R.drawable.compound_icon, 0, 0, 0);

                    LayoutCompoundFrequencyFadeIn(linearLayoutCompoundingFrequency);
                    LayoutCompoundFrequencyFadeOut(linearLayoutDurationBottomLine);

                    btnSimple.setBackgroundColor(Color.parseColor("#15202b"));
                    btnSimple.setTextColor(Color.parseColor("#8899a6"));
                    btnSimple.setCompoundDrawablesWithIntrinsicBounds(R.drawable.simple_icon_unchecked, 0, 0, 0);


                } catch (NullPointerException ignored) {
                }

            }

        });


        fromDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");
                fromClicked = true;

                hideSoftKeyboard(getActivity());

            }
        });

        toDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");
                toClicked = true;

                hideSoftKeyboard(getActivity());

            }
        });


        radioButtonDuration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                durationThenDate = true;
                year = Integer.parseInt(0 + editTextYear.getText().toString());
                month = Integer.parseInt(0 + editTextMonth.getText().toString());
                day = Integer.parseInt(0 + editTextDay.getText().toString());

                durationAndDate.setYear(year);
                durationAndDate.setMonth(month);
                durationAndDate.setDay(day);
                duration = Double.parseDouble(String.format("%.2f", durationAndDate.getDuration()));

                LayoutCompoundFrequencyFadeIn(linearLayoutDuration);
                LayoutCompoundFrequencyFadeOut(linearLayoutDate);

                LayoutCompoundFrequencyFadeOut(linearLayoutDurationBottomLine);

                // it is used to set from or to date edit text to null if only one field is filled and user swaped to duration;
                if (fromDateEditText.getText().toString().equals("") || toDateEditText.getText().toString().equals("")) {
                    if (!fromDateEditText.getText().toString().equals("")) {
                        fromDateEditText.setText("");

                    } else {
                        toDateEditText.setText("");

                    }
                }

            }
        });

        if (radioButtonDuration.isChecked()) {

//            Toast.makeText(getContext(), "checked", Toast.LENGTH_SHORT).show();
            editTextDay.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i == EditorInfo.IME_ACTION_DONE) {
                        editTextDay.clearFocus();
                    }
                    return false;
                }
            });
        }

        radioButtonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                durationThenDate = false;
                LayoutCompoundFrequencyFadeOut(linearLayoutDuration);
//                linearLayoutDuration.setVisibility(View.GONE);
                LayoutCompoundFrequencyFadeIn(linearLayoutDate);
//                linearLayoutDate.setVisibility(View.VISIBLE);
                LayoutCompoundFrequencyFadeOut(linearLayoutDurationBottomLine);
//                linearLayoutDurationBottomLine.setVisibility(View.GONE);


                if (fromDateEditText.getText().toString().equals("") && toDateEditText.getText().toString().equals("")) {

                    if (!editTextYear.getText().toString().equals("")) {
                        editTextYear.setText("");

                    }

                    if (!editTextMonth.getText().toString().equals("")) {
                        editTextMonth.setText("");

                    }

                    if (!editTextDay.getText().toString().equals("")) {
                        editTextDay.setText("");

                    }

                }
            }
        });

        try {
            mChart1.setNoDataText("");
            pieChart.setNoDataText("");
            mChart1.setNoDataTextColor(Color.parseColor("#b49332"));
            pieChart.setNoDataTextColor(Color.parseColor("#b49332"));
        } catch (NullPointerException ignore) {
        }


        countryName = ((MainActivity) Objects.requireNonNull(requireActivity())).ccp.getSelectedCountryEnglishName();

        CountryNameToSymbol countryNameToCurrency = new CountryNameToSymbol();
        countryNameToCurrency.setCountryName(countryName);

        countrySymbol = countryNameToCurrency.getmYcountrySymbol();
        countryCurrency = countryNameToCurrency.getmYcountryCurrency();
        ((MainActivity) Objects.requireNonNull(requireActivity())).textViewCurrencySymbol.setText(countrySymbol);


        ((MainActivity) Objects.requireNonNull(requireActivity())).ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {

                countryName = ((MainActivity) Objects.requireNonNull(requireActivity())).ccp.getSelectedCountryEnglishName();

                countryNameToCurrency.setCountryName(countryName);
                countrySymbol = countryNameToCurrency.getmYcountrySymbol();
                countryCurrency = countryNameToCurrency.getmYcountryCurrency();

                arrayListInterestRateType.remove(1);
                arrayListInterestRateType.add(countryCurrency + " (" + countrySymbol + ")");

                spinnerInterestRateTypePA.setAdapter(arrayAdapterInterestRateType);


                ((MainActivity) Objects.requireNonNull(requireActivity())).textViewCurrencySymbol.setText(countrySymbol);

                if (interestRatePercentageSelected) {


                    editTextLayoutInterestRate.setHint("Interest Rate (%)");
                    interestRatePercentageSelected = true;


                } else {
                    editTextLayoutInterestRate.setHint("Interest Rate (" + countrySymbol + ")");


// It is called again to reset the spinner data because when currency was set and country was getting selected, selected spinner value was not changing;

                    interestRatePercentageSelected = false;


                }
//------------------------------ use to update country symbol when changing country-- --------------------------------

                numberFormatterWithSymbol.setCountryName(countryName);
                numberFormatterWithSymbol.setNumber(principalAmount);
                textViewPrincipalAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());
                editTextPrincipalAmountLayout.setPrefixText(countrySymbol + " ");

                if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                        ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                !editTextDay.getText().toString().equals("")) ||
                                (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

//                    Toast.makeText(getContext(), "view is not empty", Toast.LENGTH_SHORT).show();
                    getSetViews();

                    setSimmerAndAnimationTrue();

                    if (editTextPrincipalAmount.isFocused()) {
                        editTextPrincipalAmount.clearFocus();

                    }
                    if (editTextInterestRate.isFocused()) {
                        editTextInterestRate.clearFocus();

                    }

                    if (editTextYear.isFocused()) {
                        editTextYear.clearFocus();

                    }
                    if (editTextMonth.isFocused()) {
                        editTextMonth.clearFocus();

                    }
                    if (editTextDay.isFocused()) {
                        editTextDay.clearFocus();

                    }

                    shimmerFrameLayout.showShimmer(true);
                    shimmerFrameLayout.startShimmer();

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            drawerLayout.closeDrawer(navigationView);


                        }
                    }, 500);


                    handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            shimmerFrameLayout.stopShimmer();
                            shimmerFrameLayout.hideShimmer();


                        }
                    }, 1200);


                } else {
//                    Toast.makeText(getContext(), "reset view", Toast.LENGTH_SHORT).show();
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            resetViews();
                        }
                    }, 100);


                }

                if (btnSimpleCompoundStatus) {

                    setSimpleInterestText();


                } else {

                    setCompoundInterestText();

                }

//             //        //          //             //             //              //             //        //       //          //

            }
        });

        arrayListInterestRateType.add(countryCurrency + " (" + countrySymbol + ")");

//        -----------------------------Counrty ending-------------------------------------------------------------------------------------------

        editTextPrincipalAmountLayout.setPrefixText(countrySymbol + " ");

        numberFormatterWithSymbol.setCountryName(countryName);
        numberFormatterWithSymbol.setNumber(0);

        textViewPrincipalAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());
        textViewInterestAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());
        textViewTotalAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());
        textViewFooterTotalAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());

        spinnerInterestRateTypePA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {

                    interestSpinnerRateType = 0;

                    editTextLayoutInterestRate.setHint("Interest Rate (%)");
                    interestRatePercentageSelected = true;

                } else if (i == 1) {

                    interestSpinnerRateType = 1;
                    editTextLayoutInterestRate.setHint("Interest Rate" + " " + "(" + countrySymbol + ")");
                    interestRatePercentageSelected = false;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerCompoundingFrequency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        compoundInterestSpinnerFrequency = 0;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 1) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        compoundInterestSpinnerFrequency = 1;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 2) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        compoundInterestSpinnerFrequency = 2;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 3) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        compoundInterestSpinnerFrequency = 3;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 4) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        compoundInterestSpinnerFrequency = 4;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 5) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        compoundInterestSpinnerFrequency = 5;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 6) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        compoundInterestSpinnerFrequency = 6;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 7) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        compoundInterestSpinnerFrequency = 7;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 8) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        compoundInterestSpinnerFrequency = 8;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 9) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        compoundInterestSpinnerFrequency = 9;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 10) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        compoundInterestSpinnerFrequency = 10;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerInterestRateTypeYMWDHQBI.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        rateTypeFrequencyYMWDHQBI = 0;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 1) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        rateTypeFrequencyYMWDHQBI = 1;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 2) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        rateTypeFrequencyYMWDHQBI = 2;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 3) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        rateTypeFrequencyYMWDHQBI = 3;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 4) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        rateTypeFrequencyYMWDHQBI = 4;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 5) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        rateTypeFrequencyYMWDHQBI = 5;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                } else if (i == 6) {
                    if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                            ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                    !editTextDay.getText().toString().equals("")) ||
                                    (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                        rateTypeFrequencyYMWDHQBI = 6;
                        getSetViews();
                        setSimmerAndAnimationTrue();

                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//--------------------------------------Text Watcher principal amount----------------------------------------------------------------
// gotoPrincipalTextWatcher
        editTextPrincipalAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                double myPrincipal;
                myPrincipal = Double.parseDouble("0" + editTextPrincipalAmount.getText().toString());
                if (myPrincipal > 1000000000000.00) {
                    editTextPrincipalAmountLayout.setHelperText(" Principal > 1 Trillion is not Allowed.");

                    editTextPrincipalAmountLayout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                    editTextPrincipalAmountLayout.setBoxStrokeColor(Color.parseColor("#ff0000"));
                    editTextPrincipalAmountLayout.setHintTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));

                    editTextPrincipalAmount.setText("");

                    final Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            editTextPrincipalAmountLayout.setHelperText("");
                            editTextPrincipalAmountLayout.setBoxStrokeColor(Color.parseColor("#1da1f3"));
                            editTextPrincipalAmountLayout.setHintTextColor(ColorStateList.valueOf(Color.parseColor("#1da1f3")));


                        }
                    }, 1000);

                }


                if (myPrincipal == 0) {

                    editTextPrincipalAmount.removeTextChangedListener(this);
                    editTextPrincipalAmount.setText("");
                    editTextPrincipalAmount.addTextChangedListener(this);
                }

                if ((!editTextPrincipalAmount.getText().toString().equals("") && !editTextInterestRate.getText().toString().replaceAll("%", "").equals("")) &&
                        ((!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("") ||
                                !editTextDay.getText().toString().equals("")) ||
                                (!fromDateEditText.getText().toString().equals("") && (!toDateEditText.getText().toString().equals(""))))) {

                    getSetViews();
                    setSimmerAndAnimationTrue();


                    imageViewPieNotFound.setVisibility(View.GONE);
                    imageViewBarNotFound.setVisibility(View.GONE);
                    imageViewTableNotFound.setVisibility(View.GONE);

                    if (recyclerViewTable.getVisibility() != View.VISIBLE) {
                        // this was creating ui slow rendring problem so i did very clever things
//                        it  will show recycler view only if  table layout will be visible
//                        recyclerViewTable.setVisibility(View.VISIBLE);
                        linearLayoutTableHeader.setVisibility(View.VISIBLE);
                        textViewTableNoText.setVisibility(View.GONE);
                    }

                    if (btnSimpleCompoundStatus) {

                        textViewLableBarGraph0.setText("Simple Interest");
                        textViewLableBarGraph.setText("Bar Graph");

                    } else {

                        textViewLableBarGraph.setText("Bar Graph");
                        textViewLableBarGraph0.setText("Compound Interest");
                    }

                } else {
//                    if (editTextPrincipalAmount.getText().toString().equals("") || editTextInterestRate.getText().toString().replaceAll("%", "").equals("")
//                            ||
//
//
//                            ((fromDateEditText.getText().toString().equals("") || toDateEditText.getText().toString().equals(""))
//
//                                    &&
//
//
//                                    (editTextYear.getText().toString().equals("") && editTextMonth.getText().toString().equals("")
//                                            && editTextDay.getText().toString().equals("")))) {
                    resetViews();

                    imageViewPieNotFound.setVisibility(View.VISIBLE);
                    imageViewBarNotFound.setVisibility(View.VISIBLE);
                    imageViewTableNotFound.setVisibility(View.VISIBLE);


//                        if(recyclerViewTable.getVisibility() == View.VISIBLE){
                    recyclerViewTable.setVisibility(View.GONE);
                    linearLayoutTableHeader.setVisibility(View.GONE);
                    textViewTableNoText.setVisibility(View.VISIBLE);
//                        }
//                        tableModelList = new ArrayList<>();


                }

//                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

//---------------------------------------------------End----------------------------------------------------------------------


// --------------------------------------Text Watcher interest amount----------------------------------------------------------------


        editTextInterestRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cursorPosition = editTextInterestRate.getSelectionEnd();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                if (!editTextPrincipalAmount.getText().toString().equals("") &&
                        !editTextInterestRate.getText().toString().replaceAll("%", "").equals("") &&
                        (!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("")
                                || !editTextDay.getText().toString().equals(""))) {

                    getSetViews();
                    setSimmerAndAnimationTrue();

                    imageViewPieNotFound.setVisibility(View.GONE);
                    imageViewBarNotFound.setVisibility(View.GONE);
                    imageViewTableNotFound.setVisibility(View.GONE);

                    if (recyclerViewTable.getVisibility() != View.VISIBLE) {
//                        recyclerViewTable.setVisibility(View.VISIBLE);
                        linearLayoutTableHeader.setVisibility(View.VISIBLE);
                        textViewTableNoText.setVisibility(View.GONE);
                    }


                    if (btnSimpleCompoundStatus) {

                        textViewLableBarGraph0.setText("Simple Interest");
                        textViewLableBarGraph.setText("Bar Graph");

                    } else {

                        textViewLableBarGraph.setText("Bar Graph");
                        textViewLableBarGraph0.setText("Compound Interest");
                    }

                } else {
//                    if (editTextPrincipalAmount.getText().toString().equals("")
//                            || editTextInterestRate.getText().toString().replaceAll("%", "").equals("")
//                            || (editTextYear.getText().toString().equals("") && editTextMonth.getText().toString().equals("")
//                            && editTextDay.getText().toString().equals(""))) {
                    resetViews();

                    imageViewPieNotFound.setVisibility(View.VISIBLE);
                    imageViewBarNotFound.setVisibility(View.VISIBLE);
                    imageViewTableNotFound.setVisibility(View.VISIBLE);

//                        if(recyclerViewTable.getVisibility() == View.VISIBLE){
                    recyclerViewTable.setVisibility(View.GONE);
                    linearLayoutTableHeader.setVisibility(View.GONE);
                    textViewTableNoText.setVisibility(View.VISIBLE);
//                        }
//                    }

                }

                double rate;
                rate = Double.parseDouble("0" + editTextInterestRate.getText().toString().replaceAll("%", ""));
                if (rate > 1000) {
                    editTextLayoutInterestRate.setHelperText(" Rate > 1000 is not Allowed.");

                    editTextLayoutInterestRate.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                    editTextLayoutInterestRate.setBoxStrokeColor(Color.parseColor("#ff0000"));
                    editTextLayoutInterestRate.setHintTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));

                    editTextInterestRate.setText("");

                    final Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            editTextLayoutInterestRate.setHelperText("");
                            editTextLayoutInterestRate.setBoxStrokeColor(Color.parseColor("#1da1f3"));
                            editTextLayoutInterestRate.setHintTextColor(ColorStateList.valueOf(Color.parseColor("#1da1f3")));


                        }
                    }, 1000);
//
                }


                if (rate == 0) {

                    editTextInterestRate.removeTextChangedListener(this);
                    editTextInterestRate.setText("");
                    editTextInterestRate.addTextChangedListener(this);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String myBeforePercentText;

                if (!editTextInterestRate.getText().toString().equals("")) {


                    if (edit) {
                        edit = false;
                        myBeforePercentText = editTextInterestRate.getText().toString().replaceAll("%", "");
                        editTextInterestRate.setText(myBeforePercentText + "%");
                        edit = true;

                    }

                    editTextInterestRate.setSelection(cursorPosition);


                }

                if (editTextInterestRate.getText().toString().equals("%")) {
                    editTextInterestRate.setText("");
                }

                double rate = Double.parseDouble("0" + editTextInterestRate.getText().toString().replaceAll("%", ""));


            }
        });


//-----------------------------------------------------End---------------------------------------------------------------------------------


// --------------------------------------Text Watcher Year----------------------------------------------------------------


        editTextYear.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                int years = Integer.parseInt("0" + editTextYear.getText().toString());


                if (years > 99) {
                    editTextYearLayout.setHelperText("> 99 is not Allowed.");
                    editTextYearLayout.setBoxStrokeColor(Color.parseColor("#ff0000"));
                    editTextYearLayout.setHintTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));

                    editTextYear.setText("");

                    final Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            editTextYearLayout.setHelperText("");
                            editTextYearLayout.setBoxStrokeColor(Color.parseColor("#1da1f3"));
                            editTextYearLayout.setHintTextColor(ColorStateList.valueOf(Color.parseColor("#1da1f3")));

                        }
                    }, 1000);
//
                }

                if (years == 0) {

                    editTextYear.removeTextChangedListener(this);
                    editTextYear.setText("");
                    editTextYear.addTextChangedListener(this);
                }


                if (!editTextPrincipalAmount.getText().toString().equals("") &&
                        !editTextInterestRate.getText().toString().replaceAll("%", "").equals("") &&
                        (!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("")
                                || !editTextDay.getText().toString().equals(""))) {


                    getSetViews();
                    setSimmerAndAnimationTrue();

                    imageViewPieNotFound.setVisibility(View.GONE);
                    imageViewBarNotFound.setVisibility(View.GONE);
                    imageViewTableNotFound.setVisibility(View.GONE);

                    if (recyclerViewTable.getVisibility() != View.VISIBLE) {
//                        recyclerViewTable.setVisibility(View.VISIBLE);
                        linearLayoutTableHeader.setVisibility(View.VISIBLE);
                        textViewTableNoText.setVisibility(View.GONE);
                    }

                    if (btnSimpleCompoundStatus) {

                        textViewLableBarGraph0.setText("Simple Interest");
                        textViewLableBarGraph.setText("Bar Graph");

                    } else {

                        textViewLableBarGraph.setText("Bar Graph");
                        textViewLableBarGraph0.setText("Compound Interest");
                    }

                } else {
//                    if (editTextPrincipalAmount.getText().toString().equals("")
//                            || editTextInterestRate.getText().toString().replaceAll("%", "").equals("")
//                            || (editTextYear.getText().toString().equals("") && editTextMonth.getText().toString().equals("")
//                            && editTextDay.getText().toString().equals(""))) {
                    resetViews();

                    imageViewPieNotFound.setVisibility(View.VISIBLE);
                    imageViewBarNotFound.setVisibility(View.VISIBLE);
                    imageViewTableNotFound.setVisibility(View.VISIBLE);

//                        if(recyclerViewTable.getVisibility() == View.VISIBLE){
                    recyclerViewTable.setVisibility(View.GONE);
                    linearLayoutTableHeader.setVisibility(View.GONE);
                    textViewTableNoText.setVisibility(View.VISIBLE);
//                        }
//                    }

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (radioButtonDuration.isChecked()) {
                    if (!fromDateEditText.getText().toString().equals("")) {
                        fromDateEditText.setText("");

                    }

                    if (!toDateEditText.getText().toString().equals("")) {
                        toDateEditText.setText("");

                    }
                }
            }
        });

//-----------------------------------------------------End---------------------------------------------------------------------------------


// --------------------------------------Text Watcher Day----------------------------------------------------------------


        editTextDay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                int days = Integer.parseInt("0" + editTextDay.getText().toString());

                if (days > 31) {
                    editTextDayLayout.setHelperText("> 31 is not Allowed.");
                    editTextDayLayout.setBoxStrokeColor(Color.parseColor("#ff0000"));
                    editTextDayLayout.setHintTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                    editTextDay.setText("");

                    final Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            editTextDayLayout.setHelperText("");
                            editTextDayLayout.setBoxStrokeColor(Color.parseColor("#1da1f3"));
                            editTextDayLayout.setHintTextColor(ColorStateList.valueOf(Color.parseColor("#1da1f3")));

                        }
                    }, 1000);

                }

                if (days == 0) {

                    editTextDay.removeTextChangedListener(this);
                    editTextDay.setText("");
                    editTextDay.addTextChangedListener(this);
                }

                if (!editTextPrincipalAmount.getText().toString().equals("") &&
                        !editTextInterestRate.getText().toString().replaceAll("%", "").equals("") &&
                        (!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("")
                                || !editTextDay.getText().toString().equals(""))) {


                    getSetViews();
                    setSimmerAndAnimationTrue();

                    imageViewPieNotFound.setVisibility(View.GONE);
                    imageViewBarNotFound.setVisibility(View.GONE);
                    imageViewTableNotFound.setVisibility(View.GONE);

                    if (recyclerViewTable.getVisibility() != View.VISIBLE) {
//                        recyclerViewTable.setVisibility(View.VISIBLE);
                        linearLayoutTableHeader.setVisibility(View.VISIBLE);
                        textViewTableNoText.setVisibility(View.GONE);
                    }

                    if (btnSimpleCompoundStatus) {

                        textViewLableBarGraph0.setText("Simple Interest");
                        textViewLableBarGraph.setText("Bar Graph");

                    } else {

                        textViewLableBarGraph.setText("Bar Graph");
                        textViewLableBarGraph0.setText("Compound Interest");
                    }

                } else {
//                    if (editTextPrincipalAmount.getText().toString().equals("")
//                            || editTextInterestRate.getText().toString().replaceAll("%", "").equals("")
//                            || (editTextYear.getText().toString().equals("") && editTextMonth.getText().toString().equals("")
//                            && editTextDay.getText().toString().equals(""))) {
                    resetViews();

                    imageViewPieNotFound.setVisibility(View.VISIBLE);
                    imageViewBarNotFound.setVisibility(View.VISIBLE);
                    imageViewTableNotFound.setVisibility(View.VISIBLE);

//                        if(recyclerViewTable.getVisibility() == View.VISIBLE){
                    recyclerViewTable.setVisibility(View.GONE);
                    linearLayoutTableHeader.setVisibility(View.GONE);
                    textViewTableNoText.setVisibility(View.VISIBLE);
//                        }
                }

//                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (radioButtonDuration.isChecked()) {
                    if (!fromDateEditText.getText().toString().equals("")) {
                        fromDateEditText.setText("");
                    }

                    if (!toDateEditText.getText().toString().equals("")) {
                        toDateEditText.setText("");
                    }

                }

            }
        });

//-----------------------------------------------------End---------------------------------------------------------------------------------


// --------------------------------------Text Watcher Month----------------------------------------------------------------

        editTextMonth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                int months = Integer.parseInt("0" + editTextMonth.getText().toString());


                if (months > 11) {
                    editTextMonthLayout.setHelperText("> 11 is not Allowed.");
                    editTextMonthLayout.setBoxStrokeColor(Color.parseColor("#ff0000"));
                    editTextMonthLayout.setHintTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                    editTextMonth.setText("");

                    final Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            editTextMonthLayout.setHelperText("");
                            editTextMonthLayout.setBoxStrokeColor(Color.parseColor("#1da1f3"));
                            editTextMonthLayout.setHintTextColor(ColorStateList.valueOf(Color.parseColor("#1da1f3")));


                        }
                    }, 1000);
//
                }

                if (months == 0) {

                    editTextMonth.removeTextChangedListener(this);
                    editTextMonth.setText("");
                    editTextMonth.addTextChangedListener(this);
                }

                if (!editTextPrincipalAmount.getText().toString().equals("") &&
                        !editTextInterestRate.getText().toString().replaceAll("%", "").equals("") &&
                        (!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("")
                                || !editTextDay.getText().toString().equals(""))) {


                    getSetViews();
                    setSimmerAndAnimationTrue();

                    imageViewPieNotFound.setVisibility(View.GONE);
                    imageViewBarNotFound.setVisibility(View.GONE);
                    imageViewTableNotFound.setVisibility(View.GONE);

                    if (recyclerViewTable.getVisibility() != View.VISIBLE) {
//                        recyclerViewTable.setVisibility(View.VISIBLE);
                        linearLayoutTableHeader.setVisibility(View.VISIBLE);
                        textViewTableNoText.setVisibility(View.GONE);
                    }

                    if (btnSimpleCompoundStatus) {

                        textViewLableBarGraph0.setText("Simple Interest");
                        textViewLableBarGraph.setText("Bar Graph");

                    } else {

                        textViewLableBarGraph.setText("Bar Graph");
                        textViewLableBarGraph0.setText("Compound Interest");
                    }

                } else {
//                    if (editTextPrincipalAmount.getText().toString().equals("")
//                            || editTextInterestRate.getText().toString().replaceAll("%", "").equals("")
//                            || (editTextYear.getText().toString().equals("") && editTextMonth.getText().toString().equals("")
//                            && editTextDay.getText().toString().equals(""))) {
                    resetViews();

                    imageViewPieNotFound.setVisibility(View.VISIBLE);
                    imageViewBarNotFound.setVisibility(View.VISIBLE);
                    imageViewTableNotFound.setVisibility(View.VISIBLE);

//                        if(recyclerViewTable.getVisibility() == View.VISIBLE){
                    recyclerViewTable.setVisibility(View.GONE);
                    linearLayoutTableHeader.setVisibility(View.GONE);
                    textViewTableNoText.setVisibility(View.VISIBLE);
//                        }
//                    }

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {


                if (radioButtonDuration.isChecked()) {
                    if (!fromDateEditText.getText().toString().equals("")) {
                        fromDateEditText.setText("");
                    }

                    if (!toDateEditText.getText().toString().equals("")) {
                        toDateEditText.setText("");
                    }

                }

            }
        });

//-----------------------------------------------------End---------------------------------------------------------------------------------


// --------------------------------------Text Watcher toDateEditText----------------------------------------------------------------

        toDateEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                if (!toDateEditText.getText().toString().equals("") && !fromDateEditText.getText().toString().equals("")) {


                    String myFromDate = "" + fromDateEditText.getText().toString();


                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
// It took 3 days to convert to years months and days between two dates;
                if (!toDateEditText.getText().toString().equals("") && !fromDateEditText.getText().toString().equals("")) {

                    String myFromDate = fromDateEditText.getText().toString();
                    String myToDate = toDateEditText.getText().toString();

                    Date fromDate = null;
                    Date toDate = null;


                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                    try {
                        fromDate = format.parse(myFromDate);
                    } catch (ParseException e) {
                    }

                    try {
                        toDate = format.parse(myToDate);
                    } catch (ParseException e) {
                    }


                    int fromDay = Integer.valueOf((String) DateFormat.format("dd", fromDate));
                    int fromMonth = Integer.valueOf((String) DateFormat.format("MM", fromDate));
                    int fromYear = Integer.valueOf((String) DateFormat.format("yyyy", fromDate));


                    int toDay = Integer.valueOf((String) DateFormat.format("dd", toDate));
                    int toMonth = Integer.valueOf((String) DateFormat.format("MM", toDate));
                    int toYear = Integer.valueOf((String) DateFormat.format("yyyy", toDate));


                    fromDate.after(toDate);
                    if (fromDate.after(toDate)) {
                        //if date1>date2, prints the following statement


                        if (!editTextYear.getText().toString().equals("")) {
                            editTextYear.setText("");

                        }

                        if (!editTextMonth.getText().toString().equals("")) {
                            editTextMonth.setText("");

                        }

                        if (!editTextDay.getText().toString().equals("")) {
                            editTextDay.setText("");

                        }

                        toDateEditTextLayout.setHelperText("End date can't be Lesser than start date.");
                        toDateEditTextLayout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));

                        fromDateEditTextLayout.setHelperText("Start date can't be Greater than end date.");
                        fromDateEditTextLayout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));

                        toDateEditText.setTextColor(Color.parseColor("#ff0000"));
                        fromDateEditText.setTextColor(Color.parseColor("#ff0000"));


                        final Handler handler = new Handler(Looper.getMainLooper());
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toDateEditText.setText("");
                                toDateEditTextLayout.setHelperText("");

                                toDateEditText.setTextColor(Color.parseColor("#ff0000"));
                                fromDateEditText.setTextColor(Color.parseColor("#ff0000"));

                                fromDateEditTextLayout.setHelperText("");
                                fromDateEditText.setText("");
                                toDateEditText.setTextColor(Color.parseColor("#ffffff"));
                                fromDateEditText.setTextColor(Color.parseColor("#ffffff"));

                            }
                        }, 1000);

                    } else if (fromDate.before(toDate)) {

                        org.joda.time.LocalDate finalFromDate = new org.joda.time.LocalDate(fromYear, fromMonth, fromDay);
                        org.joda.time.LocalDate finalToDate = new org.joda.time.LocalDate(toYear, toMonth, toDay);
                        org.joda.time.Period period = new Period(finalFromDate, finalToDate, PeriodType.yearMonthDay());

                        int years = period.getYears();
                        int months = period.getMonths();
                        int days = period.getDays();

                        editTextYear.setText(String.valueOf(years));
                        editTextMonth.setText(String.valueOf(months));
                        editTextDay.setText(String.valueOf(days));

                        radioButtonDuration.performClick();

                    } else if (fromDate.equals(toDate)) {


                        if (!editTextYear.getText().toString().equals("")) {
                            editTextYear.setText("");

                        }

                        if (!editTextMonth.getText().toString().equals("")) {
                            editTextMonth.setText("");

                        }

                        if (!editTextDay.getText().toString().equals("")) {
                            editTextDay.setText("");

                        }


                        toDateEditTextLayout.setHelperText("End date can't be Equal to start date.");
                        toDateEditTextLayout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                        fromDateEditTextLayout.setHelperText("Start date can't be Equal to end date.");
                        fromDateEditTextLayout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                        fromDateEditTextLayout.setBoxStrokeColor(Color.parseColor("#ff0000"));
                        toDateEditTextLayout.setBoxStrokeColor(Color.parseColor("#ff0000"));
                        toDateEditText.setTextColor(Color.parseColor("#ff0000"));
                        fromDateEditText.setTextColor(Color.parseColor("#ff0000"));

                        final Handler handler = new Handler(Looper.getMainLooper());
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toDateEditText.setText("");
                                toDateEditTextLayout.setHelperText("");
                                toDateEditText.setTextColor(Color.parseColor("#ffffff"));
                                fromDateEditText.setTextColor(Color.parseColor("#ffffff"));

                                fromDateEditTextLayout.setHelperText("");
                                fromDateEditText.setText("");

                            }
                        }, 1000);
                    }
                }

            }
        });

        // --------------------------------------Text Watcher fromDateEditText----------------------------------------------------------------

        fromDateEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                if (!toDateEditText.getText().toString().equals("") && !fromDateEditText.getText().toString().equals("")) {

                    String myFromDate = "" + fromDateEditText.getText().toString();

                }


            }

            @Override
            public void afterTextChanged(Editable editable) {
                // It took 3 days to convert to years months and days between two dates;
                if (!toDateEditText.getText().toString().equals("") && !fromDateEditText.getText().toString().equals("")) {

                    String myFromDate = fromDateEditText.getText().toString();
                    String myToDate = toDateEditText.getText().toString();

                    Date fromDate = null;
                    Date toDate = null;

                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                    try {
                        fromDate = format.parse(myFromDate);
                    } catch (ParseException ignore) {
                    }

                    try {
                        toDate = format.parse(myToDate);
                    } catch (ParseException ignore) {
                    }

                    int fromDay = Integer.valueOf((String) DateFormat.format("dd", fromDate));
                    int fromMonth = Integer.valueOf((String) DateFormat.format("MM", fromDate));
                    int fromYear = Integer.valueOf((String) DateFormat.format("yyyy", fromDate));

                    int toDay = Integer.valueOf((String) DateFormat.format("dd", toDate));
                    int toMonth = Integer.valueOf((String) DateFormat.format("MM", toDate));
                    int toYear = Integer.valueOf((String) DateFormat.format("yyyy", toDate));

                    fromDate.after(toDate);
                    if (fromDate.after(toDate)) {
                        //if date1>date2, prints the following statement

                        if (!editTextYear.getText().toString().equals("")) {
                            editTextYear.setText("");

                        }

                        if (!editTextMonth.getText().toString().equals("")) {
                            editTextMonth.setText("");

                        }

                        if (!editTextDay.getText().toString().equals("")) {
                            editTextDay.setText("");

                        }


                        toDateEditTextLayout.setHelperText("End date can't be Lesser than start date.");
                        toDateEditTextLayout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));

                        fromDateEditTextLayout.setHelperText("Start date can't be Greater than end date.");
                        fromDateEditTextLayout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));

                        toDateEditText.setTextColor(Color.parseColor("#ff0000"));
                        fromDateEditText.setTextColor(Color.parseColor("#ff0000"));

                        final Handler handler = new Handler(Looper.getMainLooper());
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toDateEditText.setText("");
                                toDateEditTextLayout.setHelperText("");

                                toDateEditText.setTextColor(Color.parseColor("#ff0000"));
                                fromDateEditText.setTextColor(Color.parseColor("#ff0000"));

                                fromDateEditTextLayout.setHelperText("");
                                fromDateEditText.setText("");
                                toDateEditText.setTextColor(Color.parseColor("#ffffff"));
                                fromDateEditText.setTextColor(Color.parseColor("#ffffff"));

                            }
                        }, 1000);


                    } else if (fromDate.before(toDate)) {

                        org.joda.time.LocalDate finalFromDate = new org.joda.time.LocalDate(fromYear, fromMonth, fromDay);
                        org.joda.time.LocalDate finalToDate = new org.joda.time.LocalDate(toYear, toMonth, toDay);
                        org.joda.time.Period period = new Period(finalFromDate, finalToDate, PeriodType.yearMonthDay());

                        int years = period.getYears();
                        int months = period.getMonths();
                        int days = period.getDays();

                        editTextYear.setText(String.valueOf(years));
                        editTextMonth.setText(String.valueOf(months));
                        editTextDay.setText(String.valueOf(days));

                        radioButtonDuration.performClick();

                    } else if (fromDate.equals(toDate)) {

                        if (!editTextYear.getText().toString().equals("")) {
                            editTextYear.setText("");

                        }

                        if (!editTextMonth.getText().toString().equals("")) {
                            editTextMonth.setText("");

                        }

                        if (!editTextDay.getText().toString().equals("")) {
                            editTextDay.setText("");

                        }

                        toDateEditTextLayout.setHelperText("End date can't be Equal to start date.");
                        toDateEditTextLayout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                        fromDateEditTextLayout.setHelperText("Start date can't be Equal to end date.");
                        fromDateEditTextLayout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                        fromDateEditTextLayout.setBoxStrokeColor(Color.parseColor("#ff0000"));
                        toDateEditTextLayout.setBoxStrokeColor(Color.parseColor("#ff0000"));
                        toDateEditText.setTextColor(Color.parseColor("#ff0000"));
                        fromDateEditText.setTextColor(Color.parseColor("#ff0000"));

                        final Handler handler = new Handler(Looper.getMainLooper());
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                toDateEditText.setText("");
                                toDateEditTextLayout.setHelperText("");

                                toDateEditText.setTextColor(Color.parseColor("#ffffff"));
                                fromDateEditText.setTextColor(Color.parseColor("#ffffff"));

                                fromDateEditTextLayout.setHelperText("");
                                fromDateEditText.setText("");

                            }
                        }, 1000);

                    }
                }
            }
        });

        textViewFooterTotalAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


//-----------------------------------------------------End---------------------------------------------------------------------------------


//        fromDateEditText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                hideSoftKeyboard(getActivity());
//            }
//        });


//        Took 4 hours to do this, changing device language to arabic it changes app numeric to arabic also;
        Locale.setDefault(new Locale("en", "US"));


// goto shimmer
        calculationScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                Rect scrollBounds = new Rect();
                calculationScrollView.getHitRect(scrollBounds);
                if (shimmerFrameLayout.getLocalVisibleRect(scrollBounds)) {

                    recyclerViewTable.setVisibility(View.VISIBLE);

                    if (checkScrollShimmerTableVisisble) {

                        shimmerFrameLayout.showShimmer(true);


                    } else {
//                        recyclerViewTable.setVisibility(View.);
                    }

                    final Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            shimmerFrameLayout.hideShimmer();
                            checkScrollShimmerTableVisisble = false;

                        }
                    }, 700);

                } else {
                    recyclerViewTable.setVisibility(View.GONE);
                }
                if (pieChart.getLocalVisibleRect(scrollBounds)) {

                    if (checkScrollPieChartVisible) {
                        pieChart.animateY(1400, Easing.EaseInOutQuad);
                        checkScrollPieChartVisible = false;
                    }
                }


                if (mChart1.getLocalVisibleRect(scrollBounds)) {


                    if (checkScrollBarGraphVisible) {

                        mChart1.animateY(1400, Easing.EaseInOutQuad);
                        checkScrollBarGraphVisible = false;
                    }
                }
            }
        });


        mChart1.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
//                Log.d("onValueSelected", "Value: " + e.toString() + ", xIndex: " + h.getAxis());

//                mChart1.setDrawMarkers(true);
//                mChart1.setMarker(mChart1.getMarker());
                CustomMarkerView mv = new CustomMarkerView(getContext(), R.layout.custom_marker_view);

//                mv.getXOffset(01);

// set the marker to the chart
//                mChart1.setHighlightPerTapEnabled(false);
//                mChart1.setDrawMarkers(true);
//                mChart1.setMarkerView(mv);


                mv.setChartView(mChart1); // For bounds control i.e graph
                mChart1.setMarker(mv); // Set marker
                mChart1.setHighlightPerDragEnabled(false);


            }

            @Override
            public void onNothingSelected() {

            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!editTextPrincipalAmount.getText().toString().equals("") &&
                        !editTextInterestRate.getText().toString().replaceAll("%", "").equals("") &&
                        (!editTextYear.getText().toString().equals("") || !editTextMonth.getText().toString().equals("")
                                || !editTextDay.getText().toString().equals(""))) {


                    LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getContext());
                    View mView = layoutInflaterAndroid.inflate(R.layout.brrow_dialog_layout, null);
                    AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(getContext(), R.style.alertDialog);

                    alertDialogBuilderUserInput.setView(mView);

                    final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);

                    userInputDialogEditText.requestFocus();

                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                    alertDialogBuilderUserInput.setPositiveButton("Save", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            getActivity().getWindow().setSoftInputMode(
                                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

                            if (userInputDialogEditText.getText().toString().equals("")) {
                                myName = "Unknown";
                            } else {
                                myName = userInputDialogEditText.getText().toString();
                            }

                            if (btnSimpleCompoundStatus) {
                                myTypeSorC = "Simple";
                                numberFormatterWithSymbol.setNumber(totalSimpleInterestAmount);
                                myInterestAmount = numberFormatterWithSymbol.getNumberAfterFormat();

                                numberFormatterWithSymbol.setNumber(totalSimpleInterestAmount + principalAmount);
                                myTotalamount = numberFormatterWithSymbol.getNumberAfterFormat();

                            } else {
                                myTypeSorC = "Compound";
                                numberFormatterWithSymbol.setNumber(totalCompoundInterestAmount - principalAmount);
                                myInterestAmount = numberFormatterWithSymbol.getNumberAfterFormat();

                                numberFormatterWithSymbol.setNumber(totalCompoundInterestAmount);
                                myTotalamount = numberFormatterWithSymbol.getNumberAfterFormat();

                            }


                            calendar = Calendar.getInstance();
                            dateFormat = new SimpleDateFormat("dd/MM/yyyy");


                            myDate = dateFormat.format(calendar.getTime());

                            numberFormatterWithSymbol.setNumber(principalAmount);
                            myPrincipalAmount = numberFormatterWithSymbol.getNumberAfterFormat();

                            myInterestRate = "@" + editTextInterestRate.getText().toString() + " / ";

                            if (rateTypeFrequencyYMWDHQBI == 0) {
                                myInteresRateFrequency = "Year";
                            } else if (rateTypeFrequencyYMWDHQBI == 1) {
                                myInteresRateFrequency = "Month";
                            } else if (rateTypeFrequencyYMWDHQBI == 2) {
                                myInteresRateFrequency = "Week";
                            } else if (rateTypeFrequencyYMWDHQBI == 3) {
                                myInteresRateFrequency = "Day";
                            } else if (rateTypeFrequencyYMWDHQBI == 4) {
                                myInteresRateFrequency = "Half-Year";
                            } else if (rateTypeFrequencyYMWDHQBI == 5) {
                                myInteresRateFrequency = "Quarter";
                            } else if (rateTypeFrequencyYMWDHQBI == 6) {
                                myInteresRateFrequency = "Bi-Annual";
                            }


                            myYear = String.valueOf((int) year) + "Y";

                            myMonth = String.valueOf((int) month + "M");

                            myDay = String.valueOf((int) day + "D");


                            if (compoundInterestSpinnerFrequency == 0) {
                                myCompoundingFrequency = "Yearly";
                            } else if (compoundInterestSpinnerFrequency == 1) {
                                myCompoundingFrequency = "Monthly";
                            } else if (compoundInterestSpinnerFrequency == 2) {
                                myCompoundingFrequency = "Weekly";
                            } else if (compoundInterestSpinnerFrequency == 3) {
                                myCompoundingFrequency = "Daily(365/Y)";
                            } else if (compoundInterestSpinnerFrequency == 4) {
                                myCompoundingFrequency = "Half-Yearly";
                            } else if (compoundInterestSpinnerFrequency == 5) {
                                myCompoundingFrequency = "Quarterly";
                            } else if (compoundInterestSpinnerFrequency == 6) {
                                myCompoundingFrequency = "Daily(360/Y)";
                            } else if (compoundInterestSpinnerFrequency == 7) {
                                myCompoundingFrequency = "Bi-Weekly";
                            } else if (compoundInterestSpinnerFrequency == 8) {
                                myCompoundingFrequency = "Half-Monthly";
                            } else if (compoundInterestSpinnerFrequency == 9) {
                                myCompoundingFrequency = "Bi-Monthly";
                            } else if (compoundInterestSpinnerFrequency == 10) {
                                myCompoundingFrequency = "Bi-Annually";
                            }


                            Date currentTime = Calendar.getInstance().getTime();

                            myTimeAsUniqueId = String.valueOf(currentTime);

                            System.out.println(myTimeAsUniqueId);


                            if (btnSimpleCompoundStatus) {
                                dbHandlerSimple.addNewRecords(myName, myTypeSorC, myDate, myPrincipalAmount, myInterestRate, myInteresRateFrequency, myYear, myMonth, myDay, myInterestAmount, myTotalamount, myTimeAsUniqueId);
                                dbHandler.close();


                                Toast toast1 = new Toast(getContext());
                                toast1.setDuration(Toast.LENGTH_SHORT);
                                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.my_toast_data_saved, null);
                                toast1.setView(view);
                                toast1.show();


                            } else {


                                dbHandler.addNewRecords(myName, myTypeSorC, myDate, myPrincipalAmount, myInterestRate, myInteresRateFrequency, myYear, myMonth, myDay, myCompoundingFrequency, myInterestAmount, myTotalamount, myTimeAsUniqueId);
                                dbHandler.close();

                                Toast toast1 = new Toast(getContext());
                                toast1.setDuration(Toast.LENGTH_SHORT);
                                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.my_toast_data_saved, null);
                                toast1.setView(view);
                                toast1.show();

                            }

                        }

                    });

                    alertDialogBuilderUserInput.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getActivity().getWindow().setSoftInputMode(
                                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

                            dialogInterface.cancel();


                        }
                    });

                    androidx.appcompat.app.AlertDialog alertDialog = alertDialogBuilderUserInput.create();
                    alertDialog.show();
                    alertDialog.getButton(androidx.appcompat.app.AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.highlight_blue));
                    alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.light_white));
                    alertDialog.setCancelable(false);


//                dbHandler.addNewRecords("5","100","1000","500","500","500","500","500","500","500","500","500");
//                dbHandler.close();


                } else {


                    Toast toast1 = new Toast(getContext());
                    toast1.setDuration(Toast.LENGTH_SHORT);
                    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.my_toast_calculate_save, null);
                    toast1.setView(view);
                    toast1.show();


//                    toast
                }


            }

        });


        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void loadPieChartData() {
        ArrayList<PieEntry> entries = new ArrayList<>();

        if (btnSimpleCompoundStatus) {
            entries.add(new PieEntry((float) principalAmount, "Principal Amount"));
            entries.add(new PieEntry((float) totalSimpleInterestAmount, "Total Interest"));

        } else {
            entries.add(new PieEntry((float) principalAmount, "Principal Amount"));
            entries.add(new PieEntry((float) (totalCompoundInterestAmount - principalAmount), "Total Interest"));

        }

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.parseColor("#080b10"));
        colors.add(Color.parseColor("#1da1f3"));


        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(colors);


        PieData data = new PieData(dataSet);

        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.WHITE);
        data.getDataSet().setValueTextColor(Color.WHITE);


        pieChart.setData(data);
        pieChart.invalidate();

        pieChart.animateY(1400, Easing.EaseInOutQuad);
    }

    private void setupPieChart() {

        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setEntryLabelColor(Color.parseColor("#000000"));


        if (btnSimpleCompoundStatus) {

            pieChart.setCenterText("Simple Interest");

        } else {

            pieChart.setCenterText("Compound Interest");
        }
        pieChart.setCenterTextColor(Color.parseColor("#8899a6"));
        pieChart.setCenterTextSize(12);

        pieChart.getDescription().setEnabled(true);
        pieChart.getDescription().setText("Pie Chart");
        pieChart.getDescription().setTextSize(10);
        pieChart.getDescription().setTextColor(Color.parseColor("#8899a6"));
        pieChart.setHoleColor(Color.parseColor("#15202b"));
        pieChart.setEntryLabelColor(Color.WHITE);


        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setTextColor(Color.parseColor("#8899a6"));
        l.setDrawInside(false);


        l.setEnabled(false);
    }

    public void MultipalColor() {

        mChart1.getDescription().setEnabled(false);

        // drawn
        mChart1.setMaxVisibleValueCount(40);

        // scaling can now only be done on x- and y-axis separately
        mChart1.setPinchZoom(true);
        mChart1.setDrawValueAboveBar(false);
        mChart1.setDragEnabled(true);
        mChart1.setNoDataTextColor(Color.parseColor("#b49332"));

        mChart1.animateY(1400, Easing.EaseInOutQuad);

        mChart1.getXAxis().setGridColor(Color.parseColor("#8899a6"));
        mChart1.getXAxis().setAxisLineColor(Color.parseColor("#8899a6"));
        mChart1.getAxisLeft().setAxisLineColor(Color.parseColor("#8899a6"));

        // change the position of the y-labels
        YAxis leftAxis = mChart1.getAxisLeft();

        leftAxis.setTextColor(Color.parseColor("#ffffff"));

        leftAxis.setGridColor(Color.parseColor("#8899a6"));

        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        mChart1.getAxisRight().setEnabled(false);

        XAxis xLabels = mChart1.getXAxis();
        xLabels.setTextColor(Color.parseColor("#ffffff"));
        xLabels.setPosition(XAxis.XAxisPosition.TOP);

        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("");
        xAxisLabel.add("1y");
        xAxisLabel.add("2Y");
        xAxisLabel.add("3Y");
        xAxisLabel.add("4Y");
        xAxisLabel.add("5Y");
        xAxisLabel.add("6Y");
        xAxisLabel.add("7Y");
        xAxisLabel.add("8Y");
        xAxisLabel.add("9Y");
        xAxisLabel.add("10Y");
        xAxisLabel.add("11Y");
        xAxisLabel.add("12Y");
        xAxisLabel.add("13Y");
        xAxisLabel.add("14Y");
        xAxisLabel.add("15Y");
        xAxisLabel.add("16Y");
        xAxisLabel.add("17Y");
        xAxisLabel.add("18Y");
        xAxisLabel.add("19Y");
        xAxisLabel.add("20Y");
        xAxisLabel.add("21Y");
        xAxisLabel.add("22Y");
        xAxisLabel.add("23Y");
        xAxisLabel.add("24Y");
        xAxisLabel.add("25Y");
        xAxisLabel.add("26Y");
        xAxisLabel.add("27Y");
        xAxisLabel.add("28Y");
        xAxisLabel.add("29Y");
        xAxisLabel.add("30Y");
        xAxisLabel.add("31Y");
        xAxisLabel.add("32Y");
        xAxisLabel.add("33Y");
        xAxisLabel.add("34Y");
        xAxisLabel.add("35Y");
        xAxisLabel.add("36Y");
        xAxisLabel.add("37Y");
        xAxisLabel.add("38Y");
        xAxisLabel.add("39Y");
        xAxisLabel.add("40Y");
        xAxisLabel.add("41Y");
        xAxisLabel.add("42Y");
        xAxisLabel.add("43Y");
        xAxisLabel.add("44Y");
        xAxisLabel.add("45Y");
        xAxisLabel.add("46Y");
        xAxisLabel.add("47Y");
        xAxisLabel.add("48Y");
        xAxisLabel.add("49Y");
        xAxisLabel.add("50Y");
        xAxisLabel.add("51Y");
        xAxisLabel.add("52Y");
        xAxisLabel.add("53Y");
        xAxisLabel.add("54Y");
        xAxisLabel.add("55Y");
        xAxisLabel.add("56Y");
        xAxisLabel.add("57Y");
        xAxisLabel.add("58Y");
        xAxisLabel.add("59Y");
        xAxisLabel.add("60Y");
        xAxisLabel.add("61Y");
        xAxisLabel.add("62Y");
        xAxisLabel.add("63Y");
        xAxisLabel.add("64Y");
        xAxisLabel.add("65Y");
        xAxisLabel.add("66Y");
        xAxisLabel.add("67Y");
        xAxisLabel.add("68Y");
        xAxisLabel.add("69Y");
        xAxisLabel.add("70Y");
        xAxisLabel.add("71Y");
        xAxisLabel.add("72Y");
        xAxisLabel.add("73Y");
        xAxisLabel.add("74Y");
        xAxisLabel.add("75Y");
        xAxisLabel.add("76Y");
        xAxisLabel.add("77Y");
        xAxisLabel.add("78Y");
        xAxisLabel.add("79Y");
        xAxisLabel.add("80Y");
        xAxisLabel.add("81Y");
        xAxisLabel.add("82Y");
        xAxisLabel.add("83Y");
        xAxisLabel.add("84Y");
        xAxisLabel.add("85Y");
        xAxisLabel.add("86Y");
        xAxisLabel.add("87Y");
        xAxisLabel.add("88Y");
        xAxisLabel.add("89Y");
        xAxisLabel.add("90Y");
        xAxisLabel.add("91Y");
        xAxisLabel.add("92Y");
        xAxisLabel.add("93Y");
        xAxisLabel.add("94Y");
        xAxisLabel.add("95Y");
        xAxisLabel.add("96Y");
        xAxisLabel.add("97Y");
        xAxisLabel.add("98Y");
        xAxisLabel.add("99Y");
        xAxisLabel.add("100Y");

        xLabels.setValueFormatter(new IndexAxisValueFormatter(xAxisLabel));

        Legend l = mChart1.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setFormSize(8f);
        l.setFormToTextSpace(4f);
        l.setXEntrySpace(6f);

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        tableModelList = new ArrayList<>();
        counter = true;
//        double myInteretForTable =0;


//        if(counter <= 2){
//        double myInteretForTable = 0;
//        if(counter == true){
        double myInteretForTable = 0;
        double temp = 0;

//             double myInteretForTable = simpleInterest.getTotalSimpleInterestAmount();

//        }

//        }
        for (double time = 1.0; time < duration + 1; time++) {


            // It took 50 hrs to create a bar graph properly. (Amrit hostel ) dated - 14/01/2023
            if (btnSimpleCompoundStatus) {

                double fraction = duration % 1;

                if (((time + fraction) == (duration + 1)) && (fraction != 0)) {
                    simpleInterest.setTime(fraction);


                    double myPredeccessorSI = simpleInterest.getTotalSimpleInterestAmount();

                    if (duration < 1.0) {

                        totalSimpleInterestAmount = simpleInterest.getTotalSimpleInterestAmount();
                        yVals1.add(new BarEntry((float) time,
                                new float[]{(float) principalAmount, (float) totalSimpleInterestAmount},
                                getResources().getDrawable(R.drawable.ic_baseline_feedback_24)));
//                        tableModelList = new ArrayList<>();
                        setRecyclerViewTable((int) time, totalSimpleInterestAmount, totalSimpleInterestAmount, principalAmount + totalSimpleInterestAmount);

                    } else {

                        myPredeccessorSI = totalSimpleInterestAmount;
                        totalSimpleInterestAmount = simpleInterest.getTotalSimpleInterestAmount();

                        yVals1.add(new BarEntry((float) time,
                                new float[]{(float) principalAmount, (float) totalSimpleInterestAmount + (float) myPredeccessorSI},
                                getResources().getDrawable(R.drawable.ic_baseline_feedback_24)));
                        setRecyclerViewTable((int) time, totalSimpleInterestAmount, totalSimpleInterestAmount + myPredeccessorSI, principalAmount + totalSimpleInterestAmount + myPredeccessorSI);

//                        counter = false;

                    }

                } else {

                    simpleInterest.setTime(time);
//                    double myPInterestForTable = totalSimpleInterestAmount;

                    double previousBalance = totalSimpleInterestAmount + principalAmount;
                    totalSimpleInterestAmount = simpleInterest.getTotalSimpleInterestAmount();

//                    myInteretForTable = myPInterestForTable - simpleInterest.getTotalSimpleInterestAmount();
//                      temp =  temp - myInteretForTable;
//                     myInteretForTable = 0;
                    yVals1.add(new BarEntry((float) time,
                            new float[]{(float) principalAmount, (float) totalSimpleInterestAmount},
                            getResources().getDrawable(R.drawable.ic_baseline_feedback_24)));
                    if (time == 1) {

                        setRecyclerViewTable((int) time, totalSimpleInterestAmount, totalSimpleInterestAmount, principalAmount + totalSimpleInterestAmount);
//                    Toast.makeText(getContext(), String.valueOf(myPInterestForTable), Toast.LENGTH_SHORT).show();

                    } else {

                        setRecyclerViewTable((int) time, (totalSimpleInterestAmount + principalAmount) - previousBalance, totalSimpleInterestAmount, principalAmount + totalSimpleInterestAmount);
//                    Toast.makeText(getContext(), String.valueOf(myPInterestForTable), Toast.LENGTH_SHORT).show();

                    }


                }

            } else {
                double previousBalanceCompound = 0;
                double fraction = duration % 1;
                //took 5 hrs to create this concept, need to chagne principal amount for last iteration
                if (((time + fraction) == (duration + 1)) && (fraction != 0)) {
                    compoundInterest.setTime(fraction);

                    if (duration < 1) {
//                        previousBalance = totalCompoundInterestAmount - principalAmount;
                        totalCompoundInterestAmount = compoundInterest.getTotalCompoundInterestAmount();
                        compoundInterest.setPrincipal(Double.parseDouble(0 + editTextPrincipalAmount.getText().toString()));
//                        setRecyclerViewTable((int) time,principalAmount - totalCompoundInterestAmount,principalAmount - totalCompoundInterestAmount,totalCompoundInterestAmount);

                    } else {

                        previousBalanceCompound = totalCompoundInterestAmount - principalAmount;
                        compoundInterest.setPrincipal(totalCompoundInterestAmount);
                        totalCompoundInterestAmount = compoundInterest.getTotalCompoundInterestAmount();
                        compoundInterest.setPrincipal(Double.parseDouble(0 + editTextPrincipalAmount.getText().toString()));
//                        setRecyclerViewTable((int) time,  totalCompoundInterestAmount,totalCompoundInterestAmount ,principalAmount + totalCompoundInterestAmount);

                    }

                } else {
                    previousBalanceCompound = totalCompoundInterestAmount - principalAmount;
                    compoundInterest.setTime(time);
                    totalCompoundInterestAmount = compoundInterest.getTotalCompoundInterestAmount();

                }

                yVals1.add(new BarEntry((float) time,
                        new float[]{(float) principalAmount, (float) (totalCompoundInterestAmount - principalAmount)},
                        getResources().getDrawable(R.drawable.ic_baseline_feedback_24)));

                if (time == 1) {
                    setRecyclerViewTable((int) time, (totalCompoundInterestAmount - principalAmount), totalCompoundInterestAmount - principalAmount, totalCompoundInterestAmount);

                } else {
                    setRecyclerViewTable((int) time, (totalCompoundInterestAmount - principalAmount) - previousBalanceCompound, totalCompoundInterestAmount - principalAmount, totalCompoundInterestAmount);

                }

            }

        }

        myYearForTableAdapter = duration;

        if (btnSimpleCompoundStatus) {
            simpleInterest.setTime(Double.parseDouble(String.format("%.2f", durationAndDate.getDuration())));
            totalSimpleInterestAmount = simpleInterest.getTotalSimpleInterestAmount();
            setSimpleInterestText();

        } else {
            compoundInterest.setTime(Double.parseDouble(String.format("%.2f", durationAndDate.getDuration())));
            totalCompoundInterestAmount = compoundInterest.getTotalCompoundInterestAmount();
            setCompoundInterestText();

        }

        leftAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {

                String vibhuFormattedValue;

                if (value <= 999) {

                    numberFormatterWithSymbol.setNumber(value);
                    vibhuFormattedValue = numberFormatterWithSymbol.getNumberAfterFormat();

                } else {

                    vibhuFormattedValue = countrySymbol + " " + String.valueOf(format((long) value));

                }

                return vibhuFormattedValue;

            }
        });

        BarDataSet set1;

        if (mChart1.getData() != null &&
                mChart1.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mChart1.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mChart1.getData().notifyDataChanged();
            mChart1.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "Compound Interest");
            set1.setDrawIcons(false);
            set1.setColors(getColors());
            set1.setStackLabels(new String[]{"", ""});

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);

// It took 2 days to sort out this format before using LargeValueFormatter but it was showing wrong value < 1000;
            data.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value) {

                    String vibhuFormattedValue;

                    if (value <= 999) {

                        numberFormatterWithSymbol.setNumber(value);
                        vibhuFormattedValue = numberFormatterWithSymbol.getNumberAfterFormat();

                    } else {

                        vibhuFormattedValue = countrySymbol + " " + String.valueOf(format((long) value));

                    }

                    return vibhuFormattedValue;

                }
            });

            data.setValueTextColor(Color.WHITE);

            mChart1.setData(data);

        }

// Achived very fast before zoom in zoom out of chart was conflicting with scroll view;
        mChart1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ViewPortHandler viewPortHandler = mChart1.getViewPortHandler();
                        float scaleX = viewPortHandler.getScaleX();
                        float scaleY = viewPortHandler.getScaleY();

                        if (scaleX != 1 || scaleY != 1) {

                            calculationScrollView.requestDisallowInterceptTouchEvent(true);
                        }

                        break;
                    }
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP: {

                        ViewPortHandler viewPortHandler = mChart1.getViewPortHandler();
                        float scaleX = viewPortHandler.getScaleX();
                        float scaleY = viewPortHandler.getScaleY();

                        if (scaleX != 1 || scaleY != 1) {

                            calculationScrollView.requestDisallowInterceptTouchEvent(false);
                        }

                        break;
                    }
                }

                return false;
            }
        });


        mChart1.getLegend().setEnabled(false);
        mChart1.getLegend().setDrawInside(false);
        mChart1.setFitBars(true);
        mChart1.fitScreen();
        mChart1.invalidate();


    }

    private ArrayList<Integer> getColors() {

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.parseColor("#080b10"));
        colors.add(Color.parseColor("#1da1f3"));

        return colors;
    }

    public int getSpinnerInterestRateType() {

        return interestSpinnerRateType;

    }

    public int getSpinnerRateTypeFrequencyYMWDHQBI() {
        return rateTypeFrequencyYMWDHQBI;
    }

    public int getSpinnerCompoundingFrequency() {
        return compoundInterestSpinnerFrequency;
    }

    public void textWatcherPrincipalAmount() {

    }

    public void upDateData() {

        MultipalColor();
        loadPieChartData();
        setupPieChart();


    }

    public void getSetViews() {

        // trick for comparing old and new value to ticker
        principalAmountOldValue = principalAmount;
        principalAmount = Double.parseDouble(0 + editTextPrincipalAmount.getText().toString());

        interestAmounOldValue = getInterestAmount;

        if (btnSimpleCompoundStatus) {

            getInterestAmount = totalSimpleInterestAmount;

        } else {

            getInterestAmount = totalCompoundInterestAmount;

        }

        totalAmountOldValue = getTotalAmount;

        if (btnSimpleCompoundStatus) {

            getTotalAmount = principalAmount + totalSimpleInterestAmount;

        } else {

            getTotalAmount = principalAmount + totalCompoundInterestAmount;

        }

        totalAmountFooterOldValue = getTotalFooterAmount;

        if (btnSimpleCompoundStatus) {
            getTotalFooterAmount = principalAmount + totalSimpleInterestAmount;

        } else {
            getTotalFooterAmount = principalAmount + totalSimpleInterestAmount;

        }

        interestRate = Double.parseDouble(0 + editTextInterestRate.getText().toString().replaceAll("%", ""));

        year = Integer.parseInt(0 + editTextYear.getText().toString());
        month = Integer.parseInt(0 + editTextMonth.getText().toString());
        day = Integer.parseInt(0 + editTextDay.getText().toString());

        durationAndDate.setYear(year);
        durationAndDate.setMonth(month);

        if (day == 1) {
//it is used because on day one duration was 0 hence bar graph representing wrong whenever user put a number starting with 1 day;
            durationAndDate.setDay(day + 1);

        } else {
            durationAndDate.setDay(day);
        }


        simpleInterest.setPrincipal(principalAmount);
        simpleInterest.setRateType(rateTypePA);
        simpleInterest.setRate(interestRate);
        simpleInterest.setRateTypeFrequencyYMWDHQBI(rateTypeFrequencyYMWDHQBI);

        compoundInterest.setPrincipal(principalAmount);
        compoundInterest.setRateType(rateTypePA);
        compoundInterest.setRate(interestRate);
        compoundInterest.setCompoundingFrequency(compoundInterestSpinnerFrequency);
        compoundInterest.setRateTypeFrequencyYMWDHQBI(rateTypeFrequencyYMWDHQBI);

        numberFormatterWithSymbol.setCountryName(countryName);

        if (principalAmountOldValue < principalAmount) {

            textViewPrincipalAmount.setPreferredScrollingDirection(DOWN);

        } else {

            textViewPrincipalAmount.setPreferredScrollingDirection(UP);

        }

        numberFormatterWithSymbol.setNumber(principalAmount);
        textViewPrincipalAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());

        rateTypePA = getSpinnerInterestRateType();
        compoundInterestSpinnerFrequency = getSpinnerCompoundingFrequency();
        rateTypeFrequencyYMWDHQBI = getSpinnerRateTypeFrequencyYMWDHQBI();

        duration = Double.parseDouble(String.format("%.2f", durationAndDate.getDuration()));


        upDateData();


    }


    public void resetViews() {

        numberFormatterWithSymbol.setNumber(0);
        textViewPrincipalAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());
        textViewInterestAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());
        textViewTotalAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());
        textViewFooterTotalAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());

        try {
            mChart1.clear();
            pieChart.clear();
            textViewLableBarGraph0.setText("");
            textViewLableBarGraph.setText("");
        } catch (NullPointerException ignore) {
        }

    }

    private void setSimpleInterestText() {

        if (interestAmounOldValue < getInterestAmount) {
            textViewInterestAmount.setPreferredScrollingDirection(DOWN);

        } else {
            textViewInterestAmount.setPreferredScrollingDirection(UP);

        }

        if (totalAmountOldValue < getTotalAmount) {
            textViewTotalAmount.setPreferredScrollingDirection(DOWN);

        } else {
            textViewTotalAmount.setPreferredScrollingDirection(UP);

        }

        if (totalAmountFooterOldValue < getTotalFooterAmount) {
            textViewFooterTotalAmount.setPreferredScrollingDirection(DOWN);

        } else {
            textViewFooterTotalAmount.setPreferredScrollingDirection(UP);

        }

        numberFormatterWithSymbol.setNumber(totalSimpleInterestAmount);
        textViewInterestAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());

        numberFormatterWithSymbol.setNumber(principalAmount + totalSimpleInterestAmount);
        textViewTotalAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());

        numberFormatterWithSymbol.setNumber(principalAmount + totalSimpleInterestAmount);
        textViewFooterTotalAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());

    }

    private void setCompoundInterestText() {

        if (interestAmounOldValue < getInterestAmount) {
            textViewInterestAmount.setPreferredScrollingDirection(DOWN);

        } else {
            textViewInterestAmount.setPreferredScrollingDirection(UP);

        }

        if (totalAmountOldValue < getTotalAmount) {
            textViewTotalAmount.setPreferredScrollingDirection(DOWN);

        } else {
            textViewTotalAmount.setPreferredScrollingDirection(UP);

        }

        if (totalAmountFooterOldValue < getTotalFooterAmount) {
            textViewFooterTotalAmount.setPreferredScrollingDirection(DOWN);

        } else {
            textViewFooterTotalAmount.setPreferredScrollingDirection(UP);

        }

        numberFormatterWithSymbol.setNumber(totalCompoundInterestAmount - principalAmount);
        textViewInterestAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());

        numberFormatterWithSymbol.setNumber(totalCompoundInterestAmount);
        textViewTotalAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());

        numberFormatterWithSymbol.setNumber(totalCompoundInterestAmount);
        textViewFooterTotalAmount.setText(numberFormatterWithSymbol.getNumberAfterFormat());

    }

    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();

    static {
        suffixes.put(1_000L, "k");
        suffixes.put(1_000_000L, "M");
        suffixes.put(1_000_000_000L, "B");
        suffixes.put(1_000_000_000_000L, "T");
        suffixes.put(1_000_000_000_000_000L, "P");
        suffixes.put(1_000_000_000_000_000_000L, "E");
    }

    public static String format(long value) {
        //Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
        if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
        if (value < 0) return "-" + format(-value);
        if (value < 1000) return Long.toString(value); //deal with easy case

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = e.getKey();
        String suffix = e.getValue();

        long truncated = value / (divideBy / 10); //the number part of the output times 10
        boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
    }

    private void LayoutCompoundFrequencyFadeOut(final LinearLayout layout) {

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(100);

        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                layout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        layout.startAnimation(fadeOut);

    }

    private void LayoutCompoundFrequencyFadeIn(LinearLayout layout) {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new AccelerateInterpolator());
        fadeIn.setDuration(750);

        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                layout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        layout.startAnimation(fadeIn);

    }

    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(getActivity());
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
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

    @Override
    public void onResume() {
        super.onResume();


        SharedPreferences sh = this.getActivity().getSharedPreferences("DurationAndDateStatus", MODE_PRIVATE);

        durationThenDate = sh.getBoolean("radioStatus", true);

        if (durationThenDate) {

            radioButtonDuration.performClick();

        } else {

            radioButtonDate.performClick();

        }


        if (editTextPrincipalAmount.isFocused()) {
            editTextPrincipalAmount.clearFocus();

        }
        if (editTextInterestRate.isFocused()) {
            editTextInterestRate.clearFocus();

        }

        if (editTextYear.isFocused()) {
            editTextYear.clearFocus();

        }
        if (editTextMonth.isFocused()) {
            editTextMonth.clearFocus();

        }
        if (editTextDay.isFocused()) {
            editTextDay.clearFocus();

        }


        if (btnSimpleCompoundStatus) {


            btnSimple.setBackgroundColor(Color.parseColor("#1da1f3"));
            btnSimple.setTextColor(Color.parseColor("#ffffff"));
            btnSimple.setCompoundDrawablesWithIntrinsicBounds(R.drawable.simple_icon, 0, 0, 0);


            btnCompound.setBackgroundColor(Color.parseColor("#15202b"));
            btnCompound.setTextColor(Color.parseColor("#8899a6"));
            btnCompound.setCompoundDrawablesWithIntrinsicBounds(R.drawable.compound_icon_unchecked, 0, 0, 0);


        } else {

            btnCompound.setBackgroundColor(Color.parseColor("#1da1f3"));
            btnCompound.setTextColor(Color.parseColor("#ffffff"));
            btnCompound.setCompoundDrawablesWithIntrinsicBounds(R.drawable.compound_icon, 0, 0, 0);


            LayoutCompoundFrequencyFadeIn(linearLayoutCompoundingFrequency);
            LayoutCompoundFrequencyFadeOut(linearLayoutDurationBottomLine);

            btnSimple.setBackgroundColor(Color.parseColor("#15202b"));
            btnSimple.setTextColor(Color.parseColor("#8899a6"));
            btnSimple.setCompoundDrawablesWithIntrinsicBounds(R.drawable.simple_icon_unchecked, 0, 0, 0);


        }

    }


    public void reCalculateCompound(String myPrincipalAmount, String myRate, String myInterestFrequency
            , String myFrequency, String myYear, String myMonth, String myDay) {



        if (myInterestFrequency.equals("Year")) {
            spinnerInterestRateTypeYMWDHQBI.setSelection(0);

        } else if (myInterestFrequency.equals("Month")) {
            spinnerInterestRateTypeYMWDHQBI.setSelection(1);

        } else if (myInterestFrequency.equals("Week")) {
            spinnerInterestRateTypeYMWDHQBI.setSelection(2);

        } else if (myInterestFrequency.equals("Day")) {
            spinnerInterestRateTypeYMWDHQBI.setSelection(3);

        } else if (myInterestFrequency.equals("Half-Year")) {
            spinnerInterestRateTypeYMWDHQBI.setSelection(4);

        } else if (myInterestFrequency.equals("Quarter")) {
            spinnerInterestRateTypeYMWDHQBI.setSelection(5);

        } else if (myInterestFrequency.equals("Bi-Annual")) {
            spinnerInterestRateTypeYMWDHQBI.setSelection(6);

        }



        if(myFrequency.equals("Yearly")){
            spinnerCompoundingFrequency.setSelection(0);

        } else if(myFrequency.equals("Monthly")){
            spinnerCompoundingFrequency.setSelection(1);

        } else if(myFrequency.equals("Weekly")){
            spinnerCompoundingFrequency.setSelection(2);

        } else if(myFrequency.equals("Daily(365/Y)")){
            spinnerCompoundingFrequency.setSelection(3);

        } else if(myFrequency.equals("Half-Yearly")){
            spinnerCompoundingFrequency.setSelection(4);

        } else if(myFrequency.equals("Quarterly")){
            spinnerCompoundingFrequency.setSelection(5);

        } else if(myFrequency.equals("Daily(360/Y)")){
            spinnerCompoundingFrequency.setSelection(6);

        } else if(myFrequency.equals("Bi-Weekly")){
            spinnerCompoundingFrequency.setSelection(7);

        } else if(myFrequency.equals("Half-Monthly")){
            spinnerCompoundingFrequency.setSelection(8);

        } else if(myFrequency.equals("Bi-Monthly")){
            spinnerCompoundingFrequency.setSelection(9);

        } else if(myFrequency.equals("Bi-Anually")){
            spinnerCompoundingFrequency.setSelection(10);

        }


        editTextPrincipalAmount.setText(String.valueOf(myPrincipalAmount));
        editTextInterestRate.setText(String.valueOf(myRate));
        editTextYear.setText(String.valueOf(myYear));
        editTextMonth.setText(String.valueOf(myMonth));
        editTextDay.setText(String.valueOf(myDay));

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                ((MainActivity) getActivity()).switchBottomNavigation();

            }
        }, 300);

        editTextPrincipalAmount.setSelection(editTextPrincipalAmount.getText().length());

    }



    public void reCalculate( String myPrincipalAmount, String myRate, String myInterestFrequency
    , String myYear, String myMonth, String myDay){

        if(myInterestFrequency.equals("Year")){
            spinnerInterestRateTypeYMWDHQBI.setSelection(0);

        }else if(myInterestFrequency.equals("Month")){
            spinnerInterestRateTypeYMWDHQBI.setSelection(1);

        } else if(myInterestFrequency.equals("Week")){
            spinnerInterestRateTypeYMWDHQBI.setSelection(2);

        } else if(myInterestFrequency.equals("Day")){
            spinnerInterestRateTypeYMWDHQBI.setSelection(3);

        } else if(myInterestFrequency.equals("Half-Year")){
            spinnerInterestRateTypeYMWDHQBI.setSelection(4);

        } else if(myInterestFrequency.equals("Quarter")){
            spinnerInterestRateTypeYMWDHQBI.setSelection(5);

        } else if (myInterestFrequency.equals("Bi-Annual")){
            spinnerInterestRateTypeYMWDHQBI.setSelection(6);

        }

        editTextPrincipalAmount .setText(String.valueOf(myPrincipalAmount));
        editTextInterestRate.setText(String.valueOf(myRate));
        editTextYear.setText(String.valueOf(myYear));
        editTextMonth.setText(String.valueOf(myMonth));
        editTextDay.setText(String.valueOf(myDay));

        final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        ((MainActivity)getActivity()).switchBottomNavigation();

                    }
                }, 300);

        editTextPrincipalAmount.setSelection(editTextPrincipalAmount.getText().length());

    }






    @Override
    public void onPause() {
        super.onPause();


        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("DurationAndDateStatus", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.clear();
        myEdit.putBoolean("radioStatus", Boolean.parseBoolean(String.valueOf(durationThenDate)));
        myEdit.apply();

    }

    public void setRecyclerViewTable(int time, double interest, double accruedInterest, double balance) {
        recyclerViewTable.setHasFixedSize(true);
        recyclerViewTable.setLayoutManager(new LinearLayoutManager(this.getContext()));
        tableAdapter = new TableAdapter(this.getContext(), getList(time, interest, accruedInterest, balance));
        tableAdapter.setHasStableIds(true);

//goto recycler adapter

        // it slow down UI i tried alot to solve but couldn't ;(

        recyclerViewTable.setVisibility(View.GONE);
        recyclerViewTable.setAdapter(tableAdapter);
//        recyclerViewTable.setVisibility(View.GONE);

    }

    private List<TableModel> getList(int time, double interest, double accruedInterest, double balance) {

        numberFormatterWithSymbol.setNumber(interest);
        String myInterest = numberFormatterWithSymbol.getNumberAfterFormat();
        numberFormatterWithSymbol.setNumber(accruedInterest);
        String myAccruedInterest = numberFormatterWithSymbol.getNumberAfterFormat();
        numberFormatterWithSymbol.setNumber(balance);
        String myBalance = numberFormatterWithSymbol.getNumberAfterFormat();
        numberFormatterWithSymbol.setNumber(principalAmount);
        String myPrincipalAmount = numberFormatterWithSymbol.getNumberAfterFormat();

        if (counter == true) {
            tableModelList.add(new TableModel("0Y", "-", "-", myPrincipalAmount));

            counter = false;
        }
        tableModelList.add(new TableModel(String.valueOf(time) + "Y", myInterest, myAccruedInterest, myBalance));

        return tableModelList;
    }

    void setSimmerAndAnimationTrue() {

        checkScrollShimmerTableVisisble = true;
        checkScrollPieChartVisible = true;
        checkScrollBarGraphVisible = true;

    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {

        menu.findItem(R.id.deleteAll).setVisible(false);
        menu.findItem(R.id.Share).setVisible(true);
        menu.findItem(R.id.Reset).setVisible(true);

        super.onPrepareOptionsMenu(menu);
    }

    // this method is used to call reCalculate method from RecordAdapterSimple;
    public static CalculatorFragment getInstance() {

        return instance;
    }


    public String getEdittextPrincipal(){

        return editTextPrincipalAmount.getText().toString();
    }

    public String getEditTextInterest(){

        return editTextInterestRate.getText().toString();
    }


    public String getYear(){

        return  editTextYear.getText().toString();
    }

    public String getMonth(){

     return  editTextMonth.getText().toString();
    }

    public String getDay(){

        return  editTextDay.getText().toString();
    }

}