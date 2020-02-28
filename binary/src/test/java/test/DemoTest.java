package test;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class DemoTest {

	private int b1;
	private int b2;
	private int b3;
	
	
	@Test
	public void test1(){
		String str = StringUtils.leftPad("101",16,'1');
		int k=10;
		System.out.println(str);
		System.out.println(Integer.toBinaryString(k));
		int m = 0x7532a2fa;
		System.out.println(Integer.toBinaryString(m));
		System.out.println(m);
		int n=-3;
		System.out.println(Integer.toBinaryString(n));
		int min = 0x80000000;
		System.out.println(min);
		System.out.println(Integer.toBinaryString(min));
		
		int max = Integer.MAX_VALUE;
		min = Integer.MIN_VALUE;
		System.out.println(min-max);
		System.out.println(max-min);
		System.out.println(~8);
		System.out.println(~-8);
		
		System.out.println(Integer.toBinaryString('中'));
	}
	
	@Test
	public void test2(){
		char chr = '中';
		int m = 0x3f;
		int n = chr&m;
		System.out.println(Integer.toBinaryString(chr));
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(n));
	}

	@Test
	public void test3(){
		char chr = '中';
		int m = 0x3f;
		int b3 = chr&m|0x80;
		System.out.println(Integer.toBinaryString(chr));
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(b3));
	}
	
	@Test
	public void test4(){
		char chr = '中';
		int m = 0x3f;
		int b2 = ((chr>>>6)&m)|0x80;
		System.out.println(Integer.toBinaryString(chr));
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(b2));
	}
	
	@Test
	public void test5(){
		char chr = '中';
		int m = 0xf;
		int b1 = ((chr>>>12)&m)|0xe0;
		System.out.println(Integer.toBinaryString(chr));
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(b1));
	}
	
	@Test
	public void test6() throws UnsupportedEncodingException{
		char chr = '中';
		int n = 0x3f;
		int m = 0xf;
		//编码
		int b3 = chr&n|0x80;
		int b2 = ((chr>>>6)&n)|0x80;
		int b1 = ((chr>>>12)&m)|0xe0;
		/*//编码
		int b4 = (b1<<16)|(b2<<8)|b3;
		System.out.println(Integer.toBinaryString(b4));*/
		
		//JDK提供utf-8到char的解码
		byte[] bytes = {(byte) b1,(byte) b2,(byte) b3};
		String str = new String(bytes,"utf-8");
		System.out.println(str);
		
	    //解码
		int b5 = ((b1&m)<<12)|((b2&n)<<6)|(b3&n);
		System.out.println(Integer.toBinaryString(b5));
		System.out.println((char) b5);
	}
	
}
