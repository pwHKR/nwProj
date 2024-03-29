package Hibernate.Entity;

import javax.persistence.*;
import java.io.Serializable;

// Entity bean that defines an Account



@Entity
@javax.persistence.Table(name = "account")
public class Account implements Serializable {


    @Id @GeneratedValue
    @Column(name = "id")
    private int id;


    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;

    @Column(name ="email")
    private String email;

    @Column(name ="isOnline")
    private int isOnline;

    @Column(name ="isBan")
    private int isBan;

    @Column(name ="isAdmin")
    private int isAdmin;





    public Account(){}


    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Account(String username,int id, int isBan) {
        this.username = username;
        this.id = id;
        this.isBan = isBan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
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

    public int getIsBan() {
        return isBan;
    }

    public void setIsBan(int isBan) {
        this.isBan = isBan;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isOnline=" + isOnline +
                ", isBan=" + isBan +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
