package chenwj.cn.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 字符流：以字符位单位读写数据的流，所以字符流只能读写文本数据，字符流本质还是读写字节
 * Reader:字符输入流的父类，定义了读取字符的相关方法
 * Writer:字符输出流的父类，定义了写出字符的相关方法
 *
 * 转换流，字符输出流的一个实现类
 * java.io.OutPutStreamWriter
 * java.io.ImputStreamReader
 * 由于大部分的字符流都只能处理其他字符流，不能直接处理字节流，而低级的流绝大部分都是字节流，
 * 这也导致这些字符流是不能直接处理这些字节流的，就需要用到IRS，OSW这两个流，
 * 因为他们可以直接处理字节流，而自身又不是字符流，所以经常在流链接中其承上启下的作用。
 * @author Administrator
 *
 */
public class CharStream {

	public static void main(String[] args) throws IOException {
		CharStream cs = new CharStream();
		//cs.OSWDemo();
		cs.ISRDemo();
	}

	/**
	 * 写流
	 * @throws IOException
	 */
	public void OSWDemo() throws IOException{
		FileOutputStream fos = new FileOutputStream("fan.txt");
		
		/**
		 * OSW还支持第二个参数，是一个字符串，用来指定字符集，当
		 * 指定后，那么所有使用OSW写出来的字符串都使用该字符集转换为字节
		 */
		//OutputStreamWriter osw = new OutputStreamWriter(fos);
		OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
		
		osw.write("想跟你在成都的街头走一走，哦哦哦哦哦！");
		osw.write("直到所有的灯都熄灭了");
		System.out.println("写入成功！");
		osw.close();
	}
	
	/**
	 * 读流
	 * java.io.InputStreamReader
	 * 字符输入流，转换流，可以按照指定字符集读取字符
	 * @throws IOException 
	 */
	public void ISRDemo() throws IOException{
		FileInputStream fis = new FileInputStream("fan.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		
		int d = -1;
		while((d=isr.read())!=-1){
			System.out.print((char)d);
		}
		isr.close();
	}
}
