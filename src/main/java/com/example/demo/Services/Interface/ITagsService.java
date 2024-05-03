package com.example.demo.Services.Interface;

import com.example.demo.Tables.Tag;

import java.sql.SQLException;
import java.util.List;

public interface ITagsService {
    public List<Tag> GetAllTags();
    public boolean InsertTags(List<Tag> tags);
    public boolean RemoveTagsByTagName(String[] tags);
}
