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

    //Used this to --> No need to Add column to created Associate table
    @ManyToMany(mappedBy = "books") //using mappedBy create associate table
    private List<Author> authors;

    //Used this to --> Need to Add columns to created Associate table
    /*@OneToMany(mappedBy = "book",
            cascade ={
                CascadeType.ALL
            }
    )
    private List<BookDetail> details; */

    public Book(String bookName, double price,List<Author> authors) {
        this.bookName=bookName;
        this.price=price;
        this.authors=authors;
    }
}
