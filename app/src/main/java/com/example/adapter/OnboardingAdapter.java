package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.OnboardingItems;
import com.example.ohfresh.R;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>{
    private List<OnboardingItems> onboardingItemsList;

    public OnboardingAdapter(List<OnboardingItems> onboardingItemsList) {
        this.onboardingItemsList = onboardingItemsList;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_onboarding_container, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        holder.setOnboardingData(onboardingItemsList.get(position));
    }

    @Override
    public int getItemCount() {
        return onboardingItemsList.size();
    }

    class OnboardingViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private TextView txtDescription;
        private ImageView imvOnboarding;

        OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            imvOnboarding = itemView.findViewById(R.id.imvOnboarding);
        }

        void setOnboardingData (OnboardingItems onboardingItems) {
            txtTitle.setText(onboardingItems.getTitle());
            txtDescription.setText(onboardingItems.getDescription());
            imvOnboarding.setImageResource(onboardingItems.getImage());
        }
    }
}
