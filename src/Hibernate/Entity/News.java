package Hibernate.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@javax.persistence.Table(name = "news")
public class News implements Serializable {

    public News(){}



    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "post")
    private String post;


    public News(String post) {
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", post='" + post + '\'' +
                '}';
    }
}
