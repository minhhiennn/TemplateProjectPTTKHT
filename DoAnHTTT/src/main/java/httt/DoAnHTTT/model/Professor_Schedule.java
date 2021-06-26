package httt.DoAnHTTT.model;

public class Professor_Schedule {
	private Semester semester;
	private Schedule schedule;
	private Professor professor;
	public Professor_Schedule(Semester semester, Schedule schedule, Professor professor) {
		super();
		this.semester = semester;
		this.schedule = schedule;
		this.professor = professor;
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
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}	
}
