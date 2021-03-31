package beans;

public class Course {
	int id,certificate;
	String name;
	public Course(int id, int certificate, String name) {
		super();
		this.id = id;
		this.certificate = certificate;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCertificate() {
		return certificate;
	}
	public void setCertificate(int certificate) {
		this.certificate = certificate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
