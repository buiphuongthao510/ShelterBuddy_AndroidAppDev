package com.example.shelterbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class favoritePet extends AppCompatActivity implements PetRecyclerViewAdapter.ItemClickListener{

    PetRecyclerViewAdapter myAdapter;

    ShelterBuddyDBHandler myDB;

    ArrayList<PetInformation> mFavoritePetData;

    private int mIndex;
    private static final String KEY_INDEX = "index";
    //flags used for switching activities
    private static final boolean USED_FLAG = true;
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_pet);

        //define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setTitle("Favorite");
        //showing the back button in actionBar
        actionBar.setDisplayHomeAsUpEnabled(true);
        //define ColorDrawable object and Parse Color, using parseColor method with color harsh code as its parameter
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#4AA6B5"));
        //set background drawable
        actionBar.setBackgroundDrawable(colorDrawable);

        //Initialize the Pet Data
        myDB = new ShelterBuddyDBHandler(favoritePet.this);
        mFavoritePetData = new ArrayList<PetInformation>();
        mFavoritePetData = myDB.fetchAllFavorite();


        RecyclerView rView = (RecyclerView)findViewById(R.id.petRecyclerView);
        rView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new PetRecyclerViewAdapter(this, mFavoritePetData);
        myAdapter.setmClickListener(this);
        rView.setAdapter(myAdapter);
    }
    //enable the back function to the back button on press
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu and add items to action bar
        getMenuInflater().inflate(R.menu.menu_favorite, menu);
        MenuItem searchItem = menu.findItem(R.id.searchBar);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.searchBar:
                Toast.makeText(this, "Clicked on search icon", Toast.LENGTH_LONG).show();
                return true;
            case R.id.deleteButton:
                ShelterBuddyDBHandler handler = new ShelterBuddyDBHandler(this);
                handler.updateIsNotFavorite();
                Toast.makeText(this, "All Favorite has been removed!", Toast.LENGTH_SHORT).show();
            //enable the back function to the back button on press
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onItemClick (View view, int position){
        Intent myIntent = new Intent(this, petInformationDisplay.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        myIntent.putExtra(KEY_INDEX, mFavoritePetData.get(position).getmPetID());
        startActivity(myIntent);
    }
}