package com.microservices.course.restfulwebservices.jpa.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservices.course.restfulwebservices.jpa.user.JPAUser;

import javax.persistence.*;


@Entity
public class Post {
    @Id
    @GeneratedValue
    private int id;
    private String description;

    //User information will not be fetched in post unless it's explicitly called
    @ManyToOne (fetch = FetchType.LAZY)
    @JsonIgnore
    private JPAUser jpaUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JPAUser getJpaUser() {
        return jpaUser;
    }

    public void setJpaUser(JPAUser jpaUser) {
        this.jpaUser = jpaUser;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
