package com.example.taqtile.onboard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by taqtile on 1/8/16.
 */
public class Database{
    private SQLiteDatabase mUserDatabase;
    public Database(String nome){
        mUserDatabase = SQLiteDatabase.openDatabase(nome,null,0);
    }
}
