package cn.tedu.note.dao;

import org.springframework.stereotype.Repository;

import cn.tedu.note.entity.User;

//ɨ��ʱ��beanָ�����֣��־û���ӿڣ���д��ɨ��ʱĬ��bean��idΪuserDao
@Repository("userdao")
public interface UserDao {
  
	public User findUserByName(String name);
	public int addUser(User user);
	public User findUserById(String userId);
}
