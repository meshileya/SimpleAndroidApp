package com.developer.techies.retrofittutorial.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.developer.techies.retrofittutorial.R;
import com.developer.techies.retrofittutorial.model.Item;

public class ResponseHolder extends RecyclerView.ViewHolder {

    public TextView titleTv;
    public ImageView mPhoto;

    public ResponseHolder(View itemView) {
        super(itemView);
        titleTv = itemView.findViewById(R.id.text_view);
        mPhoto = itemView.findViewById(R.id.photo);

    }

}
