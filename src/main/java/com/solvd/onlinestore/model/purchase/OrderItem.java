package com.solvd.onlinestore.model.purchase;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "orderID", "productID", "sku", "price", "discount", "quantity", "timeCreated"
})
@XmlRootElement(name = "OrderItem")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "orderID", "productID", "sku", "price", "discount", "quantity", "timeCreated"})

public class OrderItem {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("orderID")
    private Long orderID;
    @JsonProperty("productID")
    private Long productID;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("price")
    private float price;
    @JsonProperty("discount")
    private float discount;
    @JsonProperty("quantity")
    private long quantity;
    @JsonProperty("timeCreated")
    private Date timeCreated;

    public OrderItem() {

    }

    public OrderItem(float discount) {
        this.discount = discount;
    }

    public OrderItem(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public OrderItem(String sku, float price) {
        this.sku = sku;
        this.price = price;
    }

    public OrderItem(Long id, Long orderID, Long productID, String sku, float price, float discount, long quantity, Date timeCreated) {
        this.id = id;
        this.orderID = orderID;
        this.productID = productID;
        this.sku = sku;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.timeCreated = timeCreated;
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
    public Long getOrderID() {
        return orderID;
    }

    @JsonAnySetter
    public void setOrderID(Long orderID) {
        this.orderID = orderID;
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
    @XmlElement(name = "sku")
    public String getSku() {
        return sku;
    }

    @JsonAnySetter
    public void setSku(String sku) {
        this.sku = sku;
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
    @XmlElement(name = "discount")
    public float getDiscount() {
        return discount;
    }

    @JsonAnySetter
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @JsonAnyGetter
    @XmlElement(name = "quantity")
    public long getQuantity() {
        return quantity;
    }

    @JsonAnySetter
    public void setQuantity(long quantity) {
        this.quantity = quantity;
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


    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderID=" + orderID +
                ", productID=" + productID +
                ", sku='" + sku + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", timeCreated=" + timeCreated +
                '}';
    }
}
