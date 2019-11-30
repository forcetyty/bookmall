package kr.co.itcen.bookmall.vo;

public class MemberOrder {
	private String userid;
	private int orderno;
	private String order_date;
	private String name;

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

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
		return "MemberOrder [userid=" + userid + ", orderno=" + orderno + ", order_date=" + order_date + ", name="
				+ name + "]";
	}

}
