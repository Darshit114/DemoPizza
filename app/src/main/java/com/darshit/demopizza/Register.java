package com.darshit.demopizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText edtFname, edtLname, edtUsername, edtPassword;
    Button btnRegister;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        btnRegister = findViewById(R.id.btnRegister);
        edtFname = findViewById(R.id.edtFname);
        edtLname = findViewById(R.id.edtLname);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        db = new DatabaseHelper(Register.this);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Register.this, HomeActivity.class));

                String firstname = edtFname.getText().toString();
                String lastname = edtLname.getText().toString();
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                Validate validate = new Validate();
                if (!validate.eValidation(username)) {

                    edtUsername.setError("Invalid E-mail address");
                } else if (firstname.isEmpty() && lastname.isEmpty() && password.isEmpty()) {
                    Toast.makeText(Register.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {

                        db.addUser(firstname, lastname, username, password);
                        startActivity(new Intent(Register.this, MainActivity.class));
                        finish();

                       /* Log.d("insert",""+isInserted);
                        boolean isInserted =
                        if (isInserted == true) {
                            finish();
                            Toast.makeText(Register.this, "Register Sucessfully..!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Register.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                        }*/

                       // Log.d("My Error", e.toString());

                }
            }
        });


    }
}
