package cn.poem.service;

import cn.poem.entity.User;
import cn.poem.exception.PassWordNotFoundException;
import cn.poem.exception.UserNotFoundException;

public interface UserService {
    int regist(String name,String password,String confirmPsw,String nick,String email) 
    		throws UserNotFoundException,PassWordNotFoundException;
    User login(String name,String password)
    		throws UserNotFoundException,PassWordNotFoundException;
}
