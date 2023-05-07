package com.loan.interest.rate.calculator.simple;

import static com.loan.interest.rate.calculator.simple.CalculatorFragment.btnSimpleCompoundStatus;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


public class RecordFragment extends Fragment {



    Prefs prefs;
    static boolean isRecordVisible = false;
    static ImageView imageViewNotFound;
    View view;
    private RecyclerView recordRV;


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
        prefs = new Prefs(requireContext());

        recordRV = view.findViewById(R.id.RVRecords);

        imageViewNotFound = view.findViewById(R.id.image_view_not_found);


        return view;


    }


    public void setUserVisibleHint(boolean isVisibleToUser) {


        super.setUserVisibleHint(isVisibleToUser);




        if(isVisibleToUser) {
            isRecordVisible = true;



            if(btnSimpleCompoundStatus){

                mySimple();


            }else {

                myCompound();


            }


        }

    }



    public void mySimple(){

        ArrayList<RecordModalSimple> recordModalArrayListSimple = new ArrayList<>();
        DBHandlerSimple dbHandlerSimple = new DBHandlerSimple(getContext());

            recordModalArrayListSimple = dbHandlerSimple.readData();


        RecordAdapterSimple recordRVAdapterSimple = new RecordAdapterSimple(recordModalArrayListSimple, getContext());
        recordRVAdapterSimple.setHasStableIds(true);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManagerSimple = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recordRV.setLayoutManager(linearLayoutManagerSimple);


        // setting layout manager for our recycler view.
        recordRV.setHasFixedSize(true);

        // setting our adapter to recycler view.
        recordRV.setAdapter(recordRVAdapterSimple);


    }


    public void myCompound(){

        ArrayList<RecordModal> recordModalArrayList = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(getContext());



        // getting our record array
        // list from db handler class.
        recordModalArrayList = dbHandler.readData();

        // on below line passing our array lost to our adapter class.
        RecordAdapter recordRVAdapter = new RecordAdapter(recordModalArrayList, getContext());
        recordRVAdapter.setHasStableIds(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recordRV.setLayoutManager(linearLayoutManager);


        // setting layout manager for our recycler view.
        recordRV.setHasFixedSize(true);

        recordRV.setAdapter(recordRVAdapter);


    }


    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {

        menu.findItem(R.id.deleteAll).setVisible(true);
        menu.findItem(R.id.Share).setVisible(false);
        menu.findItem(R.id.Reset).setVisible(false);


        if(prefs.isRemoveAd()){
            menu.findItem(R.id.Remove_ad).setVisible(false);
            menu.findItem(R.id.vip).setVisible(true);
        }


        super.onPrepareOptionsMenu(menu);
    }



}