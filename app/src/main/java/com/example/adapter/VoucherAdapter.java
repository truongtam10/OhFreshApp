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
import com.example.model.Voucher;
import com.example.ohfresh.R;

import java.util.ArrayList;

public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.ViewHolder>{

    Context context;
    ArrayList<Voucher> vouchers;

    public VoucherAdapter(Context context, ArrayList<Voucher> vouchers) {
        this.context = context;
        this.vouchers = vouchers;
    }

    @NonNull
    @Override
    public VoucherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.item_availablevoucher, parent, false);

        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherAdapter.ViewHolder holder, int position) {
        Voucher v = vouchers.get(position);
        holder.txtAmountDiscount.setText(String.valueOf(vouchers.get(position).getAmountDiscount()));
        holder.txtDateExpiration.setText(String.valueOf(vouchers.get(position).getDateExpiration()));
    }

    @Override
    public int getItemCount() {
        return vouchers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtDateExpiration, txtAmountDiscount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtAmountDiscount = itemView.findViewById(R.id.txtAmountDiscount);
            txtDateExpiration = itemView.findViewById(R.id.txtDateExpiration);
        }
    }
}
