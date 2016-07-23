package com.goeuro.entities;

import lombok.Getter;

import java.util.Map;
public class GoEuroData {

    public GoEuroData() {
    }

    @Getter private Long _id;
    private Object key;
    @Getter private String name;
    private String fullName;
    private Object iata_airport_code;
    @Getter private String type;
    private String country;
    @Getter private GeoPosition geo_position;
    private Long location_id;
    private Boolean inEurope;
    private Long countryId;
    private String countryCode;
    private Boolean coreCountry;
    private Object distance;
    private Map<String, String> names;
    private Map<String, String> alternativeNames;
}
