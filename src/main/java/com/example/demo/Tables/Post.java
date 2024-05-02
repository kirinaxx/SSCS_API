package com.example.demo.Tables;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Title", nullable = true)
    private String title;
    @Column(name = "PostInEnglish", nullable = true)
    private String postInEnglish;

    @Column(name = "PostOriginal", nullable = true)
    private String postOriginal;
    @Column(name = "Date", nullable = true)
    private Date date;
    @Column(name="ParentId", nullable = true)
    private Long parentId;
    @Column(name="NumberOfLikes", nullable = true)
    private Integer numberOfLikes;


    public Post()
    {

    }

    public Post(long id, String title, String postOriginal, String postInEnglish, java.util.Date date, long parentId, int numberOfLikes) {
        this.id = id;
        this.title = title;
        this.postOriginal = postOriginal;
        this.postInEnglish = postInEnglish;
        this.date = date;
        this.parentId = parentId;
        this.numberOfLikes = numberOfLikes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostOriginal() {
        return postOriginal;
    }

    public void setPostOriginal(String postOriginal) {
        this.postOriginal = postOriginal;
    }

    public String getPostInEnglish() {
        return postInEnglish;
    }

    public void setPostInEnglish(String postInEnglish) {
        this.postInEnglish = postInEnglish;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
            this.parentId = parentId;
    }

    public Integer getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(Integer numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

}
