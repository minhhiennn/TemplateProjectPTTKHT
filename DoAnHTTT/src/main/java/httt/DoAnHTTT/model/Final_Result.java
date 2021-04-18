package httt.DoAnHTTT.model;

public class Final_Result {
	Student student;
	float gradeAv;
	float gradeAv4;

	public Final_Result(Student student, float gradeAv,float gradeAv4) {
		super();
		this.student = student;
		this.gradeAv = gradeAv;
		this.gradeAv4=gradeAv4;
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
	public float getGradeAv4(){
		return gradeAv4;
	}
}
