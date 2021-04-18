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

public class Semester_ResultDAO implements IDAO<Semester_Result>{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Semester_ResultDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Semester_Result getByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Semester_Result getByKeyS(List<String> key) {
		Semester_Result semester_Result = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from Semester_Result where ID_Semester = ? and ID_Student = ?");
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
		String ID_Semester=key.getSemester().getiD_Semester();
		String ID_Student=key.getStudent().getUser().getiD_User();
		float gradeAv=key.getGradeAv();
		int creditGet=key.getCreditGet();
		try {
			pstmt=conn.prepareStatement("insert into semester_Result values (?,?,?,?)");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Student);
			pstmt.setFloat(3, gradeAv);
			pstmt.setInt(4, creditGet);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return false;
	}

	@Override
	public boolean update(Semester_Result key) {
		String ID_Semester=key.getSemester().getiD_Semester();
		String ID_Student=key.getStudent().getUser().getiD_User();
		float gradeAv=key.getGradeAv();
		int creditGet=key.getCreditGet();
		try {
			pstmt=conn.prepareStatement("UPDATE semester_Result SET gradeAv = ?,creditGet=? WHERE ID_Semester=?and ID_Student=?");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Student);
			pstmt.setFloat(3, gradeAv);
			pstmt.setInt(4, creditGet);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return false;
	}

	@Override
	public boolean delete(Semester_Result key) {
		// TODO Auto-generated method stub
		return false;
	}
	public float sumScore(String key) {
		float sum=0;
		int cre=0;
		try {
			pstmt = conn.prepareStatement(
					"select * from Sub_Pass sp join Course C on sp.ID_Course=c.ID_Course where sp.ID_Semester=?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sum+=(rs.getFloat("Score")*rs.getInt("Course_certificate"));
				cre+=rs.getInt("Course_certificate");
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
		return sum/cre;

	}
	public int sumcre(String key) {
		int cre=0;
		try {
			pstmt = conn.prepareStatement(
					"select * from Sub_Pass sp join Course C on sp.ID_Course=c.ID_Course where sp.ID_Semester=?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if(rs.getFloat("Score")>4) {
				cre+=rs.getInt("Course_certificate");
				}
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
		return cre;

	}
public static void main(String[] args) {
	Semester_ResultDAO dao3=new Semester_ResultDAO();
	System.out.println(dao3.sumScore("2_2018"));
	System.out.println(dao3.sumcre("2_2018"));
}
}