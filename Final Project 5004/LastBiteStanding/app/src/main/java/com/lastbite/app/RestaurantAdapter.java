package com.lastbite.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private List<RestaurantCard> restaurants;

    public RestaurantAdapter(List<RestaurantCard> restaurants) {
        this.restaurants = restaurants;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_card, parent, false);
        RestaurantViewHolder holder = new RestaurantViewHolder(view);

        // Set click listener on the whole card
        view.setOnClickListener(v -> {
            int position = holder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                RestaurantCard restaurant = restaurants.get(position);
                if (v.getContext() instanceof GameActivity) {
                    ((GameActivity) v.getContext()).openInMaps(restaurant);
                }
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        RestaurantCard restaurant = restaurants.get(position);
        holder.restaurantName.setText(restaurant.getName());
        holder.cuisineType.setText(restaurant.getCuisine());
        holder.rating.setText(restaurant.getRating());
        holder.address.setText(restaurant.getAddress());
        holder.suggestedFor.setText("Suggested for: " + restaurant.getSuggestedFor());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public void removeItem(int position) {
        restaurants.remove(position);
        notifyItemRemoved(position);
    }

    static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        TextView restaurantName, cuisineType, rating, address, suggestedFor;

        RestaurantViewHolder(View itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.restaurantName);
            cuisineType = itemView.findViewById(R.id.cuisineType);
            rating = itemView.findViewById(R.id.rating);
            address = itemView.findViewById(R.id.address);
            suggestedFor = itemView.findViewById(R.id.suggestedFor);
        }
    }
}