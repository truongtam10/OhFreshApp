package com.example.ohfresh;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.MyVoucher;
import com.example.utils.Constant;

public class InfoFragment extends Fragment {

    MyVoucher myVoucher=null;
    TextView txtVoucherName, txtVoucherValue, txtVoucherDate,txtContentPromotion,txtContentDate,txtContentCondition ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        txtVoucherName =view.findViewById(R.id.txtVoucherName);
        txtVoucherValue = view.findViewById(R.id.txtVoucherValue);
        txtVoucherDate = view.findViewById(R.id.txtVoucherDate);
        txtContentPromotion = view.findViewById(R.id.txtContentPromotion);
        txtContentDate = view.findViewById(R.id.txtContentDate);
        txtContentCondition = view.findViewById(R.id.txtContentCondition);

        Bundle bundle = getArguments();
        if (bundle != null)
        {
            myVoucher = (MyVoucher) bundle.getSerializable(Constant.SELECTED_VOUCHER);
            txtVoucherName.setText(myVoucher.getVoucherName());
            txtVoucherDate.setText(myVoucher.getVoucherDate());
            txtVoucherValue.setText(myVoucher.getVoucherValue());
            txtContentPromotion.setText("Lượt sử dụng có hạn. Nhanh tay kẻo lỡ bạn nhé!"+ "\n"+myVoucher.getVoucherValue());
            txtContentDate.setText(myVoucher.getVoucherDate());
            txtContentCondition.setText("Mã "+myVoucher.getVoucherID() +" cho "+myVoucher.getVoucherValue() +" trên ứng dụng Oh!Fresh. HSD: "+myVoucher.getVoucherDate() +" Số lượng có hạn. Mỗi khách hàng chỉ được sử dụng một lần.");
        }
        return view;
    }
}