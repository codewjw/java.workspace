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
     * ��װTCPͨ��Э�飬ʹ������Զ�̼������������ͨ��
     */
	private Socket socket;
	
    /**
     * 
     * @throws UnknownHostException
     * @throws IOException
     */
	public Client2() throws UnknownHostException, IOException{
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
}

