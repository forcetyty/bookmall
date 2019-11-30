package kr.co.itcen.bookmall.vo;

public class Cart {

	private int no;
	private String userid;
	private String isbn;
	private String num;
	private String cart_date;
	private int count;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCart_date() {
		return cart_date;
	}

	public void setCart_date(String cart_date) {
		this.cart_date = cart_date;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Cart [no=" + no + ", userid=" + userid + ", isbn=" + isbn + ", num=" + num + ", cart_date=" + cart_date
				+ ", count=" + count + "]";
	}

}
