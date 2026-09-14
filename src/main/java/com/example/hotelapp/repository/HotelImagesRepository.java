package com.example.hotelapp.repository;

import com.example.hotelapp.entity.HotelImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelImagesRepository extends JpaRepository<HotelImages, Long> {
}