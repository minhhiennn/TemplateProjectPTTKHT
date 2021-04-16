package httt.DoAnHTTT.model;

public class Faculty {
	String iD_Faculty,name_Faculty;
	int ID_FacultyN;
	public Faculty(String iD_Faculty, String name_Faculty, int iD_FacultyN) {
		super();
		this.iD_Faculty = iD_Faculty;
		this.name_Faculty = name_Faculty;
		ID_FacultyN = iD_FacultyN;
	}
	public String getiD_Faculty() {
		return iD_Faculty;
	}
	public void setiD_Faculty(String iD_Faculty) {
		this.iD_Faculty = iD_Faculty;
	}
	public String getName_Faculty() {
		return name_Faculty;
	}
	public void setName_Faculty(String name_Faculty) {
		this.name_Faculty = name_Faculty;
	}
	public int getID_FacultyN() {
		return ID_FacultyN;
	}
	public void setID_FacultyN(int iD_FacultyN) {
		ID_FacultyN = iD_FacultyN;
	}

	}
