package beans;

public class Student {
	User user;
	int  idUK;
	String name, classCode, idF, createDate;
	public Student(User user, int idUK, String name, String classCode, String idF, String createDate) {
		super();
		this.user = user;
		this.idUK = idUK;
		this.name = name;
		this.classCode = classCode;
		this.idF = idF;
		this.createDate = createDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getIdUK() {
		return idUK;
	}
	public void setIdUK(int idUK) {
		this.idUK = idUK;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public String getIdF() {
		return idF;
	}
	public void setIdF(String idF) {
		this.idF = idF;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
