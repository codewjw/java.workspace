package cn.poem.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.poem.result.JsonResult;

public abstract class AbstructHandleException {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult handleException(Exception e){
		return new JsonResult(e);
	}
}
