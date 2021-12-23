package com.example.ohfresh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.adapter.MyVoucherAdapter;
import com.example.model.MyVoucher;
import com.example.model.MyVoucherClick;

import java.util.ArrayList;

public class FragmentMyvoucher extends Fragment {

    ListView lvMyVoucher;
    ArrayList<MyVoucher> vouchers;
    MyVoucherAdapter adapter;
    MyVoucherClick myVoucherClick;
    ImageView imvBacktoAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_myvoucher, container, false);
        lvMyVoucher = view.findViewById(R.id.lvMyVoucher);
        adapter = new MyVoucherAdapter(getContext(),R.layout.item_voucher,initData());
        lvMyVoucher.setAdapter(adapter);
        lvMyVoucher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                myVoucherClick = (MyVoucherClick) getActivity();
                myVoucherClick.click(vouchers.get(i));
            }
        });

        imvBacktoAccount = view.findViewById(R.id.imvBackToAccount);
        imvBacktoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        return view;

    }

    private ArrayList<MyVoucher> initData() {
    vouchers = new ArrayList<>();
    vouchers.add(new MyVoucher("Giảm 50%","Đơn tối thiểu 50k giảm tối đa 25k","Có hiệu lực đến 20/10/2021 00:00","XKMAIFJ122"));
        vouchers.add(new MyVoucher("Miễn phí vận chuyển","Giảm tối đá 40k","Có hiệu lực đến 30/10/2021 00:00","MPVCIGH265"));
        vouchers.add(new MyVoucher("Giảm 10%","Đơn tối thiểu 90k giảm tối đa 30k","Có hiệu lực đến 25/11/2021 00:00","XKAPKSQ693"));
        vouchers.add(new MyVoucher("Giảm 5%","Đơn tối thiểu 100k giảm tối đa 50k","Có hiệu lực đến 17/12/2021 00:00","GNPRQNJ732"));
        vouchers.add(new MyVoucher("Miễn phí vận chuyển","Giảm 50% giảm tối đa 30k","Có hiệu lực đến 30/12/2021 00:00","MPAVHSY382"));
    return vouchers;
    }
}