package Hibernate.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Person_has_Friend")
public class Person_has_Friend {

    Person_has_Friend(){}

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "Person_id")
    private int person_id;

    @Column(name = "Friend_id")
    private int friend_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }
}
