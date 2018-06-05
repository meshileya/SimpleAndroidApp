package com.developer.techies.retrofittutorial.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developer.techies.retrofittutorial.R;
import com.developer.techies.retrofittutorial.adapter.holder.ResponseHolder;
import com.developer.techies.retrofittutorial.model.Item;
import com.developer.techies.retrofittutorial.utils.ItemListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseHolder>{

    private List<Item> items;
    private Context mContext;
    private ItemListener<Item> listener;

    public ResponseAdapter(List<Item> items, ItemListener<Item> listener){

        this.items = items;
        this.listener = listener;
    }

    public void updateAnswers(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ResponseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_answers, parent, false);
        return new ResponseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseHolder holder, int position) {

        Item item = items.get(position);

        Picasso.with(holder.itemView.getContext()).load(item.getOwner().getProfileImage()).placeholder(R.drawable.ic_launcher_background).into(holder.mPhoto);
        holder.titleTv.setText(item.getOwner().getDisplayName());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(item));
    }

    @Override
    public int getItemCount() {
        return this.items != null ? items.size() : 0;
    }

}
