package com.example.ohfresh;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentAddMessage extends Fragment {
    private EditText edtaddMess;
    private Button btnAddMess;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_message, container, false);

        edtaddMess = v.findViewById(R.id.edtaddMess);
        btnAddMess = v.findViewById(R.id.btnAddMess);
        btnAddMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putCharSequence("Mess", edtaddMess.getText());
                getParentFragmentManager().setFragmentResult("Data", result);
                edtaddMess.setText("");
                InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
            }
        });

        return v;
    }
}
