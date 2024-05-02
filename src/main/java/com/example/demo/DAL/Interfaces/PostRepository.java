package com.example.demo.DAL.Interfaces;

import com.example.demo.Tables.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.SQLException;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Tags_Posts tp " +
            "left join Post p on tp.postId=p.id " +
            "WHERE tp.tagId in (:tagIds)")
    List<Post> findPostsByTagIds(long[] tagIds);

    @Query("SELECT p FROM Post p " +
            "WHERE p.parentId=:parentId")
    List<Post> GetPostsByParentID(long parentId);

    @Query("SELECT p FROM Post p " +
            "WHERE p.postInEnglish like '%:keywords%' ")
    List<Post> SearchPosts(String keywords);

    @Modifying
    @Query(value = "INSERT INTO Tags_Posts tp (tp.TagId, tp.PostId) VALUES (:tagId, :postId)", nativeQuery = true)
    void InsertTagPostRelationship(long tagId, long postId);
}