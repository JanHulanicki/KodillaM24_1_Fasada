package com.kodilla.hibernate.invoice;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Entity
@Table(name = "ITEMS")
public class Item {
    private int id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
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
    private int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }
    private void setProduct(Product product) {
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
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "INVOICE_ID")
    public Invoice getInvoice() {
        return invoice;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID")
    public Product getProduct() {
        return product;
    }
    private void setInvoice(Invoice invoice) {
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
