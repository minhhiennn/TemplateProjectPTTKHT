package beans;

import java.util.Date;

public class Course_Offering {
	String iD_Course_Offering;
	Course course;
	String class_code;
	int max_Size, current_Size;
	Date start_Day, end_Day;
	String study_place;
	int start_Slot, end_Slot, eeekdays;
	String theoretical;

	public Course_Offering(String iD_Course_Offering, Course course, String class_code, int max_Size, int current_Size,
			Date start_Day, Date end_Day, String study_place, int start_Slot, int end_Slot, int eeekdays,
			String theoretical) {
		super();
		this.iD_Course_Offering = iD_Course_Offering;
		this.course = course;
		this.class_code = class_code;
		this.max_Size = max_Size;
		this.current_Size = current_Size;
		this.start_Day = start_Day;
		this.end_Day = end_Day;
		this.study_place = study_place;
		this.start_Slot = start_Slot;
		this.end_Slot = end_Slot;
		this.eeekdays = eeekdays;
		this.theoretical = theoretical;
	}

	public String getiD_Course_Offering() {
		return iD_Course_Offering;
	}

	public void setiD_Course_Offering(String iD_Course_Offering) {
		this.iD_Course_Offering = iD_Course_Offering;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getClass_code() {
		return class_code;
	}

	public void setClass_code(String class_code) {
		this.class_code = class_code;
	}

	public int getMax_Size() {
		return max_Size;
	}

	public void setMax_Size(int max_Size) {
		this.max_Size = max_Size;
	}

	public int getCurrent_Size() {
		return current_Size;
	}

	public void setCurrent_Size(int current_Size) {
		this.current_Size = current_Size;
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

	public int getEeekdays() {
		return eeekdays;
	}

	public void setEeekdays(int eeekdays) {
		this.eeekdays = eeekdays;
	}

	public String getTheoretical() {
		return theoretical;
	}

	public void setTheoretical(String theoretical) {
		this.theoretical = theoretical;
	}

}
