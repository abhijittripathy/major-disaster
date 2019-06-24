package com.example.backend.model.dto;

public class PostDto {

    private String id;
    private String userId;
    private String title;
    private String body;

    public PostDto() { }

    public PostDto(String id, String userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
