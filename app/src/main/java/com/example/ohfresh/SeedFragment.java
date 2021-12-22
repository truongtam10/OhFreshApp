package com.example.ohfresh;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SeedFragment extends Fragment {

    GridView gvSeed;
    ArrayList<Product> products;
    ProductAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seed, container, false);
        gvSeed = view.findViewById(R.id.gvSeed);
        adapter = new ProductAdapter(getActivity(), R.layout.item_layout, (List<Product>) initData());
        gvSeed.setAdapter(adapter);
        return view;
    }

    private Object initData() {
        products = new ArrayList<Product>();
        products.add(new Product(R.drawable.img_cashew, "Hạt điều", "50.000", "KG"));
        products.add(new Product(R.drawable.img_chia, "Hạt Chia", "35.000", "KG"));
        products.add(new Product(R.drawable.img_flax, "Hạt dưa", "15.000", "KG"));
        products.add(new Product(R.drawable.img_macca, "Hạt Macca", "40.000", "KG"));
        products.add(new Product(R.drawable.img_occho, "Hạt óc chó", "35.000", "KG"));
        products.add(new Product(R.drawable.img_hemp, "Gai dầu", "35.000", "KG"));
        products.add(new Product(R.drawable.img_oats, "Yến mạch", "35.000", "KG"));
        products.add(new Product(R.drawable.img_nhokhoden, "Nho khô", "35.000", "KG"));

        return products;
    }
}