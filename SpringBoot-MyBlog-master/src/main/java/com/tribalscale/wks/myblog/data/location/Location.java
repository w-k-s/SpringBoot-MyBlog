package com.tribalscale.wks.myblog.data.location;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

    @JsonProperty("lat")
    private final double latitude;

    @JsonProperty("lon")
    private final double longitude;

    private final String city;

    private final String country;

    private Location() {
        this.latitude = 0;
        this.longitude = 0;
        this.city = "";
        this.country = "";
    }

    public Location(double latitude, double longitude, String city, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
