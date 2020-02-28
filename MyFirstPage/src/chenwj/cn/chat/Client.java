package chenwj.cn.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    /*
     * java.net.socket
     * ��װTCPͨ��Э�飬ʹ������Զ�̼������������ͨ��
     */
	private Socket socket;
	
    /**
     * 
     * @throws UnknownHostException
     * @throws IOException
     */
	public Client() throws UnknownHostException, IOException{
		/*
		 * ʵ����Socket����Ҫ������������
		 * 1�������IP��ַ
		 * 2������˶˿�
		 * ͨ��IP��ַ�����ҵ������ϵķ�������ڵļ����
		 * ͨ���˿ڿ������ӵ��ü�����ϵķ����Ӧ�ó���
		 * 
		 * ʵ����Socket�Ĺ��̾��ǽ������ӵĹ��̣����������ӷ����ʧ�ܣ�����ͻ�
		 * �׳��쳣
		 */
		 System.out.println("���������˽�������......");
		 socket = new Socket("localhost",8088);
		 System.out.println("���ӳɹ���");
	}

	public void start(){
		try {
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
			PrintWriter  pw = new PrintWriter(osw,true);
			
			/*
			 * ������ȡ�߳�
			 */
			ServerHandle sHander = new ServerHandle();
			Thread t = new Thread(sHander);
			t.start();
			
			Scanner scan = new Scanner(System.in);
			String line = null;
			System.out.println("��ʼ����ɣ�");
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
    
    private class ServerHandle implements Runnable{

		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is,"utf-8");
				BufferedReader   br = new BufferedReader(isr);
				String message = null;
				while((message = br.readLine())!=null){
					System.out.println(message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
    	
    }
}
