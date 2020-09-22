package com.aranibar.homeservice.viewcontrollers.networking.responses;

import com.aranibar.homeservice.viewcontrollers.models.Specialty;

import java.util.List;

public class GetSpecialtyResponse {
    private List<Specialty> data;
    private boolean success;
    private String message;
    public GetSpecialtyResponse(List<Specialty> data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }
    public List<Specialty> getData() {
        return data;
    }

    public void setData(List<Specialty> data) {
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
