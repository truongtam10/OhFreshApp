package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Product;
import com.example.ohfresh.R;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    Activity context;
    int item_gridview;
    List<Product> productList;

    public ProductAdapter(Activity context, int item_gridview, List<Product> productList) {
        this.context = context;
        this.item_gridview = item_gridview;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_gridview, null);
            holder.imvThumb = view.findViewById(R.id.imvThumb);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtPrice = view.findViewById(R.id.txtPrice);
            holder.btnUnit = view.findViewById(R.id.btnUnit);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        Product product = productList.get(i);
//        holder.imvThumb.setImageResource(product.getThumb());
        holder.txtName.setText(product.getName());
        holder.txtPrice.setText(product.getPrice());

        return view;

    }
    public static class ViewHolder{
        ImageView imvThumb;
        TextView txtName, txtPrice;
        MaterialButton btnUnit;
    }
}