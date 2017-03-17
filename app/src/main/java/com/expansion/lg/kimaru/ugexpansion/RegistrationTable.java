package com.expansion.lg.kimaru.ugexpansion;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/*
public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_USERS = "users";
    public static final String TABLE_EXAM = "exam";
    public static final String TABLE_RECRUITMENT = "recruitment";
    public static final String TABLE_REGISTRATION = "registration";
    public static final String TABLE_INTERVIEW = "interview";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_COMMENT = "comment";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_LAST_LOGIN = "last_login";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_ADDED_BY = "added_by";
    public static final String COLUMN_FULLNAMES = "fullnames";
    public static final String COLUMN_LON = "lon";
    public static final String COLUMN_LAT = "lat";
    public static final String COLUMN_CREATED = "created";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_DELETED = "deleted";
    public static final String COLUMN_PASSED = "passed";

    public static final String PHONE = "phone";
    public static final String GENDER = "gender";
    public static final String VILLAGE = "village";
    public static final String LANDMARK = "landmark";
    public static final String OCCUPANCY = "occupancy";
    public static final String ENGLISH = "english";
    public static final String LANGUAGES = "languages";
    public static final String BRAC = "brac";
    public static final String BRAC_CHP = "brac_chp";
    public static final String VHT = "vht";
    public static final String EDUCATION = "education";
    public static final String OCCUPATION = "occupation";
    public static final String PARTICIPATION = "";
    public static final String RECRUITMENT_ID = "recruitment_id";

    public static final String MATHS = "maths";
    public static final String COMPREHENSION = "comprehension";
    public static final String SELF_ASSESMENT = "self_assesment";
    public static final String REG_ID = "registration_id";

    public static final String MOTIVATION = "motivation";
    public static final String COMMUNITY_WORK = "community_work";
    public static final String MENTALITY = "mentality";
    public static final String SELLING = "selling";
    public static final String HEALTH = "health";
    public static final String INVESTMENT = "investment";
    public static final String INTERPERSONAL = "interpersonal";
    public static final String DEDICATION = "commitment";

    public static final String DATABASE_NAME = "lg_ops.db";
    public static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String USERS_TABLE = "create table "
            + TABLE_USERS + "( "
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_EMAIL + " varchar(90), "
            + COLUMN_PHONE + " varchar(90), "
            + COLUMN_LAST_LOGIN + "integer default 0, "
            + COLUMN_FULLNAMES + "varchar(120), "
            + COLUMN_PASSWORD + " varchar(250), "
            + COLUMN_LAST_LOGIN + "integer default 0, "
            + COLUMN_DELETED + "integer default 0, "
            + COLUMN_COMMENT + " text);";

    private static final String RECRUITMENT_TABLE = "create table "
            + TABLE_RECRUITMENT + "( "
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TITLE + " varchar(90), "
            + COLUMN_CREATED + " integer default 0, "
            + COLUMN_ADDED_BY + "integer default 0, "
            + COLUMN_LOCATION + "integer default 0, "
            + COLUMN_LAT + " varchar(200) default '0', "
            + COLUMN_LON + "varchar(200) default '0', "
            + COLUMN_DELETED + "integer default 0);";

    private static final String REGISTRATION_TABLE = "create table "
            + TABLE_REGISTRATION + "( "
            + COLUMN_TITLE + " varchar(120), "
            + PHONE + " varchar(120), "
            + GENDER + " integer default 0, "
            + VILLAGE + " varchar(120), "
            + LANDMARK + " varchar(256), "
            + OCCUPANCY + " varchar(120), "
            + ENGLISH + " integer default 0, "
            + LANGUAGES + " varchar(512), "
            + BRAC + " integer default 0, "
            + BRAC_CHP + " integer default 0, "
            + VHT + " integer default 0, "
            + EDUCATION + " varchar(128), "
            + OCCUPATION + " varchar(128), "
            + PARTICIPATION + " integer default 0, "
            + RECRUITMENT_ID + " integer default 0, "
            + COLUMN_ADDED_BY + " integer default 0, "
            + COLUMN_CREATED + " integer default 0, "
            + COLUMN_COMMENT + " text, "
            + COLUMN_PASSED + " integer default 0, "
            + COLUMN_DELETED + " integer default 0); ";


    private static final String EXAM_TABLE = "create table "
            + TABLE_EXAM + "( "
            + MATHS + " varchar(120), "
            + COMPREHENSION + " integer default 0, "
            + SELF_ASSESMENT + " integer default 0, "
            + REG_ID + " integer default 0, "
            + RECRUITMENT_ID + " integer default 0, "
            + COLUMN_ADDED_BY + " integer default 0, "
            + COLUMN_CREATED + " integer default 0, "
            + COLUMN_COMMENT + " text, "
            + COLUMN_DELETED + " integer default 0); ";



    private static final String INTERVIEW_TABLE = "create table "
            + TABLE_INTERVIEW + "( "
            + MOTIVATION + " integer default 0, "
            + COMMUNITY_WORK + " integer default 0, "
            + MENTALITY + " integer default 0, "
            + SELLING + " integer default 0, "
            + HEALTH + " integer default 0, "
            + INVESTMENT + " integer default 0, "
            + INTERPERSONAL + " integer default 0, "
            + DEDICATION + " text, "
            + COLUMN_ADDED_BY + " integer default 0, "
            + COLUMN_DELETED + " integer default 0); ";

    public DataBaseHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        database.execSQL(USERS_TABLE);
        database.execSQL(RECRUITMENT_TABLE);
        database.execSQL(REGISTRATION_TABLE);
        database.execSQL(EXAM_TABLE);
        database.execSQL(INTERVIEW_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
*/

