package beans;

import java.sql.Date;

public class Professor {
	User user;
	Faculty faculty;
	String name,degree;
	Date createD;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public Date getCreateD() {
		return createD;
	}
	public void setCreateD(Date createD) {
		this.createD = createD;
	}
	public Professor(User user, Faculty faculty, String name, String degree, Date createD) {
		super();
		this.user = user;
		this.faculty = faculty;
		this.name = name;
		this.degree = degree;
		this.createD = createD;
	}
}
