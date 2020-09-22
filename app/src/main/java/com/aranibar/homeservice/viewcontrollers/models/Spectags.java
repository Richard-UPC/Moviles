package com.aranibar.homeservice.viewcontrollers.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Spectags {
    private int spectagsId;
    private int tagId;
    private int specialistId;
    private boolean spectagsHidden;

    public Spectags() {
    }

    public Spectags(int spectagsId, int tagId, int specialistId, boolean spectagsHidden) {
        this.spectagsId = spectagsId;
        this.tagId = tagId;
        this.specialistId = specialistId;
        this.spectagsHidden = spectagsHidden;
    }

    public int getSpectagsId() {
        return spectagsId;
    }

    public Spectags setSpectagsId(int spectagsId) {
        this.spectagsId = spectagsId;
        return this;
    }

    public int getTagId() {
        return tagId;
    }

    public Spectags setTagId(int tagId) {
        this.tagId = tagId;
        return this;
    }

    public int getSpecialistId() {
        return specialistId;
    }

    public Spectags setSpecialistId(int specialistId) {
        this.specialistId = specialistId;
        return this;
    }

    public boolean isSpectagsHidden() {
        return spectagsHidden;
    }

    public Spectags setSpectagsHidden(boolean spectagsHidden) {
        this.spectagsHidden = spectagsHidden;
        return this;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("spectagsId", getSpectagsId());
        bundle.putInt("tagId", getTagId());
        bundle.putInt("specialistId", getSpecialistId());
        bundle.putBoolean("spectagsHidden", isSpectagsHidden());
        return bundle;
    }

    public static class Builder {
        Spectags spectags;
        List<Spectags> spectagsList;

        public Builder() {
            spectags = new Spectags();
            spectagsList = new ArrayList<>();
        }

        public Builder(Spectags spectags) {
            this.spectags = spectags;
        }

        public Builder(List<Spectags> spectagsList) {
            this.spectagsList = spectagsList;
        }

        public Spectags build() {
            return spectags;
        }

        public List<Spectags> buildAll() {
            return spectagsList;
        }

        public static Builder from(JSONObject jsonSpectags) {
            try {
                return new Builder(new Spectags(
                        jsonSpectags.getInt("spectagsId"),
                        jsonSpectags.getInt("tagId"),
                        jsonSpectags.getInt("specialistId"),
                        jsonSpectags.getBoolean("spectagsHidden")
                ));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static Builder from(JSONArray jsonSpectagsList) {
            int length = jsonSpectagsList.length();
            List<Spectags> spectagsList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                try {
                    spectagsList.add(Builder.from(jsonSpectagsList.getJSONObject(i)).build());
                } catch (JSONException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
            return new Builder(spectagsList);
        }

        public static Builder from(Bundle bundle) {
            return new Builder(new Spectags(
                    bundle.getInt("spectagsId"),
                    bundle.getInt("tagId"),
                    bundle.getInt("specialistId"),
                    bundle.getBoolean("spectagsHidden")
            ));
        }
    }
}

