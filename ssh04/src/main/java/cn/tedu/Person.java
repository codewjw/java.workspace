package cn.tedu;

import java.io.Serializable;

public class Person implements Serializable {

	
	private static final long serialVersionUID = 4171435543834699408L;
	
	private Integer id;
	private String name;
	private String message;
	
	public Person(Integer id, String name, String message) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
	}

	public Person() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", message=" + message + "]";
	}
	
	
	
	
	

}
