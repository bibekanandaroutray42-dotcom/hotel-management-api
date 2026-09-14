package com.example.hotelapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class HotelImportRequest {

    @JsonProperty("ProviderHotelIdentifiers")
    private List<ProviderHotelIdentifier> providerHotelIdentifiers;

    public HotelImportRequest(List<ProviderHotelIdentifier> providerHotelIdentifiers) {
        this.providerHotelIdentifiers = providerHotelIdentifiers;
    }

    public List<ProviderHotelIdentifier> getProviderHotelIdentifiers() { return providerHotelIdentifiers; }
    public void setProviderHotelIdentifiers(List<ProviderHotelIdentifier> providerHotelIdentifiers) { 
        this.providerHotelIdentifiers = providerHotelIdentifiers; 
    }
}
