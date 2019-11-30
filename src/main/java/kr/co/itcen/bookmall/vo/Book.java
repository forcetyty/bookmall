package kr.co.itcen.bookmall.vo;

public class Book {

	private String isbn;
	private String name;
	private int price;
	private String maincate;
	private String midcate;
	private String count;

	
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

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

	public String getMaincate() {
		return maincate;
	}

	public void setMaincate(String maincate) {
		this.maincate = maincate;
	}

	public String getMidcate() {
		return midcate;
	}

	public void setMidcate(String midcate) {
		this.midcate = midcate;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", price=" + price + ", maincate=" + maincate + ", midcate="
				+ midcate + ", count=" + count + "]";
	}
	
	

}
