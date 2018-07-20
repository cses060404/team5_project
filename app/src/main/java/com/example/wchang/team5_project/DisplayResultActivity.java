package com.example.wchang.team5_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

/**
 * Displays the result(s) of the scanner.
 */
public class DisplayResultActivity extends AppCompatActivity {

    private RetrievedData result;
    private TextView tv_name;
    private TextView tv_brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        String json = getIntent().getExtras().getString("result");
        Gson gson = new Gson();
        result = gson.fromJson(json, RetrievedData.class);

        tv_name = findViewById(R.id.textView_display_name);
        tv_brand=  findViewById(R.id.textView_display_brand);
    }

    public void createPage() {
        tv_name.setText(result.getItemName());
        tv_brand.setText(result.getBrandName());
    }
}
