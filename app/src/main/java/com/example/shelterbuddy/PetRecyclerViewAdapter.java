package com.example.shelterbuddy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;


public class PetRecyclerViewAdapter extends RecyclerView.Adapter<PetRecyclerViewAdapter.ViewHolder> implements Filterable {

    private ItemClickListener mClickListener;

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
    private Context context;
    private ArrayList<PetInformation> mPetRowData;

    //create a copy of the original list to store the filterred list
    private ArrayList<PetInformation> mPetRowDataFull;

    //constructor for this adapter takes the data you want to display
    public PetRecyclerViewAdapter(Context context, ArrayList<PetInformation> mPetRowData){
       this.context = context;
       this.mPetRowData = mPetRowData;
       mPetRowDataFull = new ArrayList<>(mPetRowData);
    }

    //provide preference to the type of view you're using
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //for an item in the list get the TextView for petInfoTextView and petImageButton
        //initializer - getters
        private final TextView mPetNameTextView;
        private final TextView mPetBreedTextView;
        private final TextView mPetSizeTextView;
        private final ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mPetNameTextView = (TextView) itemView.findViewById(R.id.petNameTextView);
            mPetBreedTextView = (TextView) itemView.findViewById(R.id.petBreedTextView);
            mPetSizeTextView = (TextView) itemView.findViewById(R.id.petSizeTextView);
            mImageView = (ImageView) itemView.findViewById(R.id.petImageView);
            itemView.setOnClickListener(this);
        }
        public TextView getmPetNameTextView(){ return mPetNameTextView;}
        public TextView getmPetBreedTextView(){return mPetBreedTextView;}
        public TextView getmPetSizeTextView(){return mPetSizeTextView;}
        public ImageView getmImageView(){ return mImageView;}


        @Override
        public void onClick(View v) {
            if (mClickListener != null)
                mClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int ViewType) {
        //create a new view, which defines the UI of each pet listing
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.petrecycler_row,
                viewGroup, false);
        return new ViewHolder(view);
    }
    //replace to content of the view
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position){
        //get the element from the dataset at this position and replace the content of the TextView and
       viewHolder.mPetNameTextView.setText(mPetRowData.get(position).getmPetName());
       viewHolder.mPetBreedTextView.setText(mPetRowData.get(position).getmPetBreed());
       viewHolder.mPetSizeTextView.setText(mPetRowData.get(position).getmPetSize());
       viewHolder.mImageView.setImageResource(mPetRowData.get(position).getmPetImage());
    }
    @Override
    public int getItemCount() {
        return mPetRowData.size();
    }
    void setmClickListener(ItemClickListener i){
        this.mClickListener = i;
    }

    @Override
    public Filter getFilter() {
        return typeFilter;
    }

    private Filter typeFilter = new Filter() {
        @Override
        //this code will be executed in the background
        //constraint will take the user input in the searchview and represent the filter logic
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<PetInformation> filteredList = new ArrayList<>();
            //if nothing was input in the searchview, the full list of data will be shown
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(mPetRowDataFull);
            } else {
                //create a new string from our input, turn it into lower case and remove the empty space from the beginning
                //and the end of our input
                String filterPattern = constraint.toString().toLowerCase().trim();
                //for each item in our list, we check if they align with our filterPattern
                for (PetInformation item: mPetRowDataFull){
                    //we check for the type of animal being searched contains the filter pattern
                    if (item.getmPetType().toLowerCase().contains(filterPattern)){
                        //if yes, we add it into our filteredList
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        //the result of performFiltering will be published through this method
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mPetRowData.clear();
            mPetRowData.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
}
