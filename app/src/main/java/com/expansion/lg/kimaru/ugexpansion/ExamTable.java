package com.expansion.lg.kimaru.ugexpansion;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by kimaru on 2/28/17.
 */


public class ExamTable extends SQLiteOpenHelper {

    public static final String TABLE_NAME="exam";
    public static final String DATABASE_NAME="expansion";
    public static final int DATABASE_VERSION=1;


    public static String varchar_field = " varchar(512) ";
    public static String primary_field = " id INTEGER PRIMARY KEY AUTOINCREMENT ";
    public static String integer_field = " integer default 0 ";
    public static String text_field = " text ";

    public static final String APPLICANT= "applicant";
    public static final String RECRUITMENT = "recruitment";
    public static final String MATH = "math";
    public static final String PERSONALITY = "personality";
    public static final String ENGLISH = "english";
    public static final String ADDED_BY = "added_by";
    public static final String COMMENT = "comment";
    public static final String DATE_ADDED = "date_added";
    public static final String SYNCED = "synced";

    public static final String CREATE_DATABASE="CREATE TABLE " + TABLE_NAME + "("
            + primary_field + ", "
            + APPLICANT + integer_field + ", "
            + RECRUITMENT + integer_field + ", "
            + MATH + integer_field + ", "
            + PERSONALITY + integer_field + ", "
            + ENGLISH + integer_field + ", "
            + ADDED_BY + integer_field + ", "
            + COMMENT + text_field + ", "
            + DATE_ADDED + integer_field + ", "
            + SYNCED + integer_field + ", "
            + ")";

    public static final String DATABASE_DROP="DROP TABLE IF EXISTS" + TABLE_NAME;

    public ExamTable(Context context) {
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

    public long addData(Exam exam) {

        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(APPLICANT, exam.getApplicant());
        cv.put(RECRUITMENT, exam.getRecruitment());
        cv.put(MATH, exam.getMath());
        cv.put(PERSONALITY, exam.getPersonality());
        cv.put(ENGLISH, exam.getEnglish());
        cv.put(ADDED_BY, exam.getAddedBy());
        cv.put(COMMENT, exam.getComment());
        cv.put(DATE_ADDED, exam.getDateAdded());
        cv.put(SYNCED, exam.getSynced());

        long id=db.insert(TABLE_NAME,null,cv);

        db.close();
        return id;

    }
    public List<Exam> getExamData() {

        SQLiteDatabase db=getReadableDatabase();

        String [] columns=new String[]{APPLICANT, RECRUITMENT, MATH, PERSONALITY, ENGLISH, ADDED_BY, COMMENT, DATE_ADDED, SYNCED};

        Cursor cursor=db.query(TABLE_NAME,columns,null,null,null,null,null,null);

        List<Exam> examList=new ArrayList<>();


        for (cursor.moveToFirst(); !cursor.isAfterLast();cursor.moveToNext()){


            Exam exam=new Exam();

            exam.setApplicant(cursor.getInt(0));
            exam.setRecruitment(cursor.getInt(1));
            exam.setMath(cursor.getInt(2));
            exam.setPersonality(cursor.getInt(3));
            exam.setEnglish(cursor.getInt(4));
            exam.setAddedBy(cursor.getInt(5));
            exam.setComment(cursor.getString(6));
            exam.setDateAdded(cursor.getInt(7));
            exam.setSynced(cursor.getInt(8));

            examList.add(exam);
        }
        db.close();

        return examList;
    }
}

