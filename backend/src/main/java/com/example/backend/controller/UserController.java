package com.example.backend.controller;

import com.example.backend.model.dao.UserDao;
import com.example.backend.model.dto.UserDto;
import com.example.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUsers(){
        List<UserDao> users=userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") String id){
        UserDao dao=null;
        try {
            dao=userService.getUserById(id);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.fillInStackTrace();
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dao, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> addNewUser(@RequestBody UserDto userDto){
        String id=null;
        try {
            id=userService.addUser(userDto);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
