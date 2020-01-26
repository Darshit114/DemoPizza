package com.darshit.demopizza;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CartBaseAdapter extends ArrayAdapter<cartItem>{

    Context context;
    public ArrayList<cartItem> items;

    public CartBaseAdapter(Context context, ArrayList<cartItem> items) {
        super(context,R.layout.cartitems,items);
        this.context = context;
        this.items = items;
    }

//    @Override
//    public int getCount() {
//        return items.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return items.get();
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //create inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        //get rowview from inflaterget
        View rowview = inflater.inflate(R.layout.cartitems, parent, false);

        //get the two text view from rowview
        TextView name = (TextView) rowview.findViewById(R.id.cartPizza);
        TextView qty = (TextView) rowview.findViewById(R.id.cartQty);

        //set the text for textview
        name.setText(items.get(position).getPname());
        qty.setText(items.get(position).getQty());

        return rowview;
    }

}
