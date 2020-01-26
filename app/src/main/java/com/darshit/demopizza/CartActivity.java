package com.darshit.demopizza;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    SharedPreferences preferences;
    DatabaseHelper helper;
    CartBaseAdapter adapter2;
    MYArrayAdepter adepter;
    ArrayList<String> items;
    ArrayList<String> itemsint;
    DatabaseHelper db;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        list = findViewById(R.id.cartLst);
        this.setTitle("PizzaOrder");
        helper = new DatabaseHelper(this);
        preferences = getSharedPreferences("Login",MODE_PRIVATE);
        int id = preferences.getInt("USERID",0);


        db = new DatabaseHelper(CartActivity.this);


        Cursor cursor = db.getCartData(id);
        Log.d("dataid",""+cursor.getCount());
        items = new ArrayList<String>();
        itemsint = new ArrayList<>();
        if (cursor != null) {
            cursor.moveToFirst();
            do {
                items.add(cursor.getString(cursor.getColumnIndex("ITEM_NAME")));
                itemsint.add(cursor.getString(cursor.getColumnIndex("QTY")));
            } while (cursor.moveToNext());
            Log.d("dataid",""+items.size());
            adepter = new MYArrayAdepter(this,items,itemsint);
            //adapter = new CartBaseAdapter(CartActivity.this, items);
            //ArrayAdapter<String>
            // adapter = new ArrayAdapter(this,R.layout.cartitems,R.id.cartPizza,items);
            list.setAdapter(adepter);

        }


        //helper.getCartData(id);
//        Log.d("datasize", ""+helper.getCartData(id).size());
//        adapter = new CartBaseAdapter(this, helper.getCartData(id));
//        list.setAdapter(adapter);

    }
}
