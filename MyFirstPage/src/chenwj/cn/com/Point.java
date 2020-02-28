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
	 * 比较对象的大小，比较当前对象与传参对象的大小
	 * 返回一个int值，该值不关心大小，值关心范围
	 * 返回值>0，表示当前对象大于传参对象(this>o)
	 * 返回值=0，表示当前对象等于传参对象(this=o)
	 * 返回值<0，表示当前对象小于传参对象(this<o)
	 */
	 public int compareTo(Point p){
		 int thisNum = this.x*this.x+this.y*this.y;
		 int oNum  = p.getX()*p.getX()+p.getY()*p.getY();
		 return thisNum-oNum;
	 }
}
