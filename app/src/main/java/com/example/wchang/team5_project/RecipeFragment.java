package com.example.wchang.team5_project;

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

public class RecipeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipe, container, false);
    }

    public void addRecipeName(String name) {
        LinearLayout mLayout = (LinearLayout)getView().findViewById(R.id.recipe_view);
    }

    public void addRecipeBtn(View view) {
        Intent intent = new Intent(getActivity(), AddRecipeActivity.class);
        startActivity(intent);
    }
}
