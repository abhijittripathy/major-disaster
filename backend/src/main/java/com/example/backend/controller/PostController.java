package com.example.backend.controller;

import com.example.backend.model.dao.PostDao;
import com.example.backend.model.dto.PostDto;
import com.example.backend.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    private static final Logger LOGGER= LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;


    @GetMapping("/{id}")
    public ResponseEntity<Object> getPost(@PathVariable("id") String id){
        PostDao postDao=null;
        try {
            postDao=postService.getPostById(id);
        } catch (Exception e){
            LOGGER.error(e.getMessage());
            e.fillInStackTrace();
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(postDao,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> addNewPost(@RequestBody PostDto postDto) {
        String id=null;
        try {
            id = postService.addPost(postDto);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.fillInStackTrace();
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
