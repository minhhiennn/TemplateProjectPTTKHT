package httt.DoAnHTTT.model;

public class Class {
	private String class_Code;
	private Faculty faculty;
	private int max_Size,current_Size;
	public Class(String class_Code, Faculty faculty, int max_Size, int current_Size) {
		super();
		this.class_Code = class_Code;
		this.faculty = faculty;
		this.max_Size = max_Size;
		this.current_Size = current_Size;
	}
	public String getClass_Code() {
		return class_Code;
	}
	public void setClass_Code(String class_Code) {
		this.class_Code = class_Code;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public int getMax_Size() {
		return max_Size;
	}
	public void setMax_Size(int max_Size) {
		this.max_Size = max_Size;
	}
	public int getCurrent_Size() {
		return current_Size;
	}
	public void setCurrent_Size(int current_Size) {
		this.current_Size = current_Size;
	}
	
}
