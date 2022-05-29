package com.example.shelterbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class shelterInformationDisplay extends AppCompatActivity {

    private TextView mShelterNameTextView;
    private TextView mShelterAddressTextView;
    private TextView mShelterDescriptionTextView;
    private TextView mShelterPhoneTextView;
    private TextView mShelterEmailTextView;
    private Button mMapButton;

    ShelterBuddyDBHandler myDB;
    private ShelterInformation mShelterInfo;

    //index of Array
    private int mIndex;

    //identify user permission request
    private static final int REQUEST_CALL = 1;

    //flags used for switching activities
    private static final String KEY_INDEX = "index";
    private static final boolean USED_FLAG = true;
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_information);

        //define actionBar object
        ActionBar actionBar = getSupportActionBar();
        //set the title for the actionBar
        actionBar.setTitle("Shelter Information");
        //showing the back button in actionBar
        actionBar.setDisplayHomeAsUpEnabled(true);
        //define ColorDrawable object and Parse Color, using parseColor method with color harsh code as its parameter
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#4AA6B5"));
        //set background drawable
        actionBar.setBackgroundDrawable(colorDrawable);

        mShelterNameTextView = (TextView)findViewById(R.id.shelterNameDisplayTextView);
        mShelterAddressTextView = (TextView)findViewById(R.id.shelterAddressDisplayTextView);
        mShelterDescriptionTextView = (TextView)findViewById(R.id.descriptionDisplayTextView);
        mShelterPhoneTextView = (TextView)findViewById(R.id.phoneDisplayTextView);
        mShelterEmailTextView = (TextView)findViewById(R.id.emailDisplayTextView);
        mMapButton = (Button)findViewById(R.id.mapButton);

    }
    @Override
    public void onResume(){
        super.onResume();

        Bundle myData = getIntent().getExtras();
        mIndex = myData.getInt(KEY_INDEX);
        myDB = new ShelterBuddyDBHandler(shelterInformationDisplay.this);
        mShelterInfo = myDB.fetchARowShelter(mIndex);

        mShelterNameTextView.setText(mShelterInfo.getmShelterName());
        mShelterAddressTextView.setText(mShelterInfo.getmShelterAddress());
        mShelterDescriptionTextView.setText(mShelterInfo.getmShelterDescription());
        mShelterPhoneTextView.setText(mShelterInfo.getmShelterPhone());
        mShelterEmailTextView.setText(mShelterInfo.getmShelterEmail());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu and add items to action bar
        getMenuInflater().inflate(R.menu.menu_shelterinfodisplay, menu);
        return true;
    }
    //enable the back function to the back button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.callButton:
                Toast.makeText(this, "Calling the Shelter...", Toast.LENGTH_LONG).show();
                makePhoneCall();
            return true;
            case R.id.emailButton:
                sendEmail();
                return true;
            case R.id.homeButton:
                Intent myIntent = new Intent(this, MainActivity.class);
                if (USED_FLAG){
                    myIntent.addFlags(mFlag);
                }
                startActivity(myIntent);
                return true;
            //enable the back function to the back button on press
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void makePhoneCall(){
        String number = mShelterPhoneTextView.getText().toString();
        if (number.replaceAll("[()-]","").length() > 0){
            // if no permission was granted
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                //we request permission again
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            }else{
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else{
            Toast.makeText(this, "No valid phone number", Toast.LENGTH_LONG).show();
        }
    }
    private void sendEmail(){
        String email = mShelterEmailTextView.getText().toString();
        if (email.trim().length() > 0){
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            startActivity(Intent.createChooser(emailIntent,"Send email..."));
        }else {
            Toast.makeText(this, "No valid email for this Shelter", Toast.LENGTH_LONG).show();
        }
    }

    public void onMapButtonClick(View v){
        //create a new intent
        Intent myIntent = new Intent(this, MapsActivity.class);
        //getting the address
        myIntent.putExtra(KEY_INDEX, mShelterInfo.getmShelterAddress());
        if (USED_FLAG){
            myIntent.addFlags(mFlag);
        }
        //start the activity that leads to MapsActivity class
        startActivity(myIntent);
    }
}