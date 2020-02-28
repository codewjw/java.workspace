package cn.tedu;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype") //��ʾÿһ�����󣬶���������һ��Action���������ȫ�����⣬������ַ��������ظ���ռ�ڴ�
public class HelloAction {
    /*ע��*/
	@Resource(name="demoService")
    private DemoService service;
	
	public String doHello(){
		System.out.println("hello");
		service.hello();
		return "success";
	}
}
