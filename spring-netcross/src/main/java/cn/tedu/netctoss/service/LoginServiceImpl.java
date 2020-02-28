package cn.tedu.netctoss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.netctoss.dao.AdminDao;
import cn.tedu.netctoss.entity.Admin;

/*
 * ҵ����ʵ��,ҵ����ע��
 * @Service("loginService"),����loginServiceΪbena��id
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Resource(name="adminDAO")
    private AdminDao aDao;
	
	public Admin checkLogin(String adminCode, String pwd,String sessionCode,String reqCode) {
		if(!sessionCode.equalsIgnoreCase(reqCode)){
			throw new ApplicationException("��֤�����");
		}
		Admin admin = aDao.findAdminByCode(adminCode);
		if(admin == null){
			  //�˺Ų�����
			  //ע��Ӧ���쳣��ָ������Ϊ�û��Ĳ���ȷ����������쳣�������˺ţ�������д����
			  //��Ҫ��ȷ��ʾ�û���ȡ��ȷ�Ĳ���
			 throw new ApplicationException("�˺Ŵ���");
		}else if(!pwd.equals(admin.getPassword())){
			throw new ApplicationException("�������");
		}
		//��¼�ɹ�
		return admin;
	}
      
}
