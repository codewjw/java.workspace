package cn.tedu.note.service;


public interface StarService {
   //public List<Map<String,Object>> findStarsByUserId();
   public int addStars(String userId,int stars) throws UserNotFoundException;
   //public int updateStars(Stars stars);
}
