package com.example.spring02.mapper;

import java.util.List;

import com.example.spring02.domain.Post;

public interface PostMapper {
    
    List<Post> selectOrderByIdDesc();
    int insert(Post post);

}
