package httt.DoAnHTTT.model;

public class Semester_Result {
	private Semester semester;
	private Student student;
	private double gradeAv;
	private double gradeAv4;
	private int creditGet;

	public Semester_Result(Semester semester, Student student, double gradeAv, double gradeAv4, int creditGet) {
		super();
		this.semester = semester;
		this.student = student;
		this.gradeAv = gradeAv;
		this.gradeAv4 = gradeAv4;
		this.creditGet = creditGet;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public double getGradeAv() {
		return gradeAv;
	}

	public void setGradeAv(double gradeAv) {
		this.gradeAv = gradeAv;
	}

	public double getGradeAv4() {
		return gradeAv4;
	}

	public void setGradeAv4(double gradeAv4) {
		this.gradeAv4 = gradeAv4;
	}

	public int getCreditGet() {
		return creditGet;
	}

	public void setCreditGet(int creditGet) {
		this.creditGet = creditGet;
	}

}
