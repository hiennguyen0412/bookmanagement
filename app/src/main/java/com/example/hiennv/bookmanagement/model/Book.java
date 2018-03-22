package com.example.hiennv.bookmanagement.model;

/**
 * Created by hiennv on 22/03/2018.
 */

public class Book {
    private int id;
    private String name;
    private String author;
    private Category category;
    private int quantity;
    private double price;
    private String description;

    public Book() {
    }

    public Book(String name, String author, Category category, int quantity, double price, String description) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public Book(int id, String name, String author, Category category, int quantity, double price, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
