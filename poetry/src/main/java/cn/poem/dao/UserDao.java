package cn.poem.dao;

import org.springframework.stereotype.Repository;
import cn.poem.entity.User;

@Repository("userDao")
public interface UserDao {
	User findUserByName(String name);
	int insertUser(User user);
}
