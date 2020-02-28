package cn.tedu.service;

import cn.tedu.Result;

public interface UserPwdService {
	Result login(String name,String password);
}
