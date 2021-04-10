package httt.DoAnHTTT.model;

public class User {
	String iD_User,iD_UserKind,email,password;

	public User(String iD_User, String iD_UserKind, String email, String password) {
		super();
		this.iD_User = iD_User;
		this.iD_UserKind = iD_UserKind;
		this.email = email;
		this.password = password;
	}

	public String getiD_User() {
		return iD_User;
	}

	public void setiD_User(String iD_User) {
		this.iD_User = iD_User;
	}

	public String getiD_UserKind() {
		return iD_UserKind;
	}

	public void setiD_UserKind(String iD_UserKind) {
		this.iD_UserKind = iD_UserKind;
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

	}
