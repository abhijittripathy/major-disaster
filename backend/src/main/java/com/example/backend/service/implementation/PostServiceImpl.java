package com.example.backend.service.implementation;

import com.example.backend.model.dao.PostDao;
import com.example.backend.model.document.Post;
import com.example.backend.model.document.User;
import com.example.backend.model.dto.PostDto;
import com.example.backend.repository.PostRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.PostService;
import com.example.backend.service.converters.PostConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class PostServiceImpl implements PostService {

    private static final Logger LOGGER= LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostConverterService postConverterService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PostDao getPostById(String id) {
        Post post=null;
        try {
            post = postRepository.findById(id).get();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.fillInStackTrace();
            return null;
        }
        return postConverterService.getPostDao(post);
    }

    @Override
    public String addPost(PostDto postDto) {
        Post post=new Post();
        post.setUserId(postDto.getUserId());
        post.setTitle(postDto.getTitle());
        post.setBody(postDto.getBody());
        post.setCreatedTime(LocalDateTime.now());
        post.setComments(new ArrayList<>());

        try {
            post = postRepository.save(post);
            User user = userRepository.findById(postDto.getUserId()).get();
            user.getPosts().add(post.getId());
            userRepository.save(user);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.fillInStackTrace();
        }
        return post.getId();
    }
}
