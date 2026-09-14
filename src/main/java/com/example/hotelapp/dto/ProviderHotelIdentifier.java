package com.example.hotelapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProviderHotelIdentifier {
    
    // @JsonProperty forces Jackson to use the exact uppercase naming the exam requires
    @JsonProperty("ProviderHotelId")
    private String providerHotelId;
    
    @JsonProperty("ProviderFamily")
    private String providerFamily;

    public ProviderHotelIdentifier(String providerHotelId, String providerFamily) {
        this.providerHotelId = providerHotelId;
        this.providerFamily = providerFamily;
    }

    public String getProviderHotelId() { return providerHotelId; }
    public void setProviderHotelId(String providerHotelId) { this.providerHotelId = providerHotelId; }

    public String getProviderFamily() { return providerFamily; }
    public void setProviderFamily(String providerFamily) { this.providerFamily = providerFamily; }
}
