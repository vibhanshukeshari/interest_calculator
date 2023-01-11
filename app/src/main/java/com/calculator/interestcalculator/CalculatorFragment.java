package com.calculator.interestcalculator;
import static com.robinhood.ticker.TickerView.ScrollingDirection.ANY;
import static com.robinhood.ticker.TickerView.ScrollingDirection.DOWN;
import static com.robinhood.ticker.TickerView.ScrollingDirection.UP;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class CalculatorFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    View view;

    String[] rateType = {"Yearly", "Monthly", "Weekly", "Daily", "Half-Yearly", "Quarterly", "Bi-Annually"};
    String[] compoundingFrequency = {"Yearly", "Monthly", "Weekly", "Daily", "Half-Yearly", "Quarterly"};

    private static String countryName;
    private static String countrySymbol;
    private static String countryCurrency;
    static boolean interestRatePercentageSelected = true;
    private  int simpleInteresetSpinnerRateType;
    private  int compoundInterestSpinnerFrequency;
    private double principalAmount;
    private double principalAmountOldvalue = 0;
    private int rateTypePercentageOrAmount;
    private int compoundInterestFrequency;

    private double interestRate;
//    private double time;
    private double totalSimpleInterestAmount;
    private double totalCompoundInterestAmount;
    private double year;
    private double month;
    private double day;
    private double fromDate;
    private double toDate;
    private boolean btnSimpleCompoundStatus = true;

    SimpleInterest simpleInterest;
    CompoundInterest compoundInterest;

    PieChart pieChart;
    BarChart mChart1;


    public static boolean fromClicked = false;
    public static boolean toClicked = false;

    LinearLayout linearLayoutDate, linearLayoutDuration, linearLayoutDurationBottomLine, linearLayoutCompoundingFrequency;
    Spinner spinnerInterestRatePeriod, spinnerCompoundingFrequency, spinnerInterestRateType;
    EditText editTextPrincipalAmount,editTextInterestRate,editTextYear,editTextMonth,editTextDay,fromDateEditText, toDateEditText;
    TextView textViewResultPrincipal,textViewInterestAmount,textViewTotalAmount, textViewCompoundingFrequency, textViewInterestRateType;
    ArrayAdapter<String> aa, arrayAdapter, arrayAdapterInterestRateType;
    Button btnCompound, btnSimple;
    TextView textViewFooterTotalAmount;

    TextInputLayout editTextLayoutInterestRate;

    TextView textViewPieChartLable;

    RadioButton radioButtonDuration, radioButtonDate;

    TickerView textViewPrincipalAmount;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_calculator, container, false);

        spinnerInterestRatePeriod = view.findViewById(R.id.spinner_interest_rate_period);
        spinnerInterestRatePeriod.setOnItemSelectedListener(this);

        spinnerCompoundingFrequency = view.findViewById(R.id.spinner_compounding_frequency);
        spinnerCompoundingFrequency.setOnItemSelectedListener(this);

        spinnerInterestRateType = view.findViewById(R.id.spinner_interest_rate_type);
        spinnerInterestRateType.setOnItemSelectedListener(this);

        editTextPrincipalAmount = view.findViewById(R.id.edit_text_principal_amount);
        editTextInterestRate = view.findViewById(R.id.edit_text_interest_rate);
        editTextYear = view.findViewById(R.id.edit_text_year);
        editTextMonth  = view.findViewById(R.id.edit_text_month);
        editTextDay = view.findViewById(R.id.edit_text_day);
        fromDateEditText = view.findViewById(R.id.from_date_editText);
        toDateEditText = view.findViewById(R.id.to_date_editText);

        textViewPieChartLable = view.findViewById(R.id.textView_pie_chart_lable);

        radioButtonDuration = view.findViewById(R.id.radio_button_duration);
        radioButtonDate = view.findViewById(R.id.radio_button_date);

        linearLayoutDate = view.findViewById(R.id.linear_layout_date);
        linearLayoutDuration = view.findViewById(R.id.linear_layout_duration);

        linearLayoutDurationBottomLine = view.findViewById(R.id.duration_bottom_line);

        linearLayoutCompoundingFrequency = view.findViewById(R.id.linear_layout_compounding_frequency);

        textViewPrincipalAmount = view.findViewById(R.id.text_view_principal_amount);
        textViewPrincipalAmount.setCharacterLists(TickerUtils.provideNumberList());

        textViewPrincipalAmount.setPreferredScrollingDirection(TickerView.ScrollingDirection.DOWN);

        textViewInterestAmount = view.findViewById(R.id.text_view_interest_amount);
        textViewTotalAmount = view.findViewById(R.id.text_view_total_amount);
        textViewResultPrincipal = view.findViewById(R.id.text_view_result_principal);
        textViewCompoundingFrequency = view.findViewById(R.id.text_view_compounding_frequency);
        textViewInterestRateType = view.findViewById(R.id.text_view_interest_rate_type);

        btnCompound = requireActivity().findViewById(R.id.btn_compound_interest);
        btnSimple = requireActivity().findViewById(R.id.btn_simple_interest);

        textViewFooterTotalAmount = requireActivity().findViewById(R.id.text_view_footer_total_amount);


        editTextLayoutInterestRate = view.findViewById(R.id.edit_text_layout_interest_rate);

        ArrayList<String> arrayListInterestRateType = new ArrayList<>();
        arrayListInterestRateType.add("Percentage (%)");

        pieChart = view.findViewById(R.id.pieChart);

        mChart1 = view.findViewById(R.id.bar_chart1);


