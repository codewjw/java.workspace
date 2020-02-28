package cn.tedu;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype") //表示每一个请求，都但都创建一个Action处理，解决安全性问题，但会出现方法或类重复，占内存
public class HelloAction {
    /*注入*/
	@Resource(name="demoService")
    private DemoService service;
	
	public String doHello(){
		System.out.println("hello");
		service.hello();
		return "success";
	}
}
