package com.cg.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
    @Value("${City}")
    private String city;
    @Value("${Country}")
    private String country;
    @Value("${zip}")
    private long zip;

//    public Address(String city, String country, long zip) {
//        this.city = city;
//        this.country = country;
//        this.zip = zip;
//    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }
}
