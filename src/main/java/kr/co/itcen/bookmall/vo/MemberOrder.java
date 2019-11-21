package kr.co.itcen.bookmall.vo;

public class MemberOrder {

	private String userid;
	private String name;
	private int orderno;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	@Override
	public String toString() {
		return "MemberOrder [userid=" + userid + ", name=" + name + ", orderno=" + orderno + "]";
	}

}
