package com.example.taqtile.onboard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by taqtile on 1/11/16.
 */
public class CriaBanco extends SQLiteOpenHelper {
    private static final String BASE_NAME = "userData.db";
    public static final String TABLE = "USERS";
    public static final String ID = "_id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String AVATAR = "avatar";
    public static final String COUNT_VIEW = "count_view";
    public static final int VERSION = 1;

    public CriaBanco(Context context) {
        super(context, BASE_NAME,null , VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABLE+" ("
        + ID+ " integer primary key autoincrement, "
        + FIRST_NAME + " text, "
        + LAST_NAME + " text, "
        + AVATAR + " text , "
        + COUNT_VIEW + " integer); ";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE);
        onCreate(db);
    }
}
