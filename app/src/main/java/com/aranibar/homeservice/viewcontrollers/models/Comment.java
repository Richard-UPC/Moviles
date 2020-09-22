package com.aranibar.homeservice.viewcontrollers.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Comment {
    private int commentId;
    private int dealId;
    private int clientId;
    private int specialistId;
    private String commentDate;
    private String commentDescription;
    private boolean commentHidden;

    public Comment() {
    }

    public Comment(int commentId, int dealId, int clientId, int specialistId, String commentDate, String commentDescription, boolean commentHidden) {
        this.commentId = commentId;
        this.dealId = dealId;
        this.clientId = clientId;
        this.specialistId = specialistId;
        this.commentDate = commentDate;
        this.commentDescription = commentDescription;
        this.commentHidden = commentHidden;
    }

    public int getCommentId() {
        return commentId;
    }

    public Comment setCommentId(int commentId) {
        this.commentId = commentId;
        return this;
    }

    public int getDealId() {
        return dealId;
    }

    public Comment setDealId(int dealId) {
        this.dealId = dealId;
        return this;
    }

    public int getClientId() {
        return clientId;
    }

    public Comment setClientId(int clientId) {
        this.clientId = clientId;
        return this;
    }

    public int getSpecialistId() {
        return specialistId;
    }

    public Comment setSpecialistId(int specialistId) {
        this.specialistId = specialistId;
        return this;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public Comment setCommentDate(String commentDate) {
        this.commentDate = commentDate;
        return this;
    }

    public String getCommentDescription() {
        return commentDescription;
    }

    public Comment setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
        return this;
    }

    public boolean isCommentHidden() {
        return commentHidden;
    }

    public Comment setCommentHidden(boolean commentHidden) {
        this.commentHidden = commentHidden;
        return this;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("commentId", getCommentId());
        bundle.putInt("dealId", getDealId());
        bundle.putInt("clientId", getClientId());
        bundle.putInt("specialistId", getSpecialistId());
        bundle.putString("commentDate", getCommentDate());
        bundle.putString("commentDescription", getCommentDescription());
        bundle.putBoolean("commentHidden", isCommentHidden());
        return bundle;
    }

    public static class Builder{
        Comment comment;
        List<Comment> commentList;

        public Builder() {
            comment = new Comment();
            commentList = new ArrayList<>();
        }

        public Builder(Comment comment) {
            this.comment = comment;
        }

        public Builder(List<Comment> commentList) {
            this.commentList = commentList;
        }

        public Comment build() {
            return comment;
        }

        public List<Comment> buildAll() {
            return commentList;
        }

        public static Builder from(JSONObject jsonComment) {
            try {
                return new Builder(new Comment(
                        jsonComment.getInt("commentId"),
                        jsonComment.getInt("dealId"),
                        jsonComment.getInt("clientId"),
                        jsonComment.getInt("specialistId"),
                        jsonComment.getString("commentDate"),
                        jsonComment.getString("commentDescription"),
                        jsonComment.getBoolean("commentHidden")
                ));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static Builder from(JSONArray jsonCommentList) {
            int length = jsonCommentList.length();
            List<Comment> commentList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                try {
                    commentList.add(Builder.from(jsonCommentList.getJSONObject(i)).build());
                } catch (JSONException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
            return new Builder(commentList);
        }

        public static Builder from(Bundle bundle) {
            return new Builder(new Comment(
                    bundle.getInt("commentId"),
                    bundle.getInt("dealId"),
                    bundle.getInt("clientId"),
                    bundle.getInt("specialistId"),
                    bundle.getString("commentDate"),
                    bundle.getString("commentDescription"),
                    bundle.getBoolean("commentHidden")
            ));
        }
    }
}

