package com.example.wchang.team5_project;

        import android.content.Intent;
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
        import android.widget.ProgressBar;
        import java.util.Vector;

public class ShoppingFragment extends Fragment {

    private RecyclerView recyclerView;
    private Vector<Recipe> recipes;
    private ShoppingAdapter adapter;
    public ProgressBar progressbar;
    private static int position;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Here it creates a new view and set up the environment
        View view = inflater.inflate(R.layout.fragment_shopping, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.shoppingView);


        //Here connects the adapter and the fragment.
        adapter = new ShoppingAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // This is to connect the progressbar and set it to invisible at start point.
        progressbar = (ProgressBar) view.findViewById(R.id.progressBar3);
        progressbar.setVisibility(View.GONE);

        //This is the listener to see if any of the items in the recyclerview was clicked.
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        final Intent intent = new Intent(getContext(),DisplayShoppingList.class);
                        setPosition(position);
                        Handler TimeDelay=new Handler();
                        Runnable content = new Runnable() {
                            @Override
                            public void run() {
                                startActivity(intent);
                            }
                        };
                        progressbar.setVisibility(View.VISIBLE);
                        TimeDelay.postDelayed(content, 1500);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
        return view;
    }

    //This is the function provided for the class to get the recipe vector.
    public static Vector<Recipe> getData(){
        Vector<Recipe> data = MainActivity.controller.getRecipes();
       return data;
    }

    @Override
    public void onResume() {
        super.onResume();
        // This resets the progressbar to invisible when the user come back to the page.
        progressbar.setVisibility(View.GONE);
    }

    // These set and get position functions are for other classes to know which position was being clicked.
    public void setPosition(int p){
        position = p;
    }
    public static int getPosition(){
        return position;
    }
}