//        simpleInterest = new SimpleInterest();
//        compoundInterest = new CompoundInterest();












        //Creating the ArrayAdapter instance having the interest rate type
        aa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, rateType);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerInterestRatePeriod.setAdapter(aa);

        //Creating the ArrayAdapter instance having the interest rate type
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, compoundingFrequency);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerCompoundingFrequency.setAdapter(arrayAdapter);

        //Creating the ArrayAdapter instance having the interest rate type
        arrayAdapterInterestRateType = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayListInterestRateType);
        arrayAdapterInterestRateType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerInterestRateType.setAdapter(arrayAdapterInterestRateType);

        linearLayoutDate.setVisibility(View.GONE);
        linearLayoutCompoundingFrequency.setVisibility(View.GONE);

        textViewCompoundingFrequency.setSelected(true);
        textViewInterestRateType.setSelected(true);

        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnSimpleCompoundStatus = true;
                textViewPieChartLable.setText("Simple Interest");


                if(!editTextPrincipalAmount.getText().toString().equals("") &&
                        !editTextInterestRate.getText().toString().equals("") &&
                        !editTextYear.getText().toString().equals("")) {

//                    upDateData();
                    getSetViews();

                }





                    try {

                    btnSimple.setBackgroundColor(Color.parseColor("#1da1f3"));
                    btnSimple.setTextColor(Color.parseColor("#ffffff"));
                    btnSimple.setCompoundDrawablesWithIntrinsicBounds(R.drawable.simple_icon, 0, 0, 0);


                    btnCompound.setBackgroundColor(Color.parseColor("#15202b"));
                    btnCompound.setTextColor(Color.parseColor("#8899a6"));
                    btnCompound.setCompoundDrawablesWithIntrinsicBounds(R.drawable.compound_icon_unchecked, 0, 0, 0);
                    linearLayoutCompoundingFrequency.setVisibility(View.GONE);


                } catch (NullPointerException ignored) {
                }

            }
        });

        btnCompound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnSimpleCompoundStatus = false;
//                tickerView.setPaintFlags(1);
//                tickerView.setPreferredScrollingDirection(ANY);

