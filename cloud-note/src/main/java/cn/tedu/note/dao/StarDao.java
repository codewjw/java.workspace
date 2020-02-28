package cn.tedu.note.dao;

import cn.tedu.note.entity.Stars;

public interface StarDao {
    Stars findStarsByUserId(String userId);
    
    int insertStars(Stars stars);
    
    int updateStars(Stars stars);
}
