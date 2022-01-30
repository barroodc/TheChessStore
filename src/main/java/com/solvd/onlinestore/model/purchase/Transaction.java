package com.solvd.onlinestore.model.purchase;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "userID", "status", "timeCreated", "approvalStatus"
})
@XmlRootElement(name = "Transaction")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "userID", "status", "timeCreated", "approvalStatus"})

public class Transaction {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("userID")
    private Long userID;
    @JsonProperty("status")
    private String status;
    @JsonProperty("timeCreated")
    private Date timeCreated;
    @JsonProperty("approvalStatus")
    private String approvalStatus;

    public Transaction() {

    }

    public Transaction(long id, Long userID, String status, Date timeCreated, String approvalStatus) {
        this.id = id;
        this.userID = userID;
        this.status = status;
        this.timeCreated = timeCreated;
        this.approvalStatus = approvalStatus;
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
    public Long getUserID() {
        return userID;
    }

    @JsonAnySetter
    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @JsonAnyGetter
    @XmlElement(name = "status")
    public String getStatus() {
        return status;
    }

    @JsonAnySetter
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonAnyGetter
    @XmlElement(name = "timeCreated")
    public Date getTimeCreated() {
        return timeCreated;
    }

    @JsonAnySetter
    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    @JsonAnyGetter
    @XmlElement(name = "approvalStatus")
    public String getApprovalStatus() {
        return approvalStatus;
    }

    @JsonAnySetter
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", userID=" + userID +
                ", status='" + status + '\'' +
                ", timeCreated=" + timeCreated +
                ", approvalStatus='" + approvalStatus + '\'' +
                '}';
    }
}
