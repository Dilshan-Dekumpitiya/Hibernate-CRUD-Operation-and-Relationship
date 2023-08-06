package org.assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "authorId",unique = true,nullable = false)
    private String id;

    @Column(name = "author_name",nullable = false)
    private String name;

    @Column(name = "author_address")
    private String address;

    //FetchType --> Load all data (Book and author)
    @OneToOne(mappedBy = "author",fetch = FetchType.EAGER) //mapped to author in Book class, after that create column in Book class as authorId
    private Book book;

}
