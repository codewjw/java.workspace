package cn.tedu.dao;

import org.springframework.stereotype.Repository;

import cn.tedu.entity.UserPwd;

@Repository
public interface UserPwdDao {
	UserPwd findByName(String name);
}
