package cn.tedu.dao;

import cn.tedu.entity.User;

public interface UserDao {
   void save(User user);
   void update(User user);
   void delete(User user);
   User findByName(String name);
}
