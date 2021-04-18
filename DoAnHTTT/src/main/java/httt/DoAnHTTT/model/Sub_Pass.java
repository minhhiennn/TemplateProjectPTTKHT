package httt.DoAnHTTT.model;

public class Sub_Pass {
	Semester semester;
	Course course;
	Student student;
	float score;
	String rated;
	public Sub_Pass(Semester semester, Course course, Student student, float score, String rated) {
		super();
		this.semester = semester;
		this.course = course;
		this.student = student;
		this.score = score;
		this.rated = rated;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	@Override
	public String toString() {
		return "Sub_Pass [semester=" + semester + ", course=" + course + ", student=" + student + ", score=" + score
				+ ", rated=" + rated + "]";
	}
	
}
