package beans;

import java.util.Date;

public class Semester {
	String iD_Semester;
	Date startDate,endDate;
	int years,numberS;
	public Semester(String iD_Semester, Date startDate, Date endDate, int years, int numberS) {
		super();
		this.iD_Semester = iD_Semester;
		this.startDate = startDate;
		this.endDate = endDate;
		this.years = years;
		this.numberS = numberS;
	}
	public String getiD_Semester() {
		return iD_Semester;
	}
	public void setiD_Semester(String iD_Semester) {
		this.iD_Semester = iD_Semester;
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
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public int getNumberS() {
		return numberS;
	}
	public void setNumberS(int numberS) {
		this.numberS = numberS;
	}
	
	}
