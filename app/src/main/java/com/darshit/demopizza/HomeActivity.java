package com.darshit.demopizza;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    private List<PizzaItem> pizzaList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.setTitle("PizzaOrder");

        preferences = getSharedPreferences("Login", MODE_PRIVATE);

        initializePizzaItemList();

        RecyclerView recyclerView = findViewById(R.id.lst);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        PizzaItemDataAdapter pizzaItemDataAdapter = new PizzaItemDataAdapter(pizzaList);
        recyclerView.setAdapter(pizzaItemDataAdapter);



        /*Intent intent = getIntent();
        String Username = intent.getStringExtra("username");
        TextView textView = findViewById(R.id.txtView);
        textView.setText("Welcome, " + Username);*/


    }

    private void initializePizzaItemList() {
        if(pizzaList == null)
        {
            pizzaList = new ArrayList<PizzaItem>();
            pizzaList.add(new PizzaItem( R.drawable.pepperoni,"Pepperoni"));
            pizzaList.add(new PizzaItem( R.drawable.extraacheese,"Extraa Cheese"));
            pizzaList.add(new PizzaItem( R.drawable.blackolive,"Blackolive"));
            pizzaList.add(new PizzaItem( R.drawable.mushrooms,"Mushrooms"));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuLogout:
                editor = preferences.edit();
                editor.remove("username");
                editor.commit();
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.mnuAbout:
                Toast.makeText(this, "This activity is not added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cart:
                startActivity(new Intent(HomeActivity.this,CartActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
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

