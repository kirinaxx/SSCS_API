package com.example.demo.Tables;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Tag;

    @OneToMany(mappedBy = "tag")
    Set<Tags_Posts> tagsPosts;
    public Tag() {
    }

    public Tag(String Tag) {
        this.Tag = Tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        this.Tag = tag;
    }
    @Override
    public String toString()
    {
        return "Tag ID: " + this.id + "\nTag: " + this.Tag + "\n";
    }

}
