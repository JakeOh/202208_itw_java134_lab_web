package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.dto.PostCreateDto;

public interface PostService {
    
    public List<Post> read(); // 포스트 전체 목록 읽어오기
    public int create(PostCreateDto dto); // 포스트 작성하기
    public Post read(Integer id); // id(포스트 번호)가 일치하는 포스트 1개 읽어오기

}
