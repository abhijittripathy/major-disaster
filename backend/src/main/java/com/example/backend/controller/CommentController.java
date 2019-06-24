package com.example.backend.controller;

import com.example.backend.model.document.Comment;
import com.example.backend.model.dto.CommentDto;
import com.example.backend.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private static final Logger LOGGER= LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @GetMapping("/{postId}")
    public ResponseEntity<Object> getComments(@PathVariable("postId") String postId){
        List<Comment> comments=null;
        try {
            comments=commentService.getComentsByPostId(postId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.fillInStackTrace();
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> addComment(@RequestBody CommentDto commentDto){
        String id=null;
        try {
            id=commentService.addComment(commentDto);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.fillInStackTrace();
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
