package httt.DoAnHTTT.model;

public class TimeTableItem {
	private Schedule schedule;
	private String id_Professor;

	public TimeTableItem(Schedule schedule, String id_Professor) {
		super();
		this.schedule = schedule;
		this.id_Professor = id_Professor;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String getId_Professor() {
		return id_Professor;
	}

	public void setId_Professor(String id_Professor) {
		this.id_Professor = id_Professor;
	}

	@Override
	public String toString() {
		return "TimeTableItem [schedule=" + schedule + ", id_Professor=" + id_Professor + "]";
	}

}
