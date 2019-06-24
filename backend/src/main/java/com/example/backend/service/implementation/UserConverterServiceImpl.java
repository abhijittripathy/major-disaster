package com.example.backend.service.implementation;

import com.example.backend.model.dao.PostDao;
import com.example.backend.model.dao.UserDao;
import com.example.backend.model.document.Post;
import com.example.backend.model.document.User;
import com.example.backend.repository.PostRepository;
import com.example.backend.service.converters.PostConverterService;
import com.example.backend.service.converters.UserConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserConverterServiceImpl implements UserConverterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserConverterServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostConverterService postConverterService;

    @Override
    public List<UserDao> getUserDaos(List<User> users) {
        return users.stream().map(user->getUserDao(user)).collect(Collectors.toList());
    }

    @Override
    public UserDao getUserDao(User user) {
        UserDao userDao=new UserDao();
        List<PostDao> postDaos=null;
        List<Post> posts=null;
        userDao.setId(user.getId());
        userDao.setFirstname(user.getFirstname());
        userDao.setLastname(user.getLastname());
        userDao.setUsername(user.getUsername());

        try {
            posts=user.getPosts().stream()
                    .map(id->postRepository.findById(id).get())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.fillInStackTrace();
        }
        postDaos=postConverterService.getPostDaos(posts);
        userDao.setPosts(postDaos);
        return userDao;
    }
}
