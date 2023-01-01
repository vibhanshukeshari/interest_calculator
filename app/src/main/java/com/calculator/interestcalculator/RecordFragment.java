package com.calculator.interestcalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecordFragment extends Fragment {

    RecyclerView recyclerView;
    View view;









    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =   inflater.inflate(R.layout.fragment_record, container, false);

        setRetainInstance(true);

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
}