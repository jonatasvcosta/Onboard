package com.example.taqtile.onboard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by taqtile on 1/11/16.
 */
public class CriaBanco extends SQLiteOpenHelper {
    private static final String BASE_NAME = "userData.db";
    private static final String TABLE = "USERS";
    private static final String ID = "_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String AVATAR = "avatar";
    private static final String COUNT_VIEW = "count_view";
    private static final int VERSAO = 1;

    public CriaBanco(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABLE+"("
        + ID+ "integer primary key,"
        + FIRST_NAME + "text,"
        + LAST_NAME + "text,"
        + AVATAR + "text,"
        + COUNT_VIEW + "integer);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE);
        onCreate(db);
    }
}
