package org.assignment;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.assignment.entity.Book;
import org.assignment.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

            saveBook();
         //  loadAllBooks();
        // loadAllBooksWithCriteria();
        //  findBook();
        //  findBookWithQuery();
        // updateBook();
        //    deleteBook();
    }

    //need session for every new method call
    private static void saveBook() {
        Book book=new Book("B001","Hath Pana",2500);

        /* Need to use try with resource --> firstly try session,
        Another time can't run the Session, after that close the session object */

        //start session --> Session is Interface (Therefore can't initialize with new keyword)
        try(Session session= FactoryConfiguration.getInstance().getSession();) {

            Transaction transaction = session.beginTransaction(); //begin transaction
            session.persist(book); //add data to table

            transaction.commit(); //commit that transaction

            session.close(); //close the session

        }

    }

    private static void loadAllBooks() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("FROM Book ");//HQL --> Hibernate Query Language
        List<Book> bookList= query.list();
        for (Book book:bookList) {
            System.out.println(book);
            //table -->add code here
        }
    }

    //without HQL to load all books (Using CriteriaBuilder)
    private static void loadAllBooksWithCriteria() {
        Session session= FactoryConfiguration.getInstance().getSession();

        //create the criteria
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
        query.from(Book.class);
        List<Book> resultList = session.createQuery(query).getResultList();
        for (Book book:
                resultList) {
            System.out.println(book);
        }
    }

    private static void findBook() {
        Session session= FactoryConfiguration.getInstance().getSession();

         //  Book book = session.load(Book.class, "B001");

        //-----------another way------------
        String id="B001";
        Book book1=session.get(Book.class,id);
        System.out.println(book1);

    }

    private static void findBookWithQuery() {
        Session session= FactoryConfiguration.getInstance().getSession();

        Query query = session.createQuery("FROM Book where id=:data");
        query.setParameter("data","B001");
        Book book = (Book) query.uniqueResult();
        System.out.println(book);
    }

    private static void updateBook() {
        Book book=new Book("B001","Hath",2500);

        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.update(book);
        transaction.commit();
        session.close();
    }

    private static void deleteBook() {
        Book book=new Book("B002","Hath Pana",2500);

        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction(); //begin transaction
        session.remove(book);
        transaction.commit(); //commit that transaction

        session.close(); //close the session
    }

}

