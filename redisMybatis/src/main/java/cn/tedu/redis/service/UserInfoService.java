package cn.tedu.redis.service;

import java.util.List;

import cn.tedu.redis.model.UserInfo;

public interface UserInfoService {
	/**
     * ��ȡ���е��û�
     * 
     * @return
     */
    public List<UserInfo> getUserInfos();

    /**
     * �����Ñ�id��ȡ�û���Ϣ
     * 
     * @param id
     * @return
     */
    public UserInfo getUserInfoByID(int id);

    /**
     * ����redis��key��ȡredis��һ���ı���value
     * @param key
     * @return
     */
    public String getValueByRedisKey(String key);
}
