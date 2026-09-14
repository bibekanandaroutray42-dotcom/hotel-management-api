package com.example.hotelapp.repository;

import com.example.hotelapp.entity.HotelContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelContactInfoRepository extends JpaRepository<HotelContactInfo, Long> {
}
