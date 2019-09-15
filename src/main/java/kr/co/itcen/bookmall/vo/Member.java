package kr.co.itcen.bookmall.vo;

/*
 * user 테이블에 대한 VO
 * userid - 아이디
 * name - 이름
 * pnumber - 핸드폰 번호
 * email - 이메일
 * password - 비밀번호
 */

public class Member {

	private String userid;
	private String name;
	private String pnumber;
	private String email;
	private String password;

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

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", pnumber=" + pnumber + ", email=" + email + ", password="
				+ password + "]";
	}

}
