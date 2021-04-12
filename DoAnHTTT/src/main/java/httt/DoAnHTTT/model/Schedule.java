package httt.DoAnHTTT.model;

public class Schedule {
	String iD_Schedule;
	Course_Offering course_Offering;
	Professor professor;

	public Schedule(String iD_Schedule, Course_Offering course_Offering, Professor professor) {
		super();
		this.iD_Schedule = iD_Schedule;
		this.course_Offering = course_Offering;
		this.professor = professor;
	}

	public String getiD_Schedule() {
		return iD_Schedule;
	}

	public void setiD_Schedule(String iD_Schedule) {
		this.iD_Schedule = iD_Schedule;
	}

	public Course_Offering getCourse_Offering() {
		return course_Offering;
	}

	public void setCourse_Offering(Course_Offering course_Offering) {
		this.course_Offering = course_Offering;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return "Schedule [iD_Schedule=" + iD_Schedule + ", course_Offering=" + course_Offering + ", professor="
				+ professor + "]";
	}

}
