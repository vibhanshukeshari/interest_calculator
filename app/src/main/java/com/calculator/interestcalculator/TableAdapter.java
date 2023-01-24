package com.calculator.interestcalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @Override
    public void onBindViewHolder(@NonNull TableAdapter.ViewHolder holder, int position) {
        if(tableModelList != null && tableModelList.size() > 0) {
            TableModel tableModel = tableModelList.get(position);
            holder.yearTextView.setText(String.valueOf(tableModel.getYear()));
            holder.interestTextView.setText(String.valueOf(tableModel.getInterest()));
            holder.accruedTextView.setText(String.valueOf(tableModel.getAccruedInterest()));
            holder.balanceTextView.setText(String.valueOf(tableModel.getBalance()));
        }

    }

    @Override
    public int getItemCount() {
        return tableModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView yearTextView,interestTextView,accruedTextView,balanceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            yearTextView = itemView.findViewById(R.id.text_view_year);
            interestTextView = itemView.findViewById(R.id.text_view_interest);
            accruedTextView = itemView.findViewById(R.id.text_view_accrued_interest);
            balanceTextView = itemView.findViewById(R.id.text_view_balance);
        }
    }
}
