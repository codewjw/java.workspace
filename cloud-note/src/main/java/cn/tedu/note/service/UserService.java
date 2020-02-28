package cn.tedu.note.service;

import cn.tedu.note.entity.User;

public interface UserService {
   /*
    * 登录功能，登录成功则返回用户信息，登录失败则抛出异常
    * @param name 用户名
    * @param passwd 用户密码
    * @return 登陆成功则返回用户对象
    * @throws UserNotFoundException 用户不存在
    * @throws PasswordException 密码错误
    */
	public User Login(String name,String passwd)
	throws UserNotFoundException,PasswordException;
	/*
	    * 注册功能，注册成功则返回插入一条记录数，插入失败则抛出异常
	    * @param name 用户名
        * @param passwd 用户密码
        * @param confirm 确认密码
        *  @param nick 昵称
	    * @return 注册成功则返回1
	    * @throws UserHadExistException 用户名已存在
	    * @throws PasswordException 密码错误
	    */
	public User regist(String name,String passwd,
			String confirm,String nick) throws UserHadExistException,PasswordException;
}
