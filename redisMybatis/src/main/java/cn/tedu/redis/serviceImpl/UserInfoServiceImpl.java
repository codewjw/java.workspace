package cn.tedu.redis.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.redis.dao.RedisDao;
import cn.tedu.redis.dao.UserInfoDao;
import cn.tedu.redis.model.UserInfo;
import cn.tedu.redis.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
    UserInfoDao userInfoDao;

    @Resource
    RedisDao redisDao;

    public List<UserInfo> getUserInfos() {
        return userInfoDao.getUserInfos();
    }

    public UserInfo getUserInfoByID(int id) {
        return userInfoDao.getUserInfoByID(id);
    }

    public String getValueByRedisKey(String key) {
        return redisDao.get(key);
    }
}
