package com.darshit.demopizza;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    TextView txtRegister;
    DatabaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        preferences = getSharedPreferences("Login", MODE_PRIVATE);
        String Username = preferences.getString("username", "");
        if (!Username.equals("")) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.putExtra("username", Username);
            startActivity(intent);
        }
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                String valUsername = edtUsername.getText().toString();
                String valPassword = edtPassword.getText().toString();
                db = new DatabaseHelper(MainActivity.this);
                try {

                    if (db.validateUser(valUsername, valPassword)) {
                        //int id = 1;
                        int id = db.getUSerid(valUsername, valPassword);
                        Log.d("IDUSER",""+id);
                        editor = preferences.edit();
                        editor.putString("username", valUsername);
                        editor.putInt("USERID", id);
                        editor.commit();

                        startActivity(new Intent(MainActivity.this, HomeActivity.class).putExtra("username", valUsername));
                        finish();

                    } else {
                        Toast.makeText(MainActivity.this, "invalid Username and Password", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Log.e("My Error", e.toString());
                }


            }
        });
        txtRegister = findViewById(R.id.txtRegister);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);

    }


}

