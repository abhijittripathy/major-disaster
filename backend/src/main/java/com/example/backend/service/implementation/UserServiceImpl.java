package com.example.backend.service.implementation;

import com.example.backend.model.dao.UserDao;
import com.example.backend.model.document.User;
import com.example.backend.model.dto.UserDto;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.converters.UserConverterService;
import com.example.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserConverterService userConverterService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDao> getAll() {
        return userConverterService.getUserDaos(userRepository.findAll());
    }

    @Override
    public UserDao getUserById(String id) {
        User user=null;
        try {
            user = userRepository.findById(id).get();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
            e.fillInStackTrace();
            return null;
        }
        return userConverterService.getUserDao(user);
    }

    @Override
    public String addUser(UserDto userDto) {
        User user=new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setUsername(userDto.getUsername());
        user.setPosts(new ArrayList<>());
        try {
            user=userRepository.save(user);
        } catch(Exception e) {
            LOGGER.error(e.getMessage());
            e.fillInStackTrace();
        }
        return user.getId();
    }

}
