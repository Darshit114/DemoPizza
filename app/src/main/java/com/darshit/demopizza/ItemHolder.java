package com.darshit.demopizza;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemHolder extends RecyclerView.ViewHolder {

    ImageView carImageView;
    TextView des_TextView;
    Context context;


    public ItemHolder(@NonNull View itemView) {
        super(itemView);

        carImageView = itemView.findViewById(R.id.des_myImg);
        des_TextView = itemView.findViewById(R.id.des_TextView);
        context = itemView.getContext();
    }

    public ImageView getCarImageView() {
        return carImageView;
    }
    public TextView getCarTextView() {
        return des_TextView;
    }

    public Context getContext() {
        return context;
    }
}
