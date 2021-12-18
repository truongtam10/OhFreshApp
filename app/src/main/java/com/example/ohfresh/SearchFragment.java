package com.example.ohfresh;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SearchFragment extends Fragment {

    ImageView imvBack;
    LinearLayout linearSearch, linearProduct;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        imvBack = view.findViewById(R.id.imvBack);
        linearSearch = view.findViewById(R.id.linearSearch);
        linearProduct = view.findViewById(R.id.linearProduct);

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Category.class);
                startActivity(intent);
            }
        });

        linearSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchResult.class);
                startActivity(intent);
            }
        });

        linearProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProductDetail.class);
                startActivity(intent);
            }
        });
        return view;
    }

}