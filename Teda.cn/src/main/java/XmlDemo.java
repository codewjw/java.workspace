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
		 * ��ȡemlList�ļ�����XML�ĵ��е�����Ա����Ϣ������������
		 * ������Empʵ�����棬Ȼ����ЩԱ����Ϣ���뵽һ��List������
		 */
	     
		/*
		 * ʹ��DOM����XML�Ĵ������̣�
		 * 1.����SAXReader
		 * 2.ʹ��SAXReader��ȡҪ������XML�ĵ����ò������DOM��ʱ����ԭ�ĵط�
		 * ��Ϊ�Ὣ�ĵ��������ݽ�����ϲ����뵽�ڴ��С�
		 * ��ȡ�����᷵��һ��Document���󣬸ö����ʾ���������ĸ�XML�ĵ�����
		 * 3.ͨ��Document�����ȡ��Ԫ�أ�����ǩ��
		 * 4.�����ĵ��Ľṹ���Ӹ�Ԫ�ؿ�ʼ�𼶻�ȡ��Ԫ�أ��Դﵽ����XML�ĵ����ݵ�Ŀ��
		 */
		try {
			
			SAXReader saxr = new SAXReader();
			
			Document doc = saxr.read(new FileInputStream("src"+File.separator+
					"main"+File.separator+
					"resources"+File.separator+ "empList.xml"));
			/*
			 * 3��ȡ��Ԫ��
			 * Element��ÿһ��ʵ�����ڱ�ʾXML�ĵ��е�һ��Ԫ�أ�һ�Ա�ǩ��
			 * ���ṩ�˺ܶ����ڲ�����ǰ��ǩ�ķ��������г��õ����ڻ�ȡ��ǩ��Ϣ
			 * �ķ����У�
			 * String getName()
			 * ��ȡ��ǩ��
			 * 
			 * Element element(String name)
			 * ���ݸ������ֻ�ȡ��ǰ��ǩ�е��ӱ�ǩ
			 * List elements()
			 * ��ȡ��ǰ��ǩ�е������ӱ�ǩ�����صļ����������ɵ�Elementʵ��
			 * ÿ��Ϊһ����Ԫ��
			 * 
			 * List elements(String name)
			 * ��ȡ��ǰ��ǩ������ͬ����Ԫ��
			 * 
			 * String getText()
			 * ��ȡ��ǰ��ǩ�м���ı�
			 * 
			 * Attribute attribute(String name)
			 * ��ȡ��ǰ��ǩ��ָ�����ֵ�����
			 */
			Element root = doc.getRootElement();
			List<Emp> emps = new ArrayList<Emp>();
			//��ȡ��Ԫ���µ�������Ԫ��
			List<Element> elements = root.elements();
	
			/*
			 * ��ÿһ��<emp>��ǩ�е�����ȡ��������һ��Empʵ�����棬
			 * ����ӵ�������
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
