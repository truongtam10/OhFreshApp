package com.example.ohfresh;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomDialog extends Dialog {
    Activity context;
    ImageButton imvOk, imvNo;
    public CustomDialog(@NonNull Context context) {
        super(context);
        this.context = (Activity) context;
        setContentView(R.layout.custom_dialog);

        linkViews();
        addEvents();
    }

    private void addEvents() {
        imvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.finish();

            }
        });

        imvNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void linkViews() {
        imvOk=findViewById(R.id.imbOk);
        imvNo=findViewById(R.id.imbNo);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context);


    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
