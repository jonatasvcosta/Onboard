package com.example.taqtile.onboard;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.JsonObjectRequest;
import com.example.taqtile.onboard.User;
import com.example.taqtile.onboard.CustomAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import android.util.Log;

import com.android.volley.*;
import org.json.JSONObject;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;

public class Main extends ActionBarActivity{
    private User mUsuario = new User();
    private HashMap<Integer, User.info> mListaDados;
    private CustomAdapter mAdapter;
//    private MyDatabase mUserDatabase;
    String mHttpUserData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for(int i = 0; i < 10; i++) mUsuario.resetViewCount(i);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListaDados = mUsuario.list(0);
        final String[] infoUsuarios = new String[10];
//        mSQLiteDatabase = mUserDatabase.getWritableDatabase();
 //       mSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS USERS(id INT PRIMARY KEY NOT NULL,first_name TEXT NOT NULL,last_name TEXT NOT NULL,avatar TEXT NOT NULL,view_count INT NOT NULL);");
//        ContentValues values = new ContentValues();
//        values.put("id",0);
//        values.put("first_name", "Manuel");
//        values.put("last_name", "Nóbrega");
//        values.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
//// insert row in table
//        long insert = mSQLiteDatabase.insert("USERS", null, values);

        for(int i = 0; i < 10; i++){
            infoUsuarios[i] = mListaDados.get(i).first_name+"  "+mListaDados.get(i).last_name;
            //infoUsuarios[i] = cursor.getString(cursor.getColumnIndex("first_name")) + " " + cursor.getString(cursor.getColumnIndex("last_name"));
        }

        mAdapter = new CustomAdapter(this, infoUsuarios, mUsuario.ViewCount);
        final ListView listView = (ListView) findViewById(R.id.lista_usuarios);
        listView.setAdapter(mAdapter);

        final Intent intent = new Intent(this, DetalheUsuario.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int itemPosition = position;
                mUsuario.incrementViewCount(itemPosition);
                mAdapter.notifyDataSetChanged();
                intent.putExtra("first_name",mListaDados.get(itemPosition).first_name);
                intent.putExtra("last_name",mListaDados.get(itemPosition).last_name);
                intent.putExtra("avatar",mListaDados.get(itemPosition).avatar);
                startActivity(intent);
            }
        });

        //tentativa de Volley (para texto):
        //final TextView responseText = (TextView)findViewById(R.id.texto_http_teste);
//
//        String url = "http://reqres.in/api/users?page=1";
//
//        final ProgressDialog pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        pDialog.show();

//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
//                url, null,
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d("App", response.toString());
//                        mHttpUserData = response.toString();
//                        String auxString = new String();
//                        Random rand;
//                        int randNum;
//                        for(int i = 0; i != -1; i = mHttpUserData.indexOf("first_name",i+1)) {
//                            rand = new Random();
//                            randNum = rand.nextInt(10);
//                            infoUsuarios[randNum] = "";
//                            auxString = mHttpUserData.substring(mHttpUserData.indexOf("first_name", i) + 13, mHttpUserData.indexOf("last_name", i) - 3);
//                            infoUsuarios[randNum] += auxString+" ";
//                            mListaDados.get(randNum).first_name = auxString;
//                            auxString = mHttpUserData.substring(mHttpUserData.indexOf("last_name", i) + 12, mHttpUserData.indexOf("avatar", i) - 3);
//                            infoUsuarios[randNum] += auxString;
//                            mListaDados.get(randNum).last_name = auxString;
//                            auxString = mHttpUserData.substring(mHttpUserData.indexOf("avatar", i) + 9, mHttpUserData.indexOf("}", i) - 1);
//                            mListaDados.get(randNum).avatar = auxString.replace("\\","");
//                        }
//                        mAdapter.notifyDataSetChanged();
//                        pDialog.hide();
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d("App", "Error: " + error.getMessage());
//                // hide the progress dialog
//                pDialog.hide();
//            }
//        });
//
//        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjReq);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void newUser(View view){
        Intent intent = new Intent(this, AddUser.class);
        startActivity(intent);
    }
}
