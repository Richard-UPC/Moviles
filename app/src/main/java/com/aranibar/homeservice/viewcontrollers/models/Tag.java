package com.aranibar.homeservice.viewcontrollers.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private int tagId;
    private String tagDescription;
    private String url;


    public Tag(int tagId, String tagDescription, String url) {
        this.tagId = tagId;
        this.tagDescription = tagDescription;
        this.url = url;
    }

    public Tag() {
    }


    public int getTagId() {
        return tagId;
    }

    public Tag setTagId(int tagId) {
        this.tagId = tagId;
        return this;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public Tag setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
        return this;
    }


    public String getUrl() {
        return url;
    }

    public Tag setUrl(String url) {
        this.url = url;
        return this;
    }



    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("id", getTagId());
        bundle.putString("description",getTagDescription());
        bundle.putString("url", getUrl());
        return bundle;
    }


    public static class Builder {
        private Tag tag;
        private List<Tag> tags;

        public Builder() {
            tag = new Tag();
            tags = new ArrayList<>();
        }

        public Builder(Tag tag) {
            this.tag = tag;
        }

        public Builder(List<Tag> sources) {
            this.tags = sources;
        }

        public Tag build() {
            return tag;
        }

        public List<Tag> buildAll() {
            return tags;
        }

        public static Builder from(JSONObject jsonTag) {
            try {
                return new Builder(new Tag(
                        jsonTag.getInt("id"),
                        jsonTag.optString("description"),
                        jsonTag.optString("url")
                ));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static Builder from(JSONArray jsonTags) {
            List<Tag> tags = new ArrayList<>();
            int length = jsonTags.length();
            try {
                for(int i = 0; i < length; i++ )
                    tags.add(Tag.Builder.from(jsonTags.getJSONObject(i)).build());
            } catch(JSONException e) {
                e.printStackTrace();
            }
            return new Builder(tags);
        }


        public static Builder from(Bundle bundle) {
            return new Builder(new Tag(
                    bundle.getInt("id"),
                    bundle.getString("description"),
                    bundle.getString("url")
            ));
        }
    }
}

