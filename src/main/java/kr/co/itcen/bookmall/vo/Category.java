package kr.co.itcen.bookmall.vo;


public class Category {

	private String maincate;
	private String midcate;
	private String countnum;

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

	public String getCountnum() {
		return countnum;
	}

	public void setCountnum(String countnum) {
		this.countnum = countnum;
	}

	@Override
	public String toString() {
		return "Category [maincate=" + maincate + ", midcate=" + midcate + ", countnum=" + countnum + "]";
	}

}
