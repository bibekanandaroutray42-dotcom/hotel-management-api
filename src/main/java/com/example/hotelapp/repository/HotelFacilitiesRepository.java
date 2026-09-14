package com.example.hotelapp.repository;

import com.example.hotelapp.entity.HotelFacilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelFacilitiesRepository extends JpaRepository<HotelFacilities, Long> {
}
