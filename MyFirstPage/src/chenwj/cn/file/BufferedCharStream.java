package chenwj.cn.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * �����ַ���
 * ��һ�Ը߼��ַ������ص��ǿ��԰��ж�д�ַ�����
 * java.io.BufferedWriter:����д�ַ���
 * java.io.BufferedReader:������ַ���
 * 
 * java.io.PrintWriter
 * ���õĻ����ַ���������ڲ�ʹ��BufferedWriter��Ϊ�仺�幦�ܣ�
 * PW���������Զ���ˢ�£����Գ��������
 * 
 * @author Administrator
 *
 */
public class BufferedCharStream {

	public static void main(String[] args) throws IOException {
		BufferedCharStream bcs = new BufferedCharStream();
		//bcs.PWDemo3();
		//bcs.BRDemo();
		bcs.mouseInputDemo();
	}

	/*
	 * java.io.PrintWriter�ṩ�˽϶�Ĺ��췽��
	 * ���Է��㴴����
	 * ����������ֱ������ļ���д���ַ��������Ĺ��췽��
	 * PrintWriter(String path)
	 * PrintWriter(File file)
	 */
	public void PWDemo() throws FileNotFoundException, UnsupportedEncodingException{
		/*
		 * ���밴��ָ���ַ���д���ַ�������ô������������ļ���д��
		 * �����Ĺ��췽����֧�ֵڶ����������ò���Ϊ�ַ���������ָ���ַ�������
		 */
//		PrintWriter pw = new PrintWriter("pw.txt");
		PrintWriter pw = new PrintWriter("pw.txt","GBK");
		//pw.write("����˭��һ�����ˣ�����һ��Ӣ�ۣ�")
		pw.println("����˭��һ�����ˣ�����һ��Ӣ�ۣ�");
		System.out.println("д����ϣ�");
		pw.close();
		
		
	}
	
	/*
	 * PrintWriter(Writer w)
	 * PrintWriter(OutputStream os)
	 * �����ֹ��췽�����������ֽ�����Ҳ���������ַ���
	 */
	public void PWDemo2() throws FileNotFoundException, UnsupportedEncodingException{
		/*
		 * ��������ʽ���������ַ���PrintWriter�����ǲ���ֱ���ڴ��������ʱ��ֱ��
		 * ָ���ַ��������
		 */
		FileOutputStream fos = new FileOutputStream("pw2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
		//PrintWriter pw = new PrintWriter(fos); //������������������
		PrintWriter pw = new PrintWriter(osw); //������������������
		
	/*	pw.write("�������ˣ�����ʲô�ط���");
		pw.write("������ɵ����飬���Ǻ�����һ��");*/
		pw.print("�����");
		pw.print("�������ˣ�");
		System.out.println("д���ɹ�!");
		
		pw.close();
	    
	}
	
	/*
	 * �Զ���ˢ��
	 */
	public void PWDemo3() throws FileNotFoundException, UnsupportedEncodingException{
		    Scanner scan = new Scanner(System.in);
		    System.out.println("�������ļ�����");
		    String name = scan.nextLine();
			FileOutputStream fos = new FileOutputStream(name);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
			//PrintWriter pw = new PrintWriter(osw); //������������������
			/*
			 * �ڶ�������Ϊboolean��Ϊtrueʱ�������Զ���д�룬�Զ���ˢ��
			 * �൱��flush()
			 * Ϊfalse,�������Զ���ˢ��
			 */
			PrintWriter pw = new PrintWriter(osw,true);
			System.out.println("���������ݣ�");
			String str = null;
			while(true){
				str = scan.nextLine();
				if("exit".equals(str)){
					break;
				}
				pw.println(str);
			}
			pw.close();
	}
	
	/*
	 * java.io.BufferedReader
	 * �����ַ������������԰��ж�ȡ�ַ���
	 */
	public void BRDemo() throws IOException{
		FileInputStream fis = new FileInputStream("pw2.txt");
		InputStreamReader fisr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(fisr);
		
		/*
		 * String readLine()
		 * �÷�������ϵ��ȡ�����ַ���ֱ����ȡ�����з�Ϊֹ��Ȼ�󽫻��з�
		 * ֮ǰ�����е��ַ���һ���ַ�������ʽ���ء�
		 * ע�⣺���ص��ַ���������������з���
		 * ������ֵΪNULL����˵���޷�ͨ�������ڶ�ȡ������(���ڶ��ļ����ԣ�
		 * ����null��ʾ��ȡ���ļ�ĩβ)
		 */
		String str = null;
		while((str = br.readLine())!=null){
			System.out.println(str);
		}
		br.close();
	}
	
	
	public void mouseInputDemo() throws IOException{
		System.out.println("����������");
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
				);
		String line = null;
		PrintWriter pw = new PrintWriter("pw4.txt");
		while((line = br.readLine())!=null){
			if("exit".equals(line)){
				break;
			}
			pw.println(line);
		}
		
		br.close();
		pw.close();
	}
}
