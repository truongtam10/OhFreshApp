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

public class FruitFragment extends Fragment {

    GridView gvFruit;
    ArrayList<Product> products;
    ProductAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fruit, container, false);
        gvFruit = view.findViewById(R.id.gvFruit);
        adapter = new ProductAdapter(getActivity(), R.layout.item_layout, (List<Product>) initData());
        gvFruit.setAdapter(adapter);
        return view;
    }

    private Object initData() {
        products = new ArrayList<Product>();
        products.add(new Product(R.drawable.img_peach, "Đào", "50.000", "KG"));
        products.add(new Product(R.drawable.img_apple, "Táo", "35.000", "KG"));
        products.add(new Product(R.drawable.img_banana, "Chuối", "15.000", "KG"));
        products.add(new Product(R.drawable.img_cherry, "Cherry", "40.000", "KG"));
        products.add(new Product(R.drawable.img_nhoxanh, "Nho xanh", "35.000", "KG"));
        products.add(new Product(R.drawable.img_nhotim, "Nho tím", "35.000", "KG"));
        products.add(new Product(R.drawable.img_nhoden, "Nho Mỹ", "35.000", "KG"));
        products.add(new Product(R.drawable.img_strawberry, "Dâu tây", "35.000", "KG"));
        products.add(new Product(R.drawable.img_blueberry, "Blueberry", "35.000", "KG"));
        products.add(new Product(R.drawable.img_raspberry, "Raspberry", "35.000", "KG"));

        return products;
    }
}