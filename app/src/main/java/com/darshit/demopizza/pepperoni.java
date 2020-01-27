package com.darshit.demopizza;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class pepperoni extends AppCompatActivity {


    ImageView imageView;
    TextView tv;
    Button order_btn,cart_btn;
    EditText qunt,num,addr;
    DatabaseHelper db;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pepperoni);
        this.setTitle("PizzaOrder");

        imageView = findViewById(R.id.itemImg);
        tv = findViewById(R.id.price);
        cart_btn = findViewById(R.id.cart);
        qunt = findViewById(R.id.qnt);
        num = findViewById(R.id.contact);
        addr = findViewById(R.id.addr);
        order_btn = findViewById(R.id.order);


        Intent intent = getIntent();
        final int id = intent.getExtras().getInt("img");

        switch(id){

            case R.drawable.pepperoni:
                imageView.setImageResource(id);
                tv.setText("Rs.250");
                break;

            case R.drawable.extraacheese:
                imageView.setImageResource(id);
                tv.setText("Rs.300");
                break;

            case R.drawable.blackolive:
                imageView.setImageResource(id);
                tv.setText("Rs.200");
                break;

            case R.drawable.mushrooms:
                imageView.setImageResource(id);
                tv.setText("Rs.200");
                break;

        }

        cart_btn.setOnClickListener(new View.OnClickListener() {

            String pizza_name,usr_addr,usr_num;

                int item_qty;
                String uname;
            @Override
            public void onClick(View view) {


                item_qty = Integer.parseInt(qunt.getText().toString());
                usr_num = num.getText().toString();
                usr_addr = addr.getText().toString();

                preferences = getSharedPreferences("Login",MODE_PRIVATE);
                int id = preferences.getInt("USERID",0);
                Intent intent = getIntent();
                pizza_name = intent.getStringExtra("pizzanam");
                Log.d("pizzanam",pizza_name);

                db = new DatabaseHelper(pepperoni.this);

                try{

                    boolean isInserted = db.addItem(id,pizza_name,item_qty,usr_num,usr_addr);

                    if(isInserted == true){
                        Toast.makeText(pepperoni.this, "Added Sucessfully..!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(pepperoni.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Log.i("My Error", e.toString());
                }

                startActivity(new Intent(pepperoni.this,HomeActivity.class));

            }
        });



    }

}
