package com.solvd.onlinestore.model.product;

import com.fasterxml.jackson.annotation.*;
import jakarta.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.*;
import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "productID", "overallRating", "title", "parentID", "timeCreated", "userReview"
})
@XmlRootElement(name = "ProductReview")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "productID", "overallRating", "title", "parentID", "timeCreated", "userReview"})

public class ProductReview {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("productID")
    private Long productID;
    @JsonProperty("overallRating")
    private float overallRating;
    @JsonProperty("title")
    private String title;
    @JsonProperty("parentID")
    private long parentID;
    @JsonProperty("timeCreated")
    private Date timeCreated;
    @JsonProperty("userReview")
    private String userReview;

    public ProductReview() {

    }

    public ProductReview(String title, float overallRating) {
        this.title = title;
        this.overallRating = overallRating;
    }

    public ProductReview(float overallRating, String userReview) {
        this.overallRating = overallRating;
        this.userReview = userReview;
    }

    public ProductReview(String title, Date timeCreated) {
        this.title = title;
        this.timeCreated = timeCreated;
    }

    public ProductReview(Long id, Long productID, float overallRating, String title, long parentID, Date timeCreated, String userReview) {
        this.id = id;
        this.productID = productID;
        this.overallRating = overallRating;
        this.title = title;
        this.parentID = parentID;
        this.timeCreated = timeCreated;
        this.userReview = userReview;
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
    public Long getProductID() {
        return productID;
    }

    @JsonAnySetter
    public void setProductID(Long productID) {
        this.productID = productID;
    }

    @JsonAnyGetter
    @XmlElement(name = "overallRating")
    public float getOverallRating() {
        return overallRating;
    }

    @JsonAnySetter
    public void setOverallRating(float overallRating) {
        this.overallRating = overallRating;
    }

    @JsonAnyGetter
    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    @JsonAnySetter
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonAnyGetter
    @XmlElement(name = "parentID")
    public long getParentID() {
        return parentID;
    }

    @JsonAnySetter
    public void setParentID(long parentID) {
        this.parentID = parentID;
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
    @XmlElement(name = "userReview")
    public String getUserReview() {
        return userReview;
    }

    @JsonAnySetter
    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "id=" + id +
                ", productID=" + productID +
                ", overallRating=" + overallRating +
                ", title='" + title + '\'' +
                ", parentID=" + parentID +
                ", timeCreated=" + timeCreated +
                ", userReview='" + userReview + '\'' +
                '}';
    }
}
