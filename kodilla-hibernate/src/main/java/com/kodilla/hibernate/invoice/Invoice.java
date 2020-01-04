package com.kodilla.hibernate.invoice;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "INVOICES")
public class Invoice {
    private int id;
    private String number;
    private List<Item> items=new ArrayList<>();

    public Invoice() {
    }

    public Invoice(String number, List<Item> items) {
        this.number = number;
        this.items = items;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "INVOICE_ID", unique = true)
    public int getId() {
        return id;
    }
    @Column(name = "NUMBER")
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }
    private void setItems(List<Item> items) {
        this.items = items;
    }
    private void addItems(Item item){
        items.add(item);
    }
    private void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", items=" + items +
                '}';
    }
}
