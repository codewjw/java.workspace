package entity;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer stuId;
    private String name;
    private String sex;
    private Integer age;
    private String[] interests;
    private Course cour;
    
    public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	//Bean����
    //1.ȥ��get/setʣ�µĵ��ʣ�����ĸСд
    //ͨ��get/set��������������������
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String[] getInterests() {
		return interests;
	}
	public void setInterests(String[] interests) {
		this.interests = interests;
	}
	public Course getCour() {
		return cour;
	}
	public void setCour(Course cour) {
		this.cour = cour;
	}
    
}
