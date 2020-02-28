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
	 * 运行在服务端的ServerSocket主要有两个作用
	 * 1：申请服务端口
	 * 2：监听服务端口，一旦一个客户端通过该端口建立连接，则创建一个Socket用于
	 * 与客户端通讯
	 */
	private ServerSocket serverSocket;
	/*
	 * 该集合用于存放客户端的所有输出流，用于将消息广播给所有客户端
	 */
	private List<PrintWriter> allOut;
	
  public Server() throws IOException{
	  /*
	   * 初始化ServerSocket的同时需要指定服务端口
	   * 该端口号不能与系统其他应用程序已申请的端口号重复，
	   * 否则会抛出异常
	   */
	  serverSocket = new ServerSocket(8088);
	  
	  allOut = new ArrayList<PrintWriter>();
  }
  public void start() {
	  try {
		  /*
		   * ServerSocket提供方法：
		   * Socket accept();
		   * 该方法会监听ServerSocket申请的服务端口，这是一个阻塞方法，
		   * 直到一个客户端通过该端口连接才会返回一个Socket。这个返回的Socket
		   * 是用于与连接的客户端进行通讯的。
		   */
		  while(true){
		  System.out.println("客户端开始连接......");
		  Socket socket = serverSocket.accept();
		  System.out.println("客户端连接成功！......");
		  /*
		   * 启动一个线程与客户端交互
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
	 * 连接客户端的socket，当前线程通过socket与客户端通信
	 */
	private Socket socket;
	/*
	 * 远程计算机的地址，这里指客户端的地址
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
			   * Socket提供该方法，可以获取一个输入流
			   * 通过该流读取到远端计算机发过来的数据
			   */
			  InputStream is = socket.getInputStream();
			  InputStreamReader isr = new InputStreamReader(is,"utf-8");
			  BufferedReader br = new BufferedReader(isr);
			  
			  /*
			   * 通过Socket获取输出流，用于将数据发送给客户端
			   */
			  OutputStream out = socket.getOutputStream();
			  OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
			  pw = new PrintWriter(osw,true);
			  
			  /*
			   * 将客户端输出流存入到共享集合中
			   * 由于多个线程都会调用该集合的add方法向其中添加输出流，
			   * 所以为了保证线程安全，可以将该集合加锁
			   */
			  synchronized(allOut){
			    allOut.add(pw);
			  }
			  sendMessage(host+"上线了，当前在线"+allOut.size()+"人");
			  String message = null;
			  while((message = br.readLine())!=null){	  
				  //System.out.println(host+"说："+message);
				  //pw.println(host+"说："+message);
				  synchronized(allOut){
					  sendMessage(host+"说："+message);
				  }
			  }
		} catch (Exception e) {
		}
		  finally{
			  /*
			   *处理客户端下线后的操作
			   */
			  synchronized(allOut){
				  //将客户端输出流从共享集合中删除
			    allOut.remove(pw);
			  }
			  sendMessage(host+"下线了，当前在线"+allOut.size()+"人");
			  if(socket!=null){
				  try {
					socket.close();//关闭它，自动也会去关闭对应的流的
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			  }
		  }
	}
	  
  }
}
