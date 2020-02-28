package web;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener,ServletRequestAttributeListener {

	public void requestDestroyed(ServletRequestEvent e) {
	   System.out.println("request被销毁了");

	}

	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("request被创建了");
		System.out.println(e.getServletRequest());
		}

	//监听对象的数据添加
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("向request中添加了数据");
	}
    //监听对象数据移除
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		
	}

	//监听对象数据被替换
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		
		
	}

}
