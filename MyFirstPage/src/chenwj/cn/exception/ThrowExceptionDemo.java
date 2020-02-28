package chenwj.cn.exception;

/**
 * 
 * @author Administrator
 *
 */
public class ThrowExceptionDemo {
	 public static void main(String[] args) {
		Person p =new Person();
		try{
		p.setAge(1000);
		System.out.println("����"+p.getAge());
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
	}
}

class Person{
	private int age;
	public int getAge() {
		return age;
	}
	/* throw�ؼ��������׳��쳣
	 * ͨ��������������׳��쳣��
	 * 1���������﷨Ҫ�󣬵��ǲ�����ʵ��ҵ���߼�ʱ�����Ե���һ���쳣�׳�ȥ
	 * 2���ڵ�ǰ�����г�����һ��ʵ�ʵ��쳣�����ǲ�Ӧ���ڵ�ǰ�����д�����쳣ʱ��
	 * ���Խ����׳�
	 * �׳��쳣
	 */
	public void setAge(int age) throws Exception  {
		if(age<0||age>100){
			/*
			 * ��throw �׳�һ���쳣ʱ���׳���
			 * RuntimeException����������쳣�����Բ��ô���
			 * �����׳�һ����RuntimeException��������֮��������쳣ʱ
			 * ������Ҫ����봦����쳣����û�д�����룬����벻ͨ��
			 * �����������֣�
			 * 1.ʹ��try-catch���񲢴���
			 * 2.�ڵ�ǰ������ʹ��Throws�������쳣���׳�
			 */
			throw new Exception();
		/*	try{
				throw new Exception("���䲻�Ϸ�");
			}catch(Exception e){
				e.printStackTrace();
			}*/
			//throw new RuntimeException("���䲻�Ϸ�");
		}
		this.age = age;
	}
	
}
