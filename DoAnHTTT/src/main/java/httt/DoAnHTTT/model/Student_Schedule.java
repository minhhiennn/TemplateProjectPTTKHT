package httt.DoAnHTTT.model;

public class Student_Schedule {
	Semester semester;
	Schedule schedule;
	Student student;
	public Student_Schedule(Semester semester, Schedule schedule, Student student) {
		super();
		this.semester = semester;
		this.schedule = schedule;
		this.student = student;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
