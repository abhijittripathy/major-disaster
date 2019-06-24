package com.example.backend.service.implementation;

import com.example.backend.model.document.Comment;
import com.example.backend.model.document.Post;
import com.example.backend.model.dto.CommentDto;
import com.example.backend.repository.CommentRepository;
import com.example.backend.repository.PostRepository;
import com.example.backend.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {

    private static final Logger LOGGER= LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Comment> getComentsByPostId(String id) {
        Post post=null;
        List<Comment> comments=null;
        post=postRepository.findById(id).get();
        if(post!=null) {
            comments=post.getComments().stream()
                        .map(commentId -> commentRepository.findById(commentId).get())
                        .collect(Collectors.toList());
        }
        return comments;
    }

    @Override
    public String addComment(CommentDto comment) {
        Comment nComment=new Comment();
        nComment.setPostId(comment.getPostId());
        nComment.setUserId(comment.getUserId());
        nComment.setBody(comment.getBody());
        nComment.setCreatedTime(LocalDateTime.now());

        try {
            nComment = commentRepository.save(nComment);
            Post post = postRepository.findById(comment.getPostId()).get();
            post.getComments().add(nComment.getId());
            postRepository.save(post);
        } catch (Exception e){
            LOGGER.error(e.getMessage());
            e.fillInStackTrace();
        }
        return nComment.getId();
    }
}
