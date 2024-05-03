package com.example.demo.Controllers;



import com.example.demo.Services.Concrete.PostService;
import com.example.demo.Services.Interface.IPostService;
import com.example.demo.Services.Interface.ITagsService;
import com.example.demo.Tables.Post;
import com.example.demo.Tables.Tag;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value="/api/posts")
public class PostController {

    private final IPostService _postService;
    private final ITagsService _tagService;
    @Autowired
    public PostController(PostService postService, ITagsService tagsService) {

        _postService = postService;
        _tagService = tagsService;
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
    public boolean addPost(@RequestBody String json) {

        try {
            ObjectMapper mapper=new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            Post post=mapper.readValue(json,Post.class);
            int[] tagIds = mapper.readValue(json, int[].class);

            post.setDate(new Date());
            _postService.InsertPost(post, tagIds);
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
