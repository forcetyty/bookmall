package kr.co.itcen.bookmall.vo;



/*
 * isbm - String - 책 고유 식별번호
 * name - String - 책 이름
 * price - int   - 책 가격
 * maincate - String - 대분류 - 외래키
 * midcate - String  - 중분류 - 외래키
 * 
 */

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

}
