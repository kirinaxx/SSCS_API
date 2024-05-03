package com.example.demo.Services.Concrete;

import com.example.demo.DAL.Interfaces.TagsRepository;
import com.example.demo.Services.Interface.ITagsService;
import com.example.demo.Tables.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsService implements ITagsService {
    private final TagsRepository _tagsRepository;
    @Autowired
    public TagsService(TagsRepository _tagsRepository) {
        this._tagsRepository = _tagsRepository;
    }

    public List<Tag> GetAllTags() {
       return _tagsRepository.findAll();
    }
    public boolean InsertTags(List<Tag> tags) {
        var result = _tagsRepository.saveAll(tags);
        return !result.isEmpty();
    }
    public boolean RemoveTagsByTagName(String[] tags) {
        try {
            _tagsRepository.RemoveTagsByTagName(tags);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
}
