package Hibernate.Entity;

import javax.persistence.*;

@Entity
@Table(name ="Friend")
public class Friend {


    public Friend(){}

    public Friend(int isOnline) {
        this.isOnline = isOnline;

    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "isOnline")
    private int isOnline;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
    }


    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", isOnline=" + isOnline +
                '}';
    }
}
