package org.assignment.util;

import org.assignment.entity.Author;
import org.assignment.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    //Used singleton design pattern
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private  FactoryConfiguration(){
        //configuration part
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class); //add entities as addAnnotatedClass

        //addAnnotatedClass(Customer.class) --> Define entity as db table to hibernate (@Entity in entity package)
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){ //get factory configuration instance
        return (factoryConfiguration==null)?
                factoryConfiguration=new FactoryConfiguration(): factoryConfiguration;
    }

    public Session getSession(){ //get one session

        return sessionFactory.openSession();
    }
}
