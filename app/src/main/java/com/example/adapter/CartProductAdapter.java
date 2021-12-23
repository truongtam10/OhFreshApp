package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.CartProduct;
import com.example.model.Voucher;
import com.example.ohfresh.R;

import java.util.ArrayList;

public class CartProductAdapter extends BaseAdapter {

    Context context;
    int cart_product_item_layout;
    ArrayList<CartProduct> products;

    public CartProductAdapter(Context context, int cart_product_item_layout, ArrayList<CartProduct> products) {
        this.context = context;
        this.cart_product_item_layout = cart_product_item_layout;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    /*@NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.cart_itemlayout, parent, false);

        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartProduct p = products.get(position);
        holder.imvThumb.setImageResource(products.get(position).getProductThumb());
        holder.txtName.setText(products.get(position).getProductName());
        holder.txtWeight.setText(String.valueOf(products.get(position).getProductWeight()));
        holder.txtPrice.setText(String.valueOf(products.get(position).getProductPrice()));
        holder.txtNumber.setText(String.valueOf(products.get(position).getProductNumber()));
    }*/

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null)
        {
            holder = new viewHolder();
            view=inflater.inflate(cart_product_item_layout,null);

            holder.imvThumb = view.findViewById(R.id.imvThumb);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtWeight = view.findViewById(R.id.txtWeight);
            holder.txtPrice = view.findViewById(R.id.txtPrice);
            holder.txtNumber = view.findViewById(R.id.txtNumberProduct);

            holder.btnAdd = view.findViewById(R.id.btnAdd);
            holder.btnMinus = view.findViewById(R.id.btnMinus);
            holder.txtNumberProduct = view.findViewById(R.id.txtNumberProduct);

            view.setTag(holder);
        }
        else{
            holder = (viewHolder) view.getTag();
        }
        CartProduct product = products.get(i);
        holder.imvThumb.setImageResource(products.get(i).getProductThumb());
        holder.txtName.setText(products.get(i).getProductName());
        holder.txtWeight.setText(String.valueOf(products.get(i).getProductWeight()));
        holder.txtPrice.setText(String.valueOf(products.get(i).getProductPrice()));
        holder.txtNumberProduct.setText(String.valueOf(products.get(i).getProductNumber()));

        viewHolder finalHolder = holder;
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sl = Integer.parseInt((finalHolder.txtNumberProduct).getText().toString());
                if(sl>1 || sl==1)
                {
                    sl = sl + 1;
                    finalHolder.txtNumberProduct.setText(String.valueOf(sl));;
                }
            }
        });

        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sl = Integer.parseInt((finalHolder.txtNumberProduct).getText().toString());
                if(sl>1)
                {
                    sl = sl -1;
                    finalHolder.txtNumberProduct.setText(String.valueOf(sl));;
                }
            }
        });

        return view;
    }

    private static class viewHolder{
        ImageView imvThumb;
        TextView txtName, txtWeight, txtPrice, txtNumber, txtNumberProduct;

        ImageButton btnAdd, btnMinus;

    /*private static class viewHolder{
        TextView txtDateExpiration, txtAmountDiscount;}

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imvThumb;
        TextView txtName, txtWeight, txtPrice, txtNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imvThumb = itemView.findViewById(R.id.imvThumb);
            txtName = itemView.findViewById(R.id.txtName);
            txtWeight = itemView.findViewById(R.id.txtWeight);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtNumber = itemView.findViewById(R.id.txtNumber);
        }*/
    }
}