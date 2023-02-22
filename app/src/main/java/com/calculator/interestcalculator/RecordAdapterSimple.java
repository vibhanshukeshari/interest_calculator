package com.calculator.interestcalculator;

import static com.calculator.interestcalculator.CalculatorFragment.btnSimpleCompoundStatus;
import static com.calculator.interestcalculator.CalculatorFragment.commaOrPeriods;
import static com.calculator.interestcalculator.MainActivity.holderSimpleRecalculatePressed;
import static com.calculator.interestcalculator.MainActivity.simpleArrayListSize;
import static com.calculator.interestcalculator.RecordFragment.imageViewNotFound;
import static com.calculator.interestcalculator.RecordFragment.isRecordVisible;
import static com.github.mikephil.charting.utils.Utils.getPosition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.Serializable;
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


        holder.imgButtonReCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                CalculatorFragment myInstance = CalculatorFragment.getInstance();


//                System.out.println(myInstance.getYear());


                if ((!myInstance.getEdittextPrincipal().equals("") && !myInstance.getEditTextInterest().replaceAll("%", "").equals("")) &&
                        ((!myInstance.getYear().equals("") || !myInstance.getMonth().equals("") ||
                                !myInstance.getDay().equals("")))) {



                    MaterialAlertDialogBuilder alertDialoBuider = new MaterialAlertDialogBuilder(view.getContext(),R.style.alertDialog);
                    alertDialoBuider.setTitle("Warning !");
                    alertDialoBuider.setIcon(R.drawable.alert_24);
                    alertDialoBuider.setMessage("You have already fed some data, which will be lost !");

                    alertDialoBuider.setPositiveButton("Do anyway", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {


                            holderSimpleRecalculatePressed = true;

                            String myPrincipalOld = holder.principalAmount.getText().toString().replaceAll("[^\\d]","");
                            String myPrincipal = myPrincipalOld.substring(0,myPrincipalOld.length()-2);



                            String myInterest;
                            if(commaOrPeriods){
                                 myInterest = holder.interestRate.getText().toString().replace(",",".").replaceAll("[^\\d.]", "");

                            } else {
                                 myInterest = holder.interestRate.getText().toString().replace(".",",").replaceAll("[^\\d,]", "");

                            }

                            String myInterestFrequency = holder.interestFrequency.getText().toString();
                            String myYear = holder.year.getText().toString().replace("Y","");
                            String myMonth = holder.month.getText().toString().replace("M","");
                            String myDay = holder.day.getText().toString().replace("D","");



//                     it took one day to do like this before i was creating object of Calculator fragment which was wrong;
                            myInstance.reCalculate(myPrincipal,myInterest,myInterestFrequency, myYear, myMonth, myDay);














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
                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#1da1f3"));
                    alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#8899a6"));







                } else {


                    holderSimpleRecalculatePressed = true;


                    String myPrincipalOld = holder.principalAmount.getText().toString().replaceAll("[^\\d]","");
                    String myPrincipal = myPrincipalOld.substring(0,myPrincipalOld.length()-2);

                    String myInterest;
                    if(commaOrPeriods){
                        myInterest = holder.interestRate.getText().toString().replace(",",".").replaceAll("[^\\d.]", "");

                    } else {
                        myInterest = holder.interestRate.getText().toString().replace(".",",").replaceAll("[^\\d,]", "");

                    }
                    String myInterestFrequency = holder.interestFrequency.getText().toString();
                    String myYear = holder.year.getText().toString().replace("Y","");
                    String myMonth = holder.month.getText().toString().replace("M","");
                    String myDay = holder.day.getText().toString().replace("D","");




//                     it took one day to do like this before i was creating object of Calculator fragment which was wrong;
                    myInstance.reCalculate(myPrincipal,myInterest,myInterestFrequency, myYear, myMonth, myDay);






                }




//                    if((myInstance.getEdittextPrincipal().equals("") || myInstance.getEditTextInterest().equals(""))
//                && (myInstance.getYear().equals("") || myInstance.getMonth().equals("") || myInstance.getDay().equals(""))) {
//
//
//
//
//
//                } else {
//
//
//
//
//
//                }
//





            }
        });




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




        holder.imgButtonShareSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                scroll up karna hai


                String name = holder.name.getText().toString();
                String typeSorC = holder.typeSorC.getText().toString();
                String date = holder.date.getText().toString();
                String myPrincipal = holder.principalAmount.getText().toString();
                String myInterest = holder.interestRate.getText().toString();
                String myInterestFrequency = holder.interestFrequency.getText().toString();
                String myYear = holder.year.getText().toString();
                String myMonth = holder.month.getText().toString();
                String myDay = holder.day.getText().toString();
                String interestAmount = holder.interestAmount.getText().toString();
                String totalAmount = holder.totalAmount.getText().toString();





                StringBuilder forShare = new StringBuilder();


                // keep screen on feature have to use ;remember
                forShare.append("Interest Type : ").append(typeSorC);
                forShare.append('\n');
                forShare.append("Date : ").append(date);
                forShare.append('\n');

                forShare.append("Label : ").append(name);
                forShare.append('\n');
                forShare.append('\n');
                forShare.append("Principal Amount : " );
                forShare.append(myPrincipal);
                forShare.append('\n');
                forShare.append("Interest Rate : ");
                forShare.append(myInterest).append(myInterestFrequency);
                forShare.append('\n');
                forShare.append("Duration : ").append(myYear).append(" | ").append(myMonth).append(" | ").append(myDay);
                forShare.append('\n');
                forShare.append("Interest Amount : ").append(interestAmount);
                forShare.append('\n');
                forShare.append("Total Amount : ").append(totalAmount);
                forShare.append('\n');
                forShare.append('\n');
                forShare.append("https://play.google.com/store/apps/details?id=com.vibhunorby.totalpaisa");
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, (Serializable) forShare);
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);

            }


        });













    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {

        simpleArrayListSize = recordModalArrayListSimple.size();

        if(simpleArrayListSize == 0 && isRecordVisible && btnSimpleCompoundStatus){
            imageViewNotFound.setVisibility(View.VISIBLE);

        } else if(simpleArrayListSize > 0 && isRecordVisible && btnSimpleCompoundStatus){
            imageViewNotFound.setVisibility(View.GONE);

        }

        return recordModalArrayListSimple.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {




        private final ImageButton imgButtonDeleteSimple;
        private final ImageButton imgButtonReCalculate;
        private final ImageButton imgButtonShareSimple;

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
            imgButtonReCalculate = itemView.findViewById(R.id.reCalculate);
            imgButtonShareSimple = itemView.findViewById(R.id.image_btn_share_simple);

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
