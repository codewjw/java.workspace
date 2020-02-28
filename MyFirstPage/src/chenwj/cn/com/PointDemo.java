package chenwj.cn.com;

public class PointDemo<T> {
 private T x;
 private T y;
 
public T getX() {
	return x;
}
public void setX(T x) {
	this.x = x;
}
public T getY() {
	return y;
}
public void setY(T y) {
	this.y = y;
}
public PointDemo(T x, T y) {
	this.x = x;
	this.y = y;
}

/**
 * ��дtoString()����
 */
public String toString(){
	return "("+x+","+y+")";
}

/**
 * ��дequals����
 */
public boolean equals(Object o){
	if(o == this){
		return true;
	}
    if(o instanceof PointDemo){
    	PointDemo p = (PointDemo) o;
		return p.getX().equals(this.getX())&& p.getY().equals(this.getY());
	}
	return false;
}

}
