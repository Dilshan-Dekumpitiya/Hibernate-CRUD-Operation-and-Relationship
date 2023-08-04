package assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class BookDetail {
    @Id
    @GeneratedValue( //id auto increment
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @ManyToOne
    @JoinColumn(
            name = "bookId", //primary key
            updatable = false,
            insertable = false,
            nullable = false,
            foreignKey = @ForeignKey( //reference foreign key
                    name = "fk_bookId"
            )
    )
    private Book book;

    @ManyToOne
    @JoinColumn(
            name = "authorId", //primary key
            updatable = false,
            insertable = false,
            nullable = false,
            foreignKey = @ForeignKey( //reference foreign key
                    name = "fk_authorId"
            )
    )
    private Author author;
    private double price;
}
*/

