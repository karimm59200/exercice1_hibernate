package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;

    private String marque;

    private String reference;

    private  LocalDate date;

    private Double price;

    private int stock;

    public Produit() {
    }

    public Produit(String marque, String reference,  Double price, int stock) {
        this.marque = marque;
        this.reference = reference;
        this.price = price;
        this.stock = stock;
    }

    public Produit(int id, String marque, String reference, LocalDate localDate, Double price, int stock) {
        this.id = id;
        this.marque = marque;
        this.reference = reference;
        this.date = localDate;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", reference='" + reference + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
