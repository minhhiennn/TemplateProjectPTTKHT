package httt.DoAnHTTT.model;

public class Faculty {
	String iD_Faculty,name_Faculty;

	public Faculty(String iD_Faculty, String name_Faculty) {
		super();
		this.iD_Faculty = iD_Faculty;
		this.name_Faculty = name_Faculty;
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

	}
