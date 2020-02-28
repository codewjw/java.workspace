package reflectdemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Junit3 {

	public static void main(String[] args) {
		System.out.println("����������");
		Scanner scan = new Scanner(System.in);
		String className  = scan.nextLine();
		try {
			Class cls = Class.forName(className);
			Method[] methods = cls.getDeclaredMethods();
			Object obj = cls.newInstance();
			for(Method m:methods){
				if(m.getName().startsWith("test")){//��ȡ���������Ƚ�\
					//����˽�з��������ԵĿɷ����ԣ��ƻ���װ
					m.setAccessible(true);
					//��̬���÷���
					m.invoke(obj);
					//���е�ע�ⶼ���÷������ʵ�ֵ�
					Annotation[] anntions = m.getAnnotations();
					//Annotion annotion = m.getAnnotation(annotationClass)
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
