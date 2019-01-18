package Hibernate.Manage;

import Hibernate.Entity.Account;
import Hibernate.Entity.Group;
import Hibernate.Entity.Person;
import Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManageAccount {


    private Session session = null;

    public ManageAccount() {


        this.session = HibernateUtil.getSessionFactory().getCurrentSession();

    }


    //Method to CREATE an Account in the database */
    public void AddAccount(Account account, Person person, Group group) {


        Transaction tx = null;
        Integer accountId = null;

        try {
            tx = session.beginTransaction();


            accountId = (Integer) session.save(account);

            person.setAccount_id(accountId);
            session.save(person);
            session.save(group);


            //

            tx.commit();


        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    // Add access group to newly created account
    public void AddGroup(Group group) {
        //Session session = factory.openSession();
        Transaction tx = null;
        Integer accountId = null;

        try {
            tx = session.beginTransaction();


            session.save(group);

            tx.commit();


        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    // Return ArrayList of user accounts (non admin)
    public ArrayList<Account> listUserAccount() {

        ArrayList<Account> userAccounts = new ArrayList<>();


        session.getSessionFactory().openSession();
        Transaction tx = null;


        try {
            tx = session.beginTransaction();
            Query query = session.createNativeQuery("select username , id, isBan from account where isAdmin = 0;");


            List<Object[]> queryList = query.getResultList();
            for (Object[] result : queryList) {


                int tinyInt;


                System.out.println("result[2] to string "+result[2].toString());
                System.out.println("result[2] to boolean "+Boolean.getBoolean(result[2].toString()));
                if (result[2].toString().equalsIgnoreCase("true")) {


                    tinyInt = 1;

                } else {
                    tinyInt = 0;
                }


                // 3 parameter constructor with userName , id and isBan
                Account account = new Account(result[0].toString(),
                        Integer.valueOf(result[1].toString()),
                        tinyInt);


                userAccounts.add(account);


            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


        return userAccounts;


    }




    /* Method to  READ all the Accounts */


    public void listAccounts() {
        session.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List accounts = session.createQuery("FROM Account ").list();
            for (Iterator iterator = accounts.iterator(); iterator.hasNext(); ) {
                Account account = (Account) iterator.next();
                System.out.print("userName: " + account.getUsername());
                System.out.print("\npassword: " + account.getPassword());
                System.out.println("\nemail: " + account.getEmail() + "\n---------");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public boolean validatePassword(String userName, String password) {
        //Session session = factory.openSession();
        Transaction tx = null;

        boolean isValid = false;


        try {
            tx = session.beginTransaction();
            List accounts = session.createQuery("FROM Account WHERE username ='" + userName + "'" +
                    "and password ='" + password + "'").list();


            for (Iterator iterator = accounts.iterator(); iterator.hasNext(); ) {
                Account account = (Account) iterator.next();

                if (userName.equals(account.getUsername()) &&
                        password.equals(account.getPassword())) ;
                {


                    isValid = true;


                }
                System.out.print("userName: " + account.getUsername());
                System.out.print("\npassword: " + account.getPassword());
                System.out.println("\nemail: " + account.getEmail() + "\n---------");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return isValid;

    }

    /* Method to UPDATE ban status for an account */


    public void setBan(Integer id, boolean isBan) {

        int tinyInt;

        if (isBan) {

            tinyInt = 1;

        } else {
            tinyInt = 0;
        }


        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Account account = (Account) session.get(Account.class, id);
            account.setIsBan(tinyInt);
            session.update(account);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // check if a user is banned

    public boolean isBanned(String userName){



        boolean  output = false;


        Object o = null;







            session.getSessionFactory().openSession();
            Transaction tx = null;




            try {
                tx = session.beginTransaction();
                Query query = session.createNativeQuery("select isBan from account where username =:sp");
                query.setParameter("sp",userName);

                System.out.println("Parameter value: "+query.getParameterValue("sp"));


              o = query.getSingleResult();

                System.out.println(o.toString());



                tx.commit();
            } catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }




            if(o.toString().equalsIgnoreCase("true")){

                output = true;
            }



        return output;
        }





    /* Method to DELETE an employee from the records */
    /*
    public void deleteEmployee(Integer EmployeeID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        */


}

