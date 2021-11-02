package com.library.backend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class bookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookID", updatable = false, nullable = false)
    private Integer id;
    @Column(name = "bookName")
    private String name;
    @Column(name = "bookSubject")
    private String subject;
    @Column(name = "bookShelf")
    private String shelf;
    @Column(name = "bookPrice")
    private String price;

    public bookEntity() {
    }

    public bookEntity(String name, String subject, String shelf, String price) {
        this.name = name;
        this.subject = subject;
        this.shelf = shelf;
        this.price = price;
    }

    public bookEntity(int id, String name, String subject, String shelf, String price) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.shelf = shelf;
        this.price = price;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "bookEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", shelf='" + shelf + '\'' +
                ", price=" + price +
                '}';
    }
}
