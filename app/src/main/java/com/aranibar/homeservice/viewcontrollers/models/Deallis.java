package com.aranibar.homeservice.viewcontrollers.models;

public class Deallis {
    private int dealId;
    private int specialistId;
    private String dealDate;
    private String dealDescription;
    private float dealRate;


    public Deallis(int dealId, int specialistId, String dealDate, String dealDescription, float dealRate){
        this.dealId = dealId;
        this.specialistId = specialistId;
        this.dealDate =dealDate;
        this. dealDescription =  dealDescription;
        this. dealRate =  dealRate;
    }
    public int getDealId() { return dealId;}

    public  void setDealId(int dealId){this.dealId = dealId;}

    public int getSpecialistId() { return specialistId;}

    public  void setSpecialistId(int specialistId){this.specialistId = specialistId;}

    public String getDealDate() { return dealDate;}

    public  void setDealDate(String dealDate){this.dealDate=dealDate;}

    public String getDealDescription() { return dealDescription;}

    public  void setDealDescription(String dealDescription){this.dealDescription = dealDescription;}

    public float getDealRate() { return dealRate;}

    public  void setDealRate(float dealRate){this.dealRate = dealRate;}


}
