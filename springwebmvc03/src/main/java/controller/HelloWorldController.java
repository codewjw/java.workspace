package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    
	@RequestMapping("/hello.do")
	public String hello(){
	    System.out.println("hello()");
		return "hello";
	}
	@RequestMapping("/demo/test/hello2.do")
	public String hello2(){
	    System.out.println("hello2()");
		return "hello";
	}
}