//                tickerView.setText("" + (--a[0]));


                if(!editTextPrincipalAmount.getText().toString().equals("") &&
                        !editTextInterestRate.getText().toString().equals("") &&
                        !editTextYear.getText().toString().equals("")) {

//                    upDateData();
                    getSetViews();

                }




                textViewPieChartLable.setText("Compound Interest");
                try {

                    btnCompound.setBackgroundColor(Color.parseColor("#1da1f3"));
                    btnCompound.setTextColor(Color.parseColor("#ffffff"));
                    btnCompound.setCompoundDrawablesWithIntrinsicBounds(R.drawable.compound_icon, 0, 0, 0);
                    linearLayoutCompoundingFrequency.setVisibility(View.VISIBLE);
                    linearLayoutDurationBottomLine.setVisibility(View.GONE);

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

            }
        });

        toDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");
                toClicked = true;

            }
        });


        radioButtonDuration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linearLayoutDate.setVisibility(View.GONE);
                linearLayoutDuration.setVisibility(View.VISIBLE);
                linearLayoutDurationBottomLine.setVisibility(View.GONE);

            }
        });

        if (radioButtonDuration.isChecked()) {
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

                linearLayoutDuration.setVisibility(View.GONE);
                linearLayoutDate.setVisibility(View.VISIBLE);
                linearLayoutDurationBottomLine.setVisibility(View.GONE);

            }
        });

       //BarGraph
//        MultipalColor();

        // PieChart
        setupPieChart();
        loadPieChartData();

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

                spinnerInterestRateType.setAdapter(arrayAdapterInterestRateType);


                ((MainActivity) Objects.requireNonNull(requireActivity())).textViewCurrencySymbol.setText(countrySymbol);

                if (interestRatePercentageSelected) {


                    editTextLayoutInterestRate.setHint("Interest Rate (%)");
                    interestRatePercentageSelected = true;


                } else {
                    editTextLayoutInterestRate.setHint("Interest Rate (" + countrySymbol + ")");


// It is called again to reset the spinner data because when currency was set and country was getting selected, selected spinner value was not changing;

                    interestRatePercentageSelected = false;


                }


            }
        });


        arrayListInterestRateType.add(countryCurrency + " (" + countrySymbol + ")");


//        ------------------------------------------------------------------------------------------------------------------------

        spinnerInterestRateType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if (i == 0) {

                    simpleInteresetSpinnerRateType = 0;
                    editTextLayoutInterestRate.setHint("Interest Rate (%)");
                    interestRatePercentageSelected = true;

                } else if (i == 1) {

                    simpleInteresetSpinnerRateType = 1;
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
                
                compoundInterestFrequency = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




































//        if(!editTextPrincipalAmount.getText().toString().equals("") &&
//                !editTextInterestRate.getText().toString().equals("") &&
//                !editTextYear.getText().toString().equals("")){
//
//
//            principalAmount = Double.parseDouble(editTextPrincipalAmount.getText().toString());
//        Toast.makeText(getContext(), String.valueOf(principalAmount), Toast.LENGTH_SHORT).show();
//            interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
//            year = Double.parseDouble(editTextYear.getText().toString());
//
//            simpleInterest.setPrincipal(principalAmount);
//            simpleInterest.setRateType(rateTypePercentageOrAmount);
//            simpleInterest.setRate(interestRate);
//            totalInterestAmount = simpleInterest.getTotalSimpleInterestAmount();
//
//
//            compoundInterest.setPrincipal(principalAmount);
//            compoundInterest.setRate(rateTypePercentageOrAmount);
//            compoundInterest.setRate(interestRate);
//            compoundInterest.setCompoundingFrequency(compoundInterestFrequency);
//            totalInterestAmount = compoundInterest.getTotalCompoundInterestAmount();
//
//
//            textViewPrincipalAmount.setText(String.valueOf(principalAmount));
//            textViewInterestAmount.setText(String.valueOf(totalInterestAmount));
//            textViewTotalAmount.setText(String.valueOf(principalAmount + totalInterestAmount));
//            textViewFooterTotalAmount.setText(String.valueOf(principalAmount + totalInterestAmount));
//



//        }
//
//
//        rateTypePercentageOrAmount = getSpinnerInterestRateType();
//        compoundInterestFrequency = getSpinnerCompoundingFrequency();
//


//--------------------------------------Text Watcher----------------------------------------------------------------


        editTextPrincipalAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                //
                if(!editTextPrincipalAmount.getText().toString().equals("") &&
                        !editTextInterestRate.getText().toString().equals("") &&
                        !editTextYear.getText().toString().equals("")) {

                    getSetViews();
//                    upDateData();
//                    MultipalColor();

//                    Toast.makeText(getContext(), "hi", Toast.LENGTH_SHORT).show();
                }
//
//            principalAmount = Double.parseDouble(editTextPrincipalAmount.getText().toString());
//            interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
//            year = Double.parseDouble(editTextYear.getText().toString());
//

//            simpleInterest.setPrincipal(principalAmount);
//            simpleInterest.setRateType(rateTypePercentageOrAmount);
//            simpleInterest.setRate(interestRate);
//            totalInterestAmount = simpleInterest.getTotalSimpleInterestAmount();


//            textViewPrincipalAmount.setText(String.valueOf(principalAmount));
//            textViewInterestAmount.setText(String.valueOf(totalInterestAmount));
//            textViewTotalAmount.setText(String.valueOf(principalAmount + totalInterestAmount));
//            textViewFooterTotalAmount.setText(String.valueOf(principalAmount + totalInterestAmount));
//

//        }
//
//
//            principalAmount = Double.parseDouble(editTextPrincipalAmount.getText().toString());
////        Toast.makeText(getContext(), String.valueOf(principalAmount), Toast.LENGTH_SHORT).show();
//            interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
//            year = Double.parseDouble(editTextYear.getText().toString());
//
//            simpleInterest.setPrincipal(principalAmount);
//            simpleInterest.setRateType(rateTypePercentageOrAmount);
//            simpleInterest.setRate(interestRate);
//            totalInterestAmount = simpleInterest.getTotalSimpleInterestAmount();
//
//
//            compoundInterest.setPrincipal(principalAmount);
//            compoundInterest.setRate(rateTypePercentageOrAmount);
//            compoundInterest.setRate(interestRate);
//            compoundInterest.setCompoundingFrequency(compoundInterestFrequency);
//            totalInterestAmount = compoundInterest.getTotalCompoundInterestAmount();
//
//
//            textViewPrincipalAmount.setText(String.valueOf(principalAmount));
//            textViewInterestAmount.setText(String.valueOf(totalInterestAmount));
//            textViewTotalAmount.setText(String.valueOf(principalAmount + totalInterestAmount));
//            textViewFooterTotalAmount.setText(String.valueOf(principalAmount + totalInterestAmount));
//
//
//
//
//        }
//
//
//        rateTypePercentageOrAmount = getSpinnerInterestRateType();
//        compoundInterestFrequency = getSpinnerCompoundingFrequency();
//



































            }

            @Override
            public void afterTextChanged(Editable editable) {
//                upDateData();


            }
        });



