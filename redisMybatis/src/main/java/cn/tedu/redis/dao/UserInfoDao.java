package cn.tedu.redis.dao;

import java.util.List;

import cn.tedu.redis.model.UserInfo;

public interface UserInfoDao {
	 /**
     * 获取所有的用户
     * @return
     */
    public List<UserInfo> getUserInfos();

    /**
     * 根據用戶id获取用户消息
     * @param id
     * @return
     */
    public UserInfo getUserInfoByID(int id);
}
