package com.example.backend.service;

import com.example.backend.model.document.Comment;
import com.example.backend.model.dto.CommentDto;

import java.util.List;

public interface CommentService {

    public List<Comment> getComentsByPostId(String id);

    public String addComment(CommentDto comment);
}
