package com.example.hotelapp.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hotel_images")
public class HotelImages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String category;
    @Column(name = "image_size")
    private String size;
    private String providerhref;

    // Foreign Key linking back to hotel_info(hotel_id)
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private HotelInfo hotelInfo;

    public HotelImages() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getProviderhref() { return providerhref; }
    public void setProviderhref(String providerhref) { this.providerhref = providerhref; }

    public HotelInfo getHotelInfo() { return hotelInfo; }
    public void setHotelInfo(HotelInfo hotelInfo) { this.hotelInfo = hotelInfo; }
}
