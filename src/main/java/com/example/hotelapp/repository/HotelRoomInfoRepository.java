package com.example.hotelapp.repository;

import com.example.hotelapp.entity.HotelRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomInfoRepository extends JpaRepository<HotelRoomInfo, Long> {
}