package com.example.wchang.team5_project;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import static com.example.wchang.team5_project.MainActivity.controller;

/**
 * The ShoppingAdapter is to adapt each Receipt into a little view inside the recyclerView.
 */
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
    /**
     * This onBindViewHolder function would bind our view and holder together.
     */
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //This will get us the recipe we want from the recipe vector.
        Recipe current = data.get(position);

        //This will get the title and desc.
        holder.title.setText(current.getName());
        holder.desc.setText(current.getDirections().get(0));
    }

    /**
     * This getItemCount function would see how many recipes we have and to tell the adapter how many little views to display.
     * @return an int value.
     */
    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView desc;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);

            // These two lines of codes connects the view holder.
            title = (TextView)itemView.findViewById(R.id.listText);
            desc = (TextView)itemView.findViewById(R.id.extView);

            //This line is commented because we only have one picture to display. However,
            // if the user have more pictures, we can use this line of code.
            //icon = (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
}
