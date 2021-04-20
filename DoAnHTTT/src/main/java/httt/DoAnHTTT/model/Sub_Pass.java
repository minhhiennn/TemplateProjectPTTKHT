package httt.DoAnHTTT.model;

public class Sub_Pass {
	private Semester semester;
	private Course course;
	private Student student;
	private double score;
	private double ScoreSystem4;
	private String rated;

	public Sub_Pass(Semester semester, Course course, Student student, double score, double scoreSystem4,
			String rated) {
		super();
		this.semester = semester;
		this.course = course;
		this.student = student;
		this.score = score;
		ScoreSystem4 = scoreSystem4;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getScoreSystem4() {
		return ScoreSystem4;
	}

	public void setScoreSystem4(double scoreSystem4) {
		ScoreSystem4 = scoreSystem4;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

}
