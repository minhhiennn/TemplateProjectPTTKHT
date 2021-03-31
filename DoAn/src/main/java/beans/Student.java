package beans;

import java.util.Date;

public class Student {
	User user;
	String student_Name;
	Faculty faculty;
	Date create_date;
	String class_code;
	int cert_number_required,cert_number_accumulated;
	public Student(User user, String student_Name, Faculty faculty, Date create_date, String class_code,
			int cert_number_required, int cert_number_accumulated) {
		super();
		this.user = user;
		this.student_Name = student_Name;
		this.faculty = faculty;
		this.create_date = create_date;
		this.class_code = class_code;
		this.cert_number_required = cert_number_required;
		this.cert_number_accumulated = cert_number_accumulated;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStudent_Name() {
		return student_Name;
	}
	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
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
	public String getClass_code() {
		return class_code;
	}
	public void setClass_code(String class_code) {
		this.class_code = class_code;
	}
	public int getCert_number_required() {
		return cert_number_required;
	}
	public void setCert_number_required(int cert_number_required) {
		this.cert_number_required = cert_number_required;
	}
	public int getCert_number_accumulated() {
		return cert_number_accumulated;
	}
	public void setCert_number_accumulated(int cert_number_accumulated) {
		this.cert_number_accumulated = cert_number_accumulated;
	}
	}
