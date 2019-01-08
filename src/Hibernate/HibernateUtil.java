package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


// Class was original found at : https://stackoverflow.com/questions/27608228/hibernate-java-lang-exceptionininitializererror

// The comments in below are made by author andre_000

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author andre_000
 */


public class HibernateUtil {

    private static final  SessionFactory sessionFactory;

   static  {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            // config file.
            //sessionFactory = new Configuration().configure().buildSessionFactory();



              sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
