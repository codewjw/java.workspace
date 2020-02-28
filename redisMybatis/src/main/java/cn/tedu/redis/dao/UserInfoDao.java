package cn.tedu.redis.dao;

import java.util.List;

import cn.tedu.redis.model.UserInfo;

public interface UserInfoDao {
	 /**
     * ��ȡ���е��û�
     * @return
     */
    public List<UserInfo> getUserInfos();

    /**
     * �����Ñ�id��ȡ�û���Ϣ
     * @param id
     * @return
     */
    public UserInfo getUserInfoByID(int id);
}
