package com.aranibar.homeservice.viewcontrollers.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DocType {
    private int doctypeId;
    private String doctypeDescription;

    public DocType() {
    }

    public DocType(int doctypeId, String doctypeDescription) {
        this.doctypeId = doctypeId;
        this.doctypeDescription = doctypeDescription;
    }

    public int getDoctypeId() {
        return doctypeId;
    }

    public DocType setDoctypeId(int doctypeId) {
        this.doctypeId = doctypeId;
        return this;
    }

    public String getDoctypeDescription() {
        return doctypeDescription;
    }

    public DocType setDoctypeDescription(String doctypeDescription) {
        this.doctypeDescription = doctypeDescription;
        return this;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("doctypeId", getDoctypeId());
        bundle.putString("doctypeDescription", getDoctypeDescription());
        return bundle;
    }

    public static class Builder{
        DocType docType;
        List<DocType> docTypeList;

        public Builder() {
            docType = new DocType();
            docTypeList = new ArrayList<>();
        }

        public Builder(DocType docType) {
            this.docType = docType;
        }

        public Builder(List<DocType> docTypeList) {
            this.docTypeList = docTypeList;
        }

        public DocType build() {
            return docType;
        }

        public List<DocType> buildAll() {
            return docTypeList;
        }

        public static Builder from(JSONObject jsonDoctype) {
            try {
                return new Builder(new DocType(
                        jsonDoctype.getInt("doctypeId"),
                        jsonDoctype.getString("doctypeDescription")
                ));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static Builder from(JSONArray jsonDoctypeList) {
            int length = jsonDoctypeList.length();
            List<DocType> docTypeList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                try {
                    docTypeList.add(Builder.from(jsonDoctypeList.getJSONObject(i)).build());
                } catch (JSONException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
            return new Builder(docTypeList);
        }

        public static Builder from(Bundle bundle) {
            return new Builder(new DocType(
                    bundle.getInt("doctypeId"),
                    bundle.getString("doctypeDescription")
            ));
        }
    }
}

