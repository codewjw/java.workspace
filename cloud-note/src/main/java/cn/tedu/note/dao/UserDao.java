package cn.tedu.note.dao;

import org.springframework.stereotype.Repository;

import cn.tedu.note.entity.User;

//扫描时给bean指定名字，持久化层接口，不写，扫描时默认bean的id为userDao
@Repository("userdao")
public interface UserDao {
  
	public User findUserByName(String name);
	public int addUser(User user);
	public User findUserById(String userId);
}
