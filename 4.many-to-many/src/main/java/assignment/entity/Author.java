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
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "authorId",unique = true,nullable = false)
    private String id;

    @Column(name = "author_name",nullable = false)
    private String name;

    @Column(name = "author_address")
    private String address;

    //Used this to --> No need to Add column to created Associate table
    @ManyToMany
    private List<Book> books;

    //Used this to --> Need to Add columns to created Associate table
    /*@OneToMany(mappedBy = "author",
            cascade ={
                    CascadeType.ALL
            }
    )
    private List<BookDetail> details;*/

    public Author(String id,String name,String address){
        this.id=id;
        this.name=name;
        this.address=address;
    }


}
