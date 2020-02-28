package cn.tedu.redis.controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import cn.tedu.redis.model.UserInfo;
import cn.tedu.redis.service.UserInfoService;


@Controller
@RequestMapping("/user")
public class UserInfoController {
	 protected Logger logger = LoggerFactory.getLogger(getClass());

	    @Resource
	    UserInfoService userInfoService;

	    @RequestMapping("/userInfo")
	    public ModelAndView getUserInfoByID(int id) {
	        // ָ��view���ҳ��,����user��Ϊ��Ӧ��jsp������
	        ModelAndView mav = new ModelAndView("user");
	        if (id <= 0)
	            id = 1;
	        // ��ȡ����
	        UserInfo userInfo = userInfoService.getUserInfoByID(id);
	        // ����ȡ���Ķ�����ӵ�ModelAndView������
	        mav.addObject("user", userInfo);
	        return mav;
	    }

	    @RequestMapping("/getUserInfos")
	    @ResponseBody
	    public List<UserInfo> getUserInfos() {
	        List<UserInfo> users = userInfoService.getUserInfos();
	        logger.info(""+JSON.toJSONString(users));
	        return users;
	    }
}
