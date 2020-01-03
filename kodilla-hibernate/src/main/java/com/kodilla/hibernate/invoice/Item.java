package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "ITEMS")
public class Item {
    private int id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    BigDecimal value;
    private Invoice invoice;
    public Item() {
    }

    public Item( Product product, BigDecimal price, int quantity, BigDecimal value) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ITEM_ID", unique = true)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Column(name = "VALUE")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
    @ManyToOne()
    @JoinColumn(name = "INVOICE_ID")
    public Invoice getInvoice() {
        return invoice;
    }
    @ManyToOne()
    @JoinColumn(name = "PRODUCT_ID")
  //  @Column(name = "PRODUCT")
    public Product getProduct() {
        return product;
    }
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", product=" + product +
                ", invoice=" + invoice +
                ", price=" + price +
                ", quantity=" + quantity +
                ", value=" + value +
                '}';
    }
}
