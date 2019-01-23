package Hibernate.Manage;

import Hibernate.Entity.Friend;
import Hibernate.Entity.Person;
import Hibernate.Entity.Person_has_Friend;
import Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ManageFriend {


    private Session session = null;

    public ManageFriend() {


        this.session = HibernateUtil.getSessionFactory().getCurrentSession();

    }

    public void AddFriend(String userName_isAdding, String userName_isFriend) {

        Transaction tx = null;
        Integer friendID = null;

        Person person = null;
        Person friend = null;

        boolean isDuplicate = false;


        try {
            tx = session.beginTransaction();


            // Get Persons from usernames

            // query for account that is adding

            Query query = session.createNativeQuery("select Person.id,Person.firstName,Person.lastName,Person.adress," +
                    " Person.Account_id, account.userName from account,Person where Account_id =account.id " +
                    "and account.userName =:sp");
            query.setParameter("sp", userName_isAdding);

            System.out.println("Parameter value: " + query.getParameterValue("sp"));

            List<Object[]> personQueryList = query.getResultList();
            for (Object[] result : personQueryList) {

              //  System.out.println("result[0] " + result[0]);

                person = new Person(Integer.valueOf(result[0].toString()), result[1].toString(), result[2].toString(),
                        result[3].toString(), Integer.valueOf(result[4].toString()), result[5].toString());

            }

            // Query for Friend


            Query query2 = session.createNativeQuery("select Person.id,Person.firstName,Person.lastName,Person.adress," +
                    " Person.Account_id, account.userName from account,Person where Account_id =account.id " +
                    "and account.userName =:sp2");
            query2.setParameter("sp2", userName_isFriend);

            System.out.println("Parameter value: " + query2.getParameterValue("sp2"));

            List<Object[]> personQueryList2 = query2.getResultList();
            for (Object[] result1 : personQueryList2) {


                friend = new Person(Integer.valueOf(result1[0].toString()), result1[1].toString(), result1[2].toString(),
                        result1[3].toString(), Integer.valueOf(result1[4].toString()), result1[5].toString());

            }


            //

            Friend friend1 = new Friend(0);

            //TODO: kolla att friend inte redan finns i db här


            Query query3 = session.createNativeQuery("    select person_id, friend_id from Person_has_Friend " +
                    "where person_id =:p_id and friend_id =:f_id");
            query3.setParameter("p_id", person.getId());
            query3.setParameter("f_id", friend.getId());

            System.out.println("Parameter value p_id: " + query3.getParameterValue("p_id"));
            System.out.println("Parameter value f_id: " + query3.getParameterValue("f_id"));
            List<Object[]> duplicateList = query3.getResultList();
            for (Object[] result2 : personQueryList2) {


                try {
                        System.out.println("Result2[0] " + result2[0].toString());
                        System.out.println("Result2[1] " + result2[1].toString());

                    // Result2 toString() results below are ignored. The below statements works like a duplicate check-
                    //- for the database
                    // TODO: For future implementations , this could be solved in a nicer way
                    result2[0].toString();
                    result2[1].toString();
                    isDuplicate = true;
                } catch (NullPointerException e) {

                    System.out.println("error in DB ADD Friend method ");

                }


            }


            //

            System.out.println("idDuplicate: "+ isDuplicate);

            if (isDuplicate) {
                friendID = (Integer) session.save(friend1);

                Person_has_Friend linkingTable = new Person_has_Friend(person.getId(), friend.getId(), 1);

                session.save(linkingTable);
            }

            tx.commit();


        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    public void RemoveFriend(String userName_isRemoving, String userName_removeFriend) {

        Transaction tx = null;


        Person person = null;
        Person friend = null;


        try {
            tx = session.beginTransaction();


            // Get Persons from account username

            // query for account that is removing the friend

            Query query = session.createNativeQuery("select Person.id,Person.firstName,Person.lastName,Person.adress," +
                    " Person.Account_id, account.userName from account,Person where Account_id =account.id " +
                    "and account.userName =:sp");
            query.setParameter("sp", userName_isRemoving);

            System.out.println("Parameter value(Username of the account who wants to remove a friend) : " + query.getParameterValue("sp"));

            List<Object[]> personQueryList = query.getResultList();
            for (Object[] result : personQueryList) {

                System.out.println("result[0] " + result[0]);

                person = new Person(Integer.valueOf(result[0].toString()), result[1].toString(), result[2].toString(),
                        result[3].toString(), Integer.valueOf(result[4].toString()), result[5].toString());

            }

            // Query for the Friend that the account wants to remove


            Query query2 = session.createNativeQuery("select Person.id,Person.firstName,Person.lastName,Person.adress," +
                    " Person.Account_id, account.userName from account,Person where Account_id =account.id " +
                    "and account.userName =:sp2");
            query2.setParameter("sp2", userName_removeFriend);

            System.out.println("Parameter value(Username of the friend who is to be removed ): " + query2.getParameterValue("sp2"));

            List<Object[]> personQueryList2 = query2.getResultList();
            for (Object[] result1 : personQueryList2) {


                friend = new Person(Integer.valueOf(result1[0].toString()), result1[1].toString(), result1[2].toString(),
                        result1[3].toString(), Integer.valueOf(result1[4].toString()), result1[5].toString());

            }





                System.out.println("Person id: "+ person.getId());
            System.out.println("Friend id: "+ friend.getId());


            Person_has_Friend linkingTable = new Person_has_Friend(person.getId(), friend.getId(), 1);

            //linkingTable = (Person_has_Friend) session.merge(linkingTable);
            //session.remove(linkingTable);

           Query query3 =  session.createSQLQuery("Delete from Person_has_Friend where Person_has_Friend.person_id=:p_id and Person_has_Friend.friend_id=:f_id");

           query3.setParameter("p_id",person.getId());
           query3.setParameter("f_id",friend.getId());

           query3.executeUpdate();
            // session.delete(linkingTable);


            tx.commit();


        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    public ArrayList<Person> getFriendList(String userName) {


        ArrayList<Person> personArrayList = new ArrayList<>();

        session.getSessionFactory().openSession();
        Transaction tx = null;


        // Get Person from logged in user
        // -----------------
        Person userPerson = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createNativeQuery("select Person.id,Person.firstName,Person.lastName,Person.adress," +
                    " Person.Account_id, account.userName from account,Person where Account_id =account.id " +
                    "and account.userName =:sp");
            query.setParameter("sp", userName);

           // System.out.println("Parameter value in query1: " + query.getParameterValue("sp"));

            List<Object[]> personQueryList = query.getResultList();
            for (Object[] result : personQueryList) {

               // System.out.println("result[0] " + result[0]);

                userPerson = new Person(Integer.valueOf(result[0].toString()), result[1].toString(), result[2].toString(),
                        result[3].toString(), Integer.valueOf(result[4].toString()), result[5].toString());


            }


            // Get friends from a person
            // -----------------
            ArrayList<Person_has_Friend> psfList = new ArrayList<Person_has_Friend>();


            Query query2 = session.createNativeQuery("Select  Person_has_Friend.person_id, Person_has_Friend.friend_id," +
                    " Person_has_Friend.isPending from Person_has_Friend where Person_has_Friend.person_id =:sp");
            query2.setParameter("sp", userPerson.getId());

           // System.out.println("Parameter value in query2: " + query2.getParameterValue("sp"));


            List<Object[]> queryList = query2.getResultList();
            for (Object[] result2 : queryList) {

                /*
                System.out.println("result in query 2 for psf list: " + "result[0] : " + result2[0].toString() +
                        "\nresult[1] : " + result2[1].toString() +
                        "\nresult[2] : " + result2[2].toString()); */

                Person_has_Friend psf = new Person_has_Friend(Integer.valueOf(result2[0].toString()),
                        Integer.valueOf(result2[1].toString()),
                        Integer.valueOf(result2[2].toString()));

                psfList.add(psf);

            }

            // -----------------

            // Get an ArrayList of persons from the friend list


            for (Person_has_Friend p : psfList) {


                int searchParameter = p.getFriend_id();


                Query query3 = session.createNativeQuery("select Person.id,Person.firstName,Person.lastName,Person.adress," +
                        " Person.Account_id, account.userName from account,Person where Account_id =account.id " +
                        "and Person.id = :sp");
                query3.setParameter("sp", searchParameter);

               // System.out.println("Parameter value query 3: " + query3.getParameterValue("sp"));

                List<Object[]> personQueryList2 = query3.getResultList();
                for (Object[] result3 : personQueryList2) {

                    Person friend = new Person(result3[1].toString(), result3[2].toString(),
                            result3[3].toString(), Integer.valueOf(result3[4].toString()), result3[5].toString());

                    personArrayList.add(friend);

                   // System.out.println("sout in db method of friend first name: " + friend.getFirstName());

                }


            }

            // -----------------


            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


        return personArrayList;
    }



}
