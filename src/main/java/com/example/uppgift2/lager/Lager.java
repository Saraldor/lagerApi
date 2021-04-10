package com.example.uppgift2.lager;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Lager {
    @Id
            @SequenceGenerator(name = "Product_sequence",sequenceName = "product_sequence",allocationSize = 1)
            @GeneratedValue(
                    strategy = GenerationType.SEQUENCE, generator = "product_sequence"
            )
     Long id;
     String name;
     String product_id;
     String category;
     Integer cost;

    public Lager() {
    }

    public Lager(Long id, String name, String product_id,  String category, Integer cost) {
        this.id = id;
        this.name = name;
        this.product_id = product_id;
        this.category = category;
        this.cost = cost;
    }

    public Lager(String name, String product_id, String category, Integer cost) {
        this.name = name;
        this.product_id = product_id;
        this.category = category;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override

    public String toString() {
        return "Lager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product_id='" + product_id + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                '}';
    }
}

