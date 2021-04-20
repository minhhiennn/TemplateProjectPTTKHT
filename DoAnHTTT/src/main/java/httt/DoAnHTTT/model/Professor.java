package httt.DoAnHTTT.model;

import java.util.Date;

public class Professor {
	private User user;
	private String professor_Name;
	private Faculty faculty;
	private Date create_date;
	private String degree;
	public Professor(User user, String professor_Name, Faculty faculty, Date create_date, String degree) {
		super();
		this.user = user;
		this.professor_Name = professor_Name;
		this.faculty = faculty;
		this.create_date = create_date;
		this.degree = degree;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getProfessor_Name() {
		return professor_Name;
	}
	public void setProfessor_Name(String professor_Name) {
		this.professor_Name = professor_Name;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}

}
