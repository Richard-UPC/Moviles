package com.aranibar.homeservice.viewcontrollers.networking.responses;

import com.aranibar.homeservice.viewcontrollers.models.Customer;

import java.util.List;

public class GetSpecialistResponse {
    private List<Customer> data;
    private boolean success;
    private String message;

    public GetSpecialistResponse(List<Customer> data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public List<Customer> getData() {
        return data;
    }

    public void setData(List<Customer> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
