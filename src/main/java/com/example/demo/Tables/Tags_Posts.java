package com.example.demo.Tables;

import jakarta.persistence.*;

@Entity
public class Tags_Posts {
    @Id
    Long Id;
    @Column(name = "PostId")
    Long postId;

    @Column(name = "TagId")
    Long tagId;
    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "PostId")
    Post post;

    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "TagId")
    Tag tag;

}
