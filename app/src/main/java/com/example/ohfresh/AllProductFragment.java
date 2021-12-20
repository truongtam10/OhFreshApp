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

public class AllProductFragment extends Fragment {

    GridView gvAllProduct;
    ArrayList<Product> products;
    ProductAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_product, container, false);
        gvAllProduct = view.findViewById(R.id.gvAllProduct);
        adapter = new ProductAdapter(getActivity(), R.layout.item_layout, (List<Product>) initData());
        gvAllProduct.setAdapter(adapter);
        return view;
    }

    private Object initData() {
        products = new ArrayList<Product>();
        products.add(new Product(R.drawable.img_apple, "Táo", "35000", "KG"));
        products.add(new Product(R.drawable.img_banana, "Chuối", "15000", "KG"));
        products.add(new Product(R.drawable.img_cherry, "Cherry", "40000", "KG"));
        products.add(new Product(R.drawable.img_cabbage, "Bắp cải", "17000", "KG"));
        products.add(new Product(R.drawable.img_strawberry, "Dâu tây", "35000", "KG"));
        products.add(new Product(R.drawable.img_atiso, "Atiso", "35000", "Hoa"));
        products.add(new Product(R.drawable.img_macca, "Hạt Macca", "40.000", "KG"));
        products.add(new Product(R.drawable.img_occho, "Hạt óc chó", "35.000", "KG"));
        products.add(new Product(R.drawable.img_hemp, "Gai dầu", "35.000", "KG"));
        products.add(new Product(R.drawable.img_blueberry, "Blueberry", "35000", "KG"));
        products.add(new Product(R.drawable.img_tomato, "Cà chua", "35000", "KG"));
        products.add(new Product(R.drawable.img_raspberry, "Mâm xôi", "35000", "KG"));
        products.add(new Product(R.drawable.img_banana, "Bông cải", "49.000", "KG"));
        products.add(new Product(R.drawable.img_corn, "Ngô", "35.000", "KG"));
        products.add(new Product(R.drawable.img_pumpkin, "Bí đỏ", "35.000", "KG"));

        return products;
    }
}