package httt.DoAnHTTT.model;

public class Front_Sub {
	private Course course,courseB;

	public Front_Sub(Course course, Course courseB) {
		super();
		this.course = course;
		this.courseB = courseB;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Course getCourseB() {
		return courseB;
	}

	public void setCourseB(Course courseB) {
		this.courseB = courseB;
	}

	}
