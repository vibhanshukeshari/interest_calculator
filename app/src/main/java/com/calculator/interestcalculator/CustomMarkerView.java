package com.calculator.interestcalculator;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

public class CustomMarkerView extends MarkerView {


    private  TextView textViewMarkerYear;
    private View viewMarkerColor;
    private TextView textViewMarkerPrincipal;
    private TextView tvContent;

    public CustomMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        // this markerview only displays a textview

        textViewMarkerYear = findViewById(R.id.text_view_marker_year);
        viewMarkerColor = findViewById(R.id.view_marker_color);
        textViewMarkerPrincipal = findViewById(R.id.text_view_marker_principal);
        tvContent = findViewById(R.id.tvContent);

    }

    // callbacks everytime the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        if (e instanceof BarEntry) {
            BarEntry be = (BarEntry) e;

            if(be.getYVals() != null) {

                double stackNumber = (be.getYVals()[highlight.getStackIndex()]);

                CalculatorFragment.numberFormatterWithSymbol.setNumber(stackNumber);
                String numberAfterFormatted = CalculatorFragment.numberFormatterWithSymbol.getNumberAfterFormat();

                if(highlight.getStackIndex() == 0){
                    textViewMarkerYear.setText("" + (int)e.getX() + "Y" );
                    viewMarkerColor.setBackground(getResources().getDrawable(R.drawable.view_marker_color_border));
                    textViewMarkerPrincipal.setText("Principal Amount: ");
                    tvContent.setText(numberAfterFormatted);

                } else {

                        textViewMarkerYear.setText("" + (int)e.getX() + "Y" );
                        viewMarkerColor.setBackground(getResources().getDrawable(R.drawable.view_marker_border_interest));
                        textViewMarkerPrincipal.setText("Accrued Interest: ");
                        tvContent.setText(numberAfterFormatted);

                }

            } else {

//                double stackNumber =be.getY();
//
//                CalculatorFragment.numberFormatterWithSymbol.setNumber(stackNumber);
//                String numberAfterFormatted = CalculatorFragment.numberFormatterWithSymbol.getNumberAfterFormat();


//                tvContent.setText("" + numberAfterFormatted);
            }
        } else {

//            double stackNumber =e.getY();
//
//            CalculatorFragment.numberFormatterWithSymbol.setNumber(stackNumber);
//            String numberAfterFormatted = CalculatorFragment.numberFormatterWithSymbol.getNumberAfterFormat();

//            tvContent.setText("" + numberAfterFormatted);
        }
        super.refreshContent(e, highlight);
    }

@Override
public MPPointF getOffset() {
    return new MPPointF(-(getWidth() / 2), -getHeight());
}

}