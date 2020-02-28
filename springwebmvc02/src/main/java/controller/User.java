package controller;

/*
 * 封装请求参数值
 * 要求：属性名和请求参数名一致
 *     注：名称要一样，类型要匹配（某些类型不一致，会做相应的类型转换，如将字符串转换为整型）
 *     属性提供相应的get和set方法
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
