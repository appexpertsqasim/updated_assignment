package com.example.taeconsultant.weekly_assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import LocalDB.CustomerModel;
import LocalDB.RealmController.RealmController;
import io.realm.Realm;

public class customerList extends Fragment {
   Realm realm;
    RealmController realmController;
    ArrayList<CustomerModel> customerModels;
    RecyclerView recyclerView;
    RealmController controller;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_customer_list,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        realm=Realm.getDefaultInstance();
        realmController=new RealmController(realm);

        customerModels = realmController.getCustomerList();

        for(int i=0; i<customerModels.size();i++)
        {
            Log.i("CustomerList",customerModels.get(i).getName());
        }
        initialzerecyclerView(view);

    }



    public void initialzerecyclerView(View view){
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerCustomer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(new CustomerAdopter(customerModels,R.layout.row,getActivity().getApplicationContext()));
    }



}
