package com.example.demo.DAL.Interfaces;

import com.example.demo.Tables.Post;
import com.example.demo.Tables.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagsRepository extends JpaRepository<Tag, Long> {

    @Query("DELETE FROM Tag t " +
            "WHERE t.id in (:tags)")
    void RemoveTagsByTagName(String[] tags);
}
