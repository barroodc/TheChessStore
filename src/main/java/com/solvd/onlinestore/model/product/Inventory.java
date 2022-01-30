package com.solvd.onlinestore.model.product;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "productName", "description", "price", "amountInStock"
})
@XmlRootElement(name = "Inventory")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "productName", "description", "price", "amountInStock"})

public class Inventory {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private float price;
    @JsonProperty("amountInStock")
    private long amountInStock;


    public Inventory() {

    }

    public Inventory(String productName, String description) {
        this.productName = productName;
        this.description = description;
    }

    public Inventory(String productName, float price) {
        this.productName = productName;
        this.price = price;
    }

    public Inventory(String productName, long amountInStock) {
        this.productName = productName;
        this.amountInStock = amountInStock;
    }

    public Inventory(Long id, String productName, String description, float price, long amountInStock) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    @JsonAnyGetter
    @XmlAttribute(name = "id")
    public Long getId() {
        return id;
    }

    @JsonAnySetter
    public void setId(Long id) {
        this.id = id;
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

    @JsonAnyGetter
    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    @JsonAnySetter
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonAnyGetter
    @XmlElement(name = "price")
    public float getPrice() {
        return price;
    }

    @JsonAnySetter
    public void setPrice(float price) {
        this.price = price;
    }

    @JsonAnyGetter
    @XmlElement(name = "amountInStock")
    public long getAmountInStock() {
        return amountInStock;
    }

    @JsonAnySetter
    public void setAmountInStock(long amountInStock) {
        this.amountInStock = amountInStock;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amountInStock=" + amountInStock +
                '}';
    }
}
