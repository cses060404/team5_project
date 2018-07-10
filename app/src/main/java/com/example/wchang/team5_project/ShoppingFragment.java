package com.example.wchang.team5_project;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.Vector;

public class ShoppingFragment extends Fragment {

    private RecyclerView recyclerView;
    private Vector<Recipe> recipes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shopping, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.shoppingView);
        return view;
    }


}
