package org.assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(String id,String name,String address){
        this.id=id;
        this.name=name;
        this.address=address;
    }


}
