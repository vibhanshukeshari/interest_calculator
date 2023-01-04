package com.calculator.interestcalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class CalculatorFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    RecyclerView recyclerView;
    View view;
    String[] rateType = { "Yearly", "Monthly","Quarterly","Bi-Annually"};









    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =   inflater.inflate(R.layout.fragment_calculator, container, false);

        Spinner spin = view.findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,rateType);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);


//        setRetainInstance(true);

//        recyclerView = view.findViewById(R.id.recyclerView);


//        ItemAdapter itemAdapter = new ItemAdapter(mData);
//        recyclerView.setHasFixedSize(true);


//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(itemAdapter);
//


//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
//        recyclerView.setLayoutManager(gridLayoutManager);



        return view;


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        Toast.makeText(getContext(),rateType[rateType.length] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}