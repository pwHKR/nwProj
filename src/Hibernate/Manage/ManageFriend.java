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

    //private static SessionFactory factory;
    private Session session = null;

    public ManageFriend() {


        this.session = HibernateUtil.getSessionFactory().getCurrentSession();

    }

    public void AddFriend(Person person, Person friend) {
        //Session session = factory.openSession();
        Transaction tx = null;
        Integer friendID = null;

        try {
            tx = session.beginTransaction();


            Friend friend1 = new Friend(0);

            //TODO: kolla att friend inte redan finns i db här

            friendID = (Integer) session.save(friend1);

            Person_has_Friend linkingTable = new Person_has_Friend(person.getId(), friend.getId(), 1);

            session.save(linkingTable);


            tx.commit();


        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    public ArrayList<Person> tempGetFriendList(String userName) {


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

            System.out.println("Parameter value in query1: " + query.getParameterValue("sp"));

            List<Object[]> personQueryList = query.getResultList();
            for (Object[] result : personQueryList) {

                System.out.println("result[0] " + result[0]);

                userPerson = new Person(Integer.valueOf(result[0].toString()), result[1].toString(), result[2].toString(),
                        result[3].toString(), Integer.valueOf(result[4].toString()), result[5].toString());


            }


            // Get friends from a person
            // -----------------
            ArrayList<Person_has_Friend> psfList = new ArrayList<Person_has_Friend>();


            Query query2 = session.createNativeQuery("Select  Person_has_Friend.person_id, Person_has_Friend.friend_id," +
                    " Person_has_Friend.isPending from Person_has_Friend where Person_has_Friend.person_id =:sp");
            query2.setParameter("sp", userPerson.getId());

            System.out.println("Parameter value in query2: " + query2.getParameterValue("sp"));


            List<Object[]> queryList = query2.getResultList();
            for (Object[] result2 : queryList) {

                System.out.println("result in query 2 for psf list: " + "result[0] : " + result2[0].toString() +
                        "\nresult[1] : " + result2[1].toString() +
                        "\nresult[2] : " + result2[2].toString());

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

                    System.out.println("Parameter value query 3: " + query3.getParameterValue("sp"));

                    List<Object[]> personQueryList2 = query3.getResultList();
                    for (Object[] result3 : personQueryList2) {

                        Person friend = new Person(result3[1].toString(), result3[2].toString(),
                                result3[3].toString(), Integer.valueOf(result3[4].toString()), result3[5].toString());

                        personArrayList.add(friend);

                        System.out.println("sout in db method of friend first name: "+friend.getFirstName());

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


    public ArrayList<Person_has_Friend> getFriendList(Person person) {

        System.out.println("person id in MF " + person.getId());


        ArrayList<Person_has_Friend> friendArrayList = new ArrayList<>();


        session.getSessionFactory().openSession();
        Transaction tx = null;


        try {
            tx = session.beginTransaction();
            Query query = session.createNativeQuery("Select  Person_has_Friend.person_id, Person_has_Friend.friend_id," +
                    " Person_has_Friend.isPending from Person_has_Friend where Person_has_Friend.person_id =:sp");
            query.setParameter("sp", person.getId());

            System.out.println("Parameter value in psf: " + query.getParameterValue("sp"));


            List<Object[]> queryList = query.getResultList();
            for (Object[] result : queryList) {

                System.out.println("result in mp for psf: " + "result[0] : " + result[0].toString() +
                        "\nresult[1] : " + result[1].toString() +
                        "\nresult[2] : " + result[2].toString());

                Person_has_Friend psf = new Person_has_Friend(Integer.valueOf(result[0].toString()),
                        Integer.valueOf(result[1].toString()),
                        Integer.valueOf(result[2].toString()));

                friendArrayList.add(psf);


            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return friendArrayList;
    }


}
