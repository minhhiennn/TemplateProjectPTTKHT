package httt.DoAnHTTT.model;


public class Schedule {
	String iD_Schedule;
	Course_Offering course_Offering;
	Professor professor;
	int teaching_Day;
	public Schedule(String iD_Schedule, Course_Offering course_Offering, Professor professor, int teaching_Day) {
		super();
		this.iD_Schedule = iD_Schedule;
		this.course_Offering = course_Offering;
		this.professor = professor;
		this.teaching_Day = teaching_Day;
	}
	public String getiD_Schedule() {
		return iD_Schedule;
	}
	public void setiD_Schedule(String iD_Schedule) {
		this.iD_Schedule = iD_Schedule;
	}
	public Course_Offering getCourse_Offering() {
		return course_Offering;
	}
	public void setCourse_Offering(Course_Offering course_Offering) {
		this.course_Offering = course_Offering;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public int getTeaching_Day() {
		return teaching_Day;
	}
	public void setTeaching_Day(int teaching_Day) {
		this.teaching_Day = teaching_Day;
	}
	
	}
