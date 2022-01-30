package com.solvd.onlinestore.model.purchase;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "transactionID", "inventoryID", "isInStock", "price", "discount",
        "preTax", "tax", "subtotal"
})
@XmlRootElement(name = "Invoice")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "transactionID", "inventoryID", "isInStock", "price", "discount",
        "preTax", "tax", "subtotal"})

public class Invoice {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("transactionID")
    private Long transactionID;
    @JsonProperty("inventoryID")
    private long inventoryID;
    @JsonProperty("isInStock")
    private byte[] isInStock;
    @JsonProperty("price")
    private float price;
    @JsonProperty("discount")
    private float discount;
    @JsonProperty("preTax")
    private float preTax;
    @JsonProperty("tax")
    private float tax;
    @JsonProperty("subtotal")
    private float subtotal;

    public Invoice() {

    }

    public Invoice(byte[] inStock) {
        this.isInStock = inStock;
    }

    public Invoice(float price, float discount, float preTax, float tax, float subtotal) {
        this.price = price;
        this.preTax = preTax;
        this.tax = tax;
        this.subtotal = subtotal;
    }

    public Invoice(Long id, Long transactionID, long inventoryID, byte[] isInStock, float price, float discount, float preTax, float tax, float subtotal) {
        this.id = id;
        this.transactionID = transactionID;
        this.inventoryID = inventoryID;
        this.isInStock = isInStock;
        this.price = price;
        this.discount = discount;
        this.preTax = preTax;
        this.tax = tax;
        this.subtotal = subtotal;
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
    public Long getTransactionID() {
        return transactionID;
    }

    @JsonAnySetter
    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    @JsonAnyGetter
    @XmlElement(name = "inventoryID")
    public long getInventoryID() {
        return inventoryID;
    }

    @JsonAnySetter
    public void setInventoryID(long inventoryID) {
        this.inventoryID = inventoryID;
    }

    @JsonAnyGetter
    @XmlElement(name = "isInStock")
    public byte[] getIsInStock() {
        return isInStock;
    }

    @JsonAnySetter
    public void setIsInStock(byte[] isInStock) {
        this.isInStock = isInStock;
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
    @XmlElement(name = "preTax")
    public float getPreTax() {
        return preTax;
    }

    @JsonAnySetter
    public void setPreTax(float preTax) {
        this.preTax = preTax;
    }

    @JsonAnyGetter
    @XmlElement(name = "tax")
    public float getTax() {
        return tax;
    }

    @JsonAnySetter
    public void setTax(float tax) {
        this.tax = tax;
    }

    @JsonAnyGetter
    @XmlElement(name = "subtotal")
    public float getSubtotal() {
        return subtotal;
    }

    @JsonAnySetter
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", transactionID=" + transactionID +
                ", inventoryID=" + inventoryID +
                ", isInStock=" + Arrays.toString(isInStock) +
                ", price=" + price +
                ", discount=" + discount +
                ", preTax=" + preTax +
                ", tax=" + tax +
                ", subtotal=" + subtotal +
                '}';
    }
}
