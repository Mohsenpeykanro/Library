package com.library.backend.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "book")
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String subject;
    private String shelf;
    private String price;

    public book() {
    }

    public book(String name,
                String subject,
                String shelf,
                String price) {
        this.name = name;
        this.subject = subject;
        this.shelf = shelf;
        this.price = price;
    }

}
