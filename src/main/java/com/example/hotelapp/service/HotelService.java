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

    // Spring Boot automatically injects the WebClient Builder and your Repository here
 // We removed WebClient.Builder from the parameters
    public HotelService(HotelInfoRepository hotelRepository) {
        // We use WebClient.create() to build it manually instead
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
            // Because the exam uses a "fake-url", we expect this to return a JSON array of hotels.
            // .bodyToFlux(HotelInfo.class) automatically parses the JSON response into your Entities!
            List<HotelInfo> importedHotels = webClient.post()
                    .uri("/fake-url")
                    .header("gw-flightapi-key", "SUPER_ONLINETEST")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .bodyValue(requestPayload)
                    .retrieve()
                    .bodyToFlux(HotelInfo.class) 
                    .collectList()
                    .block(); // .block() waits for the external server to finish replying

            // 3. Save the parsed JSON into your H2 Database using the Repository
            if (importedHotels != null && !importedHotels.isEmpty()) {
                hotelRepository.saveAll(importedHotels);
            }
            
        } catch (Exception e) {
            System.out.println("Error calling the external API: " + e.getMessage());
            // In a real exam, if the fake-url is offline, this catch block prevents the app from crashing.
        }
    }
}