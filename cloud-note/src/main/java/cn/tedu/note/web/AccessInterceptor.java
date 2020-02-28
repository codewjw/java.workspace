package cn.tedu.note.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tedu.note.controller.JsonResult;
import cn.tedu.note.entity.User;
@Component
public class AccessInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		String path = request.getRequestURI();
		//System.out.println("Interceptor:"+path);
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			JsonResult result = new JsonResult("请重先登录");
			response.setContentType("text/html;charset=utf-8");//接收时的编码
			response.setCharacterEncoding("utf-8");//发送时的编码
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(result);
			response.getWriter().println(json);
			response.flushBuffer();
			return false;
		}
		return true; //放过请求
	}

	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
