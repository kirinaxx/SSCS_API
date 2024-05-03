package com.example.demo.Controllers;



import com.example.demo.Services.Concrete.PostService;
import com.example.demo.Services.Concrete.TagsService;
import com.example.demo.Services.Interface.IPostService;
import com.example.demo.Services.Interface.ITagsService;
import com.example.demo.Tables.Post;
import com.example.demo.Tables.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;


@RestController
@RequestMapping(value="/api/posts")
public class PostController {

    private final IPostService _postService;
    @Autowired
    public PostController(PostService postService) {

        _postService = postService;
    }

    @GetMapping(value="allposts")
    public List<Post> getAllPosts() {
        return _postService.GetAllPosts();
    }

    @GetMapping(value="/byparent/{parentId}")
    public List<Post> getAllPosts(@PathVariable Long parentId) {
        return _postService.GetPostsByParentID(parentId);
    }

    @PostMapping(value="/bytags")
    public List<Post> getAllPostsByTags(@RequestBody long[] tagIds) {
        return _postService.GetPostsByTagIds(tagIds);
    }
    @PostMapping(value="/addpost")
    public boolean addPost(@RequestBody Post post, @RequestBody List<Tag> tags) {
        post.setDate(new Date());
        try {
            _postService.InsertPost(post, tags);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    @PutMapping("/updatepost/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post existingPost = _postService.GetPostByPostID(id);
        if (existingPost != null) {
            post.setId(id); // Ensure the correct ID is set
            _postService.UpdatePost(post);
        }
    }
    @DeleteMapping("/deletepost/{id}")
    public void deletePost(@PathVariable Long id) {
        Post existingPost = _postService.GetPostByPostID(id);
        _postService.DeletePost(existingPost);
    }
}
