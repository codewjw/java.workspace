package cn.tedu.dao;

import org.springframework.stereotype.Repository;

import cn.tedu.entity.User;

@Repository
public interface UserDao {
   void Save(User user);
}
