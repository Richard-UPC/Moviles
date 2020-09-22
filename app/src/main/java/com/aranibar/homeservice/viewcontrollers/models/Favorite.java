package com.aranibar.homeservice.viewcontrollers.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Favorite {
    private int favoriteId;
    private int clientId;
    private int specialistId;
    private boolean favoriteHidden;

    public Favorite() {
    }

    public Favorite(int favoriteId, int clientId, int specialistId, boolean favoriteHidden) {
        this.favoriteId = favoriteId;
        this.clientId = clientId;
        this.specialistId = specialistId;
        this.favoriteHidden = favoriteHidden;
    }

    public int getFavoriteId() {
        return favoriteId;
    }

    public Favorite setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
        return this;
    }

    public int getClientId() {
        return clientId;
    }

    public Favorite setClientId(int clientId) {
        this.clientId = clientId;
        return this;
    }

    public int getSpecialistId() {
        return specialistId;
    }

    public Favorite setSpecialistId(int specialistId) {
        this.specialistId = specialistId;
        return this;
    }

    public boolean isFavoriteHidden() {
        return favoriteHidden;
    }

    public Favorite setFavoriteHidden(boolean favoriteHidden) {
        this.favoriteHidden = favoriteHidden;
        return this;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("favoriteId", getFavoriteId());
        bundle.putInt("clientId", getClientId());
        bundle.putInt("specialistId", getSpecialistId());
        bundle.putBoolean("favoriteHidden", isFavoriteHidden());
        return bundle;
    }

    public static class Builder {
        Favorite favorite;
        List<Favorite> favoriteList;

        public Builder() {
            favorite = new Favorite();
            favoriteList = new ArrayList<>();
        }

        public Builder(Favorite spectags) {
            this.favorite = spectags;
        }

        public Builder(List<Favorite> spectagsList) {
            this.favoriteList = spectagsList;
        }

        public Favorite build() {
            return favorite;
        }

        public List<Favorite> buildAll() {
            return favoriteList;
        }

        public static Builder from(JSONObject jsonSpectags) {
            try {
                return new Builder(new Favorite(
                        jsonSpectags.getInt("favoriteId"),
                        jsonSpectags.getInt("clientId"),
                        jsonSpectags.getInt("specialistId"),
                        jsonSpectags.getBoolean("favoriteHidden")
                ));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static Builder from(JSONArray jsonFavoriteList) {
            int length = jsonFavoriteList.length();
            List<Favorite> favoriteList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                try {
                    favoriteList.add(Builder.from(jsonFavoriteList.getJSONObject(i)).build());
                } catch (JSONException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
            return new Builder(favoriteList);
        }

        public static Builder from(Bundle bundle) {
            return new Builder(new Favorite(
                    bundle.getInt("favoriteId"),
                    bundle.getInt("clientId"),
                    bundle.getInt("specialistId"),
                    bundle.getBoolean("favoriteHidden")
            ));
        }
    }
}

