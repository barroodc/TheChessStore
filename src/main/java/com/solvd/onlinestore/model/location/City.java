package com.solvd.onlinestore.model.location;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Arrays;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "countryID", "cityName", "location", "zipCode", "lastUpdate"
})
@XmlRootElement(name = "City")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "countryID", "cityName", "location", "zipCode", "lastUpdate"})

public class City {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("countryID")
    private Long countryID;
    @JsonProperty("cityName")
    private String cityName;
    @JsonProperty("location")
    private byte[] location;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("lastUpdate")
    private Timestamp lastUpdate;

    public City() {

    }

    public City(String cityName){
        this.cityName = cityName;
    }

    public City(Long id, Long countryID) {
        this.id = id;
        this.countryID = countryID;
    }

    public City(Long id, Long countryID, String cityName, byte[] location, String zipCode) {
        this.id = id;
        this.countryID = countryID;
        this.cityName = cityName;
        this.location = location;
        this.zipCode = zipCode;
    }

    public City(Long id, Long countryID, String cityName, byte[] location, String zipCode, Timestamp lastUpdate) {
        this.id = id;
        this.countryID = countryID;
        this.cityName = cityName;
        this.location = location;
        this.zipCode = zipCode;
        this.lastUpdate = lastUpdate;
    }

    @JsonAnyGetter
    @XmlAttribute
    public Long getId() {
        return id;
    }

    @JsonAnySetter
    public void setId(Long id) {
        this.id = id;
    }

    @JsonAnyGetter
    @XmlAttribute
    public Long getCountryID() {
        return countryID;
    }

    @JsonAnySetter
    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    @JsonAnyGetter
    @XmlElement(name = "cityName")
    public String getCityName() {
        return cityName;
    }

    @JsonAnySetter
    public void setCity(String cityName) {
        this.cityName = cityName;
    }

    @JsonAnyGetter
    @XmlElement(name = "location")
    public byte[] getLocation() {
        return location;
    }

    @JsonAnySetter
    public void setLocation(byte[] location) {
        this.location = location;
    }

    @JsonAnyGetter
    @XmlElement(name = "zipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonAnySetter
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @JsonAnyGetter
    @XmlElement(name = "lastUpdate")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    @JsonAnySetter
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", countryID=" + countryID +
                ", cityName='" + cityName + '\'' +
                ", location=" + Arrays.toString(location) +
                ", zipCode='" + zipCode + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
