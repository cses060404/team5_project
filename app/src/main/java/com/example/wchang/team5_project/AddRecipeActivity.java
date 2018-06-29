package com.example.wchang.team5_project;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AddRecipeActivity extends AppCompatActivity {

    private EditText et_name;
    private LinearLayout ll_item;
    private EditText et_description;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        et_name = findViewById(R.id.editText_name);
        ll_item = findViewById(R.id.linearLayout_item);
        et_description = findViewById(R.id.editText_description);
    }

    public void addItemBtn(View view) {
        Intent intent = new Intent(this, AddItemToRecipeActivity.class);
        startActivity(intent);
    }

    public void addRecipeBtn(View view) {
        onBackPressed();
    }

    public void cancelBtn(View view) {
        onBackPressed();
    }

}
