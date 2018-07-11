package com.example.wchang.team5_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Vector;

public class DisplayRecipeActivity extends AppCompatActivity {

    private TextView tv_name;
    private LinearLayout ll_items;
    private TextView tv_direction;

    private String name;
    private Vector<FoodItem> items;
    private Vector<String> directions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recipe);

        tv_name = findViewById(R.id.editText_name);
        ll_items = findViewById(R.id.linearLayout_item);
        tv_direction = findViewById(R.id.textView_direction_contents);

        Intent intent = getIntent();
        name = intent.getStringExtra("recipeName");
        items = intent.getParcelableExtra("items");
        directions = intent.getParcelableExtra("directions");


        for(int i = 0; i < items.size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(items.get(i).getName() + " (" + items.get(i).getQuantity() + ")");
            tv.setTextSize(20);
            tv.setId(i);
            ll_items.addView(tv);
        }

        for(int i = 0; i < directions.size(); i++) {
            tv_direction.setText(tv_direction.getText() + "\n" + directions.get(i));
        }
    }
}
