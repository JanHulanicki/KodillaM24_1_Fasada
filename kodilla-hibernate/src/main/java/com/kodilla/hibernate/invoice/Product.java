package com.kodilla.hibernate.invoice;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "PRODUCTS")
public class Product {
    private int id;
    private String name;
    private List< Item> itemList=new ArrayList<>();
    public Product() {
    }
    public Product(String name) {
           this.name = name;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID", unique = true)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }
    @NotNull
    @Column(name = "PRODUCT_NAME")
    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "product",
            cascade  =CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItemList() {
        return itemList;
    }
    private void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}

