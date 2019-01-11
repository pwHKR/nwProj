package Hibernate.Manage;

import Hibernate.Entity.Person;
import Hibernate.Entity.Person_has_Friend;
import Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManagePerson {

    private Session session = null;

    public ManagePerson(){

        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }


    public ArrayList<Person> listPersons(){
        session.getSessionFactory().openSession();
        Transaction tx = null;

        ArrayList<Person> personList = new ArrayList();

        try {
            tx = session.beginTransaction();
            List persons = session.createQuery("FROM Person ").list();
            for (Iterator iterator = persons.iterator(); iterator.hasNext();){
                Person person = (Person) iterator.next();
                System.out.print("first name: " + person.getFirstName());
                System.out.print("\nlast name: : " + person.getLastName());
                System.out.println("\nAccount_id: " +
                        String.valueOf(person.getAccount_id()+"\n---------"));

                personList.add(person);


            }
            tx.commit();

        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {

            session.close();
        }
        return personList;
    }


    public ArrayList<Person> searchBy_userName(String username){


        ArrayList<Person> personArrayList = new ArrayList<>();

        String searchParameter ="%"+ username +"%";

        session.getSessionFactory().openSession();
        Transaction tx = null;




        try {
            tx = session.beginTransaction();
            Query query = session.createNativeQuery("select Person.id,Person.firstName,Person.lastName,Person.adress," +
                    " Person.Account_id, Account.userName from Account,Person where Account_id =Account.id and Account.userName" +
                    " LIKE :sp");
            query.setParameter("sp",searchParameter);

            System.out.println("Parameter value: "+query.getParameterValue("sp"));

            List<Object[]> personQueryList = query.getResultList();
           for(Object[] result: personQueryList){

               Person person = new Person(result[1].toString(),result[2].toString(),
                       result[3].toString(),Integer.valueOf(result[4].toString()),result[5].toString());

               personArrayList.add(person);

               System.out.println(person.getFirstName());

           }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return personArrayList;
    }



    public Person getPerson(String userName){

        System.out.println("username in mp " + userName);


        ArrayList<Person> personArrayList = new ArrayList<>();



        session.getSessionFactory().openSession();
        Transaction tx = null;




        try {
            tx = session.beginTransaction();
            Query query = session.createNativeQuery("select Person.id,Person.firstName,Person.lastName,Person.adress," +
                    " Person.Account_id, Account.userName from Account,Person where Account_id =Account.id " +
                    "and Account.userName =:sp");
            query.setParameter("sp",userName);

            System.out.println("Parameter value: "+query.getParameterValue("sp"));

            List<Object[]> personQueryList = query.getResultList();
            for(Object[] result: personQueryList){

                System.out.println("result[0] " + result[0]);

                Person person = new Person(Integer.valueOf(result[0].toString()),result[1].toString(),result[2].toString(),
                        result[3].toString(),Integer.valueOf(result[4].toString()),result[5].toString());

                personArrayList.add(person);


            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println(personArrayList.toString());
        return personArrayList.get(0);
    }


    public Person getPerson_ID(int id){


        ArrayList<Person> personArrayList = new ArrayList<>();

        int searchParameter =id;

        session.getSessionFactory().openSession();
        Transaction tx = null;




        try {
            tx = session.beginTransaction();
            Query query = session.createNativeQuery("select Person.id,Person.firstName,Person.lastName,Person.adress," +
                    " Person.Account_id, Account.userName from Account,Person where Account_id =Account.id " +
                    "and Person.id = :sp");
            query.setParameter("sp",searchParameter);

            System.out.println("Parameter value: "+query.getParameterValue("sp"));

            List<Object[]> personQueryList = query.getResultList();
            for(Object[] result: personQueryList){

                Person person = new Person(result[1].toString(),result[2].toString(),
                        result[3].toString(),Integer.valueOf(result[4].toString()),result[5].toString());

                personArrayList.add(person);

                System.out.println(person.getFirstName());

            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return personArrayList.get(0);
    }



   public ArrayList<Person>getPerson(ArrayList<Person_has_Friend> psf){


        ArrayList<Person> personArrayList = new ArrayList<>();


        for (Person_has_Friend p: psf){


            Person friend = getPerson_ID(p.getFriend_id());

            personArrayList.add(friend);

        }







        return personArrayList;
    }













    //
}
