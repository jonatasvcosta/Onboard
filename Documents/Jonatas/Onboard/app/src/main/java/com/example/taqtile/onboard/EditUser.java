package com.example.taqtile.onboard;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EditUser extends ActionBarActivity {
    private String previousName, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        final BancoController crud = new BancoController(getApplicationContext());
        Button addButton = (Button) findViewById(R.id.button_add);
        final Intent intent = getIntent();
        EditText firstName = (EditText) findViewById(R.id.ufirst_name);
        firstName.setText(intent.getStringExtra("firstName"));
        previousName = intent.getStringExtra("firstName");
        id = intent.getStringExtra("position");
        EditText lastName = (EditText) findViewById(R.id.ulast_name);
        lastName.setText(intent.getStringExtra("lastName"));
        EditText avatar = (EditText) findViewById(R.id.uavatar);
        avatar.setText(intent.getStringExtra("avatar"));
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText firstName = (EditText) findViewById(R.id.ufirst_name);
                EditText lastName = (EditText) findViewById(R.id.ulast_name);
                EditText avatar = (EditText) findViewById(R.id.uavatar);
                String result;
                result = crud.AlteraDados(previousName, lastName.getText().toString(), avatar.getText().toString(),id);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), lastName.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_user, menu);
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
    public void viewUsers(View view){
        Intent intent = new Intent(this, viewUsers.class);
        startActivity(intent);
    }
}
