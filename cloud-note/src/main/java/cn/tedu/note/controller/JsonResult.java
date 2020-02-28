package cn.tedu.note.controller;

import java.io.Serializable;

public class JsonResult implements Serializable {

	private static final long serialVersionUID = -4665297931158992088L;

	private final static int SUCCESS=0;
	private final static int ERROR=1;
	
	private int state = SUCCESS;
	private String message;
	private Object data;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public JsonResult() {}
	
	public JsonResult(Throwable e) {
        this.state = ERROR;
		this.message = e.getMessage();
	}
    
	public JsonResult(String msg){
		this.state=ERROR;
		this.message=msg;
	}
	
	public JsonResult(int state,Throwable e){
		this.state = state;
		this.message = e.getMessage();
	}
	
	public JsonResult(Object data) {
		this.data = data;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
