package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.BestSellingItems;
import com.example.ohfresh.R;

import java.util.List;

public class BestSellingAdapter extends RecyclerView.Adapter<BestSellingAdapter.ViewHolder> {
    Context context;
    List<BestSellingItems> bestSellingItems;

    public BestSellingAdapter(Context context, List<BestSellingItems> bestSellingItems) {
        this.context = context;
        this.bestSellingItems = bestSellingItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bestselling, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BestSellingItems b = bestSellingItems.get(position);
        holder.imvBestSeller.setImageResource(b.getItemID());
        holder.txtBestSeller.setText(b.getBestSellingName());

    }

    @Override
    public int getItemCount() {
        return bestSellingItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvBestSeller;
        TextView txtBestSeller;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvBestSeller = itemView.findViewById(R.id.imvBestSeller);
            txtBestSeller = itemView.findViewById(R.id.txtBestSeller);
        }
    }
}