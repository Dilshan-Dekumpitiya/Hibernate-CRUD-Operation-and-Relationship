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
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "authorId",unique = true,nullable = false)
    private String id;
    @Column(name = "author_name",nullable = false)
    private String name;
    @Column(name = "author_address")
    private String address;
}
