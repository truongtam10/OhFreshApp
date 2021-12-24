package com.example.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.PaymentMethod;
import com.example.ohfresh.R;

import java.util.ArrayList;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ViewHolderPayment> {

    Context context;
    ArrayList<PaymentMethod> payment;
    private OnPaymentListener onPaymentListener;

    public PaymentAdapter(Context context, ArrayList<PaymentMethod> payment, OnPaymentListener onPaymentListener) {
        this.context = context;
        this.payment = payment;

        this.onPaymentListener = onPaymentListener;
    }

    @NonNull
    @Override
    public ViewHolderPayment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customPaymentView = inflater.inflate(R.layout.payment_itemlayout, parent, false);

        return new ViewHolderPayment(customPaymentView, onPaymentListener);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPayment holder, int position) {

        PaymentMethod pm = payment.get(position);
        holder.imgPaymentIcon.setImageResource(payment.get(position).getPaymentIcon());
        holder.txtPaymentName.setText(payment.get(position).getPaymentName());
        holder.txtPaymentDescription.setText(payment.get(position).getPaymentDescription());

        holder.lnPaymentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*int row_index = position;
                notifyDataSetChanged();*/


                holder.lnPaymentLayout.setBackgroundResource(R.drawable.background_selected_item);
            }
        });
        /*if(row_index==position){
            holder.lnPaymentLayout.setBackgroundResource(R.drawable.background_selected_item);
            //holder.tv1.setTextColor(Color.parseColor("#ffffff"));
        }
        else
        {
            holder.lnPaymentLayout.setBackgroundResource(R.drawable.item_corner);
            //holder.tv1.setTextColor(Color.parseColor("#000000"));
        }*/
    }

    @Override
    public int getItemCount() {
        return payment.size();
    }

    public class ViewHolderPayment extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtPaymentName, txtPaymentDescription;
        ImageView imgPaymentIcon;
        LinearLayout lnPaymentLayout;

        OnPaymentListener onPaymentListener;

        public ViewHolderPayment(@NonNull View itemView, OnPaymentListener onPaymentListener) {
            super(itemView);

            this.onPaymentListener = onPaymentListener;
            txtPaymentName = itemView.findViewById(R.id.txtPaymentName);
            txtPaymentDescription = itemView.findViewById(R.id.txtPaymentDescription);
            imgPaymentIcon = itemView.findViewById(R.id.imgPaymentIcon);
            lnPaymentLayout = itemView.findViewById(R.id.lnPaymentLayout);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onPaymentListener.OnPaymentListener(getAdapterPosition());
        }
    }
    public interface OnPaymentListener{
        void OnPaymentListener(int position);
    }
}