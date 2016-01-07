package com.example.taqtile.onboard;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.taqtile.onboard.User;
import com.example.taqtile.onboard.CustomAdapter;

import java.util.ArrayList;
import java.util.HashMap;


public class Main extends ActionBarActivity{
    private User mUsuario = new User();
    private HashMap<Integer, User.info> mListaDados;
    private CustomAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for(int i = 0; i < 10; i++) mUsuario.resetViewCount(i);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListaDados = mUsuario.list(0);
        final String[] infoUsuarios = new String[10];
        for(int i = 0; i < 10; i++){
            infoUsuarios[i] = mListaDados.get(i).first_name+"  "+mListaDados.get(i).last_name;
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
}
