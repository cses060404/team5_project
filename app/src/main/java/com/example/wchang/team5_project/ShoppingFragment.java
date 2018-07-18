package com.example.wchang.team5_project;

        import android.content.Context;
        import android.content.Intent;
        import android.graphics.drawable.Drawable;
        import android.os.Bundle;
        import android.os.Handler;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.LinearLayout;
        import android.widget.ProgressBar;
        import android.widget.RadioButton;
        import android.widget.TextView;

        import com.google.gson.Gson;

        import java.util.ArrayList;
        import java.util.Vector;

public class ShoppingFragment extends Fragment {

    private RecyclerView recyclerView;
    private Vector<Recipe> recipes;
    private ShoppingAdapter adapter;
    public ProgressBar progressbar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shopping, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.shoppingView);
        setData();
        adapter = new ShoppingAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        progressbar = (ProgressBar) view.findViewById(R.id.progressBar3);
        progressbar.setVisibility(View.GONE);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        final Intent intent = new Intent(getContext(),DisplayShoppingList.class);
                        Handler TimeDelay=new Handler();
                        Runnable content = new Runnable() {
                            @Override
                            public void run() {
                                startActivity(intent);
                            }
                        };
                        progressbar.setVisibility(View.VISIBLE);
                        TimeDelay.postDelayed(content, 1500);
                       // progressbar.setVisibility(View.GONE);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        return view;
    }

    public static Vector<Recipe> getData(){
        Vector<Recipe> data = MainActivity.controller.getRecipes();

       // int[] icons = {R.drawable.apples,R.drawable.apples};
       // String[] titles = {"haha", "CC"};
       /* for (int i = 0; i < titles.length && i < icons.length; i++ )
        {
            Recipe current = new Recipe();
            current.name = titles[i];
            data.add(current);
        }*/
       return data;
    }

    @Override
    public void onResume() {
        super.onResume();
        progressbar.setVisibility(View.GONE);
    }

    public void setData(){
        recipes = getData();
    }

    /*public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }*/
}
