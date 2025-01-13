package com.iban.library.book_management_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title can't be Blank")
    private String title;

    @NotBlank(message = "Author can't be Blank")
    private String author;

    @Min(value = 1, message = "Price must be greater than 0")
    private Double price;

    public Book() {
    }

    public Book(Integer id, String title, String author, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(String s, String johnDoe, double v) {
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
