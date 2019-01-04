package Hibernate.Entity;

import javax.persistence.*;

@Entity
@Table(name ="Friend")
public class Friend {


    public Friend(){}

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "isOnline")
    private int isOnline;

    @Column(name = "isPending")
    private int isPending;

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

    public int getIsPending() {
        return isPending;
    }

    public void setIsPending(int isPending) {
        this.isPending = isPending;
    }
}
