package org.assignment;

import org.assignment.entity.Author;
import org.assignment.entity.Book;
import org.assignment.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("A01", "Mr. Perera", "Panadura");
        Author author2 = new Author("A02", "Mr.Kamal", "Matugama");

        Book book1 = new Book("Book 1", 1000.0, author1);
        Book book2 = new Book("Book 2", 1250.00, author1);
        Book book3 = new Book("Book 3", 500.00, author2);
        Book book4 = new Book("Book 4", 2500.00, author2);

        //add author1's books to list
        List<Book> books1 = new ArrayList<>();
        books1.add(book1);
        books1.add(book2);

        //add author2's books to list
        List<Book> books2 = new ArrayList<>();
        books2.add(book3);
        books2.add(book4);

        author1.setBooks(books1);
        author2.setBooks(books2);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(author1);
        session.persist(author2);

        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        session.persist(book4);

        transaction.commit();

        session.close();

    }
}
