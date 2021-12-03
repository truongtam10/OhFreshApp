package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.CartProduct;
import com.example.model.Product;
import com.example.ohfresh.R;

import java.util.ArrayList;

public class ItemCheckoutAdapter extends RecyclerView.Adapter<ItemCheckoutAdapter.ItemCheckoutViewHolder> {

    Context context;
    ArrayList<CartProduct> products;

    public ItemCheckoutAdapter(Context context, ArrayList<CartProduct> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ItemCheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customItemCheckoutView = inflater.inflate(R.layout.checkout_itemlayout, parent, false);
        return new ItemCheckoutViewHolder(customItemCheckoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCheckoutViewHolder holder, int position) {
        CartProduct p = products.get(position);
        holder.imvThumb.setImageResource(products.get(position).getProductThumb());
        holder.txtName.setText(products.get(position).getProductName());
        holder.txtWeight.setText(String.valueOf(products.get(position).getProductWeight()));
        holder.txtPrice.setText(String.valueOf(products.get(position).getProductPrice()));
        holder.txtNumber.setText(String.valueOf(products.get(position).getProductNumber()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ItemCheckoutViewHolder extends RecyclerView.ViewHolder {

        ImageView imvThumb;
        TextView txtName, txtWeight, txtPrice, txtNumber;

        public ItemCheckoutViewHolder(@NonNull View itemView) {
            super(itemView);

            imvThumb = itemView.findViewById(R.id.imvThumb);
            txtName = itemView.findViewById(R.id.txtName);
            txtWeight = itemView.findViewById(R.id.txtWeight);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtNumber = itemView.findViewById(R.id.txtNumber);
        }
    }
}
