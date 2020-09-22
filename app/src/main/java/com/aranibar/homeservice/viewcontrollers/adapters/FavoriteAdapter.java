package com.aranibar.homeservice.viewcontrollers.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aranibar.homeservice.R;
import com.aranibar.homeservice.viewcontrollers.models.Favorite;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    List<Favorite> favoriteList;

    public FavoriteAdapter(List<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public FavoriteAdapter() {
    }

    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_favorite, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {
        holder.updateViews(favoriteList.get(position));
    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    public List<Favorite> getFavoriteList() {
        return favoriteList;
    }

    public FavoriteAdapter setFavoriteList(List<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Favorite favorite;
        private TextView textRate;
        private TextView textCompany;
        private TextView textDescription;
        private Button removeFavorite;

        public ViewHolder(View itemView) {
            super(itemView);
            textRate = (TextView) itemView.findViewById(R.id.text_rate);
            textCompany = (TextView) itemView.findViewById(R.id.text_company_name);
            textDescription = (TextView) itemView.findViewById(R.id.text_description);
            removeFavorite = (Button) itemView.findViewById(R.id.button_removeFavorite);
            removeFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO:  remove favorite method
                }
            });
        }

        public void updateViews(Favorite favorite) {
            this.favorite = favorite;
            textCompany.setText(String.valueOf(favorite.getSpecialistId()));
        }
    }
}

