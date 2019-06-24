package com.example.backend.model.dto;

public class CommentDto {

    private String id;
    private String userId;
    private String body;
    private String postId;

    public CommentDto() { }

    public CommentDto(String id, String userId, String body, String postId) {
        this.id = id;
        this.userId = userId;
        this.body = body;
        this.postId = postId;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", body='" + body + '\'' +
                ", postId='" + postId + '\'' +
                '}';
    }
}
