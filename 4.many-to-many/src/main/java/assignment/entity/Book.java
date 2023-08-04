package assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @ManyToMany(mappedBy = "books") //using mappedBy create associate table
    private List<Author> authors;

    public Book(String bookName, double price,List<Author> authors) {
        this.bookName=bookName;
        this.price=price;
        this.authors=authors;
    }
}
