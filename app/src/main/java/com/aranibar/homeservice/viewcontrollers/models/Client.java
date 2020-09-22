package com.aranibar.homeservice.viewcontrollers.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int clientId;
    private String clientLogin;
    private String clientPassword;
    private String clientNames;
    private String clientLastnames;
    private int clientDocType;
    private String clientDocNumber;
    private String clientPhone;
    private String clientEmail;
    private String clientAddress;
    private String clientReference;
    private float clientRate;
    private boolean clientState;
    private boolean clientHidden;

    public Client() {
    }

    public Client(int clientId, String clientLogin, String clientPassword, String clientNames, String clientLastnames, int clientDocType, String clientDocNumber, String clientPhone, String clientEmail, String clientAddress, String clientReference, float clientRate, boolean clientState, boolean clientHidden) {
        this.clientId = clientId;
        this.clientLogin = clientLogin;
        this.clientPassword = clientPassword;
        this.clientNames = clientNames;
        this.clientLastnames = clientLastnames;
        this.clientDocType = clientDocType;
        this.clientDocNumber = clientDocNumber;
        this.clientPhone = clientPhone;
        this.clientEmail = clientEmail;
        this.clientAddress = clientAddress;
        this.clientReference = clientReference;
        this.clientRate = clientRate;
        this.clientState = clientState;
        this.clientHidden = clientHidden;
    }

    public int getClientId() {
        return clientId;
    }

    public Client setClientId(int clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public Client setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
        return this;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public Client setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
        return this;
    }

    public String getClientNames() {
        return clientNames;
    }

    public Client setClientNames(String clientNames) {
        this.clientNames = clientNames;
        return this;
    }

    public String getClientLastnames() {
        return clientLastnames;
    }

    public Client setClientLastnames(String clientLastnames) {
        this.clientLastnames = clientLastnames;
        return this;
    }

    public int getClientDocType() {
        return clientDocType;
    }

    public Client setClientDocType(int clientDocType) {
        this.clientDocType = clientDocType;
        return this;
    }

    public String getClientDocNumber() {
        return clientDocNumber;
    }

    public Client setClientDocNumber(String clientDocNumber) {
        this.clientDocNumber = clientDocNumber;
        return this;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public Client setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
        return this;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public Client setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
        return this;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public Client setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
        return this;
    }

    public String getClientReference() {
        return clientReference;
    }

    public Client setClientReference(String clientReference) {
        this.clientReference = clientReference;
        return this;
    }

    public float getClientRate() {
        return clientRate;
    }

    public Client setClientRate(float clientRate) {
        this.clientRate = clientRate;
        return this;
    }

    public boolean isClientState() {
        return clientState;
    }

    public Client setClientState(boolean clientState) {
        this.clientState = clientState;
        return this;
    }

    public boolean isClientHidden() {
        return clientHidden;
    }

    public Client setClientHidden(boolean clientHidden) {
        this.clientHidden = clientHidden;
        return this;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("clientId", getClientId());
        bundle.putString("clientLogin", getClientLogin());
        bundle.putString("clientPassword", getClientPassword());
        bundle.putString("clientNames", getClientNames());
        bundle.putString("clientLastNames", getClientLastnames());
        bundle.putInt("clientDocType", getClientDocType());
        bundle.putString("clientDocNumber", getClientDocNumber());
        bundle.putString("clientPhone", getClientPhone());
        bundle.putString("clientEmail", getClientEmail());
        bundle.putString("clientAddress", getClientAddress());
        bundle.putString("clientReference", getClientReference());
        bundle.putFloat("clientRate", getClientRate());
        bundle.putBoolean("clientState", isClientState());
        bundle.putBoolean("clientHidden", isClientHidden());
        return bundle;
    }

    public static class Builder {
        Client client;
        List<Client> clientList;

        public Builder() {
            client = new Client();
            clientList = new ArrayList<>();
        }

        public Builder(Client client) {
            this.client = client;
        }

        public Builder(List<Client> clientList) {
            this.clientList = clientList;
        }

        public Client build() {
            return client;
        }

        public List<Client> buildAll() {
            return clientList;
        }

        public static Builder from(JSONObject jsonClient) {
            try {
                return new Builder(new Client(
                        jsonClient.getInt("clientId"),
                        jsonClient.getString("clientLogin"),
                        jsonClient.getString("clientPassword"),
                        jsonClient.getString("clientNames"),
                        jsonClient.getString("clientLastNames"),
                        jsonClient.getInt("clientDocType"),
                        jsonClient.getString("clientDocNumber"),
                        jsonClient.getString("clientPhone"),
                        jsonClient.getString("clientEmail"),
                        jsonClient.getString("clientAddress"),
                        jsonClient.getString("clientReference"),
                        jsonClient.getLong("rate"),
                        jsonClient.getBoolean("clientState"),
                        jsonClient.getBoolean("clientHidden")
                ));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static Builder from(JSONArray jsonClientList) {
            int length = jsonClientList.length();
            List<Client> clientList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                try {
                    clientList.add(Builder.from(jsonClientList.getJSONObject(i)).build());
                } catch (JSONException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
            return new Builder(clientList);
        }

        public static Builder from(Bundle bundle) {
            return new Builder(new Client(
                    bundle.getInt("clientId"),
                    bundle.getString("clientLogin"),
                    bundle.getString("clientPassword"),
                    bundle.getString("clientNames"),
                    bundle.getString("clientLastNames"),
                    bundle.getInt("clientDocType"),
                    bundle.getString("clientDocNumber"),
                    bundle.getString("clientPhone"),
                    bundle.getString("clientEmail"),
                    bundle.getString("clientAddress"),
                    bundle.getString("clientReference"),
                    bundle.getLong("clientRate"),
                    bundle.getBoolean("clientState"),
                    bundle.getBoolean("clientHidden")
            ));
        }
    }
}

