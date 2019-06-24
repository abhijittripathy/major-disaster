package com.example.backend.model.dao;


import java.util.List;

public class UserDao {


    private String id;
    private String firstname;
    private String lastname;
    private String username;
    List<PostDao> posts;

    public UserDao() { }

    public UserDao(String id, String firstname, String lastname, String username, List<PostDao> posts) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.posts = posts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<PostDao> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDao> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", posts=" + posts +
                '}';
    }
}
