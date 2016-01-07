package com.example.taqtile.onboard;

import android.app.ProgressDialog;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.view.*;
import android.widget.Toast;

import com.android.volley.*;
import org.json.JSONObject;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;

import static android.widget.Toast.*;

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
        //Tentativa de adicionar Volley:
        ImageLoader imageLoader = VolleySingleton.getInstance(this).getImageLoader();

// If you are using normal ImageView
        imageLoader.get(intent.getStringExtra("avatar"), new ImageLoader.ImageListener() {
            ImageView imageView = (ImageView) findViewById(R.id.user_avatar);
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("IMG_ERROR", "Image Load Error: " + error.getMessage());
            }

            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean arg1) {
                if (response.getBitmap() != null) {
                    // load image into imageview
                    imageView.setImageBitmap(response.getBitmap());
                }
            }
        });


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

    public void voltar(View view){
//        Intent intent = new Intent(this, Main.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//        startActivity(intent);
        onBackPressed();
    }
}
