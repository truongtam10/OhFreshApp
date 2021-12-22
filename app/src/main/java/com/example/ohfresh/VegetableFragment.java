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

public class VegetableFragment extends Fragment {

    GridView gvVegetable;
    ArrayList<Product> products;
    ProductAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vegetable, container, false);
        gvVegetable = view.findViewById(R.id.gvVegetable);
        adapter = new ProductAdapter(getActivity(), R.layout.item_layout, (List<Product>) initData());
        gvVegetable.setAdapter(adapter);
        return view;
    }

    private Object initData() {
        products = new ArrayList<Product>();
        products.add(new Product(R.drawable.img_cabbage, "Bắp cải", "17.000", "KG"));
        products.add(new Product(R.drawable.img_atiso, "Atiso", "35.000", "Hoa"));
        products.add(new Product(R.drawable.img_tomato, "Cà chua", "35.000", "KG"));
        products.add(new Product(R.drawable.img_bellpepper, "Ớt chuông", "30.000", "KG"));
        products.add(new Product(R.drawable.img_caingot, "Cải ngọt", "29.000", "KG"));
        products.add(new Product(R.drawable.img_corn, "Ngô", "35.000", "KG"));
        products.add(new Product(R.drawable.img_pumpkin, "Bí đỏ", "35.000", "KG"));

        return products;
    }
}