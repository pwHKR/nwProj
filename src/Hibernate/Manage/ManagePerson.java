package Hibernate.Manage;

import Hibernate.HibernateUtil;
import org.hibernate.Session;

public class ManagePerson {

    private Session session = null;

    public ManagePerson(){

        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
