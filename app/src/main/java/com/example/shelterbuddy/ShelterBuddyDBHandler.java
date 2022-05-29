package com.example.shelterbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLInput;
import java.util.ArrayList;

import static java.lang.String.format;

public class ShelterBuddyDBHandler extends SQLiteOpenHelper {
    //database version
    private static final int DATABASE_VERSION = 18;

    //database name
    private static final String DATABASE_NAME = "LISTINGS.db";

    //tables' name
    private static final String TABLE_PETINFORMATION = "PetInformation";
    private static final String TABLE_SHELTER = "Shelter";

    //petinformation table columns' name
    private static final String COLUMN_PETID = "PetID";
    private static final String COLUMN_PETNAME = "Name";
    private static final String COLUMN_PETIMAGE = "Image";
    private static final String COLUMN_PETTYPE = "Type";
    private static final String COLUMN_PETBREED = "Breed";
    private static final String COLUMN_PETAGE = "Age";
    private static final String COLUMN_PETSIZE = "Size";
    private static final String COLUMN_PETGENDER = "Gender";
    private static final String COLUMN_PETHEALTH= "Health";
    private static final String COLUMN_PETFEE = "Fee";
    private static final String COLUMN_ISAVAILABLE = "Status";
    private static final String COLUMN_ISFAVORITE = "Favorite";
    private static final String COLUMN_PET_SHELTERID = "ShelterID";

    //shelter table columns' name
    private static final String COLUMN_SHELTERID = "ShelterID";
    private static final String COLUMN_SHELTERNAME = "Name";
    private static final String COLUMN_SHELTERADDRESS= "Address";
    private static final String COLUMN_SHELTERDESCRIPTION = "Description";
    private static final String COLUMN_SHELTERPHONE = "Phone";
    private static final String COLUMN_SHELTEREMAIL = "Email";

