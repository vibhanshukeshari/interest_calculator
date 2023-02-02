package com.calculator.interestcalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder>{


    private final ArrayList<RecordModal> recordModalArrayList;

    public RecordAdapter(ArrayList<RecordModal> currencyModalArrayList, Context context) {
        this.recordModalArrayList = currencyModalArrayList;

    }


    @NonNull
    @Override
    public RecordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_rv_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecordAdapter.ViewHolder holder, int position) {

        RecordModal modal = recordModalArrayList.get(position);

        holder.name.setText(modal.getName());
        holder.typeSorC.setText(modal.getTypeSorC());
        holder.date.setText(modal.getDate());
        holder.principalAmount.setText(modal.getPrincipalAmount());
        holder.interestRate.setText(modal.getInterestRate());
        holder.interestFrequency.setText(modal.getInterestRateFrequency());
        holder.year.setText(modal.getYears());
        holder.month.setText(modal.getMonths());
        holder.day.setText(modal.getDays());
        holder.compoundingFrequency.setText(modal.getCompoundingFrequency());
        holder.interestAmount.setText(modal.getInterestAmount());
        holder.totalAmount.setText(modal.getTotalAmount());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return recordModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {



        private final TextView name;
        private final TextView typeSorC;
        private final TextView date;
        private final TextView principalAmount;
        private final TextView interestRate;
        private final TextView interestFrequency;
        private final TextView year;
        private final TextView month;
        private final TextView day;
        private final TextView compoundingFrequency;
        private final TextView interestAmount;
        private final TextView totalAmount;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.name);
        typeSorC = itemView.findViewById(R.id.type_SorC);
        date = itemView.findViewById(R.id.date);
        principalAmount = itemView.findViewById(R.id.principal_amount);
        interestRate = itemView.findViewById(R.id.interest_rate);
        interestFrequency = itemView.findViewById(R.id.interest_frequency);
        year = itemView.findViewById(R.id.year);
        month = itemView.findViewById(R.id.month);
        day = itemView.findViewById(R.id.day);
        compoundingFrequency = itemView.findViewById(R.id.compounding_frequency);
        interestAmount = itemView.findViewById(R.id.interest_amount);
        totalAmount = itemView.findViewById(R.id.total_amount);






        }
    }
}
