package com.example.taeconsultant.weekly_assignment;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class accountActivity extends Fragment {
    private Button btnReplace;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_account,container, false);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar topToolBar = (Toolbar)view.findViewById(R.id.toolbar);
      ((AppCompatActivity) getActivity()).setSupportActionBar(topToolBar);
        setHasOptionsMenu(true);
        topToolBar.setTitle("");
        Typeface face= Typeface.createFromAsset(getActivity().getAssets(),"fonts/museoSans_300.ttf");
        TextView tv=(TextView)view.findViewById(R.id.sc2_msg1);
        TextView tv2=(TextView)view.findViewById(R.id.scr2_msg2);
        TextView tv4=(TextView)view.findViewById(R.id.scr2_msg3);
        TextView tv5=(TextView)view.findViewById(R.id.scr2_msg4);
        tv.setTypeface(face);
        tv2.setTypeface(face);
        tv4.setTypeface(face);
        tv5.setTypeface(face);
        Button btnReplace=(Button)view.findViewById(R.id.button);
        btnReplace.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){

                getFragmentManager().beginTransaction()
                        .replace(R.id.container,new DataActivity())
                        .addToBackStack(null)
                        .commit();

    }




        });
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.action_refresh){
            Toast.makeText(getActivity(), "Refresh App", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.action_new){
            Toast.makeText(getActivity(), "Add Item", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

}