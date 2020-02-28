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
 * 缓冲字符流
 * 是一对高级字符流，特点是可以按行读写字符串。
 * java.io.BufferedWriter:缓冲写字符流
 * java.io.BufferedReader:缓冲读字符流
 * 
 * java.io.PrintWriter
 * 常用的缓冲字符输出流，内部使用BufferedWriter作为其缓冲功能，
 * PW本身还具有自动行刷新，所以常用这个流
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
	 * java.io.PrintWriter提供了较多的构造方法
	 * 可以方便创建它
	 * 其中有两个直接针对文件做写出字符串操作的构造方法
	 * PrintWriter(String path)
	 * PrintWriter(File file)
	 */
	public void PWDemo() throws FileNotFoundException, UnsupportedEncodingException{
		/*
		 * 若想按照指定字符集写出字符串，那么上述两个针对文件的写出
		 * 操作的构造方法都支持第二个参数，该参数为字符串，用来指定字符集名称
		 */
//		PrintWriter pw = new PrintWriter("pw.txt");
		PrintWriter pw = new PrintWriter("pw.txt","GBK");
		//pw.write("我是谁！一个贱人！还是一个英雄！")
		pw.println("我是谁！一个贱人！还是一个英雄！");
		System.out.println("写入完毕！");
		pw.close();
		
		
	}
	
	/*
	 * PrintWriter(Writer w)
	 * PrintWriter(OutputStream os)
	 * 此两种构造方法允许链接字节流，也可以链接字符流
	 */
	public void PWDemo2() throws FileNotFoundException, UnsupportedEncodingException{
		/*
		 * 以流的形式创建缓冲字符流PrintWriter对象，是不能直接在创建对象的时候直接
		 * 指定字符集编码的
		 */
		FileOutputStream fos = new FileOutputStream("pw2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
		//PrintWriter pw = new PrintWriter(fos); //以流对象来创建对象
		PrintWriter pw = new PrintWriter(osw); //以流对象来创建对象
		
	/*	pw.write("我想你了，你在什么地方？");
		pw.write("我最想干的事情，还是和你在一起");*/
		pw.print("你好吗？");
		pw.print("我想你了！");
		System.out.println("写出成功!");
		
		pw.close();
	    
	}
	
	/*
	 * 自动行刷新
	 */
	public void PWDemo3() throws FileNotFoundException, UnsupportedEncodingException{
		    Scanner scan = new Scanner(System.in);
		    System.out.println("请输入文件名：");
		    String name = scan.nextLine();
			FileOutputStream fos = new FileOutputStream(name);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
			//PrintWriter pw = new PrintWriter(osw); //以流对象来创建对象
			/*
			 * 第二个参数为boolean，为true时，允许自动行写入，自动行刷新
			 * 相当于flush()
			 * 为false,不允许自动行刷新
			 */
			PrintWriter pw = new PrintWriter(osw,true);
			System.out.println("请输入内容：");
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
	 * 缓冲字符输入流，可以按行读取字符串
	 */
	public void BRDemo() throws IOException{
		FileInputStream fis = new FileInputStream("pw2.txt");
		InputStreamReader fisr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(fisr);
		
		/*
		 * String readLine()
		 * 该方法会联系读取若干字符，直到读取到换行符为止，然后将换行符
		 * 之前的所有的字符以一个字符串的形式返回。
		 * 注意：返回的字符串不含有这个换行符。
		 * 若返回值为NULL，则说明无法通过该流在读取到数据(对于读文件而言，
		 * 返回null表示读取到文件末尾)
		 */
		String str = null;
		while((str = br.readLine())!=null){
			System.out.println(str);
		}
		br.close();
	}
	
	
	public void mouseInputDemo() throws IOException{
		System.out.println("请输入内容");
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
