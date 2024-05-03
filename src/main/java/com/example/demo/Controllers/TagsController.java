package com.example.demo.Controllers;

import com.example.demo.Services.Concrete.TagsService;
import com.example.demo.Tables.Post;
import com.example.demo.Tables.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api/tags")
public class TagsController {

    private final TagsService tagsService;
    @Autowired
    public TagsController(TagsService _tagsService) {
        this.tagsService = _tagsService;
    }

    @GetMapping(value="alltags")
    public List<Tag> GetAllTags() {
        return tagsService.GetAllTags();
    }



}
