package com.example.demo.DAL.Interfaces;

import com.example.demo.Tables.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.SQLException;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Tags_Posts tp " +
            "left join Post p on tp.postId=p.Id " +
            "WHERE tp.tagId in (?)")
    List<Post> findPostsByTagIds(long[] tagIds);

    @Query("SELECT p FROM Post p " +
            "WHERE p.ParentId=?")
    List<Post> GetPostsByParentID(long parentId);

    @Query("SELECT p FROM Post p " +
            "WHERE p.PostInEnglish like '%?%' ")
    List<Post> SearchPosts(String keywords);
}