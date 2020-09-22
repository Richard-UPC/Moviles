package com.aranibar.homeservice.viewcontrollers.networking.responses;

import com.aranibar.homeservice.viewcontrollers.models.Customer;

import java.util.List;

public class GetSpecialistByIdResponse {
    private Customer data;
    private boolean success;
    private String message;

    public Customer getData() {
        return data;
    }

    public void setData(Customer data) {
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

