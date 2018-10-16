package com.example.pc.parksidevilla;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pc.parksidevilla.recycle_view.ParkAdapter;
import com.example.pc.parksidevilla.recycle_view.Product;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BreakFastFragment extends Fragment implements ParkAdapter.ListItemClickListener {
    ParkAdapter adapter;
    RecyclerView recyclerView;

    public BreakFastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        final ArrayList<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product(R.drawable.barger,"Berger", 300, "Available"));
        listProduct.add(new Product(R.drawable.fryfish,"Fried Fish", 750, "Available"));
        listProduct.add(new Product(R.drawable.frymeat,"Fried Meat", 1000, "Available"));
        listProduct.add(new Product(R.drawable.barger,"Berger", 300, "Available"));
        listProduct.add(new Product(R.drawable.barger,"Berger", 300, "Available"));
        listProduct.add(new Product(R.drawable.barger,"Berger", 300, "Available"));

        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        adapter = new ParkAdapter(getActivity(), listProduct, this);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(R.string.breakfirst);
    }

    @Override
    public void onListItemClickListener(int clickIndex) {
        Intent intent = new Intent(getActivity(), ProductActivity.class);

        startActivity(intent);
    }
}
