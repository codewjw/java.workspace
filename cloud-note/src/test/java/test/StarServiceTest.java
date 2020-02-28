package test;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.service.StarService;

public class StarServiceTest extends BaseTest{
	
	private StarService ss;
	@Before
	public void test(){
		  ss = cpxac.getBean("starService",StarService.class);
	}
  
	@Test
	public void test1(){
		String userId="333c6d0b-e4a2-4596-9902-a5d98c2f665a";
		int stars = 6;
		int k = ss.addStars(userId, stars);
		System.out.println(k);
	}
}
