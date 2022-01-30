package com.solvd.onlinestore.model.product;

import com.fasterxml.jackson.annotation.*;
import jakarta.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "productID", "title", "metaTitle", "productName"
})
@XmlRootElement(name = "ProductCategory")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "productID", "title", "metaTitle", "productName"})

public class ProductCategory {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("productID")
    private Long productID;
    @JsonProperty("title")
    private String title;
    @JsonProperty("metaTitle")
    private String metaTitle;
    @JsonProperty("productName")
    private String productName;

    public ProductCategory() {

    }

    public ProductCategory(String productName) {
        this.productName = productName;
    }

    public ProductCategory(String title, String metaTitle) {
        this.title = title;
        this.metaTitle = metaTitle;
    }

    public ProductCategory(Long id, Long productID, String title, String metaTitle, String productName) {
        this.id = id;
        this.productID = productID;
        this.title = title;
        this.metaTitle = metaTitle;
        this.productName = productName;
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
    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    @JsonAnySetter
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonAnyGetter
    @XmlElement(name = "metaTitle")
    public String getMetaTitle() {
        return metaTitle;
    }

    @JsonAnySetter
    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    @JsonAnyGetter
    @XmlElement(name = "productName")
    public String getProductName() {
        return productName;
    }

    @JsonAnySetter
    public void setProductName(String productName) {
        this.productName = productName;
    }


    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", productID=" + productID +
                ", title='" + title + '\'' +
                ", metaTitle='" + metaTitle + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
