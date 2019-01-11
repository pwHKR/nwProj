package Web.MVC.Controller.Bean;

import Hibernate.Entity.Person;
import Hibernate.Entity.Person_has_Friend;
import Hibernate.Manage.ManageFriend;
import Hibernate.Manage.ManagePerson;

import javax.ejb.Stateful;
import java.util.ArrayList;

@Stateful(name = "FriendEJB")
public class FriendBean {
    public FriendBean() {
    }

    public void AddFriend(){

        ArrayList<Person> list;

        ManagePerson ma = new ManagePerson();

        list = ma.listPersons();


        ManageFriend manageFriend = new ManageFriend();

        manageFriend.AddFriend(list.get(0),list.get(1));

    }


    public ArrayList<Person> getFriends(String userName){

        ArrayList<Person> personArrayList = new ArrayList<>();


        // Get Person from logged in user

        ManagePerson mp = new ManagePerson();

        Person person;

        person = mp.getPerson(userName);


            // Get friends from a person
                ArrayList<Person_has_Friend>  psf;

                ManageFriend mf = new ManageFriend();

                 psf = mf.getFriendList(person);




                 for (Person_has_Friend p: psf){


                     Person friend = mp.getPerson_ID(p.getFriend_id());

                     personArrayList.add(friend);

                 }













        return personArrayList;
    }

    public ArrayList<Person_has_Friend>getFriendList(Person person){

        // Get friends from a person
        ArrayList<Person_has_Friend>  psf;

        ManageFriend mf = new ManageFriend();

        psf = mf.getFriendList(person);

        return  psf;


    }


}
