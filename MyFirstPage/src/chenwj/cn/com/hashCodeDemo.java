package chenwj.cn.com;

public class hashCodeDemo {

}
/**
 * 当自定义类型元素需要作为Map中的key使用时，通常要注意
 * API文档上也有说明
 * 当一个类需要重写equels方法时，就应当连同重写hashCode方法，
 * 并且重写时要注意：
 * 当两个对象equels比较为true时，hashCode方法返回的数字必须相同
 * 反之虽然不是必须额的，如果两个对象的hashCode值相同，equels的值比较应该为true
 * 否则会在HashMap中产生链表，影响查询性能
 * 
 * hashCode方法返回的数字应当是一个稳定的值，即：
 * 在参与equels比较的属性值没有发生改变的前提下，多次调用hashCode方法返回的数字
 * 应当是一样的
 * 
 * @author Administrator
 *
 */
class KeyPoint{
	private int x;
	private int y;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyPoint other = (KeyPoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}