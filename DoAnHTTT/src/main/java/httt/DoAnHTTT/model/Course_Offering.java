package httt.DoAnHTTT.model;


public class Course_Offering {
	String iD_Course_Offering;
	Course course;
	Class class1;
	int max_Size, current_Size;
	public Course_Offering(String iD_Course_Offering, Course course, Class class1, int max_Size, int current_Size) {
		super();
		this.iD_Course_Offering = iD_Course_Offering;
		this.course = course;
		this.class1 = class1;
		this.max_Size = max_Size;
		this.current_Size = current_Size;
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
	public Class getClass1() {
		return class1;
	}
	public void setClass1(Class class1) {
		this.class1 = class1;
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
}
