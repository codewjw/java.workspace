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
 * 	����ʵ��Controller�ӿ�
 * �ҷ���������Ҫ�󣬷���ֵ������ModelAndView,Ҳ������String
 * ������Ӷ������
 * ʹ��@Controllerע�⣬��ʾ�����¿������࣬�൱�ڼ̳���Controller�ӿ�
 * �����ڷ���ǰ������ǰ���@RequestMapping(�൱��HandlerMapping����)
 * @Controller���ɨ�裬��ʾ�����¿�������
 * @RequestMapping("/demo")������ǰ����ʾ���ʴ˿�����,����д·��/demo
 * @RequestMapping("/hello.do")���ڷ���ǰ��ʾ����÷�������д·��/hello.do
 * ��ͷ������ӵĻ������յ������·��Ϊ https://ip:port/springwebmvc02/demo/hello.do
 * Ҳ��ֻ�ڷ����ϼ�
 */
@Controller
@RequestMapping("/demo") 
public class HelloController {
    
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello");
		//������ͼ��
		return "hello";
	}
	
	@RequestMapping("/tologin.do")
	public String tologin(){
		System.out.println("tologin()");
		return "login";
	}
	/*
	 * DispatcherServlet(ǰ�˿�����)�ڵ��ô���������֮ǰ��
	 * ������java������Ʒ��������Ľṹ������˴���ͨ��������
	 * �Ὣrequest���󴫹���(�˽�)��
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
	 * ǰ�˿�����DispatcherServlet���÷���ǰ��������java������ƣ����������Ľṹ
	 * ����˴��������request����ķ������Ȼ�ò���ֵ���ٸ�ֵ����Ӧ�Ĳ�����
	 * ���������һ�£�Ҫ��@RequestParamע��ָ��
	 * һ�£��������ֺ�ǰ�˿ؼ�name��ֵ��ͬ������Ҫƥ��(ǰ�˿������ὫĳЩ��ƥ���ת����
	 * ��ǰ�˴����ַ������֣����Զ�ת�����ͻ�Double��(ת���������ڻ�������))
	 * ����ֱ�Ӹ�ֵ
	 * �˷����������ˣ���Ȼ���ô��� 
	 */
	@RequestMapping("/login2.do")
	public String login2(String username,
			@RequestParam("passwd") String pwd){
		System.out.println("login2()");
		System.out.println(username+","+pwd);
		return "index";
	}
	/*
	 * ��bean��װǰ�����ݣ��ڴ���
	 */
	@RequestMapping("/login3.do")
	public String login3(User user){
		System.out.println("login3()");
		System.out.println(user.getUsername()+","+user.getPasswd()+","+user.getAge());
		return "index";
	}
	
	/*
	 * ��ֵת����ҳ��,����ע��requestת������ҳ�湲��һ��request��������
	 */
	@RequestMapping("/login4.do")
	public String login4(User user,HttpServletRequest req){
		System.out.println("login4()");
		System.out.println(user.getUsername()+","+user.getPasswd()+","+user.getAge());
		//������ע��requset
		req.setAttribute("user", user);
		//ת��
		//Ĭ������£�ǰ�˿�����(DispatcherServlet)��ʹ��ת��
		return "index";
	}
	
	/*
	 * ��ֵת����ҳ��
	 */
	@RequestMapping("/login5.do")
	public ModelAndView login5(User user){
		System.out.println("login5()");
		System.out.println(user.getUsername()+","+user.getPasswd()+","+user.getAge());
		
		//ֱ�ӽ����ݰ󶨵�Map�ϣ��󶨶��󣬻������Ͷ��С��������Ͷ���
		Map<String,User> data = new HashMap<String,User>();
		data.put("user", user);
		//Ĭ������£�ǰ�˿�����(DispatcherServlet)��ʹ��ת��
		return  new ModelAndView("index",data);
	}
	
	@RequestMapping("/login6.do")
	public String login6(User user,ModelMap mm){
		System.out.println("login6()");
		System.out.println(user.getUsername()+","+user.getPasswd()+","+user.getAge());
		
		//�����ݰ󶨵�ModelMap��,�൱��ִ��request.setAttribute("user",user);
		//�����󡢻������Ͷ��С��������Ͷ���
		mm.addAttribute("user", user);
		//Ĭ������£�ǰ�˿�����(DispatcherServlet)��ʹ��ת��
		return  "index";
	}
	
	//Session��ֵ
	@RequestMapping("/login7.do")
	public String login7(User user,HttpSession session){
		System.out.println("login7()");
		System.out.println(user.getUsername()+","+user.getPasswd()+","+user.getAge());
		
		session.setAttribute("user", user);
		//Ĭ������£�ǰ�˿�����(DispatcherServlet)��ʹ��ת��
		return  "index";
	}
	
	//�ض���
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
	
	    //�ض���,
		@RequestMapping("/login9.do")
		public ModelAndView login9(User user,HttpSession session){
			System.out.println("login9()");
			session.setAttribute("user", user);
			RedirectView rv = new RedirectView("toIndex.do");
			return new ModelAndView(rv);
		}
}
