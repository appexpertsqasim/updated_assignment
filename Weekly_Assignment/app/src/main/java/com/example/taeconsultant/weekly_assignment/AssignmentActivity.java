package com.example.taeconsultant.weekly_assignment;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AssignmentActivity  extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_assignment,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Typeface face= Typeface.createFromAsset(getActivity().getAssets(),"fonts/museoSans_300.ttf");
        TextView tv=(TextView)view.findViewById(R.id.message);
        TextView tv2=(TextView)view.findViewById(R.id.message2);
        TextView tv3=(TextView)view.findViewById(R.id.message3);
        TextView tv4=(TextView)view.findViewById(R.id.message4);
        TextView tv5=(TextView)view.findViewById(R.id.message5);
        tv.setTypeface(face);
        tv2.setTypeface(face);
        tv3.setTypeface(face);
        tv4.setTypeface(face);
        tv5.setTypeface(face);
        Button btnReplace=(Button)view.findViewById(R.id.account_btn);
        btnReplace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getFragmentManager().beginTransaction()
                      .replace(R.id.container, new accountActivity())
                      .commit();
            }
        });
    }


}
