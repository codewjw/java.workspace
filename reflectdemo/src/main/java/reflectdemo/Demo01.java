package reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入类名");
		String className = scan.nextLine();
		try {
			//动态创建类
			Class cls = Class.forName(className); //获取类
			System.out.println(cls); 
			System.out.println(cls.getName()); //获取完整的类名(包括包)
			//动态检测类中声明的方法信息
			Method[] methods = cls.getDeclaredMethods();
			//动态获取构造器信息
			Constructor[] cs =  cls.getDeclaredConstructors();
			for(Method m:methods){
				System.out.println(m);
			}
			for(Constructor c:cs){
				System.out.println(c);
			}
			System.out.println("输入方法名");
			String name = scan.nextLine();
			//动态找到一个方法
			Method m = cls.getDeclaredMethod(name);
			//动态创建对象
			Object obj = cls.newInstance();
			//动态执行方法
			m.invoke(obj);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
      }
}
