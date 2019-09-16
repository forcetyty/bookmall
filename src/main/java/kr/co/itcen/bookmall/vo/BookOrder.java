package kr.co.itcen.bookmall.vo;

//카트를 주문하는 Vo
// cartno - int - 카트 고유 번호를 가지고 오는 기능
// orderno - int - 주문 고유 번호
// order_date - date - 주문날짜
public class BookOrder {

	private int cartno;
	private int orderno;
	private String order_date;

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

}
