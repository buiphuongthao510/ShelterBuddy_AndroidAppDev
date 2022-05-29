package com.example.shelterbuddy;

public class ShelterInformation {
    private int mShelterID;
    private String mShelterName;
    private String mShelterAddress;
    private String mShelterDescription;
    private String mShelterPhone;
    private String mShelterEmail;

    public void ShelterInformation (int id, String name, String address, String description, String phone, String email){
        mShelterID = id;
        mShelterName = name;
        mShelterAddress = address;
        mShelterDescription = description;
        mShelterPhone = phone;
        mShelterEmail = email;
    }

    public int getmShelterID() {
        return mShelterID;
    }

    public void setmShelterID(int mShelterID) {
        this.mShelterID = mShelterID;
    }

    public String getmShelterName() {
        return mShelterName;
    }

    public void setmShelterName(String mShelterName) {
        this.mShelterName = mShelterName;
    }

    public String getmShelterAddress() {
        return mShelterAddress;
    }

    public void setmShelterAddress(String mShelterAddress) {
        this.mShelterAddress = mShelterAddress;
    }

    public String getmShelterDescription() {
        return mShelterDescription;
    }

    public void setmShelterDescription(String mShelterDescription) {
        this.mShelterDescription = mShelterDescription;
    }

    public String getmShelterPhone() {
        return mShelterPhone;
    }

    public void setmShelterPhone(String mShelterPhone) {
        this.mShelterPhone = mShelterPhone;
    }

    public String getmShelterEmail() {
        return mShelterEmail;
    }

    public void setmShelterEmail(String mShelterEmail) {
        this.mShelterEmail = mShelterEmail;
    }
}
