package com.example.backend.service.converters;

import com.example.backend.model.dao.PostDao;
import com.example.backend.model.document.Post;


import java.util.List;

public interface PostConverterService {


    public List<PostDao> getPostDaos(List<Post> posts);

    public PostDao getPostDao(Post post);
}
