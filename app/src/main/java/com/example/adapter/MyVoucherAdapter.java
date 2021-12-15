package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.MyVoucher;
import com.example.model.Voucher;
import com.example.ohfresh.R;

import java.util.ArrayList;

public class MyVoucherAdapter extends BaseAdapter {
    Context context;
    int item_layout;
    ArrayList<MyVoucher> vouchers;

    public MyVoucherAdapter(Context context, int item_layout, ArrayList<MyVoucher> vouchers) {
        this.context = context;
        this.item_layout = item_layout;
        this.vouchers = vouchers;
    }

    @Override
    public int getCount() {
        return vouchers.size();
    }

    @Override
    public Object getItem(int i) {
        return vouchers.get(i);
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
            holder = new viewHolder();
            view=inflater.inflate(item_layout,null);
            holder.txtLogo = view.findViewById(R.id.txtLogo);
            holder.txtVoucherName = view.findViewById(R.id.txtVoucherName);
            holder.txtVoucherValue=view.findViewById(R.id.txtVoucherValue);
            holder.txtVoucherDate = view.findViewById(R.id.txtVoucherDate);
            holder.txtUseVoucher = view.findViewById(R.id.txtUseVoucher);
            view.setTag(holder);
        }
        else{
            holder = (viewHolder) view.getTag();
        }
        MyVoucher myVoucher = vouchers.get(i);
        holder.txtVoucherName.setText(myVoucher.getVoucherName());
        holder.txtVoucherValue.setText(myVoucher.getVoucherValue());
        holder.txtVoucherDate.setText(myVoucher.getVoucherDate());
        return view;
    }
    private static class viewHolder{
        TextView txtVoucherName, txtVoucherValue, txtVoucherDate, txtLogo, txtUseVoucher;
    }
}
