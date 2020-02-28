package reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("����������");
		String className = scan.nextLine();
		try {
			//��̬������
			Class cls = Class.forName(className); //��ȡ��
			System.out.println(cls); 
			System.out.println(cls.getName()); //��ȡ����������(������)
			//��̬������������ķ�����Ϣ
			Method[] methods = cls.getDeclaredMethods();
			//��̬��ȡ��������Ϣ
			Constructor[] cs =  cls.getDeclaredConstructors();
			for(Method m:methods){
				System.out.println(m);
			}
			for(Constructor c:cs){
				System.out.println(c);
			}
			System.out.println("���뷽����");
			String name = scan.nextLine();
			//��̬�ҵ�һ������
			Method m = cls.getDeclaredMethod(name);
			//��̬��������
			Object obj = cls.newInstance();
			//��ִ̬�з���
			m.invoke(obj);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
      }
}
