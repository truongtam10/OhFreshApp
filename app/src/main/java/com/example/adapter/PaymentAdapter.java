package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.PaymentMethod;
import com.example.ohfresh.R;

import java.util.ArrayList;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ViewHolderPayment> {

    Context context;
    ArrayList<PaymentMethod> payment;

    public PaymentAdapter(Context context, ArrayList<PaymentMethod> payment) {
        this.context = context;
        this.payment = payment;
    }

    @NonNull
    @Override
    public ViewHolderPayment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customPaymentView = inflater.inflate(R.layout.payment_itemlayout, parent, false);

        return new ViewHolderPayment(customPaymentView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPayment holder, int position) {

        PaymentMethod pm = payment.get(position);
        holder.imgPaymentIcon.setImageResource(payment.get(position).getPaymentIcon());
        holder.txtPaymentName.setText(payment.get(position).getPaymentName());
        holder.txtPaymentDescription.setText(payment.get(position).getPaymentDescription());
    }

    @Override
    public int getItemCount() {
        return payment.size();
    }

    public class ViewHolderPayment extends RecyclerView.ViewHolder{

        TextView txtPaymentName, txtPaymentDescription;
        ImageView imgPaymentIcon;

        public ViewHolderPayment(@NonNull View itemView) {
            super(itemView);

            txtPaymentName = itemView.findViewById(R.id.txtPaymentName);
            txtPaymentDescription = itemView.findViewById(R.id.txtPaymentDescription);
            imgPaymentIcon = itemView.findViewById(R.id.imgPaymentIcon);
        }
    }
}