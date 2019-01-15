package Hibernate.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@javax.persistence.Table(name = "group")
public class Group implements Serializable {


    public Group(){}

    public Group(String role,String username) {
        this.username = username;
        this.role = role;
    }

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

        @Column(name = "username")
        private String username;

        @Column(name = "role")
        private String role;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
