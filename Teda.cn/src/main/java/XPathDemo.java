import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XPathDemo {
    public static void main(String[] args) {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new FileInputStream("src"+File.separator+
					"main"+File.separator+
					"resources"+File.separator+ "myEmp.xml"));
			String xpath = "/list/emp[gender='Å®']/salary";
			xpath = "/list/emp[salary>=8000 and gender='ÄÐ']/name";
			List<Element> list = doc.selectNodes(xpath);
			for(Element e : list){
				System.out.println(e.getText());
			}
		} catch (Exception e) {
		}
	}
}
