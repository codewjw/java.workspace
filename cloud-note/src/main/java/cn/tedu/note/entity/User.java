package cn.tedu.note.entity;

import java.io.Serializable;

public class User implements Serializable {
   
	/**
	 * 序列化版本号，目的是保证序列化的稳定性
	 */
	private static final long serialVersionUID = 5251234907750237530L;
	
	private String userId;
    private String userName;
    private String userPasswd;
    private String userToken;
    private String userNick;
   
	public User() {}
	
	public User(String userId, String userName, String userPasswd, 
			String userToken, String userNick) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPasswd = userPasswd;
		this.userToken = userToken;
		this.userNick = userNick;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPasswd() {
		return userPasswd;
	}
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPasswd=" + userPasswd + ", userToken="
				+ userToken + ", userNick=" + userNick + "]";
	}

	//重写hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	
	//重写equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
	   
	
}
