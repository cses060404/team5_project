package com.example.wchang.team5_project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import static com.example.wchang.team5_project.MainActivity.controller;

public class HomeFragment extends Fragment {
    private EditText editName;
    private static String SP_USER_STATUS = "userstatus";
    private ListView listView;
    private ArrayAdapter<FoodItem> adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        editName = (EditText)view.findViewById(R.id.name_text);
        readSharedPreferences();
        listView = (ListView)view.findViewById(R.id.foodItemListView);

        adapter = new ArrayAdapter<FoodItem>(getContext(), android.R.layout.simple_list_item_1, controller.getPantry());
        listView.setAdapter(adapter);



        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        writeSharedPreferences();
    }

    public void writeSharedPreferences(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(SP_USER_STATUS, editName.getText().toString());
        editor.commit();
    }

    public void readSharedPreferences(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String name = sp.getString(SP_USER_STATUS, "");
        editName.setText(name);
    }


}
