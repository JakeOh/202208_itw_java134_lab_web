package edu.web.jsp02.service;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.dto.UserSignUpDto;
import edu.web.jsp02.repository.UserDao;
import edu.web.jsp02.repository.UserDaoImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    
    private static UserServiceImpl instance = null;
    
    private UserServiceImpl() {
        userDao = UserDaoImpl.getInstance();
    }
    
    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        
        return instance;
    }
    
    @Override
    public int signUp(UserSignUpDto dto) {
        log.info("signUp(dto = {})", dto);
        
        return userDao.insert(dto.toEntity());
    }

    @Override
    public User signIn(String username, String password) {
        log.info("signIn(username={}, password={})", username, password);
        
        User user = User.builder()
                .username(username).password(password)
                .build();
        
        return userDao.selectByUsernameAndPassword(user);
    }

}
