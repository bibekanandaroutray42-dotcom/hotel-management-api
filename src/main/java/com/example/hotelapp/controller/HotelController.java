package com.example.hotelapp.controller;

import com.example.hotelapp.entity.*;
import com.example.hotelapp.exception.ResourceNotFoundException;
import com.example.hotelapp.repository.HotelInfoRepository;
import com.example.hotelapp.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class HotelController {

    private final HotelService hotelService;
    private final HotelInfoRepository hotelRepository;

    public HotelController(HotelService hotelService, HotelInfoRepository hotelRepository) {
        this.hotelService = hotelService;
        this.hotelRepository = hotelRepository;
    }

    // Endpoint 3a: POST /import/hotels
    @PostMapping("/import/hotels")
    public ResponseEntity<String> importHotels() {
        // The Waiter asks the Chef (Service) to fetch and save the data
        hotelService.importAndSaveHotels();
        return ResponseEntity.ok("Third-party hotel import triggered successfully.");
    }

    // Endpoint 3b: GET /hotels/rooms/sorted
    @GetMapping("/hotels/rooms/sorted")
    public ResponseEntity<List<HotelInfo>> getHotelsWithSortedRooms() {
        List<HotelInfo> hotels = hotelRepository.findAll();
        
        // Loop through all hotels and sort their nested rooms by roomrate
        for (HotelInfo hotel : hotels) {
            if (hotel.getRooms() != null) {
                hotel.getRooms().sort(Comparator.comparing(HotelRoomInfo::getRoomrate));
            }
        }
        return ResponseEntity.ok(hotels);
    }

    // Endpoint 3c: GET /hotels/{hotelId}/images
    @GetMapping("/hotels/{hotelId}/images")
    public ResponseEntity<List<HotelImages>> getHotelImages(@PathVariable Long hotelId) {
        return hotelRepository.findById(hotelId)
                .map(hotel -> ResponseEntity.ok(hotel.getImages()))
                .orElseThrow(() -> new ResourceNotFoundException("No hotel found with ID: " + hotelId));
    }

    // Endpoint 3d: GET /hotels/{hotelId}/facilities
    @GetMapping("/hotels/{hotelId}/facilities")
    public ResponseEntity<List<HotelFacilities>> getHotelFacilities(@PathVariable Long hotelId) {
        return hotelRepository.findById(hotelId)
                .map(hotel -> ResponseEntity.ok(hotel.getFacilities()))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint 3e: GET /hotels/{hotelId}/contact
    @GetMapping("/hotels/{hotelId}/contact")
    public ResponseEntity<HotelContactInfo> getHotelContactInfo(@PathVariable Long hotelId) {
        return hotelRepository.findById(hotelId)
                .map(hotel -> ResponseEntity.ok(hotel.getContactInfo()))
                .orElse(ResponseEntity.notFound().build());
    }
}