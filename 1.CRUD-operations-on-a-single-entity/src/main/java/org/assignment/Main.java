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

         //   saveBook();
        //  loadAllBooks();
       // loadAllBooksWithCriteria();
      //  findBook();
      //  findBookWithQuery();
        updateBook();
        //deleteBook();

    }

    // session.update(book);//update data from table
    //session.remove(book); //remove data from table

    private static void findBookWithQuery() {
        Session session= FactoryConfiguration.getInstance().getSession();

        Query query = session.createQuery("FROM Book where id=:data");
        query.setParameter("data","B001");
        Book book = (Book) query.uniqueResult();
        System.out.println(book);
    }

    //need session for every new method call

    private static void findBook() {
        Session session= FactoryConfiguration.getInstance().getSession();

        Book book = session.load(Book.class, "B001");
        System.out.println(book);

    }

    private static void updateBook() {
        Book book=new Book("B001","Hath","M Wickramasinghe");

        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction(); //begin transaction
        session.update(book);
        transaction.commit(); //commit that transaction

        session.close(); //close the session
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


    private static void loadAllBooks() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("FROM Book ");//HQL --> Hibernate Query Language
        List<Book> bookList= query.list();
        for (Book book:bookList) {
            System.out.println(book);
        }

    }

    private static void saveBook() {

        Book book=new Book("B002","Hath Pana","M Wickramasinghe");

        //start session
        Session session= FactoryConfiguration.getInstance().getSession(); //Session is Interface (Therefore can't initialize with new keyword)

        Transaction transaction=session.beginTransaction(); //begin transaction
        session.persist(book); //add data to table

        transaction.commit(); //commit that transaction

        session.close(); //close the session

    }

}

