package com.solvd.onlinestore.model.location;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "countryName", "currencyName", "phoneCode", "lastUpdate"
})
@XmlRootElement(name = "Country")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "countryName", "currencyName", "phoneCode", "lastUpdate"})

public class Country {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("countryName")
    private String countryName;
    @JsonProperty("currencyName")
    private String currencyName;
    @JsonProperty("phoneCode")
    private String phoneCode;
    @JsonProperty("lastUpdate")
    private Timestamp lastUpdate;

    public Country() {

    }

    public Country(Long id, String countryName) {
        this.id = id;
        this.countryName = countryName;
    }

    public Country(Long id, String countryName, String currencyName) {
        this.id = id;
        this.countryName = countryName;
        this.currencyName = currencyName;
    }

    public Country (Long id, String countryName, String currencyName, String phoneCode) {
        this.id = id;
        this.countryName = countryName;
        this.currencyName = currencyName;
        this.phoneCode = phoneCode;
    }

    public Country(Long id, String countryName, String currencyName, String phoneCode, Timestamp lastUpdate) {
        this.id = id;
        this.countryName = countryName;
        this.currencyName = currencyName;
        this.phoneCode = phoneCode;
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
    @XmlElement(name = "countryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonAnySetter
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonAnyGetter
    @XmlElement(name = "currencyName")
    public String getCurrencyName() {
        return currencyName;
    }

    @JsonAnySetter
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @JsonAnyGetter
    @XmlElement(name = "phoneCode")
    public String getPhoneCode() {
        return phoneCode;
    }

    @JsonAnySetter
    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
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
        return "Country{" +
                "id=" + id +
                ", country='" + countryName + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

}
