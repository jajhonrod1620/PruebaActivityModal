package com.jajhonrod.pruebaactivitymodal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnvioDomicilioFragment extends Fragment {

    DatabaseReference mDatabase;
    ListView lv;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;


    public EnvioDomicilioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaDirecciones =  inflater.inflate(R.layout.fragment_envio_domicilio, container, false);
        ListView lv = (ListView)vistaDirecciones.findViewById(R.id.lv_direcciones);
        adapter= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, arrayList);
        lv.setAdapter(adapter);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                arrayList.add(dataSnapshot.getValue(String.class));
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                arrayList.remove(dataSnapshot.getValue(String.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        return vistaDirecciones;
    }

}
