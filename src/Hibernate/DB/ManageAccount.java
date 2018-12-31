package Hibernate.DB;

import Hibernate.Entity.AccountData;
import Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class ManageAccount {



    //private static SessionFactory factory;
    Session session = null;

public ManageAccount(){


    this.session = HibernateUtil.getSessionFactory().getCurrentSession();

}





    public static void test() {

    /*
    try {
            factory = new AnnotationConfiguration().configure().addAnnotatedClass(AccountData.class).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);

        }

     */








        /* Add few account records in database */

       // ME.AddAccount("peter","hej","peter@mailKing.com");
        //ME.AddAccount("adam","hej","se@ada.com");





        /* List down all the employees */
      ;

       // ME.testLogin();

        /* Update employee's records */
        //ME.updateEmployee(empID1, 5000);

        /* Delete an employee from the database */
       // ME.deleteEmployee(empID2);

        /* List down new list of the employees */
      //  ME.listAccounts();
 }


    //Method to CREATE an employee in the database */
    public void AddAccount(String userName, String password, String email){
        //Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            AccountData accountData = new AccountData(userName, password, email);
            session.save(accountData);

            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    /* Method to  READ all the employees */


    public void listAccounts( ){
       session.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List accounts = session.createQuery("FROM AccountData ").list();
            for (Iterator iterator = accounts.iterator(); iterator.hasNext();){
                AccountData accountData = (AccountData) iterator.next();
                System.out.print("userName: " + accountData.getUserName());
                System.out.print("\npassword: " + accountData.getPassword());
                System.out.println("\nemail: " + accountData.getEmail()+"\n---------");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public boolean validatePassword(String userName,String password){
        //Session session = factory.openSession();
        Transaction tx = null;

        boolean isValid = false;


        try {
            tx = session.beginTransaction();
            List accounts = session.createQuery("FROM AccountData WHERE userName ='"+userName+"'" +
                    "and password ='"+password+"'").list();



            for (Iterator iterator = accounts.iterator(); iterator.hasNext();){
                AccountData accountData = (AccountData) iterator.next();

                if(userName.equals(accountData.getUserName()) &&
                        password.equals(accountData.getPassword()));
                {



                   isValid = true;



                }
                System.out.print("userName: " + accountData.getUserName());
                System.out.print("\npassword: " + accountData.getPassword());
                System.out.println("\nemail: " + accountData.getEmail()+"\n---------");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return isValid;

    }

    /* Method to UPDATE salary for an employee */

    /*
    public void updateEmployee(Integer EmployeeID, int salary ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            employee.setSalary( salary );
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    } */

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


    private void testLogin(){

        ManageAccount manageAccount = new ManageAccount();

        boolean reslut;

        reslut = manageAccount.validatePassword("peter","hej");

        System.out.println(reslut);
    }
    }

