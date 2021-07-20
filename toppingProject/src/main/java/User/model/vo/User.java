package User.model.vo;

import java.sql.Date;

public class User implements java.io.Serializable{
	private static final long serialVersionUID = 111L;
	
	private int userno;
	private String nickname;
	private String userid;
	private String pwd;
	private String username;
	private String userimg;
	private String phone;
	private String userstatus;
	private String authority;
	private java.sql.Date enrolldate;
	private java.sql.Date deletedate;

	public User() {}

	public User(int userno, String nickname, String userid, String pwd, String username, String phone,
			String userstatus, String authority, Date enrolldate, Date deletedate) {
		super();
		this.userno = userno;
		this.nickname = nickname;
		this.userid = userid;
		this.pwd = pwd;
		this.username = username;
		this.phone = phone;
		this.userstatus = userstatus;
		this.authority = authority;
		this.enrolldate = enrolldate;
		this.deletedate = deletedate;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserimg() {
		return userimg;
	}

	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public java.sql.Date getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(java.sql.Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	public java.sql.Date getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(java.sql.Date deletedate) {
		this.deletedate = deletedate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [userno=" + userno + ", nickname=" + nickname + ", userid=" + userid + ", pwd=" + pwd
				+ ", username=" + username + ", userimg=" + userimg + ", phone=" + phone + ", userstatus=" + userstatus
				+ ", authority=" + authority + ", enrolldate=" + enrolldate + ", deletedate=" + deletedate + "]";
	}
	
	
}
