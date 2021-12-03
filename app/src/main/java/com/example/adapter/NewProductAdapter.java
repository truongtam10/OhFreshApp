package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.NewProductItems;
import com.example.ohfresh.R;

import java.util.List;

public class NewProductAdapter extends BaseAdapter {
    Activity context;
    int item_layout;
    List<NewProductItems> newProducts;

    public NewProductAdapter(Activity context, int item_layout, List<NewProductItems> newProducts) {
        this.context = context;
        this.item_layout = item_layout;
        this.newProducts = newProducts;
    }

    @Override
    public int getCount() {
        return newProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return newProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            //link item view
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.imvProductImage = view.findViewById(R.id.imvNew);
            holder.txtName = view.findViewById(R.id.txtNew);
            holder.txtPrice = view.findViewById(R.id.txtGia);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        NewProductItems b = newProducts.get(i);
        holder.imvProductImage.setImageResource(b.getProductImage());
        holder.txtName.setText(b.getProductName());
        holder.txtPrice.setText(b.getProductPrice());
        return view;
    }
    public static class ViewHolder{
        ImageView imvProductImage;
        TextView txtName,txtPrice;
    }
}
