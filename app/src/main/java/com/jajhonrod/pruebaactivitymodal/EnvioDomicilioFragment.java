package com.jajhonrod.pruebaactivitymodal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnvioDomicilioFragment extends Fragment {

    private DatabaseReference mDatabase;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> adapter;


    public EnvioDomicilioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaDirecciones =  inflater.inflate(R.layout.fragment_envio_domicilio, container, false);
        /*ListView lv = (ListView)getActivity().findViewById(R.id.lv_direcciones);
        lv.setAdapter();
        mDatabase = FirebaseDatabase.getInstance().getReference();*/


        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        return vistaDirecciones;
    }

}
