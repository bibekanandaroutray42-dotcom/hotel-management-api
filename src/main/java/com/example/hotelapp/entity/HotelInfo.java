package com.example.hotelapp.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotel_info")
public class HotelInfo {

    @Id
    @Column(name = "hotel_id")
    private Long hotelId;

    @Column(name = "hotelname")
    private String hotelName;

    private String thumbnail;

    @Column(name = "providerfamily")
    private String providerFamily;

    @Column(name = "propertytype")
    private String propertyType;

    private Double rating;

    // 1-to-1 relationship with hotel_contact_info
    @OneToOne(mappedBy = "hotelInfo", cascade = CascadeType.ALL)
    private HotelContactInfo contactInfo;

    // 1-to-Many relationships with child tables
    @OneToMany(mappedBy = "hotelInfo", cascade = CascadeType.ALL)
    private List<HotelImages> images;

    @OneToMany(mappedBy = "hotelInfo", cascade = CascadeType.ALL)
    private List<HotelFacilities> facilities;

    @OneToMany(mappedBy = "hotelInfo", cascade = CascadeType.ALL)
    private List<HotelRoomInfo> rooms;

    public HotelInfo() {}

    public Long getHotelId() { return hotelId; }
    public void setHotelId(Long hotelId) { this.hotelId = hotelId; }

    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }

    public String getProviderFamily() { return providerFamily; }
    public void setProviderFamily(String providerFamily) { this.providerFamily = providerFamily; }

    public String getPropertyType() { return propertyType; }
    public void setPropertyType(String propertyType) { this.propertyType = propertyType; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public HotelContactInfo getContactInfo() { return contactInfo; }
    public void setContactInfo(HotelContactInfo contactInfo) { this.contactInfo = contactInfo; }

    public List<HotelImages> getImages() { return images; }
    public void setImages(List<HotelImages> images) { this.images = images; }

    public List<HotelFacilities> getFacilities() { return facilities; }
    public void setFacilities(List<HotelFacilities> facilities) { this.facilities = facilities; }

    public List<HotelRoomInfo> getRooms() { return rooms; }
    public void setRooms(List<HotelRoomInfo> rooms) { this.rooms = rooms; }
}