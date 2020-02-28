package cn.tedu.netctoss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tedu.netctoss.annotations.MyBatisRepository;
import cn.tedu.netctoss.entity.Admin;

/*
 * 持久层接口(映射文件)
 * 不要在接口方法上抛异常，异常的类型会限定接口应用范围，污染接口
 * 
 */
@Repository("adminDAO")
@MyBatisRepository   //自定义注解，扫描时指定它来识别
public interface AdminDao {
   public Admin findAdminByCode(String adminCode);
   public List<Admin> findAllAdmins();
}
