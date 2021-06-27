package httt.DoAnHTTT.model;

public class StudentMapDTO {
	private String id_Student;
	private String name_Student;

	public StudentMapDTO(String id_Student, String name_Student) {
		super();
		this.id_Student = id_Student;
		this.name_Student = name_Student;
	}

	public String getId_Student() {
		return id_Student;
	}

	public void setId_Student(String id_Student) {
		this.id_Student = id_Student;
	}

	public String getName_Student() {
		return name_Student;
	}

	public void setName_Student(String name_Student) {
		this.name_Student = name_Student;
	}

	@Override
	public String toString() {
		return "StudentMapDTO [id_Student=" + id_Student + ", name_Student=" + name_Student + "]";
	}

}
