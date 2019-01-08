package Hibernate.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@javax.persistence.Table(name = "Group")
public class Group implements Serializable {


    public Group(){}

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

        @Column(name = "userName_FK")
        private String userName_FK;

        @Column(name = "role")
        private String role;


    public String getUserName_FK() {
        return userName_FK;
    }

    public void setUserName_FK(String userName_FK) {
        this.userName_FK = userName_FK;
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
