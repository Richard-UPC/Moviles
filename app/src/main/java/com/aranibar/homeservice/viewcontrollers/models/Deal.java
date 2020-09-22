package com.aranibar.homeservice.viewcontrollers.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Deal {
    private int dealId;
    private int clientId;
    private int specialistId;
    private String dealDate;
    private String dealDescription;
    private float dealRate;
    private boolean dealState;

    public Deal() {
    }

    public Deal(int dealId, int clientId, int specialistId, String dealDate, String dealDescription, float dealRate, boolean dealState) {
        this.dealId = dealId;
        this.clientId = clientId;
        this.specialistId = specialistId;
        this.dealDate = dealDate;
        this.dealDescription = dealDescription;
        this.dealRate = dealRate;
        this.dealState = dealState;
    }

    public int getDealId() {
        return dealId;
    }

    public Deal setDealId(int dealId) {
        this.dealId = dealId;
        return this;
    }

    public int getClientId() {
        return clientId;
    }

    public Deal setClientId(int clientId) {
        this.clientId = clientId;
        return this;
    }

    public int getSpecialistId() {
        return specialistId;
    }

    public Deal setSpecialistId(int specialistId) {
        this.specialistId = specialistId;
        return this;
    }

    public String getDealDate() {
        return dealDate;
    }

    public Deal setDealDate(String dealDate) {
        this.dealDate = dealDate;
        return this;
    }

    public String getDealDescription() {
        return dealDescription;
    }

    public Deal setDealDescription(String dealDescription) {
        this.dealDescription = dealDescription;
        return this;
    }

    public float getDealRate() {
        return dealRate;
    }

    public Deal setDealRate(float dealRate) {
        this.dealRate = dealRate;
        return this;
    }

    public boolean isDealState() {
        return dealState;
    }

    public Deal setDealState(boolean dealState) {
        this.dealState = dealState;
        return this;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("dealId", getDealId());
        bundle.putInt("clientId", getClientId());
        bundle.putInt("specialistId", getSpecialistId());
        bundle.putString("dealDate", getDealDate());
        bundle.putString("dealDescription", getDealDescription());
        bundle.putFloat("dealRate", getDealRate());
        bundle.putBoolean("dealState", isDealState());
        return bundle;
    }

    public static class Builder {
        Deal deal;
        List<Deal> dealList;

        public Builder() {
            deal = new Deal();
            dealList = new ArrayList<>();
        }

        public Builder(Deal deal) {
            this.deal = deal;
        }

        public Builder(List<Deal> dealList) {
            this.dealList = dealList;
        }

        public Deal build() {
            return deal;
        }

        public List<Deal> buildAll() {
            return dealList;
        }

        public static Builder from(JSONObject jsonDeal) {
            try {
                return new Builder(new Deal(
                        jsonDeal.getInt("dealId"),
                        jsonDeal.getInt("clientId"),
                        jsonDeal.getInt("specialistId"),
                        jsonDeal.getString("dealDate"),
                        jsonDeal.getString("dealDescription"),
                        jsonDeal.getLong("dealRate"),
                        jsonDeal.getBoolean("dealState")
                ));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static Builder from(JSONArray jsonDealList) {
            int length = jsonDealList.length();
            List<Deal> dealList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                try {
                    dealList.add(Builder.from(jsonDealList.getJSONObject(i)).build());
                } catch (JSONException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
            return new Builder(dealList);
        }

        public static Builder from(Bundle bundle) {
            return new Builder(new Deal(
                    bundle.getInt("dealId"),
                    bundle.getInt("clientId"),
                    bundle.getInt("specialistId"),
                    bundle.getString("dealDate"),
                    bundle.getString("dealDescription"),
                    bundle.getLong("dealRate"),
                    bundle.getBoolean("dealState")
            ));
        }
    }
}

