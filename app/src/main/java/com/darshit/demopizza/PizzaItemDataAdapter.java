package com.darshit.demopizza;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PizzaItemDataAdapter extends RecyclerView.Adapter<ItemHolder> {

    private List<PizzaItem> pizza_list;

    public PizzaItemDataAdapter(List<PizzaItem> pizzaList) {
        this.pizza_list = pizzaList;
    }


    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.my_design,viewGroup,false);

        final ImageView pizzaImageView = view.findViewById(R.id.des_myImg);
        final CardView pizzaCardView = view.findViewById(R.id.des_card);
        final TextView pizzaTextView = view.findViewById(R.id.des_TextView);

       /* pizzaCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(viewGroup.getContext(),"Clicked!!", Toast.LENGTH_SHORT).show();


            }
        });*/

        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder itemHolder, final int i) {

        if(pizza_list!=null) {

            final PizzaItem item = pizza_list.get(i);

            if(item != null) {
                //itemHolder.getCarImageView().setImageResource(item.getPizzaImageId());
                Picasso.get()
                        .load(item.getPizzaImageId())
                        .into(itemHolder.getCarImageView());
                itemHolder.getCarTextView().setText(item.getPizzaName());

                final Context context = itemHolder.getContext();


                itemHolder.carImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context,pepperoni.class).putExtra("img",item.getPizzaImageId());
                        intent.putExtra("pizzanam",item.getPizzaName());
                        context.startActivity(intent);
                    }
                });
            }

        }
    }

    @Override
    public int getItemCount() {

        int flag = 0;
        if(pizza_list!=null)
        {
            flag = pizza_list.size();
        }
        return flag;
    }


}
