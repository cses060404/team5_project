package com.example.wchang.team5_project;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Vector;

public class RecipeFragment extends Fragment {

    private LinearLayout ll_recipe;
    private Vector<Recipe> recipes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        ll_recipe = (LinearLayout) view.findViewById(R.id.linearLayout_recipe);

        recipes = MainActivity.controller.getRecipes();

        addRecipeIntoView();

        return view;
    }

    public void addRecipeIntoView() {
        ll_recipe.removeAllViewsInLayout();
        for(int i = 0; i < recipes.size(); i++) {
            TextView tv = new TextView(this.getContext());
            tv.setText(recipes.get(i).getName());
            tv.setTextSize(24);
            tv.setId(i);
            tv.setClickable(true);
            final int finalI = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), DisplayRecipeActivity.class);
                    intent.putExtra("recipeName", recipes.get(finalI).getName());
                    intent.putExtra("items", recipes.get(finalI).getIngredients());
                    intent.putExtra("directions", recipes.get(finalI).getDirections());
                    startActivity(intent);
                }
            });
            ll_recipe.addView(tv);
        }
    }

    @Override
    public void onResume() {
        addRecipeIntoView();
        super.onResume();
    }

    public void addRecipeName(String name) {

        LinearLayout mLayout = (LinearLayout)getView().findViewById(R.id.recipe_view);
    }

    public void addRecipeBtn(View view) {
        Intent intent = new Intent(getActivity(), AddRecipeActivity.class);
        startActivity(intent);
    }
}
