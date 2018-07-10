package com.example.wchang.team5_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Vector;

public class AddItemToRecipeActivity extends AppCompatActivity {

    private Spinner s_item;
    private Vector<FoodItem> items;
    private EditText et_quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_to_recipe);

        s_item = findViewById(R.id.spinner_item);
        items = MainActivity.controller.getPantry();
        et_quantity = findViewById(R.id.editText_quantity);


        updateSpinner();
    }

    public void updateSpinner() {
        Vector<String> list = new Vector<String>();
        for(int i = 0; i < items.size(); i++) {
            list.add(items.get(i).getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_item.setAdapter(adapter);
    }

    public void addItemBtn(View view) {
        String selectedItem = s_item.getSelectedItem().toString();
        String quantity = et_quantity.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("selectedItem", selectedItem);
        intent.putExtra("selectedItemQuantity", quantity);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancelBtn(View view) {
        onBackPressed();
    }
}
