package com.solvd.onlinestore.model.location;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "cityID", "streetAddress", "buildingNumber", "lastUpdate"
})
@XmlRootElement(name = "Address")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "cityID", "streetAddress", "buildingNumber", "lastUpdate"})

public class Address {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("cityID")
    private Long cityID;
    @JsonProperty("streetAddress")
    private String streetAddress;
    @JsonProperty("buildingNumber")
    private String buildingNumber;
    @JsonProperty("lastUpdate")
    private Timestamp lastUpdate;

    public Address() {

    }

    public Address(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Address(String streetAddress, String buildingNumber) {
        this.streetAddress = streetAddress;
        this.buildingNumber = buildingNumber;
    }

    public Address(String streetAddress, Timestamp lastUpdate) {
        this.streetAddress = streetAddress;
        this.lastUpdate = lastUpdate;
    }

    public Address(Long id, Long cityID, String streetAddress, String buildingNumber) {
        this.id = id;
        this.cityID = cityID;
        this.streetAddress = streetAddress;
        this.buildingNumber = buildingNumber;
    }

    public Address(Long id, Long cityID, String streetAddress, String buildingNumber, Timestamp lastUpdate) {
        this.id = id;
        this.cityID = cityID;
        this.streetAddress = streetAddress;
        this.buildingNumber = buildingNumber;
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
    public Long getCityID() {
        return cityID;
    }

    @JsonAnySetter
    public void setCityID(Long cityID) {
        this.cityID = cityID;
    }

    @JsonAnyGetter
    @XmlElement(name = "streetAddress")
    public String getStreetAddress(){
        return this.streetAddress;
    }

    @JsonAnySetter
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @JsonAnyGetter
    @XmlElement(name = "buildingNumber")
    public String getBuildingNumber() {
        return buildingNumber;
    }

    @JsonAnySetter
    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
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
        return "Address{" +
                "id=" + id +
                ", cityID=" + cityID +
                ", streetAddress='" + streetAddress + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
