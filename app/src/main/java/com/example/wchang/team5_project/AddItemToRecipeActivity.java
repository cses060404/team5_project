package com.example.wchang.team5_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Vector;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Adds food items to a recipe instance.
 */
public class AddItemToRecipeActivity extends AppCompatActivity {

    private Spinner s_item;
    private Vector<FoodItem> items;
    private EditText et_quantity;
    private EditText et_name;
    private boolean isModifiedPage;  //Allow the code to know if it is adding page or editing page
    private FoodItem passedItem;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_to_recipe);

        s_item = findViewById(R.id.spinner_item);
        items = MainActivity.controller.getPantry();
        et_quantity = findViewById(R.id.editText_quantity);
        et_name = findViewById(R.id.editText_name);

        isModifiedPage = (getIntent().getExtras() != null);
        if(isModifiedPage) {
            Gson gson = new Gson();
            passedItem = gson.fromJson(getIntent().getExtras().getString("item"), FoodItem.class);
            index = getIntent().getExtras().getInt("index");

            et_name.setText(passedItem.getName());
            et_quantity.setText(Float.toString(passedItem.getQuantity()));

            ((Button)findViewById(R.id.button_add)).setText("SAVE ITEM");
            ((Button)findViewById(R.id.button_cancel)).setText("DELETE");
            ((TextView)findViewById(R.id.textView_add_item)).setText("Edit Item");
        }

        updateSpinner();
    }

    //Validate the form, make sure there is no empty text field
    public boolean validateForm() {
        if(s_item.getSelectedItem().toString().matches("Select Item") && et_name.getText().toString().equals("")) {
            Toast.makeText(this, "Please Select An Item Or Enter An Item!", LENGTH_SHORT).show();
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

    //Handle and display the drop down list to display the items
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

    //Add Item button to add item's information into new recipe page
    public void addItemBtn(View view) {
        if(validateForm()) {

            String selectedItem;
            if (et_name.getText().toString().equals("")) {
                selectedItem = s_item.getSelectedItem().toString();
            } else {
                selectedItem = et_name.getText().toString();
            }
            String quantity = et_quantity.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("selectedItem", selectedItem);
            intent.putExtra("selectedItemQuantity", quantity);
            if(isModifiedPage) {
                intent.putExtra("index", index);
                setResult(RESULT_OK, intent);
            }
            else
                setResult(RESULT_OK, intent);

            finish();
        }
    }

    public void cancelBtn(View view) {
        if(isModifiedPage) {
            Intent intent = new Intent();
            intent.putExtra("isDeleted", true);
            intent.putExtra("index", index);
            setResult(RESULT_OK, intent);
        }
        onBackPressed();
    }
}
