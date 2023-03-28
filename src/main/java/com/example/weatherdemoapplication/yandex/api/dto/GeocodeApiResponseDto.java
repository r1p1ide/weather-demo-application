package com.example.weatherdemoapplication.yandex.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class GeocodeApiResponseDto {

    @Data
    public static class Address {
        public String country_code;
        public String formatted;
        public String postal_code;
        @JsonProperty("Components")
        public ArrayList<Component> components;
    }

    @Data
    public static class AddressDetails {
        @JsonProperty("Country")
        public Country country;
    }

    @Data
    public static class AdministrativeArea {
        @JsonProperty("AdministrativeAreaName")
        public String administrativeAreaName;
        @JsonProperty("Locality")
        public Locality locality;
    }

    @Data
    public static class BoundedBy {
        @JsonProperty("Envelope")
        public Envelope envelope;
    }

    @Data
    public static class Component {
        public String kind;
        public String name;
    }

    @Data
    public static class Country {
        @JsonProperty("AddressLine")
        public String addressLine;
        @JsonProperty("CountryNameCode")
        public String countryNameCode;
        @JsonProperty("CountryName")
        public String countryName;
        @JsonProperty("AdministrativeArea")
        public AdministrativeArea administrativeArea;
    }

    @Data
    public static class Envelope {
        public String lowerCorner;
        public String upperCorner;
    }

    @Data
    public static class FeatureMember {
        @JsonProperty("GeoObject")
        public GeoObject geoObject;
    }

    @Data
    public static class GeocoderMetaData {
        public String precision;
        public String text;
        public String kind;
        @JsonProperty("Address")
        public Address address;
        @JsonProperty("AddressDetails")
        public AddressDetails addressDetails;
    }

    @Data
    public static class GeocoderResponseMetaData {
        public String request;
        public String results;
        public String found;
    }

    @Data
    public static class GeoObject {
        public MetaDataProperty metaDataProperty;
        public String name;
        public String description;
        public BoundedBy boundedBy;
        @JsonProperty("Point")
        public Point point;
    }

    @Data
    public static class GeoObjectCollection {
        public MetaDataProperty metaDataProperty;
        public ArrayList<FeatureMember> featureMember;
    }

    @Data
    public static class Locality {
        @JsonProperty("LocalityName")
        public String localityName;
        @JsonProperty("Thoroughfare")
        public Thoroughfare thoroughfare;
    }

    @Data
    public static class MetaDataProperty {
        @JsonProperty("GeocoderResponseMetaData")
        public GeocoderResponseMetaData geocoderResponseMetaData;
        @JsonProperty("GeocoderMetaData")
        public GeocoderMetaData geocoderMetaData;
    }

    @Data
    public static class Point {
        public String pos;
    }

    @Data
    public static class PostalCode {
        @JsonProperty("PostalCodeNumber")
        public String postalCodeNumber;
    }

    @Data
    public static class Premise {
        @JsonProperty("PremiseNumber")
        public String premiseNumber;
        @JsonProperty("PostalCode")
        public PostalCode postalCode;
    }

    @Data
    public static class Response {
        @JsonProperty("GeoObjectCollection")
        public GeoObjectCollection geoObjectCollection;
    }

    @Data
    public static class Root {
        public Response response;
    }

    @Data
    public static class Thoroughfare {
        @JsonProperty("ThoroughfareName")
        public String thoroughfareName;
        @JsonProperty("Premise")
        public Premise premise;
    }

    public Response response;
}
