package com.example.demo.Services.Interface;

import com.example.demo.Tables.Post;
import com.example.demo.Tables.Tag;

import java.util.List;

public interface IPostService {
    List<Post> GetAllPosts();
    List<Post> GetPostsByTagIds(long[] tagsIds) ;
    List<Post> GetPostsByParentID(long parentId);
    Post GetPostByPostID(long postId);
    List<Post> SearchPosts(String[] keywords) ;
    Post InsertPost(Post post, int[] tagIds) ;
    Post UpdatePost(Post post);
    void DeletePost(Post post);
}
