package chenwj.cn.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * �ַ��������ַ�λ��λ��д���ݵ����������ַ���ֻ�ܶ�д�ı����ݣ��ַ������ʻ��Ƕ�д�ֽ�
 * Reader:�ַ��������ĸ��࣬�����˶�ȡ�ַ�����ط���
 * Writer:�ַ�������ĸ��࣬������д���ַ�����ط���
 *
 * ת�������ַ��������һ��ʵ����
 * java.io.OutPutStreamWriter
 * java.io.ImputStreamReader
 * ���ڴ󲿷ֵ��ַ�����ֻ�ܴ��������ַ���������ֱ�Ӵ����ֽ��������ͼ��������󲿷ֶ����ֽ�����
 * ��Ҳ������Щ�ַ����ǲ���ֱ�Ӵ�����Щ�ֽ����ģ�����Ҫ�õ�IRS��OSW����������
 * ��Ϊ���ǿ���ֱ�Ӵ����ֽ������������ֲ����ַ��������Ծ���������������������µ����á�
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
	 * д��
	 * @throws IOException
	 */
	public void OSWDemo() throws IOException{
		FileOutputStream fos = new FileOutputStream("fan.txt");
		
		/**
		 * OSW��֧�ֵڶ�����������һ���ַ���������ָ���ַ�������
		 * ָ������ô����ʹ��OSWд�������ַ�����ʹ�ø��ַ���ת��Ϊ�ֽ�
		 */
		//OutputStreamWriter osw = new OutputStreamWriter(fos);
		OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
		
		osw.write("������ڳɶ��Ľ�ͷ��һ�ߣ�ŶŶŶŶŶ��");
		osw.write("ֱ�����еĵƶ�Ϩ����");
		System.out.println("д��ɹ���");
		osw.close();
	}
	
	/**
	 * ����
	 * java.io.InputStreamReader
	 * �ַ���������ת���������԰���ָ���ַ�����ȡ�ַ�
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
