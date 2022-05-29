package com.example.shelterbuddy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.ArrayList;

import static androidx.core.view.MenuItemCompat.getActionView;

/**
 * Created by Thao on 16-04-2021.
 */

public class MainActivity extends AppCompatActivity implements PetRecyclerViewAdapter.ItemClickListener {

    PetRecyclerViewAdapter myAdapter;

    ShelterBuddyDBHandler myDB;

    ArrayList<PetInformation> petDataList;

    private int mIndex;

    //key used to pass and retrieve the index of the array that represents the users' pick
    private static final String KEY_INDEX = "index";

    //flags used for switching activities
    private static final boolean USED_FLAG = true;
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        //define ColorDrawable object and Parse Color, using parseColor method with color harsh code as its parameter
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#4AA6B5"));
        //set background drawable
        actionBar.setBackgroundDrawable(colorDrawable);

        //initialize the arraylist
        myDB = new ShelterBuddyDBHandler(MainActivity.this);
        petDataList = new ArrayList<PetInformation>();
        petDataList = myDB.readAllData();

        RecyclerView rView = (RecyclerView) findViewById(R.id.petRecyclerView);
        rView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new PetRecyclerViewAdapter(this, petDataList);
        myAdapter.setmClickListener(this);
        rView.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu and add items to action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);


        //get searchview object
        MenuItem searchItem = menu.findItem(R.id.searchBar);
        //get SearchView autocomplete object
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
    public boolean onOptionsItemSelected (MenuItem item){
        //handle action bar item click here
        int id = item.getItemId();

        //nested if statements to decide what to do with the menu items
        switch (id){
            case R.id.favoriteMenuItem:
                Toast.makeText(this, "Clicked on Favorite Button", Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(this, favoritePet.class);
                if (USED_FLAG){
                    myIntent.addFlags(mFlag);
                }
                startActivity(myIntent);
                return true;
            case R.id.searchBar:
                Toast.makeText(this, "Clicked on search icon", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //when clicked on a row, we'll start petInformationDisplay activity
    @Override
    public void onItemClick(View view, int position) {
        Intent myIntent = new Intent(this, petInformationDisplay.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        myIntent.putExtra(KEY_INDEX, petDataList.get(position).getmPetID());
        startActivity(myIntent);
    }
}