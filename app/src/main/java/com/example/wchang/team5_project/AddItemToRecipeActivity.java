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
import android.widget.Toast;

import java.util.Vector;

import static android.widget.Toast.LENGTH_SHORT;

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

    public boolean validateForm() {
        if(s_item.getSelectedItem().toString().matches("Select Item")) {
            Toast.makeText(this, "Please Select An Item!", LENGTH_SHORT).show();
            s_item.requestFocus();
            return false;
        }
        else if(et_quantity.getText().toString().matches("")) {
            Toast.makeText(this, "Please Enter The Quantity!", LENGTH_SHORT).show();
            s_item.requestFocus();
            return false;
        }
        else {
            Toast.makeText(this, "Item Added!", Toast.LENGTH_LONG).show();
            return true;
        }
    }

    public void updateSpinner() {
        Vector<String> list = new Vector<String>();
        list.add("Select Item");
        for(int i = 0; i < items.size(); i++) {
            list.add(items.get(i).getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_item.setAdapter(adapter);
    }

    public void addItemBtn(View view) {
        if(validateForm()) {
            String selectedItem = s_item.getSelectedItem().toString();
            String quantity = et_quantity.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("selectedItem", selectedItem);
            intent.putExtra("selectedItemQuantity", quantity);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public void cancelBtn(View view) {
        onBackPressed();
    }
}
