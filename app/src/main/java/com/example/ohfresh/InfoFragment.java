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
import com.google.android.material.button.MaterialButton;

public class InfoFragment extends Fragment {

    MyVoucher myVoucher=null;
    TextView txtVoucherName, txtVoucherValue, txtVoucherDate,txtContentPromotion,txtContentDate,txtContentCondition ;
    ImageView imvBackToMyVoucher;
    MaterialButton btnUse;

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

        imvBackToMyVoucher = view.findViewById(R.id.imvBackToMyVoucher);
        imvBackToMyVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        btnUse = view.findViewById(R.id.btnUse);
        btnUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Category.class);
                startActivity(intent);
            }
        });

        return view;
    }

}