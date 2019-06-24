package com.example.backend.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "posts")
public class Post {

    @Id
    private String id;

    private String userId;
    private String title;
    private String body;
    private List<String> comments;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public Post() { }

    public Post(String userId,String title, String body, List<String> comments, LocalDateTime createdTime, LocalDateTime updatedTime) {
        this.userId = userId;
        this.title=title;
        this.body = body;
        this.comments = comments;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
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

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", body='" + body + '\'' +
                ", comments=" + comments +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
