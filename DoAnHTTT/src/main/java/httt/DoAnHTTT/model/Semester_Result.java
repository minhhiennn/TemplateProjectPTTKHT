package httt.DoAnHTTT.model;

public class Semester_Result {
	Semester semester;
	Student student;
	float  gradeAv;
	int creditGet;
	public Semester_Result(Semester semester, Student student, float gradeAv, int creditGet) {
		super();
		this.semester = semester;
		this.student = student;
		this.gradeAv = gradeAv;
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
	public float getGradeAv() {
		return gradeAv;
	}
	public void setGradeAv(float gradeAv) {
		this.gradeAv = gradeAv;
	}
	public int getCreditGet() {
		return creditGet;
	}
	public void setCreditGet(int creditGet) {
		this.creditGet = creditGet;
	}
	
}
