package httt.DoAnHTTT.model;

import java.util.Date;

public class Schedule {
	private String iD_Schedule;
	private Course_Offering course_Offering;
	private Professor professor;
	private String theoretical;
	private int teaching_Day;
	private Date start_Day,end_Day;
	private String study_place;	
	private int start_Slot,end_Slot;
	public Schedule(String iD_Schedule, Course_Offering course_Offering, Professor professor, String theoretical,
			int teaching_Day, Date start_Day, Date end_Day, String study_place, int start_Slot, int end_Slot) {
		super();
		this.iD_Schedule = iD_Schedule;
		this.course_Offering = course_Offering;
		this.professor = professor;
		this.theoretical = theoretical;
		this.teaching_Day = teaching_Day;
		this.start_Day = start_Day;
		this.end_Day = end_Day;
		this.study_place = study_place;
		this.start_Slot = start_Slot;
		this.end_Slot = end_Slot;
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
	public String getTheoretical() {
		return theoretical;
	}
	public void setTheoretical(String theoretical) {
		this.theoretical = theoretical;
	}
	public int getTeaching_Day() {
		return teaching_Day;
	}
	public void setTeaching_Day(int teaching_Day) {
		this.teaching_Day = teaching_Day;
	}
	public Date getStart_Day() {
		return start_Day;
	}
	public void setStart_Day(Date start_Day) {
		this.start_Day = start_Day;
	}
	public Date getEnd_Day() {
		return end_Day;
	}
	public void setEnd_Day(Date end_Day) {
		this.end_Day = end_Day;
	}
	public String getStudy_place() {
		return study_place;
	}
	public void setStudy_place(String study_place) {
		this.study_place = study_place;
	}
	public int getStart_Slot() {
		return start_Slot;
	}
	public void setStart_Slot(int start_Slot) {
		this.start_Slot = start_Slot;
	}
	public int getEnd_Slot() {
		return end_Slot;
	}
	public void setEnd_Slot(int end_Slot) {
		this.end_Slot = end_Slot;
	}
	
}