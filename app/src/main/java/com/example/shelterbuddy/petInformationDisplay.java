package com.example.shelterbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class petInformationDisplay extends AppCompatActivity {

    private ImageView mSelectedPetImageView;
    private TextView mNameTextView;
    private TextView mBreedTextView;
    private TextView mAgeTextView;
    private TextView mSizeTextView;
    private TextView mGenderTextView;
    private TextView mHealthTextView;
    private TextView mFeeTextView;
    private TextView mStatusTextView;

    ShelterBuddyDBHandler myDB;
    private PetInformation mPetInfo;

    //index of Array
    private int mIndex;
    //key used to pass and retrieve the index of the array that represents the users' pick
    private static final String KEY_INDEX = "index";
    private static final boolean USED_FLAG = true;
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_information_display);

        //define actionBar object
        ActionBar actionBar = getSupportActionBar();
        //set the title for the actionBar
        actionBar.setTitle("Listing Information");
        //showing the back button in actionBar
        actionBar.setDisplayHomeAsUpEnabled(true);
        //define ColorDrawable object and Parse Color, using parseColor method with color harsh code as its parameter
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#4AA6B5"));
        //set background drawable
        actionBar.setBackgroundDrawable(colorDrawable);

        myDB = new ShelterBuddyDBHandler(petInformationDisplay.this);

        mSelectedPetImageView = (ImageView)findViewById(R.id.selectedPetImageView);
        mNameTextView = (TextView)findViewById(R.id.nameDisplayTextView);
        mBreedTextView = (TextView)findViewById(R.id.breedDisplayTextView);
        mAgeTextView = (TextView)findViewById(R.id.ageDisplayTextView);
        mSizeTextView = (TextView)findViewById(R.id.sizeDisplayTextView);
        mGenderTextView = (TextView)findViewById(R.id.genderDisplayTextView);
        mHealthTextView = (TextView)findViewById(R.id.healthDisplayTextView);
        mFeeTextView = (TextView)findViewById(R.id.feeDisplayTextView);
        mStatusTextView = (TextView)findViewById(R.id.statusDisplayTextView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle myData = getIntent().getExtras();
        mIndex = myData.getInt(KEY_INDEX);

        myDB = new ShelterBuddyDBHandler(petInformationDisplay.this);
        mPetInfo = myDB.fetchARow(mIndex);

        mSelectedPetImageView.setImageResource(mPetInfo.getmPetImage());
        mNameTextView.setText(mPetInfo.getmPetName());
        mBreedTextView.setText(mPetInfo.getmPetBreed());
        mAgeTextView.setText(mPetInfo.getmPetAge());
        mSizeTextView.setText(mPetInfo.getmPetSize());
        mGenderTextView.setText(mPetInfo.getmPetGender());
        mHealthTextView.setText(mPetInfo.getmPetHealth());

        if (mPetInfo.getmPetFee() != 0){
            mFeeTextView.setText((int) mPetInfo.getmPetFee());
        }else{
            mFeeTextView.setText("None");
        }

        if (mPetInfo.getmPetIsAvailable() == 0){
            mStatusTextView.setText("Unavailable for Adoption.");
        }else{
            mStatusTextView.setText("Available for Adoption.");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu and add items to action bar
        getMenuInflater().inflate(R.menu.menu_petinfodisplay, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.favoriteAddMenuItem:
                ShelterBuddyDBHandler handler = new ShelterBuddyDBHandler(this);
                handler.updateIsFavorite(mPetInfo.getmPetID());
                Toast.makeText(this, "Added to your Favorite Listing!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.favoriteMenuItem:
                Intent myIntent = new Intent(this, favoritePet.class);
                if (USED_FLAG){
                    myIntent.addFlags(mFlag);
                }
                startActivity(myIntent);
                return true;
            case R.id.homeButton:
                Intent intent = new Intent(this, MainActivity.class);
                if (USED_FLAG){
                    intent.addFlags(mFlag);
                }
                startActivity(intent);
                return true;
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onPetDisplaytoShelterClick(View v){
        //create new intent
        Intent myIntent = new Intent(this, shelterInformationDisplay.class);
        myIntent.putExtra(KEY_INDEX, mPetInfo.getmShelterID());
        //start the activity without expecting anything to return
        startActivity(myIntent);
    }

}