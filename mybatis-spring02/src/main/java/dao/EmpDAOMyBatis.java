package dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import entity.Emp;
import entity.Employee;

@Repository("empDao") //组件扫描方式
public class EmpDAOMyBatis implements EmpDAO{
	
	@Autowired
	@Qualifier("sst")
	private SqlSessionTemplate sst;
	
	/*
	 *不用考虑关闭事务和提交事务
	 */
	public void save(Emp emp) {
		 sst.insert("test.save", emp);
	}

	public List<Emp> findAllEmps() {
		List<Emp> emps = sst.selectList("test.findAllEmps");
		return emps;
	}

	public Emp findEmpById(int id) {
		Emp emp = sst.selectOne("test.findEmpById",id);
		return null;
	}

	public void modifyByEmp(Emp emp) {
		sst.update("test.modifyByEmp",emp);
		
	}

	public void deleteById(int id) {
		sst.delete("test.deleteById",id);
	}

	public Map findEmpById2(int id) {
		Map map = sst.selectOne("test.findEmpById2", id);
		return null;
	}

	public Employee findEmpById3(int id) {
		Employee emp = sst.selectOne("test.findEmpById3", id);
		return emp;
	}

}
