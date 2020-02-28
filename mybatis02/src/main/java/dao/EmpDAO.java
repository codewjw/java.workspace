package dao;

import java.util.List;
import java.util.Map;

import entity.Emp;
import entity.Employee;


/*
 * Mapper”≥…‰∆˜
 */
public interface EmpDAO {
	public void save(Emp emp);
	public List<Emp> findAllEmps();
	public Emp findEmpById(int id);
	public void modifyByEmp(Emp emp);
	public void deleteById(int id);
	public Map findEmpById2(int id);
	public Employee findEmpById3(int id);
}
