package com.calculator.interestcalculator;

import static com.calculator.interestcalculator.CalculatorFragment.btnSimpleCompoundStatus;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Objects;

public class RecordFragment extends Fragment {

    View view;
    private ArrayList<RecordModal>  recordModalArrayList;
    private DBHandler dbHandler;
    private RecordAdapter recordRVAdapter;
    private RecyclerView recordRV;

    private ArrayList<RecordModalSimple> recordModalArrayListSimple;
    private DBHandlerSimple dbHandlerSimple;
    private RecordAdapterSimple recordRVAdapterSimple;


    public static RecordFragment getInstance(){
        return new RecordFragment();
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =   inflater.inflate(R.layout.fragment_record, container, false);

//        setRetainInstance(true);
        setHasOptionsMenu(true);


        recordRV = view.findViewById(R.id.RVRecords);





        return view;


    }


    public void setUserVisibleHint(boolean isVisibleToUser) {


        super.setUserVisibleHint(isVisibleToUser);




        if(isVisibleToUser) {


//            System.out.println("visible to user");
//            I am using this condition to not to refresh history fragment each and everytime user visit
//                    refresh only first time the app starts and when any data saved.
//            if(save_button_for_refreshing_sqlite || refresh_first_time_only) {
            // initializing our all variables.




            if(btnSimpleCompoundStatus){

                mySimple();


            }else {

                myCompound();

            }


        }

    }



    public void mySimple(){

        recordModalArrayListSimple  = new ArrayList<>();
        dbHandlerSimple = new DBHandlerSimple(getContext());




            recordModalArrayListSimple = dbHandlerSimple.readData();


        recordRVAdapterSimple = new RecordAdapterSimple(recordModalArrayListSimple,getContext());

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManagerSimple = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recordRV.setLayoutManager(linearLayoutManagerSimple);



        // setting our adapter to recycler view.
        recordRV.setAdapter(recordRVAdapterSimple);


    }


    public void myCompound(){

        recordModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(getContext());


        // getting our currency array
        // list from db handler class.
        recordModalArrayList = dbHandler.readData();


        // on below line passing our array lost to our adapter class.
        recordRVAdapter = new RecordAdapter(recordModalArrayList, getContext());

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recordRV.setLayoutManager(linearLayoutManager);

        recordRV.setAdapter(recordRVAdapter);




    }


    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {

        menu.findItem(R.id.deleteAll).setVisible(true);
        menu.findItem(R.id.Share).setVisible(false);
        menu.findItem(R.id.Reset).setVisible(false);

        super.onPrepareOptionsMenu(menu);
    }



}