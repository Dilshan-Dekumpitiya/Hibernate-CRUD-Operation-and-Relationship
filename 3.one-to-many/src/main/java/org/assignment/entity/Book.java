package org.assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue( //id auto increment
            strategy = GenerationType.IDENTITY
    )
    @Column(unique = true,nullable = false)
    private int bookId;

    @Column(nullable = false)
    private String bookName;

    private double price;

    @ManyToOne
    private Author author;

    public Book(String bookName, double price, Author author) {
        this.bookName=bookName;
        this.price=price;
        this.author=author;
    }
}
