package com.example.demo.Tables;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="Tag", nullable = true)
    private String tag;

    @OneToMany(mappedBy = "tag")
    Set<Tags_Posts> tagsPosts;
    public Tag() {
    }

    public Tag(String Tag) {
        this.tag = Tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    @Override
    public String toString()
    {
        return "Tag ID: " + this.id + "\nTag: " + this.tag + "\n";
    }

}
