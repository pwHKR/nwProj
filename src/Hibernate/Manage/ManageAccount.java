package Hibernate.Manage;

import Hibernate.Entity.Account;
import Hibernate.Entity.Group;
import Hibernate.Entity.Person;
import Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class ManageAccount {



    //private static SessionFactory factory;
   private Session session = null;

public ManageAccount(){


    this.session = HibernateUtil.getSessionFactory().getCurrentSession();

}





    public static void test() {

    /*
    try {
            factory = new AnnotationConfiguration().configure().addAnnotatedClass(Account.class).buildSessionFactory();
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


    //Method to CREATE an Account in the database */
    public void AddAccount(Account account, Person person, Group group){
        //Session session = factory.openSession();



        Transaction tx = null;
        Integer accountId = null;

        try {
            tx = session.beginTransaction();



            accountId =(Integer)session.save(account);

            person.setAccount_id(accountId);
            session.save(person);
            session.save(group);



          //

            tx.commit();






        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    // Add access group to newly created account
    public void AddGroup(Group group){
        //Session session = factory.openSession();
        Transaction tx = null;
        Integer accountId = null;

        try {
            tx = session.beginTransaction();





             session.save(group);

            tx.commit();



        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }




    /* Method to  READ all the accpi nt */


    public void listAccounts( ){
       session.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List accounts = session.createQuery("FROM Account ").list();
            for (Iterator iterator = accounts.iterator(); iterator.hasNext();){
                Account account = (Account) iterator.next();
                System.out.print("userName: " + account.getUsername());
                System.out.print("\npassword: " + account.getPassword());
                System.out.println("\nemail: " + account.getEmail()+"\n---------");
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
            List accounts = session.createQuery("FROM Account WHERE username ='"+userName+"'" +
                    "and password ='"+password+"'").list();



            for (Iterator iterator = accounts.iterator(); iterator.hasNext();){
                Account account = (Account) iterator.next();

                if(userName.equals(account.getUsername()) &&
                        password.equals(account.getPassword()));
                {



                   isValid = true;




                }
                System.out.print("userName: " + account.getUsername());
                System.out.print("\npassword: " + account.getPassword());
                System.out.println("\nemail: " + account.getEmail()+"\n---------");
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

