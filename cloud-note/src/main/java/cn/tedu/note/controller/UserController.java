package cn.tedu.note.controller;



import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.note.entity.User;
import cn.tedu.note.service.PasswordException;
import cn.tedu.note.service.UserHadExistException;
import cn.tedu.note.service.UserNotFoundException;
import cn.tedu.note.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractExceptionController{
	
	   @Resource(name="userService")
	   private UserService us;
	
	   @RequestMapping("/login.do")
	   @ResponseBody
	   public JsonResult Login(HttpServletRequest req,HttpSession session) {
		    String userName = req.getParameter("userName");
		    String passwd = req.getParameter("passwd");
		    User user = us.Login(userName, passwd);
		    //注入用户
		    session.setAttribute("user", user);
			return new JsonResult(user);	
		}
	    
	   @RequestMapping("/regist.do")
	   @ResponseBody
	   public JsonResult regist(String name,String passwd,String confirm,String nick){
		   User user = us.regist(name, passwd, confirm, nick);
		   return new JsonResult(user);
	   }
	     
	     /*
	       * spring框架处理异常
	       * 在其他控制器方法执行出异常的时候，执行异常处理方法
	       * @ExceptionHandler注解指定异常处理方法
	       */
		  @ExceptionHandler(UserNotFoundException.class)
		  @ResponseBody
		  public JsonResult handlerUserNotFoundEx(UserNotFoundException e){
			  e.printStackTrace();
			  return new JsonResult(2,e);
		  }
		  
		  @ExceptionHandler(PasswordException.class)
		  @ResponseBody
		  public JsonResult handlerPasswordEx(PasswordException e){
			  e.printStackTrace();
			  return new JsonResult(3,e);
		  }
		  
		  @ExceptionHandler(UserHadExistException.class)
		  @ResponseBody
		  public JsonResult handlerUserHadExistEx(UserHadExistException e){
			  e.printStackTrace();
			  return new JsonResult(4,e);
		  }
	
		  /*
		   * @ResponseBody注解会自动处理控制返回值
		   * 1.如果返回值是JavaBean(数组，集合)，封装成json返回
		   * 2.如果是byte数字，则将byte数组直接装入响应消息的body中
		   * 
		   * produces="image/png"用于设置content-type
		   */
		  @RequestMapping(value="/image.do",produces="image/png")
		  @ResponseBody
		  public byte[] image() throws IOException{
			  return createPng();
		  }
		  
		  /*
		   * 表示是保存文件
		   * produces="application/octet-stream"
		   */
		  @RequestMapping(value="/getImg.do",produces="application/octet-stream")
		  @ResponseBody
		  public byte[] getImage(HttpServletResponse res) 
				  throws IOException{
			  //参考：19.5.1 Contenet-Disposition
			  //设置协议头,设置下载的文件名及协议
			  //Content-Disposition:attachment;filename="demo.png"
			  res.setHeader("Content-Disposition", 
					  "attachment;filename=\"demo.png\"");
			  return createPng();
		  }
		  
		  @RequestMapping(value="/execl.do",produces="application/octet-stream")
		  @ResponseBody
		  public byte[] downloadExcel(HttpServletResponse res) 
				  throws IOException{
			  //参考：19.5.1 Contenet-Disposition
			  //设置协议头,设置下载的文件名及协议
			  //Content-Disposition:attachment;filename="demo.png"
			  res.setHeader("Content-Disposition", 
					  "attachment;filename=\"demo.xls\"");
			  return createExcel();
		  }
		  
		  /*
		   * 文件上载
		   */
		  @RequestMapping(value="/updaload.do")
		  @ResponseBody
		  public JsonResult upload(MultipartFile userfile1,
				  MultipartFile userfile2) 
			throws IllegalStateException, IOException {
			  //springMVC中可利用MultipartFile接收上载文件
			  //文件中的一切数据都可以从MultipartFile对象中找到
			  //获取上载的原始文件名
			  String file1 = userfile1.getOriginalFilename();
			  String file2 = userfile2.getOriginalFilename();
			  /*
			   * 保存上传文件的三种方法
			   * 1.userfile1.transferTo(目标文件)，可以处理大文件,将文件直接保存到目标文件
			   * 2.userfile1.getBytes()获取文件的全部数据，适合处理小文件，大了效率较低
			   * 它会将全部文件读取到内存！
			   * 3.userfile1.getInputStream()，获取上载的流，适合处理大文件
			   */
			  
			  File dir = new File("D:/demo");
			  dir.mkdir();
			  File f1 = new File(dir,file1);
			  File f2 = new File(dir,file2);
			  //第一种保存方式
			  //userfile1.transferTo(f1);
			  //userfile2.transferTo(f2);
			  //第二种保存方式
			  //userfile1.getBytes();
			  //第三种保存方式
			  InputStream in1 = userfile1.getInputStream();
			  InputStream in2 = userfile2.getInputStream();
			  FileOutputStream out1 = new FileOutputStream(f1);
			  FileOutputStream out2 = new FileOutputStream(f2);
			  byte[] buf = new byte[8*1024];
			  int b;
			  while((b=in1.read(buf))!=-1){
				  out1.write(buf, 0, b);
			  }
			  while((b=in2.read())!=-1){
				  out2.write(b);
			  }
			  in1.close();
			  out1.close();
			  in2.close();
			  out2.close();
			  return new JsonResult(true);
		  }
		  
		   /**
			 * 创建一个图片，并且编码为png格式
			 * @return
			 * @throws IOException 
			 */
			private byte[] createPng() throws IOException{
				BufferedImage img = new BufferedImage(200,80,BufferedImage.TYPE_3BYTE_BGR);
				//对图片绘制内容
				img.setRGB(100, 40, 0xffffff);
				//将图片编码为png
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				ImageIO.write(img, "png", out);
				out.close();
				byte[] png = out.toByteArray();
				return png;
			}
			
			/*
			 * 创建Excel
			 */
			private byte[] createExcel() throws IOException{
				//创建工作簿
				HSSFWorkbook workbook = new HSSFWorkbook();
				//创建工作表
				HSSFSheet sheet =workbook.createSheet();
				
				for(int i=0;i<2;i++){
				    //创建行
					HSSFRow row = sheet.createRow(i);
					for(int j=0;j<2;j++){
					   //创建列
						HSSFCell cell = row.createCell(j);
						//设定列的值
					    cell.setCellValue("Hello World!"+i+","+j);
					}
				}
				//将Excel文件保存为byte数组，流中
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				workbook.write(out);
				out.close();
				return out.toByteArray();
			}
}
