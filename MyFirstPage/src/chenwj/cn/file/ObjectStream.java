package chenwj.cn.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectStream obs = new ObjectStream();
	    //obs.objectOutputStream();
		obs.objectInputStream();
	}
    
	public void objectOutputStream() throws IOException{
	    String name = "陈文杰";
	    int age = 30;
	    String sex = "男";
	    List<String> list = new ArrayList<String>();
	    list.add("陈老师是个诗人");
	    list.add("陈老师热爱祖国");
	    list.add("陈老师个性坦然");
	    list.add("陈老师不善管理");
		Person person = new Person(name,age,sex,list);
		
		FileOutputStream fos = new FileOutputStream("chenwj.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		/*
		 * 对象输出流提供了一个专门用于写java对象的方法：
		 * void writeObject(Object obj)
		 * 该方法将给定的对象中的所有的内容转换为一组字节后写出
		 * writeObject() 方法要求写出的对象所属类必须实现
		 * 可序列化接口:java.util.Serializable
		 * 将对象写入文件中经历了两个操作：
		 * 1：先将给定对象转换为一组字节 ----对象序列化
		 * 2：再将这组字节写入到文件中 ----数据持久化
		 * 
		 */
		oos.writeObject(person);
		System.out.println("写出完毕！");
		oos.close();
	}
	
	public void objectInputStream() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("chenwj.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		/*
		 * 将一组字节还原为对象的过程称为：对象反序列化
		 */
		Person person = (Person) ois.readObject();
		System.out.println(person);
		ois.close();
	}
}
