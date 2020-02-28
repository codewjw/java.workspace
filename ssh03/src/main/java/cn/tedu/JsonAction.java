package cn.tedu;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class JsonAction {
  private String name;
  private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String execute(){
		age = 18;
		name = "chen";
		return "success";
	}
	public String doJson(){
		age=19;
		return "success";
	}
}
