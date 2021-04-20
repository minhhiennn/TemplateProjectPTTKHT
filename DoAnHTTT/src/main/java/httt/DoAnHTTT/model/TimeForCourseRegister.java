package httt.DoAnHTTT.model;

import java.util.Date;

public class TimeForCourseRegister {
	private String ID_Semester;
	private Date startDate;
	private Date endDate;

	public TimeForCourseRegister(String iD_Semester, Date startDate, Date endDate) {
		ID_Semester = iD_Semester;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getID_Semester() {
		return ID_Semester;
	}

	public void setID_Semester(String iD_Semester) {
		ID_Semester = iD_Semester;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
