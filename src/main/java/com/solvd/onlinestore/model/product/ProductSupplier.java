package com.solvd.onlinestore.model.product;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "productID", "supplierName", "categoryOfProducts"
})
@XmlRootElement(name = "ProductSupplier")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "productID", "supplierName", "categoryOfProducts"})

public class ProductSupplier {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("productID")
    private Long productID;
    @JsonProperty("supplierName")
    private String supplierName;
    @JsonProperty("categoryOfProducts")
    private String categoryOfProducts;

    public ProductSupplier() {

    }

    public ProductSupplier(String supplierName, String categoryOfProducts) {
        this.supplierName = supplierName;
        this.categoryOfProducts = categoryOfProducts;
    }

    public ProductSupplier(Long id, Long productID, String supplierName, String categoryOfProducts) {
        this.id = id;
        this.productID = productID;
        this.supplierName = supplierName;
        this.categoryOfProducts = categoryOfProducts;
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
    @XmlElement(name = "supplierName")
    public String getSupplierName() {
        return supplierName;
    }

    @JsonAnySetter
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @JsonAnyGetter
    @XmlElement(name = "categoryOfProducts")
    public String getCategoryOfProducts() {
        return categoryOfProducts;
    }

    @JsonAnySetter
    public void setCategoryOfProducts(String categoryOfProducts) {
        this.categoryOfProducts = categoryOfProducts;
    }


    @Override
    public String toString() {
        return "ProductSupplier{" +
                "id=" + id +
                ", productID=" + productID +
                ", supplierName='" + supplierName + '\'' +
                ", categoryOfProducts='" + categoryOfProducts + '\'' +
                '}';
    }
}
