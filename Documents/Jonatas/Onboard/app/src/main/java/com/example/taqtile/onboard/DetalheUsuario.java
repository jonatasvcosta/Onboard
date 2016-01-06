package com.example.taqtile.onboard;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.view.*;

public class DetalheUsuario extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_usuario);
        Intent intent = getIntent();
        TextView view = (TextView) findViewById(R.id.nome);
        view.setText(intent.getStringExtra("first_name"));
        view = (TextView) findViewById(R.id.sobrenome);
        view.setText(intent.getStringExtra("last_name"));
        view = (TextView) findViewById(R.id.avatar);
        if(intent.getStringExtra("avatar").length() <= 25) view.setText(intent.getStringExtra("avatar"));
        else view.setText(intent.getStringExtra("avatar").substring(0,22)+"...");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalhe_usuario, menu);
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
