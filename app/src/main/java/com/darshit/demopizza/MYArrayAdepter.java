package com.darshit.demopizza;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MYArrayAdepter extends BaseAdapter {
    Context context;
    ArrayList<String> strings;
    ArrayList<String> integers;

    public MYArrayAdepter(Context context, ArrayList<String> strings, ArrayList<String> integers) {
        this.context = context;
        this.strings = strings;
        this.integers = integers;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int i) {
        return strings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    String massg;
    int prize = 0;
    String nn ;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        //get rowview from inflaterget
        view = inflater.inflate(R.layout.cartitems, viewGroup, false);

        //get the two text view from rowview
        ImageView img = view.findViewById(R.id.cart_myImg);
        TextView name = (TextView) view.findViewById(R.id.cartPizza);
        TextView qty = (TextView) view.findViewById(R.id.cartQty);
        Button order = view.findViewById(R.id.cartOrder);
        name.setText(strings.get(i));
        qty.setText(integers.get(i));

        nn = name.getText().toString();

        if(nn.equals("Pepperoni")){
        int qq = Integer.parseInt(qty.getText().toString());
            img.setImageResource(R.drawable.pepperoni);
            prize = 250 *qq;
        }else if(nn.equals("Extraa Cheese")){
            int qq = Integer.parseInt(qty.getText().toString());

            img.setImageResource(R.drawable.extraacheese);
            prize = 300*qq;}
        else if(nn.equals("Blackolive")){
            int qq = Integer.parseInt(qty.getText().toString());

            img.setImageResource(R.drawable.blackolive);
            prize = 200*qq;}
        else if(nn.equals("Mushrooms")){
            int qq = Integer.parseInt(qty.getText().toString());
            img.setImageResource(R.drawable.mushrooms);
            prize = 200*qq;}
        massg = name.getText()+"\nTotal Rs. = " + prize ;

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new  AlertDialog.Builder(context).setMessage(massg).setTitle("BILL").setPositiveButton("Pay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new DatabaseHelper(context).Delete(nn);
                        Toast.makeText(context, "Order Placed", Toast.LENGTH_SHORT).show();
                    }
                }).show();

            }
        });
        //set the text for textview

        return view;

    }
}
