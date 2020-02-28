package chenwj.cn.com;

public class Point implements Comparable<Point>{

	private int x;
	private int y;
	public Point(){}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString(){
		return "["+this.getX()+","+this.getY()+"]";
	}
	
	public boolean equals(Object o){
		if(o == this){
			return true;
		}
        if(o instanceof Point){
        	Point p = (Point) o;
			return p.getX() == this.getX() && p.getY() == this.getY();
		}
		return false;
	}
	/**
	 * �Ƚ϶���Ĵ�С���Ƚϵ�ǰ�����봫�ζ���Ĵ�С
	 * ����һ��intֵ����ֵ�����Ĵ�С��ֵ���ķ�Χ
	 * ����ֵ>0����ʾ��ǰ������ڴ��ζ���(this>o)
	 * ����ֵ=0����ʾ��ǰ������ڴ��ζ���(this=o)
	 * ����ֵ<0����ʾ��ǰ����С�ڴ��ζ���(this<o)
	 */
	 public int compareTo(Point p){
		 int thisNum = this.x*this.x+this.y*this.y;
		 int oNum  = p.getX()*p.getX()+p.getY()*p.getY();
		 return thisNum-oNum;
	 }
}
