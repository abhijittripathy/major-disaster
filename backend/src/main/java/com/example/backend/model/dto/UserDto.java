package com.example.backend.model.dto;

public class UserDto {

    private String id;
    private String firstname;
    private String lastname;
    private String username;

    public UserDto() { }

    public UserDto(String id,String firstname, String lastname, String username) {
        this.id=id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
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
}
