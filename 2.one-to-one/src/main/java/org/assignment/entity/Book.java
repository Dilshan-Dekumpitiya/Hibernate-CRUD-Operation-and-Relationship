package org.assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
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
    @Column(name = "bookId",unique = true,nullable = false)
    private int id;

    @Column(nullable = false)
    private String bookName;

    private double price;

    @OneToOne
    private Author author; //pass AuthorId to Book entity table

    public Book(String bookName,double price, Author author) {
        this.bookName=bookName;
        this.price=price;
        this.author=author;
    }
}
