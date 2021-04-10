package httt.DoAnHTTT.model;

public class Final_Result {
	Student student;
	float gradeAv;
	int creditGet;
	public Final_Result(Student student, float gradeAv, int creditGet) {
		super();
		this.student = student;
		this.gradeAv = gradeAv;
		this.creditGet = creditGet;
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
