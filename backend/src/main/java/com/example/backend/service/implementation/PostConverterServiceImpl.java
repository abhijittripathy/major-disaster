package com.example.backend.service.implementation;

import com.example.backend.model.dao.PostDao;
import com.example.backend.model.document.Comment;
import com.example.backend.model.document.Post;
import com.example.backend.repository.CommentRepository;
import com.example.backend.service.converters.PostConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostConverterServiceImpl implements PostConverterService {

    private static final Logger LOGGER= LoggerFactory.getLogger(PostConverterServiceImpl.class);

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<PostDao> getPostDaos(List<Post> posts) {
        return posts.stream().map(post -> getPostDao(post)).collect(Collectors.toList());
    }

    @Override
    public PostDao getPostDao(Post post) {
        PostDao postDao=new PostDao();
        List<Comment> comments=null;
        postDao.setId(post.getId());
        postDao.setUserId(post.getUserId());
        postDao.setTitle(post.getTitle());
        postDao.setBody(post.getBody());
        postDao.setCreatedTime(post.getCreatedTime());
        postDao.setUpdatedTime(post.getUpdatedTime());
        try {
            comments = post.getComments().stream()
                    .map(id -> commentRepository.findById(id).get())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.fillInStackTrace();
        }
        postDao.setComments(comments);
        return postDao;
    }
}
