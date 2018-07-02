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
    private EditText et_direction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);


        et_name = findViewById(R.id.editText_name);
        ll_item = findViewById(R.id.linearLayout_item);
        et_direction = findViewById(R.id.editText_direction);
    }

    public void addItemBtn(View view) {
        Intent intent = new Intent(this, AddItemToRecipeActivity.class);
        startActivity(intent);

    }

    public void addRecipeBtn(View view) {
        String name = et_name.getText().toString();
        String direction = et_direction.getText().toString();

        Recipe newRecipe = new Recipe();
        newRecipe.addDirection(direction);
        newRecipe.setName(name);

        MainActivity.controller.addRecipe(newRecipe);

        onBackPressed();
    }

    public void cancelBtn(View view) {
        onBackPressed();
    }

}
