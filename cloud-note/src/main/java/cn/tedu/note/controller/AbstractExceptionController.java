package cn.tedu.note.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class AbstractExceptionController {

	 /*
     * spring��ܴ����쳣
     * ����������������ִ�г��쳣��ʱ��ִ���쳣������
     * @ExceptionHandlerע��ָ���쳣������
     */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult handlerException(Exception e) {
		return new JsonResult(e);
	}

}