package com.example.wchang.team5_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Vector;

public class AddItemToRecipeActivity extends AppCompatActivity {

    private Spinner s_item;
    private LinearLayout ll_item;
    private Vector<FoodItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        s_item = findViewById(R.id.spinner_item);
        ll_item = findViewById(R.id.spinner_linearLayout_item);
        items = MainActivity.controller.getPantry();

        setContentView(R.layout.activity_add_item_to_recipe);
    }

    public void updateSpinner() {
        ll_item.removeAllViewsInLayout();
        for(int i = 0; i < items.size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(items.get(i).getName());
            tv.setId(i);
            ll_item.addView(tv);
        }
    }

    public void addItemBtn(View view) {
        onBackPressed();
    }

    public void cancelBtn(View view) {
        onBackPressed();
    }
}
