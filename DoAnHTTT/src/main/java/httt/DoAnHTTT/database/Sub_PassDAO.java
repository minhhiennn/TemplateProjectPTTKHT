package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Schedule;
import httt.DoAnHTTT.model.Semester;
import httt.DoAnHTTT.model.Student;
import httt.DoAnHTTT.model.Student_Schedule;
import httt.DoAnHTTT.model.Sub_Pass;

public class Sub_PassDAO implements IDAO<Sub_Pass> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Sub_PassDAO() {
		conn = Connect.getConnection();
	}

	// Lấy điểm của học sinh theo môn học và học kỳ
	public String getScoreStudentByCourseAndSemester(String id_Student, String id_Course, String id_Semester) {
		String result = null;
		try {
			pstmt = conn.prepareStatement(
					"select sp.Score from Sub_Pass sp where sp.ID_Student = ? and sp.ID_Course = ? and sp.ID_Semester = ?");
			pstmt.setString(1, id_Student);
			pstmt.setString(2, id_Course);
			pstmt.setString(3, id_Semester);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int score = rs.getInt("Score");
				result = String.valueOf(score);
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

	// Tìm nếu đã tồn tại trong database
	public boolean checkExist(String id_Student, String id_Course, String id_Semester) {
		boolean exist = false;
		try {
			pstmt = conn.prepareStatement(
					"select sp.Score from Sub_Pass sp where sp.ID_Student = ? and sp.ID_Course = ? and sp.ID_Semester = ?");
			pstmt.setString(1, id_Student);
			pstmt.setString(2, id_Course);
			pstmt.setString(3, id_Semester);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				exist = true;
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
		return exist;
	}

	@Override
	public Sub_Pass getByKey(String key) {
		return null;
	}

	@Override
	public Sub_Pass getByKeyS(List<String> key) {
		Sub_Pass sub_Pass = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from Sub_Pass where ID_Semester = ? and ID_Course = ? and ID_Student = ?");
			pstmt.setString(1, key.get(0));
			pstmt.setString(2, key.get(1));
			pstmt.setString(3, key.get(2));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SemesterDAO semesterDAO = new SemesterDAO();
				Semester semester = semesterDAO.getByKey(key.get(0));
				CourseDAO courseDAO = new CourseDAO();
				Course course = courseDAO.getByKey(key.get(1));
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.getByKey(key.get(2));
				double Score = rs.getDouble("Score");
				double ScoreSystem4 = rs.getDouble("ScoreSystem4");
				String Rated = rs.getString("Rated");
				sub_Pass = new Sub_Pass(semester, course, student, Score, ScoreSystem4, Rated);

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
		return sub_Pass;
	}

	@Override
	public boolean insert(Sub_Pass key) {
		String ID_Semester = key.getSemester().getiD_Semester();
		String ID_Course = key.getCourse().getiD_Course();
		String ID_Student = key.getStudent().getUser().getiD_User();
		double Score = key.getScore();
		double ScoreSystem4 = key.getScoreSystem4();
		String rated = key.getRated();
		try {
			pstmt = conn.prepareStatement("insert into Sub_Pass values(?,?,?,?,?,?)");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Course);
			pstmt.setString(3, ID_Student);
			pstmt.setDouble(4, Score);
			pstmt.setDouble(5, ScoreSystem4);
			pstmt.setString(6, rated);
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
	public boolean update(Sub_Pass key) {
		String id_Semester = key.getSemester().getiD_Semester();
		String id_Course = key.getCourse().getiD_Course();
		String id_Student = key.getStudent().getUser().getiD_User();
		double score = key.getScore();
		double scoreSystem4 = key.getScoreSystem4();
		String Rated = key.getRated();
		try {
			pstmt = conn.prepareStatement(
					"update Sub_Pass set Score = ?, ScoreSystem4 = ?,Rated = ? where ID_Student = ? and ID_Course = ? and ID_Semester = ?");
			pstmt.setDouble(1, score);
			pstmt.setDouble(2, scoreSystem4);
			pstmt.setString(3, Rated);
			pstmt.setString(4, id_Student);
			pstmt.setString(5, id_Course);
			pstmt.setString(6, id_Semester);
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
	public boolean delete(Sub_Pass key) {
		return false;
	}

	// check xem student da hoc QUA mon nay hay chua
	public boolean checkScoreSub_Pass(String ID_Student, String ID_Course) {
		boolean bool = false;
		try {
			pstmt = conn
					.prepareStatement("select * from Sub_Pass where ID_Student = ? and ID_Course = ? and Score > 4.0");
			pstmt.setString(1, ID_Student);
			pstmt.setString(2, ID_Course);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bool = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
	public ArrayList<Sub_Pass> getDataScore(String ID_Student, String ID_Course,String ID_semester) {
		ArrayList<Sub_Pass> list=new ArrayList<Sub_Pass>();
		try {
			pstmt = conn.prepareStatement(
					"select * from Sub_Pass where ID_Semester = ? and ID_Course = ? and ID_Student = ?");
			pstmt.setString(1, ID_semester);
			pstmt.setString(2, ID_Course);
			pstmt.setString(3, ID_Student);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SemesterDAO semesterDAO = new SemesterDAO();
				Semester semester = semesterDAO.getByKey(ID_semester);
				CourseDAO courseDAO = new CourseDAO();
				Course course = courseDAO.getByKey(ID_Course);
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.getByKey(ID_Student);
				double Score = rs.getDouble("Score");
				double ScoreSystem4 = rs.getDouble("ScoreSystem4");
				String Rated = rs.getString("Rated");
				Sub_Pass sub_Pass = new Sub_Pass(semester, course, student, Score, ScoreSystem4, Rated);
				list.add(sub_Pass);
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
		return list;
	}
	public static void main(String[] args) {
		Sub_PassDAO sub_PassDAO = new Sub_PassDAO();
		System.out.println(sub_PassDAO.checkExist("18130006", "214370", "2020_2"));
	}
}
