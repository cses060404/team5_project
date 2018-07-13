package com.example.wchang.team5_project;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Vector;

import static com.example.wchang.team5_project.MainActivity.controller;

public class RecipeFragment extends Fragment {

    private ListView lv_recipe;
    private Vector<Recipe> recipes;
    private ArrayAdapter<Recipe> adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        lv_recipe = (ListView) view.findViewById(R.id.listView_recipe);

        updateView();

        return view;
    }

    public void updateView() {
        recipes = MainActivity.controller.getRecipes();
        adapter = new ArrayAdapter<Recipe>(getContext(), android.R.layout.simple_list_item_1, controller.getRecipes());
        lv_recipe.setAdapter(adapter);
        lv_recipe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DisplayRecipeActivity.class);
                Gson gson = new Gson();
                String json = gson.toJson(recipes.get(position));
                intent.putExtra("recipe", json);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        updateView();
    }
}
