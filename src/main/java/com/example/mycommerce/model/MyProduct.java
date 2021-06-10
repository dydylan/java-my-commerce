package com.example.mycommerce.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class MyProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private float price;

    public MyProduct() {
    }

    public MyProduct(Long id, String name, String content, float price) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public MyProduct(String name, float price) {
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}