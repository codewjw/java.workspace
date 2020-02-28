package cn.tedu.note.entity;

import java.io.Serializable;

public class Stars implements Serializable {


	private static final long serialVersionUID = -2402091082427412347L;
	
	private String id;
	private String userId;
	private Integer stars;
	
	public Stars() {}

	public Stars(String id, String userId, Integer stars) {
		this.id = id;
		this.userId = userId;
		this.stars = stars;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "Stars [id=" + id + ", userId=" + userId + ", stars=" + stars + "]";
	}
	
	
}
