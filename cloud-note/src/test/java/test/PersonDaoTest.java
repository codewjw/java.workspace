package test;


import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.dao.PersonDao;
import cn.tedu.note.entity.Person;

public class PersonDaoTest extends BaseTest {

	private PersonDao pdao;
	
	@Before
	public void test1(){
		pdao = cpxac.getBean("personDao", PersonDao.class);
	}
	
	@Test
	public void test2(){
		Person person = new Person(null,"陈文杰");
		int n = pdao.addPerson(person); //动态将自动生成的id反射给对象
		System.out.println(n);
		System.out.println(person);
	}
}
