package Hibernate.Manage;

import Hibernate.Entity.Friend;
import Hibernate.Entity.News;
import Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ManageNews {


    private Session session = null;

    public ManageNews() {


        this.session = HibernateUtil.getSessionFactory().getCurrentSession();

    }

    public void post(String post) {

        News news = new News(post);



        Transaction tx = null;



        try {
            tx = session.beginTransaction();


            Friend friend1 = new Friend(0);

            //TODO: kolla att friend inte redan finns i db här


            session.save(news);


            tx.commit();


        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }


    public String getRecentNews() {



        session.getSessionFactory().openSession();
        Transaction tx = null;

        String maxPost= "";

        try {
            tx = session.beginTransaction();
            Query query = session.createNativeQuery("SELECT max(post) from news");



               maxPost  = query.getSingleResult().toString();
              //  System.out.println(maxPost);


            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return maxPost;
    }


}
