package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Course_Offering;
import httt.DoAnHTTT.model.Professor;
import httt.DoAnHTTT.model.Schedule;
import httt.DoAnHTTT.model.Semester;
import httt.DoAnHTTT.model.Semester_Result;
import httt.DoAnHTTT.model.Student;
import httt.DoAnHTTT.model.Sub_Pass;

public class Semester_ResultDAO implements IDAO<Semester_Result> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Semester_ResultDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Semester_Result getByKey(String key) {
		return null;
	}

	@Override
	public Semester_Result getByKeyS(List<String> key) {
		Semester_Result semester_Result = null;
		try {
			pstmt = conn.prepareStatement("select * from Semester_Result where ID_Semester = ? and ID_Student = ?");
			pstmt.setString(1, key.get(0));
			pstmt.setString(2, key.get(1));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SemesterDAO semesterDAO = new SemesterDAO();
				Semester semester = semesterDAO.getByKey(key.get(0));
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.getByKey(key.get(2));
				float gradeAv = rs.getFloat("gradeAv");
				int creditGet = rs.getInt("creditGet");
				semester_Result = new Semester_Result(semester, student, gradeAv, creditGet);

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
		return semester_Result;
	}

	@Override
	public boolean insert(Semester_Result key) {
		String ID_Semester = key.getSemester().getiD_Semester();
		String ID_Student = key.getStudent().getUser().getiD_User();
		double gradeAv = key.getGradeAv();
		int creditGet = key.getCreditGet();
		try {
			pstmt = conn.prepareStatement("insert into semester_Result values(?,?,?,?)");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Student);
			pstmt.setDouble(3, gradeAv);
			pstmt.setInt(4, creditGet);
			int row = pstmt.executeUpdate();
			System.out.println(row);
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
		return false;
	}

	@Override
	public boolean update(Semester_Result key) {
		return false;
	}

	@Override
	public boolean delete(Semester_Result key) {
		return false;
	}

	public double getDiemTBHe4(String ID_Student, String ID_Semester) {
		double Diem_TB_He_4 = 0;
		try {
			pstmt = conn.prepareStatement(
					"select SUM(gr.ScoreSystem4 * gr.Course_certificate)/SUM(gr.Course_certificate) Diem_TB_He_4 from get_Semester_Reuslt(?,?) gr");
			pstmt.setString(1, ID_Student);
			pstmt.setString(2, ID_Semester);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Diem_TB_He_4 = rs.getDouble("Diem_TB_He_4");
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
		return Diem_TB_He_4;
	}

	public int getSoTinChiDaDat(String ID_Student, String ID_Semester) {
		int tinChi = 0;
		try {
			pstmt = conn.prepareStatement(
					"select SUM(gr.Course_certificate) so_TC from get_Semester_Reuslt(?,?) gr where gr.Score > 4.0");
			pstmt.setString(1, ID_Student);
			pstmt.setString(2, ID_Semester);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				tinChi = rs.getInt("so_TC");
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
		return tinChi;
	}

	public static void main(String[] args) {
		Semester_ResultDAO semester_ResultDAO = new Semester_ResultDAO();
		System.out.println(semester_ResultDAO.getDiemTBHe4("18130005", "2_2018"));
		System.out.println(semester_ResultDAO.getSoTinChiDaDat("18130005", "2_2018"));
	}
}