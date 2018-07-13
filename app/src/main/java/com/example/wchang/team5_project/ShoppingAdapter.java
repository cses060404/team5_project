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

import java.util.List;
import java.util.Vector;

import static com.example.wchang.team5_project.MainActivity.controller;
public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.MyViewHolder>{
    private LayoutInflater inflater;
    Vector<Recipe> data = controller.getRecipes();

    public ShoppingAdapter(Context context, Vector<Recipe> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_shopping,parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText("haha");
      //  holder.icon.setImageResource();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            //title = (TextView)itemView.findViewById(R.id.listText);
            //icon = (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
}
