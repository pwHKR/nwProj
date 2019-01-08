package Hibernate.Entity;

import javax.persistence.*;
import java.io.Serializable;

// Entity bean that defines an Account



@Entity
@javax.persistence.Table(name = "Account")
public class Account implements Serializable {


    @Id @GeneratedValue
    @Column(name = "id")
    private int id;


    @Column(name = "userName")
    private String userName;


    @Column(name = "password")
    private String password;

    @Column(name ="email")
    private String email;

    @Column(name ="isOnline")
    private int isOnline;





    public Account(){}


    public Account(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
