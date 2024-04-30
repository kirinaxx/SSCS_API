package com.example.demo.Controllers;

import com.example.demo.Services.Concrete.TagsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/tags")
public class TagsController {

    private final TagsService tagsService;
    public TagsController(TagsService _tagsService) {
        this.tagsService = _tagsService;
    }





}
