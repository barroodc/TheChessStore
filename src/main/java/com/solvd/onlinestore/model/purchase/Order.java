package com.solvd.onlinestore.model.purchase;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "userID", "dateOfOrder", "dateOfDelivery", "timeOfDelivery", "postalCode", "mobile",
        "email", "timeCreated", "status"
})
@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "userID", "dateOfOrder", "dateOfDelivery", "timeOfDelivery", "postalCode", "mobile",
        "email", "timeCreated", "status"})

public class Order {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("userID")
    private Long userID;
    @JsonProperty("dateOfOrder")
    private Date dateOfOrder;
    @JsonProperty("dateOfDelivery")
    private Date dateOfDelivery;
    @JsonProperty("timeOfDelivery")
    private Date timeOfDelivery;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("email")
    private String email;
    @JsonProperty("timeCreated")
    private Date timeCreated;
    @JsonProperty("status")
    private String status;

    public Order() {

    }

    public Order(String mobile, String email) {
        this.mobile = mobile;
        this.email = email;
    }

    public Order(Date timeCreated, Date dateOfOrder, Date dateOfDelivery, Date timeOfDelivery, String status) {
        this.timeCreated = timeCreated;
        this.dateOfOrder = dateOfOrder;
        this.dateOfDelivery = dateOfDelivery;
        this.timeOfDelivery = timeOfDelivery;
        this.status = status;
    }

    public Order(Long id, Long userID, Date dateOfOrder, Date dateOfDelivery, Date timeOfDelivery, String postalCode, String mobile, String email, Date timeCreated, String status) {
        this.id = id;
        this.userID = userID;
        this.dateOfOrder = dateOfOrder;
        this.dateOfDelivery = dateOfDelivery;
        this.timeOfDelivery = timeOfDelivery;
        this.postalCode = postalCode;
        this.mobile = mobile;
        this.email = email;
        this.timeCreated = timeCreated;
        this.status = status;
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
    @XmlElement(name = "dateOfOrder")
    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    @JsonAnySetter
    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    @JsonAnyGetter
    @XmlElement(name = "dateOfDelivery")
    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    @JsonAnySetter
    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    @JsonAnyGetter
    @XmlElement(name = "timeOfDelivery")
    public Date getTimeOfDelivery() {
        return timeOfDelivery;
    }

    @JsonAnySetter
    public void setTimeOfDelivery(Date timeOfDelivery) {
        this.timeOfDelivery = timeOfDelivery;
    }

    @JsonAnyGetter
    @XmlElement(name = "postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonAnySetter
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonAnyGetter
    @XmlElement(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    @JsonAnySetter
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @JsonAnyGetter
    @XmlElement(name = "email")
    public String getEmail() {
        return email;
    }

    @JsonAnySetter
    public void setEmail(String email) {
        this.email = email;
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
    @XmlElement(name = "status")
    public String getStatus() {
        return status;
    }

    @JsonAnySetter
    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userID=" + userID +
                ", dateOfOrder=" + dateOfOrder +
                ", dateOfDelivery=" + dateOfDelivery +
                ", timeOfDelivery=" + timeOfDelivery +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", timeCreated=" + timeCreated +
                ", status='" + status + '\'' +
                '}';
    }
}
