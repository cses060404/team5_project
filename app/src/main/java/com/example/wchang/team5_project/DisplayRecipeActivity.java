package com.example.wchang.team5_project;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Vector;

public class DisplayRecipeActivity extends AppCompatActivity {

    private TextView tv_name;
    private LinearLayout ll_items;
    private TextView tv_direction;

    private Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recipe);

        tv_name = this.findViewById(R.id.editText_name);
        ll_items = this.findViewById(R.id.linearLayout_item);
        tv_direction = this.findViewById(R.id.textView_direction_contents);

        String json = getIntent().getExtras().getString("recipe");
        Gson gson = new Gson();

        recipe = gson.fromJson(json, Recipe.class);


    }
}
