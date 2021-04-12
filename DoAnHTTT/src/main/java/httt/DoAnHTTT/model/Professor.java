package httt.DoAnHTTT.model;

import java.util.Date;

public class Professor {
	String ID_Professor;
	String professor_Name;
	Faculty faculty;
	Date create_date;
	String degree;

	public Professor(String ID_Professor, String professor_Name, Faculty faculty, Date create_date, String degree) {
		super();
		this.ID_Professor = ID_Professor;
		this.professor_Name = professor_Name;
		this.faculty = faculty;
		this.create_date = create_date;
		this.degree = degree;
	}

	public String getID_Professor() {
		return ID_Professor;
	}

	public void setID_Professor(String iD_Professor) {
		ID_Professor = iD_Professor;
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

	@Override
	public String toString() {
		return "Professor [ID_Professor=" + ID_Professor + ", professor_Name=" + professor_Name + ", faculty=" + faculty
				+ ", create_date=" + create_date + ", degree=" + degree + "]";
	}

}
