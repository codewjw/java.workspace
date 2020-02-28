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
	    String name = "���Ľ�";
	    int age = 30;
	    String sex = "��";
	    List<String> list = new ArrayList<String>();
	    list.add("����ʦ�Ǹ�ʫ��");
	    list.add("����ʦ�Ȱ����");
	    list.add("����ʦ����̹Ȼ");
	    list.add("����ʦ���ƹ���");
		Person person = new Person(name,age,sex,list);
		
		FileOutputStream fos = new FileOutputStream("chenwj.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		/*
		 * ����������ṩ��һ��ר������дjava����ķ�����
		 * void writeObject(Object obj)
		 * �÷����������Ķ����е����е�����ת��Ϊһ���ֽں�д��
		 * writeObject() ����Ҫ��д���Ķ������������ʵ��
		 * �����л��ӿ�:java.util.Serializable
		 * ������д���ļ��о���������������
		 * 1���Ƚ���������ת��Ϊһ���ֽ� ----�������л�
		 * 2���ٽ������ֽ�д�뵽�ļ��� ----���ݳ־û�
		 * 
		 */
		oos.writeObject(person);
		System.out.println("д����ϣ�");
		oos.close();
	}
	
	public void objectInputStream() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("chenwj.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		/*
		 * ��һ���ֽڻ�ԭΪ����Ĺ��̳�Ϊ���������л�
		 */
		Person person = (Person) ois.readObject();
		System.out.println(person);
		ois.close();
	}
}