//-------------------------------------------------------------------------------------------------------------------------








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
        entries.add(new PieEntry((float) principalAmount, "Principal Amount"));
        entries.add(new PieEntry((float) totalSimpleInterestAmount, "Total Interest"));

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.parseColor("#080b10"));
        colors.add(Color.parseColor("#1da1f3"));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
        pieChart.invalidate();

        pieChart.animateY(1400, Easing.EaseInOutQuad);
    }

    private void setupPieChart() {
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setEntryLabelColor(Color.parseColor("#000000"));

        if(btnSimpleCompoundStatus){

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

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart1.setMaxVisibleValueCount(40);

        // scaling can now only be done on x- and y-axis separately
        mChart1.setPinchZoom(true);
        mChart1.setDrawGridBackground(false);
        mChart1.setDrawBarShadow(false);

        mChart1.setDrawValueAboveBar(false);
        mChart1.setHighlightFullBarEnabled(false);

        mChart1.animateY(1400, Easing.EaseInOutQuad);

        mChart1.getXAxis().setGridColor(Color.parseColor("#8899a6"));
        mChart1.getXAxis().setAxisLineColor(Color.parseColor("#8899a6"));
        mChart1.getAxisLeft().setAxisLineColor(Color.parseColor("#8899a6"));

        // change the position of the y-labels
        YAxis leftAxis = mChart1.getAxisLeft();

        leftAxis.setGridColor(Color.parseColor("#8899a6"));

        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        mChart1.getAxisRight().setEnabled(false);

        XAxis xLabels = mChart1.getXAxis();
        xLabels.setPosition(XAxis.XAxisPosition.TOP);

        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("");
        xAxisLabel.add("1y");
        xAxisLabel.add("2Y");
        xAxisLabel.add("3Y");
        xAxisLabel.add("4Y");
        xAxisLabel.add("5Y");
        xAxisLabel.add("6y");
        xAxisLabel.add("7y");
        xAxisLabel.add("8y");
        xAxisLabel.add("9y");
        xAxisLabel.add("10y");
        xAxisLabel.add("11y");
        xAxisLabel.add("12y");
        xAxisLabel.add("13y");
        xAxisLabel.add("14y");
        xAxisLabel.add("15y");
        xAxisLabel.add("16y");
        xAxisLabel.add("17y");
        xAxisLabel.add("18y");
        xAxisLabel.add("19y");
        xAxisLabel.add("20y");
        xAxisLabel.add("21y");
        xAxisLabel.add("22y");
        xAxisLabel.add("23y");
        xAxisLabel.add("24y");
        xAxisLabel.add("25y");
        xAxisLabel.add("26y");
        xAxisLabel.add("27y");
        xAxisLabel.add("28y");
        xAxisLabel.add("29y");
        xAxisLabel.add("30y");
        xAxisLabel.add("31y");
        xAxisLabel.add("32y");
        xAxisLabel.add("33y");
        xAxisLabel.add("34y");
        xAxisLabel.add("35y");
        xAxisLabel.add("36y");
        xAxisLabel.add("37y");
        xAxisLabel.add("38y");
        xAxisLabel.add("39y");
        xAxisLabel.add("40y");
        xAxisLabel.add("41y");
        xAxisLabel.add("42y");
        xAxisLabel.add("42y");
        xAxisLabel.add("44y");
        xAxisLabel.add("45y");
        xAxisLabel.add("46y");
        xAxisLabel.add("47y");
        xAxisLabel.add("48y");
        xAxisLabel.add("49y");
        xAxisLabel.add("50y");
        xAxisLabel.add("51y");
        xAxisLabel.add("52y");
        xAxisLabel.add("53y");
        xAxisLabel.add("54y");
        xAxisLabel.add("55y");
        xAxisLabel.add("56y");
        xAxisLabel.add("57y");
        xAxisLabel.add("58y");
        xAxisLabel.add("59y");
        xAxisLabel.add("60y");
        xAxisLabel.add("61y");
        xAxisLabel.add("62y");
        xAxisLabel.add("63y");
        xAxisLabel.add("64y");
        xAxisLabel.add("65y");
        xAxisLabel.add("66y");
        xAxisLabel.add("67y");
        xAxisLabel.add("68y");
        xAxisLabel.add("69y");
        xAxisLabel.add("70y");
        xAxisLabel.add("71y");
        xAxisLabel.add("72y");
        xAxisLabel.add("73y");
        xAxisLabel.add("74y");
        xAxisLabel.add("75y");
        xAxisLabel.add("76y");
        xAxisLabel.add("77y");
        xAxisLabel.add("78y");
        xAxisLabel.add("79y");
        xAxisLabel.add("80y");
        xAxisLabel.add("81y");
        xAxisLabel.add("82y");
        xAxisLabel.add("83y");
        xAxisLabel.add("84y");
        xAxisLabel.add("85y");
        xAxisLabel.add("86y");
        xAxisLabel.add("87y");
        xAxisLabel.add("88y");
        xAxisLabel.add("89y");
        xAxisLabel.add("90y");
        xAxisLabel.add("91y");
        xAxisLabel.add("92y");
        xAxisLabel.add("93y");
        xAxisLabel.add("94y");
        xAxisLabel.add("95y");
        xAxisLabel.add("96y");
        xAxisLabel.add("97y");
        xAxisLabel.add("98y");
        xAxisLabel.add("99y");
        xAxisLabel.add("100y");


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




//        getSetViews();



        for (int time = 1; time < year + 1; time++) {

            if(btnSimpleCompoundStatus){


                simpleInterest.setTime(time);
                totalSimpleInterestAmount = simpleInterest.getTotalSimpleInterestAmount();


                setSimpleInterestText();


                yVals1.add(new BarEntry(time,
                        new float[]{(float) principalAmount, (float) totalSimpleInterestAmount},
                        getResources().getDrawable(R.drawable.ic_baseline_feedback_24)));

            } else {
                compoundInterest.setTime(time);
                totalCompoundInterestAmount = compoundInterest.getTotalCompoundInterestAmount();

               setCompoundInterestText();
//                Toast.makeText(getContext(), String.valueOf(totalInterestAmount), Toast.LENGTH_SHORT).show();

                yVals1.add(new BarEntry(time,
                        new float[]{(float) principalAmount, (float) (totalCompoundInterestAmount - principalAmount)},
                        getResources().getDrawable(R.drawable.ic_baseline_feedback_24)));

            }



        }

            leftAxis.setValueFormatter(new LargeValueFormatter());

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

//            if( principal >9999999.0){

                data.setValueFormatter(new LargeValueFormatter());

//            }
            data.setValueTextColor(Color.WHITE);

            mChart1.setData(data);
        }

        mChart1.getLegend().setEnabled(false);
        mChart1.getLegend().setDrawInside(false);
        mChart1.setFitBars(true);
        mChart1.invalidate();
    }

    private ArrayList<Integer> getColors() {

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.parseColor("#080b10"));
        colors.add(Color.parseColor("#1da1f3"));


        return colors;
    }

    public int getSpinnerInterestRateType() {

        return simpleInteresetSpinnerRateType;

    }
    
    public int getSpinnerCompoundingFrequency(){
        return compoundInterestSpinnerFrequency;
    }

    public void textWatcherPrincipalAmount(){

//                Toast.makeText(getContext(), "true", Toast.LENGTH_SHORT).show();




        if(!editTextPrincipalAmount.getText().toString().equals("")
                && !editTextInterestRate.getText().toString().equals("")
                && !editTextYear.getText().toString().equals("")){

     getSetViews();

        }


    }

    public void upDateData(){

        MultipalColor();
        loadPieChartData();
        setupPieChart();

    }

    public void getSetViews(){

        simpleInterest = new SimpleInterest();
        compoundInterest = new CompoundInterest();

        // trick for comparing old and new value to ticker
        principalAmountOldvalue = principalAmount;
        principalAmount = Double.parseDouble(editTextPrincipalAmount.getText().toString());


//        principalAmountOldvalue = 0;


        Toast.makeText(getContext(), String.valueOf(principalAmountOldvalue), Toast.LENGTH_SHORT).show();
        interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
        year = Double.parseDouble(editTextYear.getText().toString());

        simpleInterest.setPrincipal(principalAmount);
        simpleInterest.setRateType(rateTypePercentageOrAmount);
        simpleInterest.setRate(interestRate);


        compoundInterest.setPrincipal(principalAmount);
        compoundInterest.setRate(rateTypePercentageOrAmount);
        compoundInterest.setRate(interestRate);
        compoundInterest.setCompoundingFrequency(compoundInterestFrequency);


        if(principalAmountOldvalue < principalAmount){


            textViewPrincipalAmount.setPreferredScrollingDirection(DOWN);
            Toast.makeText(getContext(), "true", Toast.LENGTH_SHORT).show();

            for ( double i = principalAmountOldvalue ; i <= principalAmount; i++) {
                textViewPrincipalAmount.setText(String.valueOf(i));

            }


        }else {

            textViewPrincipalAmount.setPreferredScrollingDirection(UP);

            for ( double i = principalAmount ; i <= principalAmountOldvalue; i++) {
                textViewPrincipalAmount.setText(String.valueOf(i));

            }

        }





        rateTypePercentageOrAmount = getSpinnerInterestRateType();
        compoundInterestFrequency = getSpinnerCompoundingFrequency();

        upDateData();

    }

    private void setSimpleInterestText() {


                textViewInterestAmount.setText(String.valueOf(totalSimpleInterestAmount));
                textViewTotalAmount.setText(String.valueOf(principalAmount + totalSimpleInterestAmount));
                textViewFooterTotalAmount.setText(String.valueOf(principalAmount + totalSimpleInterestAmount));

    }

    private void setCompoundInterestText(){


        textViewInterestAmount.setText(new DecimalFormat("##.##").format(totalCompoundInterestAmount - principalAmount));
        textViewTotalAmount.setText(new DecimalFormat("##.##").format(totalCompoundInterestAmount));
        textViewFooterTotalAmount.setText(new DecimalFormat("##.##").format(totalCompoundInterestAmount));

    }

}

