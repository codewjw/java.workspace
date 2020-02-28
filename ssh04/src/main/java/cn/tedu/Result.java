package cn.tedu;

import java.io.Serializable;

public class Result implements Serializable {
	
	private static final long serialVersionUID = 3246650548617904131L;
	
	private int status;
	private String msg;
	private Object data;
	
	public Result() {}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
