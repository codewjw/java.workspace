package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/*
 * 	不必实现Controller接口
 * 且方法名不做要求，返回值可以是ModelAndView,也可以是String
 * 可以添加多个方法
 * 使用@Controller注解，表示此类事控制器类，相当于继承了Controller接口
 * 可以在方法前或者类前添加@RequestMapping(相当于HandlerMapping作用)
 * @Controller组件扫描，表示此类事控制器类
 * @RequestMapping("/demo")加在类前，表示访问此控制类,必须写路径/demo
 * @RequestMapping("/hello.do")加在方法前表示请求该方法必须写路径/hello.do
 * 类和方法都加的话，最终的请求的路径为 https://ip:port/springwebmvc02/demo/hello.do
 * 也可只在方法上加
 */
@Controller
@RequestMapping("/demo") 
public class HelloController {
    
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello");
		//返回视图名
		return "hello";
	}
	
	@RequestMapping("/tologin.do")
	public String tologin(){
		System.out.println("tologin()");
		return "login";
	}
	/*
	 * DispatcherServlet(前端控制器)在调用处理器方法之前，
	 * 会利用java反射机制分析方法的结构，比如此处，通过分析，
	 * 会将request对象传过来(了解)。
	 */
	@RequestMapping("/login.do")
	public String login(HttpServletRequest req,
			HttpServletResponse res){
		System.out.println("login()");
		String user = req.getParameter("username");
		String passwd = req.getParameter("passwd");
		System.out.println(user+","+passwd);
		return "index";
	}
	
	/*
	 * 前端控制器DispatcherServlet调用方法前，会利用java反射机制，分析方法的结构
	 * 比如此处，会调用request对象的方法，先获得参数值，再赋值给对应的参数，
	 * 如果参数不一致，要用@RequestParam注解指名
	 * 一致（参数名字和前端控件name的值相同，类型要匹配(前端控制器会将某些不匹配的转换，
	 * 如前端传的字符串数字，将自动转成整型或Double型(转换仅仅限于基本类型))
	 * ），直接赋值
	 * 此方法参数多了，仍然不好处理 
	 */
	@RequestMapping("/login2.do")
	public String login2(String username,
			@RequestParam("passwd") String pwd){
		System.out.println("login2()");
		System.out.println(username+","+pwd);
		return "index";
	}
	/*
	 * 用bean封装前端数据，在传参
	 */
	@RequestMapping("/login3.do")
	public String login3(User user){
		System.out.println("login3()");
		System.out.println(user.getUsername()+","+user.getPasswd()+","+user.getAge());
		return "index";
	}
	
	/*
	 * 将值转发给页面,数据注入request转发，量页面共享一个request对象数据
	 */
	@RequestMapping("/login4.do")
	public String login4(User user,HttpServletRequest req){
		System.out.println("login4()");
		System.out.println(user.getUsername()+","+user.getPasswd()+","+user.getAge());
		//将数据注入requset
		req.setAttribute("user", user);
		//转发
		//默认情况下，前端控制器(DispatcherServlet)会使用转发
		return "index";
	}
	
	/*
	 * 将值转发给页面
	 */
	@RequestMapping("/login5.do")
	public ModelAndView login5(User user){
		System.out.println("login5()");
		System.out.println(user.getUsername()+","+user.getPasswd()+","+user.getAge());
		
		//直接将数据绑定到Map上，绑定对象，基本类型读行、集合类型都行
		Map<String,User> data = new HashMap<String,User>();
		data.put("user", user);
		//默认情况下，前端控制器(DispatcherServlet)会使用转发
		return  new ModelAndView("index",data);
	}
	
	@RequestMapping("/login6.do")
	public String login6(User user,ModelMap mm){
		System.out.println("login6()");
		System.out.println(user.getUsername()+","+user.getPasswd()+","+user.getAge());
		
		//将数据绑定到ModelMap上,相当于执行request.setAttribute("user",user);
		//传对象、基本类型都行、集合类型都行
		mm.addAttribute("user", user);
		//默认情况下，前端控制器(DispatcherServlet)会使用转发
		return  "index";
	}
	
	//Session传值
	@RequestMapping("/login7.do")
	public String login7(User user,HttpSession session){
		System.out.println("login7()");
		System.out.println(user.getUsername()+","+user.getPasswd()+","+user.getAge());
		
		session.setAttribute("user", user);
		//默认情况下，前端控制器(DispatcherServlet)会使用转发
		return  "index";
	}
	
	//重定向
	@RequestMapping("/login8.do")
	public String login8(User user,HttpSession session){
		System.out.println("login8()");
		session.setAttribute("user", user);
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
	
	    //重定向,
		@RequestMapping("/login9.do")
		public ModelAndView login9(User user,HttpSession session){
			System.out.println("login9()");
			session.setAttribute("user", user);
			RedirectView rv = new RedirectView("toIndex.do");
			return new ModelAndView(rv);
		}
}
