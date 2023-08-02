package org.assignment;

import org.assignment.entity.Book;
import org.assignment.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Book book=new Book("B001","Madol Duuwa","Martin Wickramasinghe");

        //start session
        Session session= FactoryConfiguration.getInstance().getSession(); //Session is Interface (Therefore can't initialize with new keyword)

        Transaction transaction=session.beginTransaction(); //begin transaction
        session.persist(book); //add data to table
        //session.remove(customer); //remove data from table
        // session.update(customer);//update data from table

        transaction.commit(); //commit that transaction

        session.close(); //close the session
    }

}

