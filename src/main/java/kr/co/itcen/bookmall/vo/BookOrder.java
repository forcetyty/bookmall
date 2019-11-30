package kr.co.itcen.bookmall.vo;

public class BookOrder {

	private int cartno;
	private int orderno;
	private String order_date;
	private String addr;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getCartno() {
		return cartno;
	}

	public void setCartno(int cartno) {
		this.cartno = cartno;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "BookOrder [cartno=" + cartno + ", orderno=" + orderno + ", order_date=" + order_date + ", addr=" + addr
				+ "]";
	}
	
	

}
