import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 写出XML文档
 * @author Administrator
 *
 */
public class WriteXMLDemo {
	  public static void main(String[] args) {
		 List<Emp> list = new ArrayList<Emp>();
		 list.add(new Emp(1,"张三",25,"男",5000));
		 list.add(new Emp(1,"李四",26,"男",8000));
		 list.add(new Emp(1,"王五",20,"男",7000));
		 list.add(new Emp(1,"赵六",19,"男",10000));
		 list.add(new Emp(1,"陈七",25,"男",6000));
		 list.add(new Emp(1,"钱三",75,"男",6000));
		 list.add(new Emp(1,"寇老",55,"男",5000));
		 list.add(new Emp(1,"刘八",36,"男",3000));
		/*
		 * 写出XML文档的大致步骤：
		 * 1：创建空白文档对象Document
		 * 2：向该文档中添加根元素
		 * 3：按照预定的XML文档结构从根元素开始，逐级添加子元素，已完成该结构
		 * 4：创建XMLWriter
		 * 5：将Document对象写成XML文档
		 * 6将XMLWrite关闭
		 */
		 
		 /*
		  * 1创建一个Document对象
		  */
		 Document doc = DocumentHelper.createDocument();
		 
		 /*
		  * Element addElement(String name)
		  * Document提供的该方法是用来向当前文档中添加给定名字的根元素
		  * 并将其以一个Element实例返回，以便于继续对该根元素操作
		  * 需要注意，该方法值只能调用一次，因为一个Document文档中只有一个根元素
		  */
		 
		 Element root = doc.addElement("list");
		 for(Emp emp : list){
			 /*
			  * Element addElement(String)
			  * 向标签中添加标签，返回一个Element
			  */
			 Element empEle = root.addElement("emp");
	
			 Element nameEle = empEle.addElement("name");
			 nameEle.addText(emp.getName());
			 
			 Element ageEle = empEle.addElement("age");
			 ageEle.addText(String.valueOf(emp.getAge()));
			 
			 Element genderEle = empEle.addElement("gender");
			 genderEle.addText(emp.getGender());
			 
			/* Element salaryEle = empEle.addElement("salary");
			 salaryEle.addText(String.valueOf(emp.getSalary()));*/
			 empEle.addElement("salary").addText(String.valueOf(emp.getSalary()));
			 /*
			  * 添加属性
			  */
			 Element idEle = empEle.addAttribute("id", String.valueOf(emp.getId()));
			 XMLWriter xmlwrite = null;
			 try{
			  xmlwrite = new XMLWriter(new FileOutputStream("src"+File.separator+
						"main"+File.separator+
						"resources"+File.separator+ "myTest.xml"),OutputFormat.createPrettyPrint());
			  xmlwrite.write(doc);
			 }catch(Exception e){ 
				 e.printStackTrace();
			 }
			 finally {
				 if(xmlwrite!=null){
					 try{
				       xmlwrite.close();
					 }catch(Exception ex){
						 ex.printStackTrace();
					 }
				 }
			 }
		 }
		 System.out.println("写出完毕");
	}
}
