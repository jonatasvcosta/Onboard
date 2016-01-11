package com.example.taqtile.onboard;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class viewUsers extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.CarregaDados();
        final ArrayList first_name, last_name, avatar;
        first_name = new ArrayList();
        last_name = new ArrayList();
        avatar = new ArrayList();
        final int [] viewCount;
        do{
            first_name.add(cursor.getString(cursor.getColumnIndex(CriaBanco.FIRST_NAME)));
            last_name.add(cursor.getString(cursor.getColumnIndex(CriaBanco.LAST_NAME)));
            avatar.add(cursor.getString(cursor.getColumnIndex(CriaBanco.AVATAR)));
        }while(cursor.moveToNext());
        String[] infoUsuarios = new String[first_name.size()];
        viewCount = new int[first_name.size()];
        for(int i = 0; i < first_name.size(); i++){
            infoUsuarios[i] = first_name.get(i).toString() + " " + last_name.get(i).toString();
            viewCount[i] = 0;
        }
        final CustomAdapter mAdapter = new CustomAdapter(this,infoUsuarios,viewCount);
        ListView lista = (ListView) findViewById(R.id.users_database_list);
        lista.setAdapter(mAdapter);
        final Intent intent = new Intent(this, DetalheUsuario.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                         @Override
                                         public void onItemClick(AdapterView<?> parent, View view,
                                                                    int position, long id) {
                                            intent.putExtra("first_name", first_name.get(position).toString());
                                            intent.putExtra("last_name", last_name.get(position).toString());
                                            intent.putExtra("avatar", avatar.get(position).toString());
                                            viewCount[position] = 1;
                                            mAdapter.notifyDataSetChanged();
                                            startActivity(intent);
                                        }
                                    }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_users, menu);
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
}