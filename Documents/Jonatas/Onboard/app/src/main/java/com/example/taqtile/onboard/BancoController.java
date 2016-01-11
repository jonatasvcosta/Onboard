package com.example.taqtile.onboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.taqtile.onboard.CriaBanco;

/**
 * Created by taqtile on 1/11/16.
 */
public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;
    public BancoController(Context context){
        banco = new CriaBanco(context);
    }
    public String InsereDados(String first_name, String last_name, String avatar){
        ContentValues values;
        long result = 1;
          db = banco.getWritableDatabase();
        values = new ContentValues();
        values.put(CriaBanco.FIRST_NAME, first_name);
        values.put(CriaBanco.LAST_NAME, last_name);
        values.put(CriaBanco.AVATAR,avatar);
        values.put(CriaBanco.COUNT_VIEW,0);
        result = db.insertOrThrow(CriaBanco.TABLE, null, values);
        db.close();
        if (result == -1) return "Error when adding user to database";
        return "User added to database";
    }
}
