package Web.MVC.Controller.Bean;

import Hibernate.Entity.Person;
import Hibernate.Manage.ManagePerson;

import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless(name = "SearchBeanEJB")
public class SearchBean {

    private String searchPara;

    private String searchResult;

    public SearchBean() {
    }




    public ArrayList<Person> searchForPersons(String username){


        ManagePerson mp = new ManagePerson();



        ArrayList<Person> persons;

        persons = mp.searchBy_userName(username);




        return persons;



    }

    public String testList(String search){



        String personPrint = "";


        ArrayList<Person> persons;


        persons = searchForPersons(search);


        //TODO: insert loop and use String builder to get all the persons into one String
        personPrint =persons.get(0).getFirstName()+" "+persons.get(0).getLastName()+
                "\nUsername: "+persons.get(0).getUserNameFK();

        return personPrint;
    }

    public String getSearchPara() {
        return searchPara;
    }

    public void setSearchPara(String searchPara) {
        this.searchPara = searchPara;
    }

    public String getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(String searchResult) {
        this.searchResult = searchResult;
    }
}
