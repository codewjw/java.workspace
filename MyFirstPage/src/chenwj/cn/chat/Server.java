package chenwj.cn.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	
	/*
	 * java.net.ServerSocket
	 * �����ڷ���˵�ServerSocket��Ҫ����������
	 * 1���������˿�
	 * 2����������˿ڣ�һ��һ���ͻ���ͨ���ö˿ڽ������ӣ��򴴽�һ��Socket����
	 * ��ͻ���ͨѶ
	 */
	private ServerSocket serverSocket;
	/*
	 * �ü������ڴ�ſͻ��˵���������������ڽ���Ϣ�㲥�����пͻ���
	 */
	private List<PrintWriter> allOut;
	
  public Server() throws IOException{
	  /*
	   * ��ʼ��ServerSocket��ͬʱ��Ҫָ������˿�
	   * �ö˿ںŲ�����ϵͳ����Ӧ�ó���������Ķ˿ں��ظ���
	   * ������׳��쳣
	   */
	  serverSocket = new ServerSocket(8088);
	  
	  allOut = new ArrayList<PrintWriter>();
  }
  public void start() {
	  try {
		  /*
		   * ServerSocket�ṩ������
		   * Socket accept();
		   * �÷��������ServerSocket����ķ���˿ڣ�����һ������������
		   * ֱ��һ���ͻ���ͨ���ö˿����ӲŻ᷵��һ��Socket��������ص�Socket
		   * �����������ӵĿͻ��˽���ͨѶ�ġ�
		   */
		  while(true){
		  System.out.println("�ͻ��˿�ʼ����......");
		  Socket socket = serverSocket.accept();
		  System.out.println("�ͻ������ӳɹ���......");
		  /*
		   * ����һ���߳���ͻ��˽���
		   */
		  ClientHandler hander = new ClientHandler(socket);
		  Thread t = new Thread(hander);
		  t.start();
		  }
		  
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
  }
  private void sendMessage(String message){
	  for(PrintWriter o:allOut){
		  o.println(message);
	  }
  }
  public static void main(String[] args) {
	 try {
		Server server = new Server();
		server.start();
	} catch (Exception e) {
		
	}
  }
  
  private class ClientHandler implements Runnable{

	/*
	 * ���ӿͻ��˵�socket����ǰ�߳�ͨ��socket��ͻ���ͨ��
	 */
	private Socket socket;
	/*
	 * Զ�̼�����ĵ�ַ������ָ�ͻ��˵ĵ�ַ
	 */
	private String host;
	public ClientHandler(Socket socket){
		this.socket = socket;
		InetAddress address = socket.getInetAddress();
	    this.host = address.getHostAddress();
	}
	@Override
	public void run() {
		 PrintWriter  pw = null;
		  try {
			  /*
			   * InputStream getInputStream
			   * Socket�ṩ�÷��������Ի�ȡһ��������
			   * ͨ��������ȡ��Զ�˼����������������
			   */
			  InputStream is = socket.getInputStream();
			  InputStreamReader isr = new InputStreamReader(is,"utf-8");
			  BufferedReader br = new BufferedReader(isr);
			  
			  /*
			   * ͨ��Socket��ȡ����������ڽ����ݷ��͸��ͻ���
			   */
			  OutputStream out = socket.getOutputStream();
			  OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
			  pw = new PrintWriter(osw,true);
			  
			  /*
			   * ���ͻ�����������뵽��������
			   * ���ڶ���̶߳�����øü��ϵ�add��������������������
			   * ����Ϊ�˱�֤�̰߳�ȫ�����Խ��ü��ϼ���
			   */
			  synchronized(allOut){
			    allOut.add(pw);
			  }
			  sendMessage(host+"�����ˣ���ǰ����"+allOut.size()+"��");
			  String message = null;
			  while((message = br.readLine())!=null){	  
				  //System.out.println(host+"˵��"+message);
				  //pw.println(host+"˵��"+message);
				  synchronized(allOut){
					  sendMessage(host+"˵��"+message);
				  }
			  }
		} catch (Exception e) {
		}
		  finally{
			  /*
			   *����ͻ������ߺ�Ĳ���
			   */
			  synchronized(allOut){
				  //���ͻ���������ӹ�������ɾ��
			    allOut.remove(pw);
			  }
			  sendMessage(host+"�����ˣ���ǰ����"+allOut.size()+"��");
			  if(socket!=null){
				  try {
					socket.close();//�ر������Զ�Ҳ��ȥ�رն�Ӧ������
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			  }
		  }
	}
	  
  }
}
