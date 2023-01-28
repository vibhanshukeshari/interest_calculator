package com.calculator.interestcalculator;

import static com.calculator.interestcalculator.CalculatorFragment.myYearForTableAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder>{

    Context context;
    List<TableModel> tableModelList;

    public TableAdapter(Context context, List<TableModel> tableModelList) {
        this.context = context;
        this.tableModelList = tableModelList;
    }


    @NonNull
    @Override
    public TableAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.table_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull TableAdapter.ViewHolder holder, int position) {
        if(tableModelList != null && tableModelList.size() > 0) {
            TableModel tableModel = tableModelList.get(position);
            holder.yearTextView.setText(String.valueOf(tableModel.getYear()));
            holder.interestTextView.setText(String.valueOf(tableModel.getInterest()));
            holder.accruedTextView.setText(String.valueOf(tableModel.getAccruedInterest()));
            holder.balanceTextView.setText(String.valueOf(tableModel.getBalance()));


            double fraction = myYearForTableAdapter % 1;



            if(tableModel.equals(tableModelList.get(0))) {

                holder.balanceTextView.setTextColor(Color.parseColor("#ffffff"));
                holder.balanceTextView.setTypeface(null, Typeface.BOLD);

            }


            if(fraction != 0 ){

                if(tableModel.equals(tableModelList.get((int) (myYearForTableAdapter + 1)))){


                    holder.linearLayoutTable_item_layout.setBackground(holder.linearLayoutTable_item_layout.getResources().getDrawable(R.drawable.footer_gradient_item_layout));
                    holder.balanceTextView.setTextColor(Color.parseColor("#ffffff"));
                    holder.balanceTextView.setTypeface(null, Typeface.BOLD);
                    holder.accruedTextView.setTextColor(Color.parseColor("#ffffff"));
                    holder.accruedTextView.setTypeface(null, Typeface.BOLD);
                    holder.yearTextView.setTypeface(null, Typeface.BOLD);
                    holder.yearTextView.setTextColor(Color.parseColor("#ffffff"));


                }
            } else {
                if (tableModel.equals(tableModelList.get((int) (myYearForTableAdapter)))) {


                    holder.linearLayoutTable_item_layout.setBackground(holder.linearLayoutTable_item_layout.getResources().getDrawable(R.drawable.footer_gradient_item_layout));
                    holder.balanceTextView.setTextColor(Color.parseColor("#ffffff"));
                    holder.balanceTextView.setTypeface(null, Typeface.BOLD);
                    holder.accruedTextView.setTextColor(Color.parseColor("#ffffff"));
                    holder.accruedTextView.setTypeface(null, Typeface.BOLD);
                    holder.yearTextView.setTypeface(null, Typeface.BOLD);
                    holder.yearTextView.setTextColor(Color.parseColor("#ffffff"));


                }

            }


        }

    }

    @Override
    public int getItemCount() {
        return tableModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView yearTextView,interestTextView,accruedTextView,balanceTextView;
        LinearLayout linearLayoutTable_item_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            yearTextView = itemView.findViewById(R.id.text_view_year);
            interestTextView = itemView.findViewById(R.id.text_view_interest);
            accruedTextView = itemView.findViewById(R.id.text_view_accrued_interest);
            balanceTextView = itemView.findViewById(R.id.text_view_balance);
            linearLayoutTable_item_layout = itemView.findViewById(R.id.linear_layout_table_item_layout);
        }
    }
}
