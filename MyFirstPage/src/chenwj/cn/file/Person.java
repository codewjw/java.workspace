package chenwj.cn.file;

import java.io.Serializable;
import java.util.List;

/**
 * 类实现了序列化后才能以对象流的形式写入文件
 * Serializable接口中无任何方法，但实际编译器会自动帮你写代码加上序列化的方法的
 * @author Administrator
 *
 */

public class Person implements Serializable{
	/**
	 * 
	 * 当一个类实现了Serialzable接口后，应当定义一个常量：
	 * 版本号serialVersionUID
	 * 若我们没有定义，系统会根据当前类的结构生成一个，但是只要当前类的结构发生变化，
	 * 版本号就会发生变化，版本号决定着一个对象是否可以反序列化成功，当ObjectInputStream
	 * 读取一个对象的字节并进行反序列化时，会检查该对象的版本号与当前类的版本号是否一致，一致则反
	 * 序列化成功，不一致则反序列化失败
	 * 自行指定版本号可以控制反序列化的结果。
	 * 
	 */
 	private static final long serialVersionUID = 1L;
		private String name;
		private int age;
	    private String sex;
	    /**
	     * transient 关键字
	     * 被该关键字修饰的属性在进行对象序列化时，其值会被忽略。这样做可以达到
	     * 对象瘦身的效果
	     */
		private transient List<String> list;
  
		public Person(String name, int age, String sex, List<String> list) {
			this.name = name;
			this.age = age;
			this.sex = sex;
			this.list = list;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getage() {
			return age;
		}
		public void setage(int age) {
			this.age = age;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public List<String> getList() {
			return list;
		}
		public void setList(List<String> list) {
			this.list = list;
		}
		
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", list=" + list + "]";
		}
}
