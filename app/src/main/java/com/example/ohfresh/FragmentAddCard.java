package com.example.ohfresh;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentAddCard extends Fragment {
    private EditText edtNum, edtName, edtDate;
    private Button btnAddCard;
    FragmentListCard fragmentListCard;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_card, container, false);

        edtNum = v.findViewById(R.id.edtCardNum);
        edtName = v.findViewById(R.id.edtName);
        edtDate = v.findViewById(R.id.edtExpDate);
        btnAddCard = v.findViewById(R.id.btnAddCard);
        btnAddCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Bundle result = new Bundle();
                result.putCharSequence("Card", "Số thẻ: " + edtNum.getText() + "\n" + "Tên chủ thẻ: " + edtName.getText() + "\n" + "Ngày hết hạn: " + edtDate.getText());
                getParentFragmentManager().setFragmentResult("Data", result);
                edtNum.setText("");
                edtName.setText("");
                edtDate.setText("");

                InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);

                getView().setVisibility(View.GONE);
            }
        });

        return v;


    }
}
