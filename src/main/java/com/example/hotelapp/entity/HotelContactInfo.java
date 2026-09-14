package com.example.hotelapp.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hotel_contact_info")
public class HotelContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address1;
    private String city;
    private String citycode;
    private String country;
    private String countrycode;
    private String postalcode;
    private String statecode;
    private String phones;
    private String email;
    private String fax;

    // Foreign Key column linking back to hotel_info(hotel_id)
    @OneToOne
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private HotelInfo hotelInfo;

    public HotelContactInfo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAddress1() { return address1; }
    public void setAddress1(String address1) { this.address1 = address1; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCitycode() { return citycode; }
    public void setCitycode(String citycode) { this.citycode = citycode; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCountrycode() { return countrycode; }
    public void setCountrycode(String countrycode) { this.countrycode = countrycode; }

    public String getPostalcode() { return postalcode; }
    public void setPostalcode(String postalcode) { this.postalcode = postalcode; }

    public String getStatecode() { return statecode; }
    public void setStatecode(String statecode) { this.statecode = statecode; }

    public String getPhones() { return phones; }
    public void setPhones(String phones) { this.phones = phones; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFax() { return fax; }
    public void setFax(String fax) { this.fax = fax; }

    public HotelInfo getHotelInfo() { return hotelInfo; }
    public void setHotelInfo(HotelInfo hotelInfo) { this.hotelInfo = hotelInfo; }
}