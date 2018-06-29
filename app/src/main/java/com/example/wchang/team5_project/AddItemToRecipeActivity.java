package com.example.wchang.team5_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddItemToRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_to_recipe);
    }

    public void addItemBtn(View view) {
        onBackPressed();
    }

    public void cancelBtn(View view) {
        onBackPressed();
    }
}
