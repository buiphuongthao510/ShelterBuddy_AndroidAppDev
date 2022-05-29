package com.example.shelterbuddy;

public class PetInformation {
    private int mPetID;
    private String mPetName;
    private int mPetImage;
    private String mPetType;
    private String mPetBreed;
    private String mPetAge;
    private String mPetSize;
    private String mPetGender;
    private String mPetHealth;
    private float mPetFee;
    private int mPetIsAvailable;
    private int mPetIsFavorite;
    private int mShelterID;

    public void PetInformation (int id, String name, int image, String type, String breed, String age,
                                String size, String gender, String health, float fee, int isAvailable, int isFavorite,
                                int s_id) {
        mPetID = id;
        mPetName = name;
        mPetImage = image;
        mPetType = type;
        mPetBreed = breed;
        mPetAge = age;
        mPetSize = size;
        mPetGender = gender;
        mPetHealth = health;
        mPetFee = fee;
        mPetIsAvailable = isAvailable;
        mPetIsFavorite = isFavorite;
        mShelterID = s_id;

    }

    public int getmPetID() {
        return mPetID;
    }

    public void setmPetID(int mPetID) {
        this.mPetID = mPetID;
    }

    public String getmPetName() {
        return mPetName;
    }

    public void setmPetName(String mPetName) {
        this.mPetName = mPetName;
    }

    public int getmPetImage() {
        return mPetImage;
    }

    public void setmPetImage(int mPetImage) {
        this.mPetImage = mPetImage;
    }

    public String getmPetType() {
        return mPetType;
    }

    public void setmPetType(String mPetType) {
        this.mPetType = mPetType;
    }

    public String getmPetBreed() {
        return mPetBreed;
    }

    public void setmPetBreed(String mPetBreed) {
        this.mPetBreed = mPetBreed;
    }

    public String getmPetAge() {
        return mPetAge;
    }

    public void setmPetAge(String mPetAge) {
        this.mPetAge = mPetAge;
    }

    public String getmPetSize() {
        return mPetSize;
    }

    public void setmPetSize(String mPetSize) {
        this.mPetSize = mPetSize;
    }

    public String getmPetGender() {
        return mPetGender;
    }

    public void setmPetGender(String mPetGender) {
        this.mPetGender = mPetGender;
    }

    public String getmPetHealth() {
        return mPetHealth;
    }

    public void setmPetHealth(String mPetHealth) {
        this.mPetHealth = mPetHealth;
    }

    public float getmPetFee() {
        return mPetFee;
    }

    public void setmPetFee(float mPetFee) {
        this.mPetFee = mPetFee;
    }

    public int getmPetIsAvailable() {
        return mPetIsAvailable;
    }

    public void setmPetIsAvailable(int mPetIsAvailable) {
        this.mPetIsAvailable = mPetIsAvailable;
    }

    public int getmPetIsFavorite() {
        return mPetIsFavorite;
    }

    public void setmPetIsFavorite(int mPetIsFavorite) {
        this.mPetIsFavorite = mPetIsFavorite;
    }

    public int getmShelterID() {
        return mShelterID;
    }

    public void setmShelterID(int mShelterID) {
        this.mShelterID = mShelterID;
    }
}
