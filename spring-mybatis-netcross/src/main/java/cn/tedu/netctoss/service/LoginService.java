package cn.tedu.netctoss.service;

import cn.tedu.netctoss.entity.Admin;

/*
 * ����ҵ���ӿ�
 */
public interface LoginService {
   public Admin checkLogin(String adminCode,String pwd,String sessionCode,String reqCode);
}
