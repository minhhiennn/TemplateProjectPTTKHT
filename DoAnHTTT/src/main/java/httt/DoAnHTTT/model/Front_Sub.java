package httt.DoAnHTTT.model;

public class Front_Sub {
	String iD_CourseB;
	Course course;
	public Front_Sub(String iD_CourseB, Course course) {
		super();
		this.iD_CourseB = iD_CourseB;
		this.course = course;
	}
	public String getiD_CourseB() {
		return iD_CourseB;
	}
	public void setiD_CourseB(String iD_CourseB) {
		this.iD_CourseB = iD_CourseB;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	}
