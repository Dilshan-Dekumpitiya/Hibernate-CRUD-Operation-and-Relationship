package org.assignment;


import org.assignment.entity.Author;
import org.assignment.entity.Book;
import org.assignment.util.FactoryConfiguration;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        //use try with resource
        try(Session session= FactoryConfiguration.getInstance().getSession();){
            //save book & author
            Author author=new Author();
            author.setId("A001");
            author.setName("Dilshan");
            author.setAddress("Matugama");

            Book book=new Book("Dangara waliga",2500,author);

            Transaction transaction=session.beginTransaction(); //begin transaction

            session.persist(book); //add book data to table
            session.persist(author); //add author data to table

            transaction.commit(); //commit that transaction

        }
    }
}
