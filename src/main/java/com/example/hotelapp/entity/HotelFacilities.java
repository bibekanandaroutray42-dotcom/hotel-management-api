package com.example.hotelapp.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hotel_facilities")
public class HotelFacilities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String facilityname;
    private String facilityid;
    private String groupname;
    private String groupid;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private HotelInfo hotelInfo;

    public HotelFacilities() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFacilityname() { return facilityname; }
    public void setFacilityname(String facilityname) { this.facilityname = facilityname; }

    public String getFacilityid() { return facilityid; }
    public void setFacilityid(String facilityid) { this.facilityid = facilityid; }

    public String getGroupname() { return groupname; }
    public void setGroupname(String groupname) { this.groupname = groupname; }

    public String getGroupid() { return groupid; }
    public void setGroupid(String groupid) { this.groupid = groupid; }

    public HotelInfo getHotelInfo() { return hotelInfo; }
    public void setHotelInfo(HotelInfo hotelInfo) { this.hotelInfo = hotelInfo; }
} 
