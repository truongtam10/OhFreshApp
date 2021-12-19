package com.example.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.VeggiesItems;
import com.example.ohfresh.Account;
import com.example.ohfresh.R;

import java.util.List;

public class VeggiesAdapter extends RecyclerView.Adapter<VeggiesAdapter.ViewHolder>{
    Context context;
    List<VeggiesItems> veggies;
    private OnClickListener mOnClickListener;

    public VeggiesAdapter(Context context,List<VeggiesItems> veggies, OnClickListener onClickListener) {
        this.context = context;
        this.veggies = veggies;
        this.mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_veggies, parent, false);
        return new ViewHolder(view, mOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VeggiesItems b = veggies.get(position);
        holder.imvVeggies.setImageResource(b.getVeggiesID());
        holder.txtName.setText(b.getVeggiesName());
        holder.imvBackGround.setImageResource(b.getBackgroundID());

    }


    @Override
    public int getItemCount() {
        return veggies.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imvVeggies, imvBackGround;
        TextView txtName;
        OnClickListener onClickListener;
        public ViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);
            imvVeggies = itemView.findViewById(R.id.imvVeggies);
            imvBackGround = itemView.findViewById(R.id.imvBackground);
            txtName = itemView.findViewById(R.id.txtVeggies);
            //rclVeggies = itemView.findViewById(R.id.rclVeggies);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener((View.OnClickListener) this);
        }


        @Override
        public void onClick(View view) {
            onClickListener.onClick(getAdapterPosition());
        }
    }
    public interface OnClickListener{
        void onClick(int position);
    }
}