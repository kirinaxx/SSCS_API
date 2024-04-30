package com.example.demo.Tables;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Title;
    private String PostOriginal;
    private String PostInEnglish;
    private Date Date;
    private long ParentId;
    private int NumberOfLikes;

    @OneToMany(mappedBy = "post")
    Set<Tags_Posts> tagsPosts;

    public Post()
    {

    }

    public Post(long id, String title, String postOriginal, String postInEnglish, java.util.Date date, long parentId, int numberOfLikes) {
        Id = id;
        Title = title;
        PostOriginal = postOriginal;
        PostInEnglish = postInEnglish;
        Date = date;
        ParentId = parentId;
        NumberOfLikes = numberOfLikes;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPostOriginal() {
        return PostOriginal;
    }

    public void setPostOriginal(String postOriginal) {
        PostOriginal = postOriginal;
    }

    public String getPostInEnglish() {
        return PostInEnglish;
    }

    public void setPostInEnglish(String postInEnglish) {
        PostInEnglish = postInEnglish;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public long getParentId() {
        return ParentId;
    }

    public void setParentId(long parentId) {
        ParentId = parentId;
    }

    public int getNumberOfLikes() {
        return NumberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        NumberOfLikes = numberOfLikes;
    }

    public Set<Tags_Posts> getTagsPosts() { return tagsPosts; }

    public void setTagsPosts(Set<Tags_Posts> tagsPosts) { this.tagsPosts = tagsPosts; }
}
