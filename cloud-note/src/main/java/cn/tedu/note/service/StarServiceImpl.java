package cn.tedu.note.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.note.dao.StarDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.Stars;
import cn.tedu.note.entity.User;

@Service("starService")
public class StarServiceImpl implements StarService{

	@Resource(name="starDao")
	private StarDao sd;
	
	@Resource(name="userdao")
	private UserDao ud;
	
	/*public List<Map<String, Object>> findStarsByUserId() {
		
		return null;
	}*/
   
	public int addStars(String userId,int stars) throws UserNotFoundException{
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("id Ϊ��");
		}
		User user = ud.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("����");
		}
	    Stars st = sd.findStarsByUserId(userId);
	    int n = 0;
	    if(st==null){
	    	String id =UUID.randomUUID().toString();
	    	st = new Stars(id,userId,stars);
	    	n = sd.insertStars(st);
	    	if(n!=1){
	    		throw new RuntimeException("����ʧ��");
	    	}
	    }else{
	    	int count = st.getStars()+stars;
	    	if(count<0){
	    		throw new RuntimeException("�۷�̫��");
	    	}
	    	st.setStars(count);
	    	n = sd.updateStars(st);
	    	if(n!=1){
	    		throw new RuntimeException("����ʧ��");
	    	}
	    }
		
		return n;
	}

	/*public int updateStars(Stars stars) {
		
		return 0;
	}*/

}
