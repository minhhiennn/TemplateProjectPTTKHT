package beans;

public class Course_Offering {
	Course course;
	int id, maxSize, currentSize;
	String classCode;
	public Course_Offering(Course course, int id, int maxSize, int currentSize, String classCode) {
		super();
		this.course = course;
		this.id = id;
		this.maxSize = maxSize;
		this.currentSize = currentSize;
		this.classCode = classCode;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public int getCurrentSize() {
		return currentSize;
	}
	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
}