/**
 * Created by kimaru on 2/28/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class RegistrationTable extends SQLiteOpenHelper {

    public static final String TABLE_NAME="registration";
    public static final String DATABASE_NAME="expansion";
    public static final int DATABASE_VERSION=1;

    public static String varchar_field = " varchar(512) ";
    public static String primary_field = " id INTEGER PRIMARY KEY AUTOINCREMENT ";
    public static String integer_field = " integer default 0 ";
    public static String text_field = " text ";

    public static final String ID = "id";
    public static final String NAME= "name";
    public static final String PHONE = "phone";
    public static final String GENDER = "gender";
    public static final String DOB = "dob";
    public static final String DISTRICT = "district";
    public static final String SUB_COUNTY = "subcounty";
    public static final String DIVISION = "division";
    public static final String VILLAGE = "village";
    public static final String MARK = "feature";
    public static final String READ_ENGLISH = "english";
    public static final String DATE_MOVED = "date_moved";
    public static final String LANGS = "languages";
    public static final String BRAC = "brac";
    public static final String BRAC_CHP = "brac_chp";
    public static final String EDUCATION = "education";
    public static final String OCCUPATION = "occupation";
    public static final String COMMUNITY = "community_membership";
    public static final String ADDED_BY = "added_by";
    public static final String COMMENT = "comment";
    public static final String PROCEED = "proceed";
    public static final String DATE_ADDED = "date_added";
    public static final String SYNCED = "synced";

    public static final String CREATE_DATABASE="CREATE TABLE " + TABLE_NAME + "("
            + primary_field + ", "
            + NAME + varchar_field + ", "
            + PHONE + varchar_field + ", "
            + GENDER + varchar_field + ", "
            + DOB + integer_field + ", "
            + DISTRICT + varchar_field + ", "
            + SUB_COUNTY + varchar_field + ", "
            + DIVISION + varchar_field + ", "
            + VILLAGE + varchar_field + ", "
            + MARK + text_field + ", "
            + READ_ENGLISH + integer_field + ", "
            + DATE_MOVED + integer_field + ", "
            + LANGS + varchar_field + ", "
            + BRAC + integer_field + ", "
            + BRAC_CHP + integer_field + ", "
            + EDUCATION + text_field + ", "
            + OCCUPATION + text_field + ", "
            + COMMUNITY + integer_field + ", "
            + ADDED_BY + integer_field + ", "
            + COMMENT + text_field + ", "
            + PROCEED + integer_field + ", "
            + DATE_ADDED + integer_field + ", "
            + SYNCED + integer_field + ", "
            + ")";

    public static final String DATABASE_DROP="DROP TABLE IF EXISTS" + TABLE_NAME;

    public RegistrationTable(Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_DATABASE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w("RegistrationTable", "upgrading database from" + oldVersion + "to" + newVersion);
        db.execSQL(DATABASE_DROP);
    }

    public long addData(Registration registration) {

        SQLiteDatabase db=getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(NAME, registration.getName());
        cv.put(PHONE, registration.getPhone());
        cv.put(GENDER, registration.getGender());
        cv.put(DOB, registration.getDob());
        cv.put(DISTRICT, registration.getDistrict());
        cv.put(SUB_COUNTY, registration.getSubcounty());
        cv.put(DIVISION, registration.getDivision());
        cv.put(VILLAGE, registration.getVillage());
        cv.put(MARK, registration.getMark());
        cv.put(READ_ENGLISH, registration.getReadEnglish());
        cv.put(DATE_MOVED, registration.getDateMoved());
        cv.put(LANGS, registration.getLangs());
        cv.put(BRAC, registration.getBrac());
        cv.put(BRAC_CHP, registration.getBracChp());
        cv.put(EDUCATION, registration.getEducation());
        cv.put(OCCUPATION, registration.getOccupation());
        cv.put(COMMUNITY, registration.getCommunity());
        cv.put(ADDED_BY, registration.getAddedBy());
        cv.put(COMMENT, registration.getComment());
        cv.put(PROCEED, registration.getProceed());
        cv.put(DATE_ADDED, registration.getDateAdded());
        cv.put(SYNCED, registration.getSynced());

        long id=db.insert(TABLE_NAME,null,cv);

        db.close();
        return id;

    }

    public List<Registration> getRegistrationData() {

        SQLiteDatabase db=getReadableDatabase();

        String [] columns=new String[]{NAME, PHONE, GENDER, DOB, DISTRICT, SUB_COUNTY, DIVISION,
                VILLAGE, MARK, READ_ENGLISH, DATE_MOVED, LANGS, BRAC, BRAC_CHP, EDUCATION, OCCUPATION,
                COMMUNITY, ADDED_BY, COMMENT, PROCEED, DATE_ADDED, SYNCED};

        Cursor cursor=db.query(TABLE_NAME,columns,null,null,null,null,null,null);

        List<Registration> registrationList=new ArrayList<>();


        for (cursor.moveToFirst(); !cursor.isAfterLast();cursor.moveToNext()){


            Registration registration=new Registration();

            registration.setName(cursor.getString(0));
            registration.setPhone(cursor.getString(1));
            registration.setGender(cursor.getString(2));
            registration.setDob(cursor.getInt(2));
            registration.setDistrict(cursor.getString(2));
            registration.setSubcounty(cursor.getString(2));
            registration.setDivision(cursor.getString(2));
            registration.setVillage(cursor.getString(2));
            registration.setMark(cursor.getString(2));
            registration.setReadEnglish(cursor.getInt(2));
            registration.setDateMoved(cursor.getInt(2));
            registration.setLangs(cursor.getString(2));
            registration.setBrac(cursor.getInt(2));
            registration.setBracChp(cursor.getInt(2));
            registration.setEducation(cursor.getString(2));
            registration.setOccupation(cursor.getString(2));
            registration.setCommunity(cursor.getInt(2));
            registration.setAddedBy(cursor.getInt(2));
            registration.setComment(cursor.getString(2));
            registration.setProceed(cursor.getInt(2));
            registration.setDateAdded(cursor.getInt(2));
            registration.setSynced(cursor.getInt(2));




            registrationList.add(registration);
        }

        db.close();

        return registrationList;
    }
}

