package edu.web.jsp02.service;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.dto.UserSignUpDto;

public interface UserService {

    int signUp(UserSignUpDto dto);

    User signIn(String username, String password);

}
