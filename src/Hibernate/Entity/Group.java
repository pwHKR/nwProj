package Hibernate.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@javax.persistence.Table(name = "gdata")
public class Group implements Serializable {


    public Group(){}

    public Group(String role, String username) {
        this.username = username;
        this.role = role;
    }

    @Id@GeneratedValue
    @Column(name = "id")
    private int id;


    @Column(name = "role")
    private String role;

    @Column(name = "username")
    private String username;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
