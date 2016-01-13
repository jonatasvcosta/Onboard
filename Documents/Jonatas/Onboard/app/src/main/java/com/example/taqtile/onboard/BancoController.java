package com.example.taqtile.onboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

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
    public String AlteraDados(String first_name, String last_name, String avatar, String id){
        ContentValues values;
        long result = 1;
        db = banco.getWritableDatabase();
        values = new ContentValues();
        values.put(CriaBanco.FIRST_NAME, first_name);
        values.put(CriaBanco.LAST_NAME, last_name);
        values.put(CriaBanco.AVATAR,avatar);
        //result = db.update(CriaBanco.TABLE, values, CriaBanco.FIRST_NAME+" = '"+first_name+"' AND "+CriaBanco.LAST_NAME+" = '"+last_name+"'", null);
        result = db.update(CriaBanco.TABLE, values, CriaBanco.FIRST_NAME+" = '"+first_name+"'", null);
//        result = db.update(CriaBanco.TABLE, values, "_id = "+id,null);
        db.close();
        if (result == -1) return "Error when editing user";
        return "User edited successfully";
    }

    public Cursor CarregaDados() {
//        Cursor cursor = null;
//        db = banco.getWritableDatabase();
//        String[] fields = {CriaBanco.ID, CriaBanco.FIRST_NAME};
//        cursor = db.rawQuery("SELECT * from "+CriaBanco.TABLE,null);
//        db.close();
//        if (cursor != null) cursor.moveToFirst();
//        return cursor;
        Cursor cursor;
        String[] campos = {banco.ID, banco.FIRST_NAME, banco.LAST_NAME, banco.AVATAR, banco.COUNT_VIEW};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABLE, campos, null, null, null, null, null, null);
        if(cursor != null) cursor.moveToFirst();
        db.close();
        return cursor;
    }
    public Cursor getAllData(){
        String sql = "SELECT * FROM "+CriaBanco.TABLE;
        return db.rawQuery(sql, null);
    }
    public int DeletarDados(String name, String lastname, String position){
        db = banco.getWritableDatabase();
        return db.delete(CriaBanco.TABLE,CriaBanco.FIRST_NAME+" = '"+name+"' AND "+CriaBanco.LAST_NAME+" = '"+lastname+"'", null);
//        String sql = "DELETE FROM "+CriaBanco.TABLE+" WHERE "+CriaBanco.ID+" = "+position;
//        db.execSQL(sql);
        //return db.delete(CriaBanco.TABLE, CriaBanco.ID+" = 1",null);
        //return db.delete(CriaBanco.TABLE, "first_name = ''", null);
        //return db.delete(CriaBanco.TABLE, "_id=2", null);

    }
}
