package com.solvd.onlinestore.model.product;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "inventoryID", "productTypeID", "categoryID",
        "shopID", "countryID", "productName"
})
@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "inventoryID", "productTypeID", "categoryID",
        "shopID", "countryID", "productName"})

public class Product {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("inventoryID")
    private Long inventoryID;
    @JsonProperty("productTypeID")
    private long productTypeID;
    @JsonProperty("categoryID")
    private long categoryID;
    @JsonProperty("shopID")
    private long shopID;
    @JsonProperty("countryID")
    private long countryID;
    @JsonProperty("productName")
    private String productName;

    public Product() {

    }

    public Product(String productName) {
        this.productName = productName;
    }

    public Product(Long id, Long inventoryID, long productTypeID, long categoryID, long shopID, long countryID, String productName) {
        this.id = id;
        this.inventoryID = inventoryID;
        this.productTypeID = productTypeID;
        this.categoryID = categoryID;
        this.shopID = shopID;
        this.countryID = countryID;
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
    public Long getInventoryID() {
        return inventoryID;
    }

    @JsonAnySetter
    public void setInventoryID(Long inventoryID) {
        this.inventoryID = inventoryID;
    }

    @JsonAnyGetter
    @XmlElement(name = "productTypeID")
    public long getProductTypeID() {
        return productTypeID;
    }

    @JsonAnySetter
    public void setProductTypeID(long productTypeID) {
        this.productTypeID = productTypeID;
    }

    @JsonAnyGetter
    @XmlElement(name = "categoryID")
    public long getCategoryID() {
        return categoryID;
    }

    @JsonAnySetter
    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    @JsonAnyGetter
    @XmlElement(name = "shopID")
    public long getShopID() {
        return shopID;
    }

    @JsonAnySetter
    public void setShopID(long shopID) {
        this.shopID = shopID;
    }

    @JsonAnyGetter
    @XmlElement(name = "countryID")
    public long getCountryID() {
        return countryID;
    }

    @JsonAnySetter
    public void setCountryID(long countryID) {
        this.countryID = countryID;
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
        return "Product{" +
                "id=" + id +
                ", inventoryID=" + inventoryID +
                ", productTypeID=" + productTypeID +
                ", categoryID=" + categoryID +
                ", shopID=" + shopID +
                ", countryID=" + countryID +
                ", productName='" + productName + '\'' +
                '}';
    }
}
