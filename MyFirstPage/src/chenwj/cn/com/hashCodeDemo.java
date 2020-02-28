package chenwj.cn.com;

public class hashCodeDemo {

}
/**
 * ���Զ�������Ԫ����Ҫ��ΪMap�е�keyʹ��ʱ��ͨ��Ҫע��
 * API�ĵ���Ҳ��˵��
 * ��һ������Ҫ��дequels����ʱ����Ӧ����ͬ��дhashCode������
 * ������дʱҪע�⣺
 * ����������equels�Ƚ�Ϊtrueʱ��hashCode�������ص����ֱ�����ͬ
 * ��֮��Ȼ���Ǳ����ģ�������������hashCodeֵ��ͬ��equels��ֵ�Ƚ�Ӧ��Ϊtrue
 * �������HashMap�в�������Ӱ���ѯ����
 * 
 * hashCode�������ص�����Ӧ����һ���ȶ���ֵ������
 * �ڲ���equels�Ƚϵ�����ֵû�з����ı��ǰ���£���ε���hashCode�������ص�����
 * Ӧ����һ����
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