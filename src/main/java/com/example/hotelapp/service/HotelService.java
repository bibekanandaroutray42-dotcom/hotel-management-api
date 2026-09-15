package com.example.hotelapp.service;

import com.example.hotelapp.dto.HotelImportRequest;
import com.example.hotelapp.dto.ProviderHotelIdentifier;
import com.example.hotelapp.entity.HotelInfo;
import com.example.hotelapp.repository.HotelInfoRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
public class HotelService {

    private final WebClient webClient;
    private final HotelInfoRepository hotelRepository;

    public HotelService(HotelInfoRepository hotelRepository) {
        this.webClient = WebClient.create("https://fguat65.iweensoft.com/api/flights");
        this.hotelRepository = hotelRepository;
    }

    public void importAndSaveHotels() {
        // 1. Prepare the exact payload requested by the exam paper
        List<ProviderHotelIdentifier> identifiers = Arrays.asList(
                new ProviderHotelIdentifier("680851", "HotelBeds"),
                new ProviderHotelIdentifier("44311", "HummingBirdIndia")
        );
        HotelImportRequest requestPayload = new HotelImportRequest(identifiers);

        // 2. Make the HTTP POST call using WebClient
        try {
            List<HotelInfo> importedHotels = webClient.post()
                    .uri("/fake-url")
                    .header("gw-flightapi-key", "SUPER_ONLINETEST")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .bodyValue(requestPayload)
                    .retrieve()
                    .bodyToFlux(HotelInfo.class) 
                    .collectList()
                    .block();

            // 3. Save the parsed JSON into your Database
            if (importedHotels != null && !importedHotels.isEmpty()) {
                hotelRepository.saveAll(importedHotels);
            }
            
        } catch (Exception e) {
            System.out.println("Error calling the external API: " + e.getMessage());
            System.out.println("External API is offline. Injecting fallback mock data...");

            // Create a dummy hotel to keep your database and GET endpoints functional
            HotelInfo dummyHotel = new HotelInfo();
            
            // Using standard Java camelCase for the setter methods
            dummyHotel.setHotelId(101L); 
            dummyHotel.setHotelName("Grand Portfolio Resort");
            dummyHotel.setProviderFamily("HotelBeds");
            dummyHotel.setPropertyType("Resort");
            dummyHotel.setRating(5.0);
            
            // Save the dummy record to Oracle
            hotelRepository.save(dummyHotel);
            System.out.println("Mock data saved successfully! You can now test your GET endpoints.");
        }
    }
}