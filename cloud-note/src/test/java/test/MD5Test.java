package test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class MD5Test {
  
	@Test
	public void test(){
		String str="123456";
		String md5 = DigestUtils.md5Hex(str);
		System.out.println(md5);
		String salt = "今天你吃了么?";
		md5 = DigestUtils.md5Hex(str+salt);
		System.out.println(md5);
	}
}
