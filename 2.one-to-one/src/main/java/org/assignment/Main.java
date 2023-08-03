package org.assignment;


import org.assignment.entity.Author;
import org.assignment.entity.Book;
import org.assignment.util.FactoryConfiguration;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        //save book & author
        Book book=new Book("B003","Dangara waliga","Kamal");
        Author author=new Author("A001","Dilshan","Matugama");
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction(); //begin transaction

        session.persist(book); //add book data to table
        session.persist(author); //add author data to table
        transaction.commit(); //commit that transaction

        session.close(); //close the session
    }
}
