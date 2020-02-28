package chenwj.cn.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
    /*
     * java.net.socket
     * 封装TCP通信协议，使用它与远程计算机进行网络通信
     */
	private Socket socket;
	
    /**
     * 
     * @throws UnknownHostException
     * @throws IOException
     */
	public Client2() throws UnknownHostException, IOException{
		/*
		 * 实例化Socket是需要传入两个参数
		 * 1：服务端IP地址
		 * 2：服务端端口
		 * 通过IP地址可以找到网络上的服务端所在的计算机
		 * 通过端口可以连接到该计算机上的服务端应用程序
		 * 
		 * 实例化Socket的过程就是建立连接的过程，所以若连接服务端失败，这里就会
		 * 抛出异常
		 */
		 System.out.println("正在与服务端建立连接......");
		 socket = new Socket("localhost",8088);
		 System.out.println("连接成功！");
	}

	public void start(){
		try {
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
			PrintWriter  pw = new PrintWriter(osw,true);
			Scanner scan = new Scanner(System.in);
			String line = null;
			System.out.println("开始聊天吧！");
			while(true){
				line = scan.nextLine();
				pw.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

