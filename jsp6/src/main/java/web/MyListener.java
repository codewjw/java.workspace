package web;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener,ServletRequestAttributeListener {

	public void requestDestroyed(ServletRequestEvent e) {
	   System.out.println("request��������");

	}

	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("request��������");
		System.out.println(e.getServletRequest());
		}

	//����������������
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("��request�����������");
	}
    //�������������Ƴ�
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		
	}

	//�����������ݱ��滻
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		
		
	}

}
