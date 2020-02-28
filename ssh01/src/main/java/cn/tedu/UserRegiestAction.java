package cn.tedu;

public class UserRegiestAction {
  
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String doRegiest(){
		System.out.println("UserRegiestAction.doRegiest()"+user.getUsername()+","+
	    user.getNick());
		return "success";
	}
}