    public ShelterBuddyDBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db){
        //tables create statements
        //petinformation table create statement
        //image data is save as BLOB because it wil be saved as what it was put in for easier call later on
        String CREATE_PETINFORMATION_TABLE = "CREATE TABLE " +
                TABLE_PETINFORMATION + "(" +
                COLUMN_PETID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PETNAME + " TEXT, " +
                COLUMN_PETIMAGE + " BLOB, " +
                COLUMN_PETTYPE + " TEXT, " +
                COLUMN_PETBREED + " TEXT, " +
                COLUMN_PETAGE + " TEXT, " +
                COLUMN_PETSIZE + " TEXT, " +
                COLUMN_PETGENDER + " TEXT, " +
                COLUMN_PETHEALTH + " TEXT, " +
                COLUMN_PETFEE + " FLOAT, " +
                COLUMN_ISAVAILABLE + " BOOLEAN, " +
                COLUMN_ISFAVORITE + " BOOLEAN, " +
                COLUMN_PET_SHELTERID + " INTERGER)";

        String CREATE_SHELTER_TABLE = "CREATE TABLE " +
                TABLE_SHELTER + "(" +
                COLUMN_SHELTERID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SHELTERNAME + " TEXT, " +
                COLUMN_SHELTERADDRESS + " TEXT, " +
                COLUMN_SHELTERDESCRIPTION + " TEXT, " +
                COLUMN_SHELTERPHONE + " TEXT, " +
                COLUMN_SHELTEREMAIL + " TEXT)";

        //execute the SQL commands to create the tables
        db.execSQL(CREATE_PETINFORMATION_TABLE);
        db.execSQL(CREATE_SHELTER_TABLE);

        //adding in present entries for the database
        //entries for petinformation table
        ContentValues petValues = new ContentValues();
        petValues.put(COLUMN_PETNAME, "Neeko");
        petValues.put(COLUMN_PETIMAGE, R.drawable.neeko);
        petValues.put(COLUMN_PETTYPE, "Cat");
        petValues.put(COLUMN_PETBREED, "Brishtish Shorthair");
        petValues.put(COLUMN_PETAGE, "Young");
        petValues.put(COLUMN_PETSIZE, "Small");
        petValues.put(COLUMN_PETGENDER, "Female");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 1);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Mimi");
        petValues.put(COLUMN_PETIMAGE, R.drawable.mimi);
        petValues.put(COLUMN_PETTYPE, "Cat");
        petValues.put(COLUMN_PETBREED, "Bengal");
        petValues.put(COLUMN_PETAGE, "Adult");
        petValues.put(COLUMN_PETSIZE, "Large");
        petValues.put(COLUMN_PETGENDER, "Female");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 2);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Senna");
        petValues.put(COLUMN_PETIMAGE, R.drawable.senna);
        petValues.put(COLUMN_PETTYPE, "Cat");
        petValues.put(COLUMN_PETBREED, "American Bobtail");
        petValues.put(COLUMN_PETAGE, "Senior");
        petValues.put(COLUMN_PETSIZE, "Large");
        petValues.put(COLUMN_PETGENDER, "Male");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 3);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Jocky");
        petValues.put(COLUMN_PETIMAGE, R.drawable.jocky);
        petValues.put(COLUMN_PETTYPE, "Dog");
        petValues.put(COLUMN_PETBREED, "Akita");
        petValues.put(COLUMN_PETAGE, "Young");
        petValues.put(COLUMN_PETSIZE, "Medium");
        petValues.put(COLUMN_PETGENDER, "Male");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 4);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Chocolate");
        petValues.put(COLUMN_PETIMAGE, R.drawable.chocolate);
        petValues.put(COLUMN_PETTYPE, "Dog");
        petValues.put(COLUMN_PETBREED, "Aussiedoodle");
        petValues.put(COLUMN_PETAGE, "Puppy");
        petValues.put(COLUMN_PETSIZE, "Small");
        petValues.put(COLUMN_PETGENDER, "Female");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 5);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Jinny");
        petValues.put(COLUMN_PETIMAGE, R.drawable.jinny);
        petValues.put(COLUMN_PETTYPE, "Dog");
        petValues.put(COLUMN_PETBREED, "Chihuahua");
        petValues.put(COLUMN_PETAGE, "Adult");
        petValues.put(COLUMN_PETSIZE, "Small");
        petValues.put(COLUMN_PETGENDER, "Female");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 3);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Goldy");
        petValues.put(COLUMN_PETIMAGE, R.drawable.goldy);
        petValues.put(COLUMN_PETTYPE, "Fish & Turtles");
        petValues.put(COLUMN_PETBREED, "Goldfish");
        petValues.put(COLUMN_PETAGE, "Adult");
        petValues.put(COLUMN_PETSIZE, "Large");
        petValues.put(COLUMN_PETGENDER, "Male");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 1);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Rocky");
        petValues.put(COLUMN_PETIMAGE, R.drawable.rocky);
        petValues.put(COLUMN_PETTYPE, "Fish & Turtles");
        petValues.put(COLUMN_PETBREED, "Musk");
        petValues.put(COLUMN_PETAGE, "Baby");
        petValues.put(COLUMN_PETSIZE, "Small");
        petValues.put(COLUMN_PETGENDER, "Female");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 2);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Junior");
        petValues.put(COLUMN_PETIMAGE, R.drawable.junior);
        petValues.put(COLUMN_PETTYPE, "Fish & Turtles");
        petValues.put(COLUMN_PETBREED, "Box");
        petValues.put(COLUMN_PETAGE, "Baby");
        petValues.put(COLUMN_PETSIZE, "Small");
        petValues.put(COLUMN_PETGENDER, "Male");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 3);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Starry");
        petValues.put(COLUMN_PETIMAGE, R.drawable.starry);
        petValues.put(COLUMN_PETTYPE, "Rabbit");
        petValues.put(COLUMN_PETBREED, "American");
        petValues.put(COLUMN_PETAGE, "Adult");
        petValues.put(COLUMN_PETSIZE, "Medium");
        petValues.put(COLUMN_PETGENDER, "Female");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 1);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Izzie");
        petValues.put(COLUMN_PETIMAGE, R.drawable.izzie);
        petValues.put(COLUMN_PETTYPE, "Rabbit");
        petValues.put(COLUMN_PETBREED, "Beveren");
        petValues.put(COLUMN_PETAGE, "Young");
        petValues.put(COLUMN_PETSIZE, "Small");
        petValues.put(COLUMN_PETGENDER, "Female");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 4);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Harley");
        petValues.put(COLUMN_PETIMAGE, R.drawable.harley);
        petValues.put(COLUMN_PETTYPE, "Rabbit");
        petValues.put(COLUMN_PETBREED, "Bunny Rabbit");
        petValues.put(COLUMN_PETAGE, "Young");
        petValues.put(COLUMN_PETSIZE, "Small");
        petValues.put(COLUMN_PETGENDER, "Female");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 5);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Bernie");
        petValues.put(COLUMN_PETIMAGE, R.drawable.bernie);
        petValues.put(COLUMN_PETTYPE, "Bird");
        petValues.put(COLUMN_PETBREED, "Chicken");
        petValues.put(COLUMN_PETAGE, "Adult");
        petValues.put(COLUMN_PETSIZE, "Medium");
        petValues.put(COLUMN_PETGENDER, "Male");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 1);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Sunny");
        petValues.put(COLUMN_PETIMAGE, R.drawable.sunny);
        petValues.put(COLUMN_PETTYPE, "Bird");
        petValues.put(COLUMN_PETBREED, "Parrot");
        petValues.put(COLUMN_PETAGE, "Adult");
        petValues.put(COLUMN_PETSIZE, "Medium");
        petValues.put(COLUMN_PETGENDER, "Female");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 2);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Nugget");
        petValues.put(COLUMN_PETIMAGE, R.drawable.nugget);
        petValues.put(COLUMN_PETTYPE, "Bird");
        petValues.put(COLUMN_PETBREED, "Chicken");
        petValues.put(COLUMN_PETAGE, "Adult");
        petValues.put(COLUMN_PETSIZE, "Medium");
        petValues.put(COLUMN_PETGENDER, "Female");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 3);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Squeaky");
        petValues.put(COLUMN_PETIMAGE, R.drawable.squeaky);
        petValues.put(COLUMN_PETTYPE, "Small & Furry");
        petValues.put(COLUMN_PETBREED, "Hamster");
        petValues.put(COLUMN_PETAGE, "Adult");
        petValues.put(COLUMN_PETSIZE, "Medium");
        petValues.put(COLUMN_PETGENDER, "Male");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 1);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Victor");
        petValues.put(COLUMN_PETIMAGE, R.drawable.victor);
        petValues.put(COLUMN_PETTYPE, "Small & Furry");
        petValues.put(COLUMN_PETBREED, "Chinchilla");
        petValues.put(COLUMN_PETAGE, "Adult");
        petValues.put(COLUMN_PETSIZE, "Small");
        petValues.put(COLUMN_PETGENDER, "Male");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 2);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);

        petValues.put(COLUMN_PETNAME, "Lulu");
        petValues.put(COLUMN_PETIMAGE, R.drawable.lulu);
        petValues.put(COLUMN_PETTYPE, "Small & Furry");
        petValues.put(COLUMN_PETBREED, "Ferret");
        petValues.put(COLUMN_PETAGE, "Adult");
        petValues.put(COLUMN_PETSIZE, "Medium");
        petValues.put(COLUMN_PETGENDER, "Female");
        petValues.put(COLUMN_PETHEALTH, "Healthy");
        petValues.put(COLUMN_PETFEE, 0);
        petValues.put(COLUMN_ISAVAILABLE, true);
        petValues.put(COLUMN_ISFAVORITE, false);
        petValues.put(COLUMN_PET_SHELTERID, 3);
        db.insert(TABLE_PETINFORMATION, COLUMN_PETID, petValues);


        //entries for shelter table
        ContentValues shelterValues = new ContentValues();
        shelterValues.put(COLUMN_SHELTERNAME, "SPCA Tampa Bay");
        shelterValues.put(COLUMN_SHELTERADDRESS, "9099 130th Ave N Largo, FL 33773");
        shelterValues.put(COLUMN_SHELTERDESCRIPTION, "SPCA Tampa Bay is a For-All shelter and" +
                " we support a healthy community, animal welfare and " +
                "socially conscious animal sheltering. " +
                "Being a “For-All” shelter means that SPCA Tampa Bay will not limit admission or refuse to take in a pet.");
        shelterValues.put(COLUMN_SHELTERPHONE, "(727)586-3591");
        shelterValues.put(COLUMN_SHELTEREMAIL, "adoptions@spcatampabay.org");
        db.insert(TABLE_SHELTER, COLUMN_SHELTERID, shelterValues);

        shelterValues.put(COLUMN_SHELTERNAME, "Guam Animals In Need");
        shelterValues.put(COLUMN_SHELTERADDRESS, "Mangilao, GU");
        shelterValues.put(COLUMN_SHELTERDESCRIPTION, "Our Mission: Guam Animals In Need improves the care of all animals on Guam by sheltering those in need, and through compassionate advocacy, expert education, and strong community connections.\n" +
                "Guam Animals In Need is a 501(c)(3) nonprofit organization which was incorporated in 1989. We are the only animal shelter on the island of Guam.");
        shelterValues.put(COLUMN_SHELTERPHONE, "(671) 653-4246");
        shelterValues.put(COLUMN_SHELTEREMAIL, "None");
        db.insert(TABLE_SHELTER, COLUMN_SHELTERID, shelterValues);

        shelterValues.put(COLUMN_SHELTERNAME, "City of Garland Animal Services");
        shelterValues.put(COLUMN_SHELTERADDRESS, "600 Tower Drive Garland, TX 75040");
        shelterValues.put(COLUMN_SHELTERDESCRIPTION, "None.");
        shelterValues.put(COLUMN_SHELTERPHONE, "(972)205-3570, #2");
        shelterValues.put(COLUMN_SHELTEREMAIL, "springf@ci.garland.tx.us; \n" +
                " jomartin@ci.garland.tx.us;\n " +
                "rdjohnso@ci.garland.tx.us");
        db.insert(TABLE_SHELTER, COLUMN_SHELTERID, shelterValues);

        shelterValues.put(COLUMN_SHELTERNAME, "Bloomington Animal Shelter");
        shelterValues.put(COLUMN_SHELTERADDRESS, "3410 S Walnut St, Bloomington, IN 47401");
        shelterValues.put(COLUMN_SHELTERDESCRIPTION,"A division of the Department of Public Works, " +
                "Animal Care and Control operates the City of Bloomington Animal Shelter and provides animal control assistance for the City. " +
                "Bloomington Animal Care and Control's mission is to address and respond to all animal needs in the community through education, " +
                "enforcement and support in order to build a community where animals are valued and treated with kindness and respect.");
        shelterValues.put(COLUMN_SHELTERPHONE, "(812)349-3492");
        shelterValues.put(COLUMN_SHELTEREMAIL, "animal@bloomington.in.gov");
        db.insert(TABLE_SHELTER, COLUMN_SHELTERID, shelterValues);

        shelterValues.put(COLUMN_SHELTERNAME, "Animal Shelter");
        shelterValues.put(COLUMN_SHELTERADDRESS,"1800 West Old Shakopee Road, Bloomington, MN 55431-3027");
        shelterValues.put(COLUMN_SHELTERDESCRIPTION, "A shelter to find home for our beloved animals.");
        shelterValues.put(COLUMN_SHELTERPHONE, "(952)563-4900");
        shelterValues.put(COLUMN_SHELTEREMAIL, "police@BloomingtonMN.gov");
        db.insert(TABLE_SHELTER, COLUMN_SHELTERID, shelterValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //if the table already exist, drop it
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PETINFORMATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHELTER);

        //recreate the table by calling onCreate()
        onCreate(db);
    }
    //read all the data in database
    public ArrayList<PetInformation> readAllData() {
        ArrayList<PetInformation> data = new ArrayList<PetInformation>();
        String selectQuery = "SELECT * FROM " + TABLE_PETINFORMATION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        //looping through all the rows and adding them to the arraylist

        if (c.moveToFirst()) {
            do {
                PetInformation petInfo = new PetInformation();
                petInfo.setmPetID(c.getInt(c.getColumnIndex(COLUMN_PETID)));
                petInfo.setmPetName(c.getString(c.getColumnIndex(COLUMN_PETNAME)));
                petInfo.setmPetImage(c.getInt(c.getColumnIndex(COLUMN_PETIMAGE)));
                petInfo.setmPetType(c.getString(c.getColumnIndex(COLUMN_PETTYPE)));
                petInfo.setmPetBreed(c.getString(c.getColumnIndex(COLUMN_PETBREED)));
                petInfo.setmPetAge(c.getString(c.getColumnIndex(COLUMN_PETAGE)));
                petInfo.setmPetSize(c.getString(c.getColumnIndex(COLUMN_PETSIZE)));
                petInfo.setmPetGender(c.getString(c.getColumnIndex(COLUMN_PETGENDER)));
                petInfo.setmPetHealth(c.getString(c.getColumnIndex(COLUMN_PETHEALTH)));
                petInfo.setmPetFee(c.getFloat(c.getColumnIndex(COLUMN_PETFEE)));
                petInfo.setmPetIsAvailable(c.getInt(c.getColumnIndex(COLUMN_ISAVAILABLE)));
                petInfo.setmPetIsFavorite(c.getInt(c.getColumnIndex(COLUMN_ISFAVORITE)));
                petInfo.setmShelterID(c.getInt(c.getColumnIndex(COLUMN_PET_SHELTERID)));

                data.add(petInfo);
            } while (c.moveToNext());
        }
        return data;
    }
    //fetch a row from PetInformation table
    public PetInformation fetchARow(int id){
        String selectQuery = "SELECT * FROM " + TABLE_PETINFORMATION + " WHERE " + COLUMN_PETID + "=" + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c!=null)
            c.moveToFirst();

        PetInformation petInfo = new PetInformation();
        petInfo.setmPetID(c.getInt(c.getColumnIndex(COLUMN_PETID)));
        petInfo.setmPetName(c.getString(c.getColumnIndex(COLUMN_PETNAME)));
        petInfo.setmPetImage(c.getInt(c.getColumnIndex(COLUMN_PETIMAGE)));
        petInfo.setmPetType(c.getString(c.getColumnIndex(COLUMN_PETTYPE)));
        petInfo.setmPetBreed(c.getString(c.getColumnIndex(COLUMN_PETBREED)));
        petInfo.setmPetAge(c.getString(c.getColumnIndex(COLUMN_PETAGE)));
        petInfo.setmPetSize(c.getString(c.getColumnIndex(COLUMN_PETSIZE)));
        petInfo.setmPetGender(c.getString(c.getColumnIndex(COLUMN_PETGENDER)));
        petInfo.setmPetHealth(c.getString(c.getColumnIndex(COLUMN_PETHEALTH)));
        petInfo.setmPetFee(c.getFloat(c.getColumnIndex(COLUMN_PETFEE)));
        petInfo.setmPetIsAvailable(c.getInt(c.getColumnIndex(COLUMN_ISAVAILABLE)));
        petInfo.setmPetIsFavorite(c.getInt(c.getColumnIndex(COLUMN_ISFAVORITE)));
        petInfo.setmShelterID(c.getInt(c.getColumnIndex(COLUMN_PET_SHELTERID)));

        return petInfo;
    }

    //fetch a row from Shelter table
    public ShelterInformation fetchARowShelter(int id){
        String selectQuery = "SELECT * FROM " +TABLE_SHELTER + " WHERE " + COLUMN_SHELTERID + "=" + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery,null);

        if (c!=null)
            c.moveToFirst();

        ShelterInformation shelterInfo = new ShelterInformation();
        shelterInfo.setmShelterID(c.getInt(c.getColumnIndex(COLUMN_SHELTERID)));
        shelterInfo.setmShelterName(c.getString(c.getColumnIndex(COLUMN_SHELTERNAME)));
        shelterInfo.setmShelterAddress(c.getString(c.getColumnIndex(COLUMN_SHELTERADDRESS)));
        shelterInfo.setmShelterDescription(c.getString(c.getColumnIndex(COLUMN_SHELTERDESCRIPTION)));
        shelterInfo.setmShelterPhone(c.getString(c.getColumnIndex(COLUMN_SHELTERPHONE)));
        shelterInfo.setmShelterEmail(c.getString(c.getColumnIndex(COLUMN_SHELTEREMAIL)));

        return shelterInfo;
    }

    //update all data with value 1 in column isfavorite to 0
    public void updateIsNotFavorite(){
        String query = "UPDATE " + TABLE_PETINFORMATION + " SET " + COLUMN_ISFAVORITE + "=0" +
                " WHERE " + COLUMN_ISFAVORITE + "=1";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(query);
    }

    //fetch all favorite data
    public ArrayList<PetInformation> fetchAllFavorite(){
        ArrayList<PetInformation> data = new ArrayList<PetInformation>();
        String selectQuery = "SELECT * FROM " + TABLE_PETINFORMATION + " WHERE " + COLUMN_ISFAVORITE + "=1";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        //looping through all the rows and adding them to the arraylist
        if (c.moveToFirst()) {
            do {
                PetInformation petInfo = new PetInformation();
                petInfo.setmPetID(c.getInt(c.getColumnIndex(COLUMN_PETID)));
                petInfo.setmPetName(c.getString(c.getColumnIndex(COLUMN_PETNAME)));
                petInfo.setmPetImage(c.getInt(c.getColumnIndex(COLUMN_PETIMAGE)));
                petInfo.setmPetType(c.getString(c.getColumnIndex(COLUMN_PETTYPE)));
                petInfo.setmPetBreed(c.getString(c.getColumnIndex(COLUMN_PETBREED)));
                petInfo.setmPetAge(c.getString(c.getColumnIndex(COLUMN_PETAGE)));
                petInfo.setmPetSize(c.getString(c.getColumnIndex(COLUMN_PETSIZE)));
                petInfo.setmPetGender(c.getString(c.getColumnIndex(COLUMN_PETGENDER)));
                petInfo.setmPetHealth(c.getString(c.getColumnIndex(COLUMN_PETHEALTH)));
                petInfo.setmPetFee(c.getFloat(c.getColumnIndex(COLUMN_PETFEE)));
                petInfo.setmPetIsAvailable(c.getInt(c.getColumnIndex(COLUMN_ISAVAILABLE)));
                petInfo.setmPetIsFavorite(c.getInt(c.getColumnIndex(COLUMN_ISFAVORITE)));
                petInfo.setmShelterID(c.getInt(c.getColumnIndex(COLUMN_PET_SHELTERID)));

                data.add(petInfo);
            } while (c.moveToNext());
        }
        return data;
    }

    //update data if it is marked as favorite
    public void updateIsFavorite(int petID){
        String query = "UPDATE " + TABLE_PETINFORMATION + " SET " + COLUMN_ISFAVORITE +
                "=1" + " WHERE " + COLUMN_PETID + "=\"" + petID + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(query);
    }
}
