package beans;

import java.util.Date;

public class Schedule {
	Course course;
	Date startD,endD;
	Professor professor;
	Subject subject;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Date getStartD() {
		return startD;
	}
	public void setStartD(Date startD) {
		this.startD = startD;
	}
	public Date getEndD() {
		return endD;
	}
	public void setEndD(Date endD) {
		this.endD = endD;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Schedule(Course course, Date startD, Date endD, Professor professor, Subject subject) {
		super();
		this.course = course;
		this.startD = startD;
		this.endD = endD;
		this.professor = professor;
		this.subject = subject;
	}}
