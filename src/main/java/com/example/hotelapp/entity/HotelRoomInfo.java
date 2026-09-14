package com.example.hotelapp.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hotel_room_info")
public class HotelRoomInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roomId;
    private String roomtype;
    private Integer maxguestallowed;
    private Integer maxadultallowed;
    private Integer maxchildrenallowed;
    private Double roomrate;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private HotelInfo hotelInfo;

    public HotelRoomInfo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getRoomtype() { return roomtype; }
    public void setRoomtype(String roomtype) { this.roomtype = roomtype; }

    public Integer getMaxguestallowed() { return maxguestallowed; }
    public void setMaxguestallowed(Integer maxguestallowed) { this.maxguestallowed = maxguestallowed; }

    public Integer getMaxadultallowed() { return maxadultallowed; }
    public void setMaxadultallowed(Integer maxadultallowed) { this.maxadultallowed = maxadultallowed; }

    public Integer getMaxchildrenallowed() { return maxchildrenallowed; }
    public void setMaxchildrenallowed(Integer maxchildrenallowed) { this.maxchildrenallowed = maxchildrenallowed; }

    public Double getRoomrate() { return roomrate; }
    public void setRoomrate(Double roomrate) { this.roomrate = roomrate; }

    public HotelInfo getHotelInfo() { return hotelInfo; }
    public void setHotelInfo(HotelInfo hotelInfo) { this.hotelInfo = hotelInfo; }
}