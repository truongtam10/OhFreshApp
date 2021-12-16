package com.example.ohfresh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.adapter.MyVoucherAdapter;
import com.example.model.MyVoucher;

import java.util.ArrayList;

public class FragmentMyvoucher extends Fragment {

    ListView lvMyVoucher;
    ArrayList<MyVoucher> vouchers;
    MyVoucherAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_myvoucher, container, false);
        lvMyVoucher = view.findViewById(R.id.lvMyVoucher);
        adapter = new MyVoucherAdapter(getContext(),R.layout.item_voucher,initData());
        lvMyVoucher.setAdapter(adapter);
        return view;
    }

    private ArrayList<MyVoucher> initData() {
    vouchers = new ArrayList<>();
    vouchers.add(new MyVoucher("Giảm 50%","Đơn tối thiểu 50k giảm tối đa 25k","Có hiệu lực đến 20/10/2021 00:00","XKMAIFJ122"));
        vouchers.add(new MyVoucher("Giảm 50%","Đơn tối thiểu 50k giảm tối đa 25k","Có hiệu lực đến 20/10/2021 00:00","XKMAIFJ122"));
        vouchers.add(new MyVoucher("Giảm 50%","Đơn tối thiểu 50k giảm tối đa 25k","Có hiệu lực đến 20/10/2021 00:00","XKMAIFJ122"));
        vouchers.add(new MyVoucher("Giảm 50%","Đơn tối thiểu 50k giảm tối đa 25k","Có hiệu lực đến 20/10/2021 00:00","XKMAIFJ122"));
        vouchers.add(new MyVoucher("Giảm 50%","Đơn tối thiểu 50k giảm tối đa 25k","Có hiệu lực đến 20/10/2021 00:00","XKMAIFJ122"));
    return vouchers;
    }
}