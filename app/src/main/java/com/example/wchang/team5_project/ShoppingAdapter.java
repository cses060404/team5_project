package com.example.wchang.team5_project;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import static com.example.wchang.team5_project.MainActivity.controller;
public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.MyViewHolder>{
    private LayoutInflater inflater;
    Vector<Recipe> data;

    public ShoppingAdapter(Context context, Vector<Recipe> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_shopping_row,parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Recipe current = data.get(position);
        holder.title.setText(current.getName());
      //  holder.icon.setImageResource();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.listText);
            //icon = (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
}
