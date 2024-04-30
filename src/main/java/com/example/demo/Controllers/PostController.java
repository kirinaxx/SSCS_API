package com.example.demo.Controllers;



import com.example.demo.Services.Concrete.PostService;
import com.example.demo.Services.Interface.IPostService;
import com.example.demo.Tables.Post;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final IPostService _postService;

    public PostController(PostService postService) {
        _postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return _postService.GetAllPosts();
    }

    @GetMapping("/{parentId}")
    public List<Post> getAllPosts(@PathVariable Long parentId) {
        return _postService.GetPostsByParentID(parentId);
    }

    @PostMapping
    public List<Post> getAllPosts(@RequestBody long[] tagIds) {
        return _postService.GetPostsByTagIds(tagIds);
    }
    @PostMapping
    public void addPost(@RequestBody Post post) {
        _postService.InsertPost(post);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post existingPost = _postService.GetPostByPostID(id);
        if (existingPost != null) {
            post.setId(id); // Ensure the correct ID is set
            _postService.UpdatePost(post);
        }
    }
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        Post existingPost = _postService.GetPostByPostID(id);
        _postService.DeletePost(existingPost);
    }
}
