package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Emp;

@Repository("empDAO")
public class EmpDAO {
	 //或者用@Autowired+@Qualifier("jt")注解
	 @Resource(name="jt")
	 private JdbcTemplate jt;
	 
	public void save(Emp emp){
		String sql ="INSERT INTO t_emp VALUES(t_emp_seq.nextval,?,?)";
		Object[] args = {emp.getName(),emp.getAge()};
		int count = jt.update(sql, args);
	}
    
	//查询所有员工
	public List<Emp> findAllEmp(){
		String sql ="SELECT id,name,age FROM t_emp";
		return jt.query(sql, new EmpRowMapper());
	}
	
	public Emp findEmpById(int id){
		String sql = "SELECT id,name,age FROM t_emp WHERE id=?";
		Object[] args = {id};
		Emp emp = null;
		try{
			emp = jt.queryForObject(sql, args, new EmpRowMapper());
		}catch(EmptyResultDataAccessException e){
			e.printStackTrace();
			return null;
		}
		return emp;
	}
	
	//更新
	public void modifyEmp(Emp emp){
		String sql = "UPDATE t_emp SET name=?,age=? WHERE id=?";
		Object[] args = {emp.getName(),emp.getAge(),emp.getId()};
		jt.update(sql,args);
		
	}
	//删除
	public int deleteEmp(int id){
		String sql = "DELETE FROM t_emp WHERE id=?";
		Object[] args = {id};
		return jt.update(sql,args);
	}
	/*
	 * 内部类
	 * spring框架提供接口
	 * 封装了对结果集ResultSet的处理
	 */
	class EmpRowMapper implements RowMapper<Emp>{
         /*
          * 告诉JdbcTemplate如何将一条记录转换成一个实体
	      * index:正在被处理的方法的结果集下标
          */
		public Emp mapRow(ResultSet rs, int index)
               throws SQLException {
			Emp emp = new Emp();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setAge(rs.getInt("age"));
			return emp;
		}
		
	}
}
