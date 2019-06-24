package com.example.backend.service.converters;

import com.example.backend.model.dao.UserDao;
import com.example.backend.model.document.User;

import java.util.List;

public interface UserConverterService {

    public List<UserDao> getUserDaos(List<User> users);

    public UserDao getUserDao(User user);
}
