package com.calculator.interestcalculator;

import static com.calculator.interestcalculator.CalculatorFragment.btnSimpleCompoundStatus;
import static com.calculator.interestcalculator.MainActivity.simpleArrayListSize;
import static com.calculator.interestcalculator.RecordFragment.imageViewNotFound;
import static com.calculator.interestcalculator.RecordFragment.isRecordVisible;
import static com.github.mikephil.charting.utils.Utils.getPosition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class RecordAdapterSimple extends RecyclerView.Adapter<RecordAdapterSimple.ViewHolder>{


    private final ArrayList<RecordModalSimple> recordModalArrayListSimple;
    private final Context context;
//    private  ImageButton btnImageMoreThreeDots;

    public RecordAdapterSimple(ArrayList<RecordModalSimple> recordModalArrayListSimple, Context context) {
        this.recordModalArrayListSimple = recordModalArrayListSimple;
        this.context = context;

    }


    @NonNull
    @Override
    public RecordAdapterSimple.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_rv_item_layout_simple, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecordAdapterSimple.ViewHolder holder, int position) {


        RecordModalSimple recordModalSimple = recordModalArrayListSimple.get(holder.getAdapterPosition());
//        RecordModalSimple modal = recordModalArrayListSimple.get(position);




//        if(simpleArrayListSize == 0 && btnSimpleCompoundStatus &&  isRecordVisible == true){
//            imageViewNotFound.setVisibility(View.VISIBLE);
//
//        } else {
//            imageViewNotFound.setVisibility(View.GONE);
//        }



        holder.name.setText(recordModalSimple.getName());
        holder.typeSorC.setText(recordModalSimple.getTypeSorC());
        holder.date.setText(recordModalSimple.getDate());
        holder.principalAmount.setText(recordModalSimple.getPrincipalAmount());
        holder.interestRate.setText(recordModalSimple.getInterestRate());
        holder.interestFrequency.setText(recordModalSimple.getInterestRateFrequency());
        holder.year.setText(recordModalSimple.getYears());
        holder.month.setText(recordModalSimple.getMonths());
        holder.day.setText(recordModalSimple.getDays());
        holder.interestAmount.setText(recordModalSimple.getInterestAmount());
        holder.totalAmount.setText(recordModalSimple.getTotalAmount());
        holder.timeAsUniqueId.setText(recordModalSimple.getTimeAsUniqueId());



        holder.imgButtonDeleteSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                MaterialAlertDialogBuilder alertDialoBuider = new MaterialAlertDialogBuilder(view.getContext(), R.style.alertDialog);
                alertDialoBuider.setTitle("Confirm Delete !");
                alertDialoBuider.setIcon(R.drawable.delete_simple_warning_icon);
                alertDialoBuider.setMessage("Are you sure you want to delete ?");


                alertDialoBuider.setPositiveButton("Delete !", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        DBHandlerSimple dbSimple = new DBHandlerSimple(context);

                        String timeAsUniqueId = holder.timeAsUniqueId.getText().toString();

                        dbSimple.deleteRecordSimple(timeAsUniqueId);
                        dbSimple.close();



                        recordModalArrayListSimple.remove(holder.getAdapterPosition());
                        notifyItemRemoved(holder.getAdapterPosition());
//                        notifyDataSetChanged();





//                        Toast toast = Toast.makeText(view.getContext(), "Item Deleted.", Toast.LENGTH_SHORT);
//                        View view1 = toast.getView();
//
//                        try {
//
//                            TextView textView = toast.getView().findViewById(android.R.id.message);
//                            textView.setTextColor(Color.parseColor("#ffffff"));
//
//                        } catch (NullPointerException ignored) {
//                        }
//
//                        try {
//                            assert view1 != null;
//                            view1.getBackground().setColorFilter(Color.parseColor("#10171f"), PorterDuff.Mode.SRC_IN);
//                        } catch (NullPointerException ignored) {
//                        }
//                        toast.show();





                        Toast toast1 = new Toast(context);
                        toast1.setDuration(Toast.LENGTH_SHORT);
                        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.my_toast, null);
                        toast1.setView(view);
                        toast1.show();




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
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#A52121"));
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#8899a6"));


            }
        });















    }


//    @Override
//    public long getItemId(int position) {
//        return super.getItemId(position);
//    }

    @Override
    public int getItemCount() {
        simpleArrayListSize = recordModalArrayListSimple.size();


//        if(simpleArrayListSize ==0 && isRecordVisible && btnSimpleCompoundStatus){
//
//            imageViewNotFound.setVisibility(View.VISIBLE);
//
//        }
//



        if(simpleArrayListSize == 0 && isRecordVisible && btnSimpleCompoundStatus){
            imageViewNotFound.setVisibility(View.VISIBLE);
        } else if(simpleArrayListSize > 0 && isRecordVisible && btnSimpleCompoundStatus){
            imageViewNotFound.setVisibility(View.GONE);
        }



        return recordModalArrayListSimple.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {



        private final ImageButton imgButtonDeleteSimple;

        private final TextView name;
        private final TextView typeSorC;
        private final TextView date;
        private final TextView principalAmount;
        private final TextView interestRate;
        private final TextView interestFrequency;
        private final TextView year;
        private final TextView month;
        private final TextView day;
        private final TextView interestAmount;
        private final TextView totalAmount;
        private final TextView timeAsUniqueId;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            imgButtonDeleteSimple = itemView.findViewById(R.id.deleteSimple);

            name = itemView.findViewById(R.id.name);
            typeSorC = itemView.findViewById(R.id.type_SorC);
            date = itemView.findViewById(R.id.date);
            principalAmount = itemView.findViewById(R.id.principal_amount);
            interestRate = itemView.findViewById(R.id.interest_rate);
            interestFrequency = itemView.findViewById(R.id.interest_frequency);
            year = itemView.findViewById(R.id.year);
            month = itemView.findViewById(R.id.month);
            day = itemView.findViewById(R.id.day);
            interestAmount = itemView.findViewById(R.id.interest_amount);
            totalAmount = itemView.findViewById(R.id.total_amount);
            timeAsUniqueId = itemView.findViewById(R.id.time_as_unique_id);






        }
    }
}
