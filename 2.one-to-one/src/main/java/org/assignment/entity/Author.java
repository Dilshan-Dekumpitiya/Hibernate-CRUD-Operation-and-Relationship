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

    @OneToOne(mappedBy = "author") //mapped to author in Book class, after that create column in Book class as authorId
    private Book book;

}
