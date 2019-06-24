package com.example.backend.service;

import com.example.backend.model.dao.PostDao;
import com.example.backend.model.dto.PostDto;


public interface PostService {

    public PostDao getPostById(String id);

    public String addPost(PostDto postDto);
}
