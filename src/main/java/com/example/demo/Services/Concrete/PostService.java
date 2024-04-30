package com.example.demo.Services.Concrete;

import com.example.demo.DAL.Interfaces.PostRepository;
import com.example.demo.Services.Interface.IPostService;
import com.example.demo.Tables.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {
    private final PostRepository _postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        _postRepository = postRepository;
    }

    @Override
    public List<Post> GetAllPosts() {
        return _postRepository.findAll();
    }

    @Override
    public List<Post> GetPostsByTagIds(long[] tagsIds) {
        return _postRepository.findPostsByTagIds(tagsIds);
    }

    @Override
    public List<Post> GetPostsByParentID(long parentId) {
        return _postRepository.GetPostsByParentID(parentId);
    }

    @Override
    public Post GetPostByPostID(long postId) {
        return _postRepository.findById(postId).orElse(null);
    }

    @Override
    public List<Post> SearchPosts(String[] keywords) {
        List<Post> posts = new ArrayList<Post>();
        for(int i=0;i<keywords.length;i++)
        {
            posts.addAll(_postRepository.SearchPosts(keywords[i]));
        }
        return posts;
    }

    @Override
    public Post InsertPost(Post post) {
        return _postRepository.save(post);
    }

    @Override
    public Post UpdatePost(Post post) {
        return _postRepository.save(post);
    }

    @Override
    public void DeletePost(Post post) {
         _postRepository.delete(post);
    }
}
