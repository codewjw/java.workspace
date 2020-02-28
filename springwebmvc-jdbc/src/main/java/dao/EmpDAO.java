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
	 //������@Autowired+@Qualifier("jt")ע��
	 @Resource(name="jt")
	 private JdbcTemplate jt;
	 
	public void save(Emp emp){
		String sql ="INSERT INTO t_emp VALUES(t_emp_seq.nextval,?,?)";
		Object[] args = {emp.getName(),emp.getAge()};
		int count = jt.update(sql, args);
	}
    
	//��ѯ����Ա��
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
	
	//����
	public void modifyEmp(Emp emp){
		String sql = "UPDATE t_emp SET name=?,age=? WHERE id=?";
		Object[] args = {emp.getName(),emp.getAge(),emp.getId()};
		jt.update(sql,args);
		
	}
	//ɾ��
	public int deleteEmp(int id){
		String sql = "DELETE FROM t_emp WHERE id=?";
		Object[] args = {id};
		return jt.update(sql,args);
	}
	/*
	 * �ڲ���
	 * spring����ṩ�ӿ�
	 * ��װ�˶Խ����ResultSet�Ĵ���
	 */
	class EmpRowMapper implements RowMapper<Emp>{
         /*
          * ����JdbcTemplate��ν�һ����¼ת����һ��ʵ��
	      * index:���ڱ�����ķ����Ľ�����±�
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
