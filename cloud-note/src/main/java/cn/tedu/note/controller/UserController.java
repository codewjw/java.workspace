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
		    //ע���û�
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
	       * spring��ܴ����쳣
	       * ����������������ִ�г��쳣��ʱ��ִ���쳣������
	       * @ExceptionHandlerע��ָ���쳣������
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
		   * @ResponseBodyע����Զ�������Ʒ���ֵ
		   * 1.�������ֵ��JavaBean(���飬����)����װ��json����
		   * 2.�����byte���֣���byte����ֱ��װ����Ӧ��Ϣ��body��
		   * 
		   * produces="image/png"��������content-type
		   */
		  @RequestMapping(value="/image.do",produces="image/png")
		  @ResponseBody
		  public byte[] image() throws IOException{
			  return createPng();
		  }
		  
		  /*
		   * ��ʾ�Ǳ����ļ�
		   * produces="application/octet-stream"
		   */
		  @RequestMapping(value="/getImg.do",produces="application/octet-stream")
		  @ResponseBody
		  public byte[] getImage(HttpServletResponse res) 
				  throws IOException{
			  //�ο���19.5.1 Contenet-Disposition
			  //����Э��ͷ,�������ص��ļ�����Э��
			  //Content-Disposition:attachment;filename="demo.png"
			  res.setHeader("Content-Disposition", 
					  "attachment;filename=\"demo.png\"");
			  return createPng();
		  }
		  
		  @RequestMapping(value="/execl.do",produces="application/octet-stream")
		  @ResponseBody
		  public byte[] downloadExcel(HttpServletResponse res) 
				  throws IOException{
			  //�ο���19.5.1 Contenet-Disposition
			  //����Э��ͷ,�������ص��ļ�����Э��
			  //Content-Disposition:attachment;filename="demo.png"
			  res.setHeader("Content-Disposition", 
					  "attachment;filename=\"demo.xls\"");
			  return createExcel();
		  }
		  
		  /*
		   * �ļ�����
		   */
		  @RequestMapping(value="/updaload.do")
		  @ResponseBody
		  public JsonResult upload(MultipartFile userfile1,
				  MultipartFile userfile2) 
			throws IllegalStateException, IOException {
			  //springMVC�п�����MultipartFile���������ļ�
			  //�ļ��е�һ�����ݶ����Դ�MultipartFile�������ҵ�
			  //��ȡ���ص�ԭʼ�ļ���
			  String file1 = userfile1.getOriginalFilename();
			  String file2 = userfile2.getOriginalFilename();
			  /*
			   * �����ϴ��ļ������ַ���
			   * 1.userfile1.transferTo(Ŀ���ļ�)�����Դ�����ļ�,���ļ�ֱ�ӱ��浽Ŀ���ļ�
			   * 2.userfile1.getBytes()��ȡ�ļ���ȫ�����ݣ��ʺϴ���С�ļ�������Ч�ʽϵ�
			   * ���Ὣȫ���ļ���ȡ���ڴ棡
			   * 3.userfile1.getInputStream()����ȡ���ص������ʺϴ�����ļ�
			   */
			  
			  File dir = new File("D:/demo");
			  dir.mkdir();
			  File f1 = new File(dir,file1);
			  File f2 = new File(dir,file2);
			  //��һ�ֱ��淽ʽ
			  //userfile1.transferTo(f1);
			  //userfile2.transferTo(f2);
			  //�ڶ��ֱ��淽ʽ
			  //userfile1.getBytes();
			  //�����ֱ��淽ʽ
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
			 * ����һ��ͼƬ�����ұ���Ϊpng��ʽ
			 * @return
			 * @throws IOException 
			 */
			private byte[] createPng() throws IOException{
				BufferedImage img = new BufferedImage(200,80,BufferedImage.TYPE_3BYTE_BGR);
				//��ͼƬ��������
				img.setRGB(100, 40, 0xffffff);
				//��ͼƬ����Ϊpng
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				ImageIO.write(img, "png", out);
				out.close();
				byte[] png = out.toByteArray();
				return png;
			}
			
			/*
			 * ����Excel
			 */
			private byte[] createExcel() throws IOException{
				//����������
				HSSFWorkbook workbook = new HSSFWorkbook();
				//����������
				HSSFSheet sheet =workbook.createSheet();
				
				for(int i=0;i<2;i++){
				    //������
					HSSFRow row = sheet.createRow(i);
					for(int j=0;j<2;j++){
					   //������
						HSSFCell cell = row.createCell(j);
						//�趨�е�ֵ
					    cell.setCellValue("Hello World!"+i+","+j);
					}
				}
				//��Excel�ļ�����Ϊbyte���飬����
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				workbook.write(out);
				out.close();
				return out.toByteArray();
			}
}
