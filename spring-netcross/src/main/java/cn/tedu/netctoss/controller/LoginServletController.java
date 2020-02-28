package cn.tedu.netctoss.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.netctoss.entity.Admin;
import cn.tedu.netctoss.service.ApplicationException;
import cn.tedu.netctoss.service.LoginService;
import cn.tedu.netctoss.util.ImageUtil;

@Controller
public class LoginServletController {
	  @Resource(name="loginService")
      private  LoginService ls;
	  
	  //spring��ܴ����쳣
	  @ExceptionHandler
	  public String handlerEx(Exception e,HttpServletRequest req){
		   //e.printStackTrace();
		   if(e instanceof ApplicationException){
			   //Ӧ���쳣Ҫ��ȷ��ʾ�û�
			   /*
			    * getMessage()�����̳���RuntimeException����
			    * �����ǻ�ȡ�쳣������Ϣ
			    */
			   req.setAttribute("error", e.getMessage());
			   return "login";
		   }
		   //ϵͳ�쳣����ʾ�û��Ժ�����
			return "error";
	  }
	  
	   @RequestMapping("toLogin.do")
	   public String toLogin(){
		   System.out.println("toLogin()");
		   return "login";
	   }
	   
	   @RequestMapping("login.do")
	   public String Login(HttpServletRequest req,HttpSession session){ 
		   String adminCode = req.getParameter("adminCode");
		   String pwd = req.getParameter("passwd");
		   //��ȡ��֤��
		   String sessionCode = (String) session.getAttribute("checkcode");
		   String reqCode = req.getParameter("imgcode");
		   Admin admin = null;
		   admin = ls.checkLogin(adminCode, pwd,sessionCode,reqCode);
		   //��¼�ɹ���������Ա����󶨵�session��������
		   session.setAttribute("admin", admin);
		return "redirect:toIndex.do";
		   
	   }
	   
	   @RequestMapping("toIndex.do")
	   public String toIndex(){
		   return "index";
	   }
	   
	   //������֤��ͼƬ
	   @RequestMapping("/createImg.do")
	   public void checkcode(HttpServletResponse res,
			   HttpSession session) throws IOException{
		   Object[] objs = ImageUtil.createImage();
		   //��ȡ��֤��ͼƬ
		   BufferedImage img =  (BufferedImage) objs[1];
		   //����֤���ֵ����session��
		   session.setAttribute("checkcode", objs[0]);
		   //����֤��ͼƬ���͸������
		   //ͼƬ�������ֽ�����������Բ������ַ����������PrintWriter
		   OutputStream os = res.getOutputStream();
		   /*
		    * ����1ΪͼƬ����
		    * ����2ΪͼƬ�����ʽ
		    * ����3ָ���ֽ������
		    */
		   javax.imageio.ImageIO.write(img,"jpeg",os);
		   os.close();
	   }
}
