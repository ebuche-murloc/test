package com.example.demoweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String text;
    private Integer likes;
    private Date creationDate;



    public Post() {

    }

    public Post(Long id, String text, Date creationDate) {
        this.text=text;
        this.creationDate = creationDate;
        this.id = id;
        this.likes = 0;
    }

    public Integer getLikes() {
        return likes;
    }

    public Long getId() {
        return id;
    }

    public Date getCreationDate(){
        return creationDate;
    }

    public String getText() {
        return text;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}