package dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import annotations.MyBatisRepository;
import entity.Emp;
import entity.Employee;


/*
 * Mapperӳ����
 */
@Repository("edao")
@MyBatisRepository  //�Զ���ע��,ָ��ɨ��Ľӿ�
public interface EmpDAO {
	public void save(Emp emp);
	public List<Emp> findAllEmps();
	public Emp findEmpById(int id);
	public void modifyByEmp(Emp emp);
	public void deleteById(int id);
	public Map findEmpById2(int id);
	public Employee findEmpById3(int id);
}
