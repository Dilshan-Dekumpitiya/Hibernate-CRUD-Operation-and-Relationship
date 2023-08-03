package org.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "bookId",unique = true,nullable = false)
    private String id;
    @Column(nullable = false)
    private String bookName;
    private String authorName;
}
