package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Final_Result;
import httt.DoAnHTTT.model.Student;

public class Final_ResultDAO implements IDAO<Final_Result> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Final_ResultDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Final_Result getByKey(String key) {
		Final_Result final_Result = null;
		try {
			pstmt = conn.prepareStatement("select * from Final_Result where ID_Student = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentDAO studentDAO = new StudentDAO();
				Student student =  studentDAO.getByKey(key);
				float gradeAv = rs.getFloat("gradeAv");
				int creditGet = rs.getInt("creditGet");
				final_Result = new Final_Result(student, gradeAv, creditGet);

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
		return final_Result;
	}

	@Override
	public Final_Result getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Final_Result key) {
		String ID_Student=key.getStudent().getUser().getiD_User();
		float gradeAv=key.getGradeAv();
		int creditGet=key.getCreditGet();
		try {
			pstmt=conn.prepareStatement("Insert into Final_Result values(?,?,?)");
			pstmt.setString(1, ID_Student);
			pstmt.setFloat(2, gradeAv);
			pstmt.setInt(3, creditGet);
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
	public boolean update(Final_Result key) {
		String ID_Student=key.getStudent().getUser().getiD_User();
		float gradeAv=key.getGradeAv();
		int creditGet=key.getCreditGet();
		try {
			pstmt=conn.prepareStatement("UPDATE Sub_Pass SET gradeAv = ?,creditGet=? WHERE ID_Student=?");
			pstmt.setString(1, ID_Student);
			pstmt.setFloat(2, gradeAv);
			pstmt.setInt(3, creditGet);
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
	public boolean delete(Final_Result key) {
		// TODO Auto-generated method stub
		return false;
	}
	public float sumScore(String key) {
		float sum=0;
		int numbersemester=0;
		try {
			pstmt = conn.prepareStatement(
					"select * from semester_Result sr join Student st on sr.ID_Student=st.ID_Student where st.ID_Student=?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sum+=(rs.getFloat("gradeAv"));
				numbersemester++;
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
		return sum/numbersemester;

	}
	public int sumcre(String key) {
		int cre=0;
		try {
			pstmt = conn.prepareStatement(
					"select * from semester_Result sr join Student st on sr.ID_Student=st.ID_Student where st.ID_Student=?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
			
				cre+=rs.getInt("creditGet");
				
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
	Final_ResultDAO dao=new Final_ResultDAO();
	System.out.println(dao.sumScore("18130003"));
	System.out.println(dao.sumcre("18130003"));
}
}
