package httt.DoAnHTTT.model;

public class SubjectMapDTO {
	private String id_Course;
	private String name_Course;
	private String id_Semester;

	public SubjectMapDTO(String id_Course, String name_Course, String id_Semester) {
		super();
		this.id_Course = id_Course;
		this.name_Course = name_Course;
		this.id_Semester = id_Semester;
	}

	public String getId_Course() {
		return id_Course;
	}

	public void setId_Course(String id_Course) {
		this.id_Course = id_Course;
	}

	public String getName_Course() {
		return name_Course;
	}

	public void setName_Course(String name_Course) {
		this.name_Course = name_Course;
	}

	public String getId_Semester() {
		return id_Semester;
	}

	public void setId_Semester(String id_Semester) {
		this.id_Semester = id_Semester;
	}

	@Override
	public String toString() {
		return "SubjectMapDTO [id_Course=" + id_Course + ", name_Course=" + name_Course + ", id_Semester=" + id_Semester
				+ "]";
	}

}
