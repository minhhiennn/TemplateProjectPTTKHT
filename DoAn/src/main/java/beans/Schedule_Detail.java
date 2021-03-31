package beans;

public class Schedule_Detail {
	Schedule schedule;
	Professor professor;
	int startS,endS,weekDays;
	boolean theoretical;
	public Schedule_Detail(Schedule schedule, Professor professor, int startS, int endS, int weekDays,
			boolean theoretical) {
		super();
		this.schedule = schedule;
		this.professor = professor;
		this.startS = startS;
		this.endS = endS;
		this.weekDays = weekDays;
		this.theoretical = theoretical;
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
	public int getStartS() {
		return startS;
	}
	public void setStartS(int startS) {
		this.startS = startS;
	}
	public int getEndS() {
		return endS;
	}
	public void setEndS(int endS) {
		this.endS = endS;
	}
	public int getWeekDays() {
		return weekDays;
	}
	public void setWeekDays(int weekDays) {
		this.weekDays = weekDays;
	}
	public boolean isTheoretical() {
		return theoretical;
	}
	public void setTheoretical(boolean theoretical) {
		this.theoretical = theoretical;
	}
	
}
