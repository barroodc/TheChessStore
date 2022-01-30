package com.solvd.onlinestore.model.location;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "countryID", "stateName", "lastUpdate"
})
@XmlRootElement(name = "State")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "countryID", "stateName", "lastUpdate"})

public class State {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("countryID")
    private Long countryID;
    @JsonProperty("stateName")
    private String stateName;
    @JsonProperty("lastUpdate")
    private Timestamp lastUpdate;

    public State() {

    }

    public State(Long id, Long countryID, String stateName) {
        this.id = id;
        this.countryID = countryID;
        this.stateName = stateName;
    }

    public State(Long id, Long countryID, String stateName, Timestamp lastUpdate) {
        this.id = id;
        this.countryID = countryID;
        this.stateName = stateName;
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
    @XmlElement(name = "stateName")
    public String getStateName() {
        return stateName;
    }

    @JsonAnySetter
    public void setStateName(String stateName) {
        this.stateName = stateName;
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
        return "State{" +
                "id=" + id +
                ", countryID=" + countryID +
                ", state='" + stateName + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
