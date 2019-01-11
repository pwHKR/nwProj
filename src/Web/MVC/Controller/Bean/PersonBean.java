package Web.MVC.Controller.Bean;

import Hibernate.Entity.Person;
import Hibernate.Entity.Person_has_Friend;
import Hibernate.Manage.ManagePerson;

import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless(name = "PersonEJB")
public class PersonBean {
    public PersonBean() {
    }

    public Person getPerson(String userName){

        // Get Person from logged in user

        ManagePerson mp = new ManagePerson();

        Person person;

        person = mp.getPerson(userName);

        return person;

    }


    public ArrayList<Person>getPersonList(ArrayList<Person_has_Friend> psf){

        ArrayList<Person> personArrayList;

        ManagePerson mp = new ManagePerson();

      personArrayList =  mp.getPerson(psf);

      return personArrayList;
        }
    }

