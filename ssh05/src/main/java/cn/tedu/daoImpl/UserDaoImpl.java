package cn.tedu.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void save(User user) {
		hibernateTemplate.save(user);
	}

	public void update(User user) {
		hibernateTemplate.update(user);
	}

	public void delete(User user) {
		hibernateTemplate.delete(user);
	}

	public User findByName(String name) {
		//2.∂®“Âhql”Ôæ‰
		String hql = "from User WHERE name=:name";
	    List<User> users =  hibernateTemplate.findByNamedParam(hql, "name", name);
		return users.get(0);
	}

}
