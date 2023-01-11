package com.calculator.interestcalculator;

import static com.calculator.interestcalculator.CalculatorFragment.fromClicked;
import static com.calculator.interestcalculator.CalculatorFragment.toClicked;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Objects;

public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),R.style.vibhuCalenderPickerTheme, this, yy, mm, dd);
    }

    public void onDateSet(DatePicker view, int yy, int mm, int dd) {
        populateSetDate(yy, mm+1, dd);
    }
    public void populateSetDate(int year, int month, int day) {
        EditText fromDateEditText,toDateEditText;
        fromDateEditText = requireActivity().findViewById(R.id.from_date_editText);
        toDateEditText = requireActivity().findViewById(R.id.to_date_editText);

        String fm=""+month;
        String fd =""+day;
        if(month < 10) {
            fm = "0" + month;
        }
        if(day < 10) {
            fd ="0" + day;
        }

        String date = fd+"/"+fm+"/"+year;

        if(fromClicked){
            fromDateEditText.setText(date);
            fromClicked = false;
        }

        if(toClicked){
            toDateEditText.setText(date);
            toClicked = false;
        }
    }


}