package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.CartProduct;
import com.example.model.MyVoucher;
import com.example.model.Voucher;
import com.example.ohfresh.R;

import java.util.ArrayList;

public class VoucherAdapter extends BaseAdapter{

    private Context context;
    private int voucher_item_layout;
    private ArrayList<Voucher> vouchers;

    public VoucherAdapter(Context context, int voucher_item_layout, ArrayList<Voucher> vouchers) {
        this.context = context;
        this.voucher_item_layout = voucher_item_layout;
        this.vouchers = vouchers;
    }

    @Override
    public int getCount() {
        return vouchers.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null)
        {
            holder = new VoucherAdapter.viewHolder();
            view=inflater.inflate(voucher_item_layout,null);

            holder.txtDateExpiration = view.findViewById(R.id.txtDateExpiration);
            holder.txtAmountDiscount = view.findViewById(R.id.txtAmountDiscount);
            view.setTag(holder);
        }
        else{
            holder = (VoucherAdapter.viewHolder) view.getTag();
        }
        Voucher voucher = vouchers.get(i);
        holder.txtDateExpiration.setText(voucher.getDateExpiration());
        holder.txtAmountDiscount.setText(voucher.getAmountDiscount());
        return view;
    }

    static class viewHolder{
        TextView txtDateExpiration, txtAmountDiscount;}

}



    /*@NonNull
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

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public class ViewHolder extends ListView.ViewHolder {

        TextView txtDateExpiration, txtAmountDiscount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtAmountDiscount = itemView.findViewById(R.id.txtAmountDiscount);
            txtDateExpiration = itemView.findViewById(R.id.txtDateExpiration);
        }
    }*/

