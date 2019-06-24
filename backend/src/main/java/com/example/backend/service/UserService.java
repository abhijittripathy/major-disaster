package com.example.backend.service;

import com.example.backend.model.dao.UserDao;
import com.example.backend.model.dto.UserDto;

import java.util.List;

public interface UserService {

    public List<UserDao> getAll();

    public UserDao getUserById(String id);

    public String addUser(UserDto userDto);
}
