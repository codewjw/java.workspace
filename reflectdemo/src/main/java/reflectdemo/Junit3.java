package reflectdemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Junit3 {

	public static void main(String[] args) {
		System.out.println("请输入类名");
		Scanner scan = new Scanner(System.in);
		String className  = scan.nextLine();
		try {
			Class cls = Class.forName(className);
			Method[] methods = cls.getDeclaredMethods();
			Object obj = cls.newInstance();
			for(Method m:methods){
				if(m.getName().startsWith("test")){//获取方法名并比较\
					//设置私有方法和属性的可访问性，破坏封装
					m.setAccessible(true);
					//动态调用方法
					m.invoke(obj);
					//所有的注解都是用反射机制实现的
					Annotation[] anntions = m.getAnnotations();
					//Annotion annotion = m.getAnnotation(annotationClass)
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
