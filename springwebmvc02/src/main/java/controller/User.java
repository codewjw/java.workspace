package controller;

/*
 * ��װ�������ֵ
 * Ҫ�������������������һ��
 *     ע������Ҫһ��������Ҫƥ�䣨ĳЩ���Ͳ�һ�£�������Ӧ������ת�����罫�ַ���ת��Ϊ���ͣ�
 *     �����ṩ��Ӧ��get��set����
 */
public class User {
  private String username;
  private String passwd;
  private Integer age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
  
}
