package com.example.taeconsultant.weekly_assignment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by TAE Consultant on 25/09/2017.
 */

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private Button btnReplace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if(savedInstanceState ==null){
            fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.container,new AssignmentActivity())
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }
}