package com.solvd.onlinestore.model.checkout;

import com.fasterxml.jackson.annotation.*;
import jakarta.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.*;
import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id","productID","sku", "price", "subtotalOfItems", "discount",
        "quantity", "timeCreated", "cartUpdated"
})
@XmlRootElement(name = "ItemsInCart")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "productID", "sku", "price",
        "subtotalOfItems", "discount", "quantity", "timeCreated", "cartUpdated"})

public class ItemsInCart {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("productID")
    private Long productID;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("price")
    private float price;
    @JsonProperty("subtotalOfItems")
    private float subtotalOfItems;
    @JsonProperty("discount")
    private float discount;
    @JsonProperty("quantity")
    private float quantity;
    @JsonProperty("timeCreated")
    private Date timeCreated;
    @JsonProperty("cartUpdated")
    private Date cartUpdated;

    public ItemsInCart() {

    }

    public ItemsInCart(float subtotalOfItems, float quantity) {
        this.subtotalOfItems = subtotalOfItems;
        this.quantity = quantity;
    }

    public ItemsInCart(float price) {
        this.price = price;
    }

    public ItemsInCart(Date timeCreated, Date cartUpdated) {
        this.timeCreated = timeCreated;
        this.cartUpdated = cartUpdated;
    }

    public ItemsInCart(float subtotalOfItems, float quantity, float discount) {
        this.subtotalOfItems = subtotalOfItems;
        this.quantity = quantity;
        this.discount = discount;
    }

    public ItemsInCart(Long id, Long productID, String sku, float price, float subtotalOfItems, float discount, float quantity, Date timeCreated, Date cartUpdated) {
        this.id = id;
        this.productID = productID;
        this.sku = sku;
        this.price = price;
        this.subtotalOfItems = subtotalOfItems;
        this.discount = discount;
        this.quantity = quantity;
        this.timeCreated = timeCreated;
        this.cartUpdated = cartUpdated;
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
    @XmlElement(name = "sku")
    public String getSku() {
        return sku;
    }

    @JsonAnySetter
    public void setSku(String sku) {
        this.sku = sku;
    }

    @JsonAnyGetter
    @XmlElement(name = "float")
    public float getPrice() {
        return price;
    }

    @JsonAnySetter
    public void setPrice(float price) {
        this.price = price;
    }

    @JsonAnyGetter
    @XmlElement(name = "subtotalOfItems")
    public float getSubtotalOfItems() {
        return subtotalOfItems;
    }

    @JsonAnySetter
    public void setSubtotalOfItems(float subtotalOfItems) {
        this.subtotalOfItems = subtotalOfItems;
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
    public float getQuantity() {
        return quantity;
    }

    @JsonAnySetter
    public void setQuantity(float quantity) {
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

    @JsonAnyGetter
    @XmlElement(name = "cartUpdated")
    public Date getCartUpdated() {
        return cartUpdated;
    }

    @JsonAnySetter
    public void setCartUpdated(Date cartUpdated) {
        this.cartUpdated = cartUpdated;
    }

    @Override
    public String toString() {
        return "ItemsInCart{" +
                "id=" + id +
                ", productID=" + productID +
                ", sku='" + sku + '\'' +
                ", price=" + price +
                ", subtotalOfItems=" + subtotalOfItems +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", timeCreated=" + timeCreated +
                ", cartUpdated=" + cartUpdated +
                '}';
    }
}
