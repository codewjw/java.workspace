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
 * д��XML�ĵ�
 * @author Administrator
 *
 */
public class WriteXMLDemo {
	  public static void main(String[] args) {
		 List<Emp> list = new ArrayList<Emp>();
		 list.add(new Emp(1,"����",25,"��",5000));
		 list.add(new Emp(1,"����",26,"��",8000));
		 list.add(new Emp(1,"����",20,"��",7000));
		 list.add(new Emp(1,"����",19,"��",10000));
		 list.add(new Emp(1,"����",25,"��",6000));
		 list.add(new Emp(1,"Ǯ��",75,"��",6000));
		 list.add(new Emp(1,"����",55,"��",5000));
		 list.add(new Emp(1,"����",36,"��",3000));
		/*
		 * д��XML�ĵ��Ĵ��²��裺
		 * 1�������հ��ĵ�����Document
		 * 2������ĵ�����Ӹ�Ԫ��
		 * 3������Ԥ����XML�ĵ��ṹ�Ӹ�Ԫ�ؿ�ʼ���������Ԫ�أ�����ɸýṹ
		 * 4������XMLWriter
		 * 5����Document����д��XML�ĵ�
		 * 6��XMLWrite�ر�
		 */
		 
		 /*
		  * 1����һ��Document����
		  */
		 Document doc = DocumentHelper.createDocument();
		 
		 /*
		  * Element addElement(String name)
		  * Document�ṩ�ĸ÷�����������ǰ�ĵ�����Ӹ������ֵĸ�Ԫ��
		  * ��������һ��Elementʵ�����أ��Ա��ڼ����Ըø�Ԫ�ز���
		  * ��Ҫע�⣬�÷���ֵֻ�ܵ���һ�Σ���Ϊһ��Document�ĵ���ֻ��һ����Ԫ��
		  */
		 
		 Element root = doc.addElement("list");
		 for(Emp emp : list){
			 /*
			  * Element addElement(String)
			  * ���ǩ����ӱ�ǩ������һ��Element
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
			  * �������
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
		 System.out.println("д�����");
	}
}
