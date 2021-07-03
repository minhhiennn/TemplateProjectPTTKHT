package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import httt.DoAnHTTT.model.BillingSystem;

public class BillingSystemDAO implements IDAO<BillingSystem> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public BillingSystemDAO() {
		conn = Connect.getConnection();
	}

	// check billing by ID_Student and Semester
	public boolean checkBilling(String ID_Student) {
		boolean bool = false;
		String ID_Semester = new SemesterDAO().getID_SemesterByGetDate();
		try {
			pstmt = conn.prepareStatement("select * from BillingSystem where ID_Student = ? and ID_Semester = ?");
			pstmt.setString(1, ID_Student);
			pstmt.setString(2, ID_Semester);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bool = true;
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bool;
	}

	// Tính tổng số tín chỉ tất cả môn học của từng học sinh trong học kỳ hiện tại
	public int sumCreadit(String ID_Student) {
		int result = 0;
		String ID_Semester = new SemesterDAO().getID_SemesterByGetDate();
		CourseDAO courseDAO = new CourseDAO();
		try {
			pstmt = conn.prepareStatement(
					"select DISTINCT c.ID_Course from Student_ScheduleR strr join Schedule sc on strr.ID_Schedule = sc.ID_Schedule\r\n"
							+ "                                         join Course_Offering co on sc.ID_Course_Offering = co.ID_Course_Offering\r\n"
							+ "                                         join Course c on co.ID_Course = c.ID_Course\r\n"
							+ "where strr.ID_Student = ? and strr.ID_Semester = ?");
			pstmt.setString(1, ID_Student);
			pstmt.setString(2, ID_Semester);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Course = rs.getString("ID_Course");
				int Course_certificate = courseDAO.getCourse_certificate(ID_Course);
				result += Course_certificate;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// Tính số tiền phải trả theo kỳ
	// 1 tín chỉ là 315 tiền
	public double getPaymoney(String ID_Student) {
		int sumCreadit = sumCreadit(ID_Student);
		double payMoney = sumCreadit * 315;
		return payMoney;
	}

	@Override
	public BillingSystem getByKey(String key) {
		return null;
	}

	@Override
	public BillingSystem getByKeyS(List<String> key) {
		return null;
	}

	@Override
	public boolean insert(BillingSystem key) {
		String ID_Semester = key.getID_Semester();
		String ID_Student = key.getID_Student();
		double Paymoney = key.getPaymoney();
		int creadit = key.getCreadit();
		try {
			pstmt = conn.prepareStatement("insert into BillingSystem values (?,?,?,?)");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Student);
			pstmt.setDouble(3, Paymoney);
			pstmt.setInt(4, creadit);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean update(BillingSystem key) {
		return false;
	}

	@Override
	public boolean delete(BillingSystem key) {
		return false;
	}

	public static void main(String[] args) {
		BillingSystemDAO billingSystemDAO = new BillingSystemDAO();
		System.out.println(billingSystemDAO.getPaymoney("18130005"));
	}
}
