package httt.DoAnHTTT.model;

public class BillingSystem {
	private String ID_Semester;
	private String ID_Student;
	private double Paymoney;
	private int creadit;

	public BillingSystem(String iD_Semester, String iD_Student, double paymoney, int creadit) {
		ID_Semester = iD_Semester;
		ID_Student = iD_Student;
		Paymoney = paymoney;
		this.creadit = creadit;
	}

	public String getID_Semester() {
		return ID_Semester;
	}

	public void setID_Semester(String iD_Semester) {
		ID_Semester = iD_Semester;
	}

	public String getID_Student() {
		return ID_Student;
	}

	public void setID_Student(String iD_Student) {
		ID_Student = iD_Student;
	}

	public double getPaymoney() {
		return Paymoney;
	}

	public void setPaymoney(double paymoney) {
		Paymoney = paymoney;
	}

	public int getCreadit() {
		return creadit;
	}

	public void setCreadit(int creadit) {
		this.creadit = creadit;
	}

}
