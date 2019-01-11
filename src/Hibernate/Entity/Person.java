package Hibernate.Entity;


import javax.persistence.*;

@Entity
@Table(name ="Person")
public class Person {

    public Person(){}



    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name ="firstName")
    private String firstName;

    @Column(name ="lastName")
    private String lastName;

    @Column(name ="adress")
    private String adress;


    @Column(name = "Account_id")
    private int Account_id;

    // Instance variable not part of entity!

    private String userNameFK;





    public Person(String firstName, String lastName, String adress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
    }


    public Person(String firstName, String lastName, String adress, int account_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        Account_id = account_id;
    }

    public Person(String firstName, String lastName, String adress, int account_id, String userNameFK) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        Account_id = account_id;
        this.userNameFK = userNameFK;
    }


    public Person(int id,String firstName, String lastName, String adress, int account_id, String userNameFK) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        Account_id = account_id;
        this.userNameFK = userNameFK;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getAccount_id() {
        return Account_id;
    }

    public void setAccount_id(int account_id) {
        Account_id = account_id;
    }

    public String getUserNameFK() {
        return userNameFK;
    }

    public void setUserNameFK(String userNameFK) {
        this.userNameFK = userNameFK;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adress='" + adress + '\'' +
                ", Account_id=" + Account_id +
                ", userNameFK='" + userNameFK + '\'' +
                '}';
    }
}
