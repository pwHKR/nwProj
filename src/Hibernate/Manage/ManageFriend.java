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

    public ManageFriend(){


        this.session = HibernateUtil.getSessionFactory().getCurrentSession();

    }

    public void AddFriend(Person person, Person friend){
        //Session session = factory.openSession();
        Transaction tx = null;
        Integer friendID = null;

        try {
            tx = session.beginTransaction();


            Friend friend1 = new Friend(0);

            //TODO: kolla att friend inte redan finns i db här

            friendID = (Integer)session.save(friend1);

            Person_has_Friend linkingTable = new Person_has_Friend(person.getId(),friend.getId(),1);

            session.save(linkingTable);



            tx.commit();



        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }



    public ArrayList<Person_has_Friend> getFriendList(Person person){

        System.out.println("person id in MF " + person.getId());


        ArrayList<Person_has_Friend> friendArrayList = new ArrayList<>();




        session.getSessionFactory().openSession();
        Transaction tx = null;





        try {
            tx = session.beginTransaction();
            Query query = session.createNativeQuery("Select  Person_has_Friend.person_id, Person_has_Friend.friend_id," +
                    " Person_has_Friend.isPending from Person_has_Friend where Person_has_Friend.person_id =:sp");
            query.setParameter("sp",person.getId());

            System.out.println("Parameter value in psf: "+query.getParameterValue("sp"));











            List<Object[]> queryList = query.getResultList();
            for(Object[] result: queryList){

                System.out.println("result in mp for psf: " + "result[0] : "+ result[0].toString()+
                        "\nresult[1] : "+ result[1].toString()+
                        "\nresult[2] : "+ result[2].toString());

                Person_has_Friend psf  = new Person_has_Friend(Integer.valueOf(result[0].toString()),
                        Integer.valueOf(result[1].toString()),
                        Integer.valueOf(result[2].toString()));

                friendArrayList.add(psf);


            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return friendArrayList;
    }




}
