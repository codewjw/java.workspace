package cn.tedu.netctoss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tedu.netctoss.annotations.MyBatisRepository;
import cn.tedu.netctoss.entity.Admin;

/*
 * �־ò�ӿ�(ӳ���ļ�)
 * ��Ҫ�ڽӿڷ��������쳣���쳣�����ͻ��޶��ӿ�Ӧ�÷�Χ����Ⱦ�ӿ�
 * 
 */
@Repository("adminDAO")
@MyBatisRepository   //�Զ���ע�⣬ɨ��ʱָ������ʶ��
public interface AdminDao {
   public Admin findAdminByCode(String adminCode);
   public List<Admin> findAllAdmins();
}
