package Hibernate.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Person_has_Friend")
public class Person_has_Friend {

   public Person_has_Friend(){}

    public Person_has_Friend(int person_id, int friend_id,int isPending) {
        this.person_id = person_id;
        this.friend_id = friend_id;
        this.isPending = isPending;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "person_id")
    private int person_id;

    @Column(name = "friend_id")
    private int friend_id;

    @Column(name = "isPending")
    private int isPending;

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

    public int getIsPending() {
        return isPending;
    }

    public void setIsPending(int isPending) {
        this.isPending = isPending;
    }

    @Override
    public String toString() {
        return "Person_has_Friend{" +
                "id=" + id +
                ", person_id=" + person_id +
                ", friend_id=" + friend_id +
                ", isPending=" + isPending +
                '}';
    }
}
