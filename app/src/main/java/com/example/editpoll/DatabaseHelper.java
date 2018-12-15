package com.example.editpoll;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "Poll.db";
    // private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Poll";
    public static final String COL_ID = "_id";
 //   public static final String COL_NUM= "number";
    public static final String COL_SCO = "Score";
    public static final String COL_IMAGE = "imege";


    private static final String SQL_CREATE_TABLE_POLL
            = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//            + COL_NUM+ " TEXT,"
            + COL_SCO + " TEXT,"
            + COL_IMAGE + "TEXT"
            + ")";

    public DatabaseHelper(Context context) {
        super(context, "Poll.db", null, 3);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_POLL);

        ContentValues cv = new ContentValues();
        cv.put(COL_SCO, "0");
        cv.put(COL_IMAGE,"one.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_SCO, "0");
        cv.put(COL_IMAGE,"two.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_SCO, "0");
        cv.put(COL_IMAGE,"three.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_SCO, "0");
        cv.put(COL_IMAGE,"vote_no.png");
        db.insert(TABLE_NAME, null, cv);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


