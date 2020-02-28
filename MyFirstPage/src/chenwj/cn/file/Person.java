package chenwj.cn.file;

import java.io.Serializable;
import java.util.List;

/**
 * ��ʵ�������л�������Զ���������ʽд���ļ�
 * Serializable�ӿ������κη�������ʵ�ʱ��������Զ�����д����������л��ķ�����
 * @author Administrator
 *
 */

public class Person implements Serializable{
	/**
	 * 
	 * ��һ����ʵ����Serialzable�ӿں�Ӧ������һ��������
	 * �汾��serialVersionUID
	 * ������û�ж��壬ϵͳ����ݵ�ǰ��Ľṹ����һ��������ֻҪ��ǰ��Ľṹ�����仯��
	 * �汾�žͻᷢ���仯���汾�ž�����һ�������Ƿ���Է����л��ɹ�����ObjectInputStream
	 * ��ȡһ��������ֽڲ����з����л�ʱ������ö���İ汾���뵱ǰ��İ汾���Ƿ�һ�£�һ����
	 * ���л��ɹ�����һ�������л�ʧ��
	 * ����ָ���汾�ſ��Կ��Ʒ����л��Ľ����
	 * 
	 */
 	private static final long serialVersionUID = 1L;
		private String name;
		private int age;
	    private String sex;
	    /**
	     * transient �ؼ���
	     * ���ùؼ������ε������ڽ��ж������л�ʱ����ֵ�ᱻ���ԡ����������Դﵽ
	     * ���������Ч��
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
