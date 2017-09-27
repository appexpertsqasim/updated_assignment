package com.example.taeconsultant.weekly_assignment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.codetroopers.betterpickers.datepicker.DatePickerDialogFragment;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import LocalDB.CustomerModel;
import LocalDB.RealmController.RealmController;
import io.realm.Realm;

public class DataActivity extends Fragment implements DatePickerDialogFragment.DatePickerDialogHandler {

    EditText nameText;
    EditText ageText;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageView;
    Realm realm;
    RealmController controller;
    CustomerModel customerModel;
    Button photo;
    byte[] bytesImage;
    private FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.activity_data,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner sp = (Spinner) view.findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> av, View v,
                                       int position, long itemId) {
                // TODO Auto-generated method stub
                String item=av.getItemAtPosition(position).toString();
                ((TextView) v).setTextColor(Color.BLACK);
                ((TextView) v).getText().toString();

            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });

        Button sendButton = (Button)view. findViewById(R.id.submit);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DataActivity", "Save to DB" );
                saveToDB(v);
                getFragmentManager().beginTransaction()
                        .replace(R.id.container,new customerList())
                        .addToBackStack(null)
                        .commit();
            }
        });


        Button datePickerButton= (Button) view.findViewById(R.id.date_btn);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerBuilder dpb = new DatePickerBuilder()
                        .setFragmentManager(getFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment)
                        .setTargetFragment(DataActivity.this);
                dpb.show();
            }
        });
         Button photo=(Button)view.findViewById(R.id.photo);
         mImageView=(ImageView)view.findViewById(R.id.imageView2);
        nameText =(EditText)view.findViewById(R.id.name_txt);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoIntent,1);
            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == getActivity().RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap resultPhoto = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(resultPhoto);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            resultPhoto.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytesImage = stream.toByteArray();
            Log.i("DataActivity", "+++++++++ " +"photoadded+"+ " +++++++++++");
        }
        Log.i("DataActivity", "requestCode = " + requestCode + ", resultCode = " + resultCode);
    }


    @Override
    public void onDialogDateSet(int reference, int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();
        ageText =(EditText)getActivity().findViewById(R.id.age);
        ageText.setText(ageS);

    }




    private void saveToDB(View view){
        Realm.init(getContext());
        realm=Realm.getDefaultInstance();
        controller=new RealmController(realm);




        //TODO: logic to check for nulls here

        customerModel =new CustomerModel();
        Log.i("DataActivity", "requestCode = " + nameText.getText().toString() );
       customerModel.setName(String.valueOf(nameText.getText().toString()));
        controller.saveCustomer(customerModel);


    }




    }







