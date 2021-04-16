package httt.DoAnHTTT.model;

public class Course {
	String iD_Course, name_Course;
	Faculty faculty;
	int course_certificate, years, numberS;
	public Course(String iD_Course, String name_Course, Faculty faculty, int course_certificate, int years,
			int numberS) {
		super();
		this.iD_Course = iD_Course;
		this.name_Course = name_Course;
		this.faculty = faculty;
		this.course_certificate = course_certificate;
		this.years = years;
		this.numberS = numberS;
	}
	public String getiD_Course() {
		return iD_Course;
	}
	public void setiD_Course(String iD_Course) {
		this.iD_Course = iD_Course;
	}
	public String getName_Course() {
		return name_Course;
	}
	public void setName_Course(String name_Course) {
		this.name_Course = name_Course;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public int getCourse_certificate() {
		return course_certificate;
	}
	public void setCourse_certificate(int course_certificate) {
		this.course_certificate = course_certificate;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public int getNumberS() {
		return numberS;
	}
	public void setNumberS(int numberS) {
		this.numberS = numberS;
	}

}
