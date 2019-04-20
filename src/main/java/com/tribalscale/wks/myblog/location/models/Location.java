package com.tribalscale.wks.myblog.location.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LatLng {

    @JsonProperty("lat")
    private final double latitude;

    @JsonProperty("lon")
    private final double longitude;
    
    private final String city;

    private LatLng() {
        this.latitude = 0;
        this.longitude = 0;
    }

    public LatLng(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
