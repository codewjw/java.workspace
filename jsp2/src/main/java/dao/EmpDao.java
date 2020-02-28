package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;

public class EmpDao implements Serializable{
   public List<Emp> findAll(){
	   List<Emp> emps = new ArrayList<Emp>();
	   //模拟数据
	   Emp e1 = new Emp();
	   e1.setEmpno(1);
	   e1.setName("唐生");
	   e1.setAge(30);
	   e1.setGender("M");
	   e1.setSalary(8000.0);
	   e1.setDeptno(3);
	   emps.add(e1);
	   Emp e2 = new Emp();
	   e2.setEmpno(2);
	   e2.setName("唐唐");
	   e2.setAge(30);
	   e2.setGender("M");
	   e2.setSalary(7000.0);
	   e2.setDeptno(3);
	   emps.add(e2);
	   Emp e3 = new Emp();
	   e3.setEmpno(3);
	   e3.setName("悟空");
	   e3.setAge(30);
	   e3.setGender("M");
	   e3.setSalary(10000.0);
	   e3.setDeptno(3);
	   emps.add(e3);
	   
	   return emps;
   }
   
     public void save(Emp emp){
    	 System.out.println("增加员工"+emp.getName()+","+emp.getGender());
     }
}
