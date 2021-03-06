package cn.tedu.entity;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = -2198794479585123541L;
	
	private Integer bid;
	private String bname;
	private TUser tuser;
	
	public Book() {}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	
	public TUser getTuser() {
		return tuser;
	}

	public void setTuser(TUser tuser) {
		this.tuser = tuser;
	}



	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", tuser=" + tuser.getName() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bid == null) ? 0 : bid.hashCode());
		result = prime * result + ((bname == null) ? 0 : bname.hashCode());
		result = prime * result + ((tuser == null) ? 0 : tuser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bid == null) {
			if (other.bid != null)
				return false;
		} else if (!bid.equals(other.bid))
			return false;
		if (bname == null) {
			if (other.bname != null)
				return false;
		} else if (!bname.equals(other.bname))
			return false;
		if (tuser == null) {
			if (other.tuser != null)
				return false;
		} else if (!tuser.equals(other.tuser))
			return false;
		return true;
	}
	
	
	

}
