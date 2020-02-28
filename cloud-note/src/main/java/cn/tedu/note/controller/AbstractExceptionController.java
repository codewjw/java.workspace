package cn.tedu.note.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class AbstractExceptionController {

	 /*
     * spring框架处理异常
     * 在其他控制器方法执行出异常的时候，执行异常处理方法
     * @ExceptionHandler注解指定异常处理方法
     */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult handlerException(Exception e) {
		return new JsonResult(e);
	}

}