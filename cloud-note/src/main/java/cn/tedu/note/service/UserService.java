package cn.tedu.note.service;

import cn.tedu.note.entity.User;

public interface UserService {
   /*
    * ��¼���ܣ���¼�ɹ��򷵻��û���Ϣ����¼ʧ�����׳��쳣
    * @param name �û���
    * @param passwd �û�����
    * @return ��½�ɹ��򷵻��û�����
    * @throws UserNotFoundException �û�������
    * @throws PasswordException �������
    */
	public User Login(String name,String passwd)
	throws UserNotFoundException,PasswordException;
	/*
	    * ע�Ṧ�ܣ�ע��ɹ��򷵻ز���һ����¼��������ʧ�����׳��쳣
	    * @param name �û���
        * @param passwd �û�����
        * @param confirm ȷ������
        *  @param nick �ǳ�
	    * @return ע��ɹ��򷵻�1
	    * @throws UserHadExistException �û����Ѵ���
	    * @throws PasswordException �������
	    */
	public User regist(String name,String passwd,
			String confirm,String nick) throws UserHadExistException,PasswordException;
}
