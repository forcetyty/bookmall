package kr.co.itcen.bookmall.vo;

public class BookOrderDetail {

	private String isbn;
	private String name;
	private int price;
	private int orderNum;
	private String address;
	private String order_date;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "BookOrderDetail [isbn=" + isbn + ", name=" + name + ", price=" + price + ", orderNum=" + orderNum
				+ ", address=" + address + ", order_date=" + order_date + "]";
	}
	
	

}
