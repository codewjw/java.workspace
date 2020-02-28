import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlDemo {

	public static void main(String[] args) {
		/*
		 * 读取emlList文件，将XML文档中的所有员工信息解析出来，并
		 * 以若干Emp实例保存，然后将这些员工信息存入到一个List集合中
		 */
	     
		/*
		 * 使用DOM解析XML的大致流程：
		 * 1.创建SAXReader
		 * 2.使用SAXReader读取要解析的XML文档，该步骤就是DOM耗时耗资原的地方
		 * 因为会将文档所有内容解析完毕并存入到内存中。
		 * 读取方法会返回一个Document对象，该对象表示解析出来的该XML文档内容
		 * 3.通过Document对象获取根元素（根标签）
		 * 4.根据文档的结构，从根元素开始逐级获取子元素，以达到遍历XML文档数据的目的
		 */
		try {
			
			SAXReader saxr = new SAXReader();
			
			Document doc = saxr.read(new FileInputStream("src"+File.separator+
					"main"+File.separator+
					"resources"+File.separator+ "empList.xml"));
			/*
			 * 3获取根元素
			 * Element的每一个实例用于表示XML文档中的一个元素（一对标签）
			 * 它提供了很多用于操作当前标签的方法，其中常用的用于获取标签信息
			 * 的方法有：
			 * String getName()
			 * 获取标签名
			 * 
			 * Element element(String name)
			 * 根据给定名字获取当前标签中的子标签
			 * List elements()
			 * 获取当前标签中的所有子标签，返回的集合中是若干的Element实例
			 * 每个为一个子元素
			 * 
			 * List elements(String name)
			 * 获取当前标签中所有同名子元素
			 * 
			 * String getText()
			 * 获取当前标签中间的文本
			 * 
			 * Attribute attribute(String name)
			 * 获取当前标签中指定名字的属性
			 */
			Element root = doc.getRootElement();
			List<Emp> emps = new ArrayList<Emp>();
			//获取根元素下的所有子元素
			List<Element> elements = root.elements();
	
			/*
			 * 将每一个<emp>标签中的内容取到，并以一个Emp实例保存，
			 * 并添加到集合中
			 */
			Emp emp = null;
			for(Element ele : elements){
				/*System.out.println(ele.getName());*/
				Element nameEle = ele.element("name");
				String name = nameEle.getText();
				Element ageEle = ele.element("age");
				int age = Integer.parseInt(ageEle.getText());
				String gender = ele.elementText("gender");
				int salary = Integer.parseInt(ele.elementText("salary"));
				Attribute attr = ele.attribute("id");
				int id = Integer.parseInt(attr.getValue());
				emp = new Emp(id,name,age,gender,salary);
				emps.add(emp);
			}
			for(Emp em:emps){
				System.out.println(em);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
