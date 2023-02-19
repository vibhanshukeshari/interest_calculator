package com.calculator.interestcalculator;

import static com.calculator.interestcalculator.CalculatorFragment.btnSimpleCompoundStatus;
import static com.calculator.interestcalculator.CalculatorFragment.commaOrPeriods;
import static com.calculator.interestcalculator.MainActivity.compoundArrayListSize;
import static com.calculator.interestcalculator.MainActivity.holderSimpleRecalculatePressed;
import static com.calculator.interestcalculator.MainActivity.simpleArrayListSize;
import static com.calculator.interestcalculator.RecordFragment.imageViewNotFound;
import static com.calculator.interestcalculator.RecordFragment.isRecordVisible;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.Serializable;
import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder>{


    private final ArrayList<RecordModal> recordModalArrayList;
    private final Context context;
//    private  ImageButton btnImageMoreThreeDots;

    public RecordAdapter(ArrayList<RecordModal> recordModalArrayList, Context context) {
        this.recordModalArrayList = recordModalArrayList;
        this.context = context;

    }


    @NonNull
    @Override
    public RecordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_rv_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecordAdapter.ViewHolder holder, int position) {

        RecordModal modal = recordModalArrayList.get(holder.getAdapterPosition());

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
        holder.timeAsUniqueId.setText(modal.getTimeAsUniqueId());




        holder.imageButtonDeleteCompound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {










                MaterialAlertDialogBuilder alertDialoBuider = new MaterialAlertDialogBuilder(view.getContext(), R.style.alertDialog);
                alertDialoBuider.setTitle("Confirm Delete !");
                alertDialoBuider.setIcon(R.drawable.delete_simple_warning_icon);
                alertDialoBuider.setMessage("Are you sure you want to delete ?");

                alertDialoBuider.setPositiveButton("Delete !", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        DBHandler dbCompound = new DBHandler(context);



//                        String name = holder.name.getText().toString();
//                        String typeSorC = holder.typeSorC.getText().toString();
//                        String date = holder.date.getText().toString();
//                        String principalAmount = holder.principalAmount.getText().toString();
//                        String interestRate = holder.interestAmount.getText().toString();
//                        String interestRateFrequency = holder.interestFrequency.getText().toString();
//                        String year = holder.year.getText().toString();
//                        String month = holder.month.getText().toString();
//                        String day = holder.day.getText().toString();
//                        String compoundingFrequency = holder.compoundingFrequency.getText().toString();
//                        String interestAmount = holder.interestAmount.getText().toString();
//                        String totalAmount = holder.totalAmount.getText().toString();
                        String timeAsUniqueId = holder.timeAsUniqueId.getText().toString();




                        dbCompound.deleteRecordCompound(timeAsUniqueId);
                        dbCompound.close();



                        recordModalArrayList.remove(holder.getAdapterPosition());
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


        holder.imageButtonRecalculateCompound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                CalculatorFragment myInstance = CalculatorFragment.getInstance();


                System.out.println(myInstance.getYear());


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
                            String myFrequency = holder.compoundingFrequency.getText().toString();
                            String myYear = holder.year.getText().toString().replace("Y","");
                            String myMonth = holder.month.getText().toString().replace("M","");
                            String myDay = holder.day.getText().toString().replace("D","");




//                     it took one day to do like this before i was creating object of Calculator fragment which was wrong;
                            myInstance.reCalculateCompound(myPrincipal,myInterest,myInterestFrequency,myFrequency, myYear, myMonth, myDay);














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
                    String myFrequency = holder.compoundingFrequency.getText().toString();
                    String myYear = holder.year.getText().toString().replace("Y","");
                    String myMonth = holder.month.getText().toString().replace("M","");
                    String myDay = holder.day.getText().toString().replace("D","");




//                  it took one day to do like this before i was creating object of Calculator fragment which was wrong;
                            myInstance.reCalculateCompound(myPrincipal,myInterest,myInterestFrequency,myFrequency, myYear, myMonth, myDay);





                }







            }
        });



        holder.imageButtonShareCompound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String name = holder.name.getText().toString();
                String typeSorC = holder.typeSorC.getText().toString();
                String date = holder.date.getText().toString();
                String myPrincipal = holder.principalAmount.getText().toString();
                String myInterest = holder.interestRate.getText().toString();
                String myInterestFrequency = holder.interestFrequency.getText().toString();
                String myYear = holder.year.getText().toString();
                String myMonth = holder.month.getText().toString();
                String myDay = holder.day.getText().toString();
                String compoundingFrequency = holder.compoundingFrequency.getText().toString();
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
                forShare.append("Compounding Freq. : ").append(compoundingFrequency);
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
    public int getItemCount() {
        // returning the size of our array list
        compoundArrayListSize = recordModalArrayList.size();

        if(compoundArrayListSize == 0 && isRecordVisible && !btnSimpleCompoundStatus){
            if(imageViewNotFound.getVisibility() != View.VISIBLE){
                imageViewNotFound.setVisibility(View.VISIBLE);

            }

        } else if(compoundArrayListSize > 0 && isRecordVisible && !btnSimpleCompoundStatus){
            if(imageViewNotFound.getVisibility() == View.VISIBLE){
                imageViewNotFound.setVisibility(View.GONE);

            }
        }

        return recordModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {



        ImageButton imageButtonDeleteCompound;
        ImageButton imageButtonRecalculateCompound;
        ImageButton imageButtonShareCompound;

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
        private final TextView timeAsUniqueId;
//        private final ImageButton btnImgMoreThreeDots;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);



            imageButtonDeleteCompound = itemView.findViewById(R.id.deleteCompound);
            imageButtonRecalculateCompound = itemView.findViewById(R.id.reCalculateCompound);
            imageButtonShareCompound = itemView.findViewById(R.id.image_btn_share_compound);


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
        timeAsUniqueId = itemView.findViewById(R.id.time_as_unique_id_compound);
//        btnImgMoreThreeDots = itemView.findViewById(R.id.more_three_dots);






        }
    }
}
