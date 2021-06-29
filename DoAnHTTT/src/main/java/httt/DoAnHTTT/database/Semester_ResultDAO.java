package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
				Student student = studentDAO.getByKey(key.get(1));
				double gradeAv = rs.getFloat("gradeAv");
				double gradeAv4 = rs.getDouble("gradeAv4");
				int creditGet = rs.getInt("creditGet");
				semester_Result = new Semester_Result(semester, student, gradeAv, gradeAv4, creditGet);

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
		double gradeAv4 = key.getGradeAv4();
		int creditGet = key.getCreditGet();
		try {
			pstmt = conn.prepareStatement("insert into semester_Result values(?,?,?,?,?)");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Student);
			pstmt.setDouble(3, gradeAv);
			pstmt.setDouble(4, gradeAv4);
			pstmt.setInt(5, creditGet);
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
		String ID_Semester = key.getSemester().getiD_Semester();
		String ID_Student = key.getStudent().getUser().getiD_User();
		double gradeAv = key.getGradeAv();
		double gradeAv4 = key.getGradeAv4();
		int creditGet = key.getCreditGet();
		try {
			pstmt = conn.prepareStatement("update semester_Result set gradeAv = ?, gradeAv4 = ?,creditGet = ? where ID_Student = ? and ID_Semester = ?");
			pstmt.setDouble(1, gradeAv);
			pstmt.setDouble(2, gradeAv4);
			pstmt.setInt(3, creditGet);
			pstmt.setString(4, ID_Student);
			pstmt.setString(5, ID_Semester);
			
			
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
	public boolean delete(Semester_Result key) {
		return false;
	}

	public double getDiemTB(String ID_Student, String ID_Semester) {
		double Diem_TB = 0;
		try {
			pstmt = conn.prepareStatement(
					"select SUM(gr.Score * gr.Course_certificate)/SUM(gr.Course_certificate) Diem_TB from get_Semester_Reuslt(?,?) gr");
			pstmt.setString(1, ID_Student);
			pstmt.setString(2, ID_Semester);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Diem_TB = rs.getDouble("Diem_TB");
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
	
		double roundOff = (double) Math.round(Diem_TB * 100) / 100;
		return roundOff;
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
	
		double roundOff = (double) Math.round(Diem_TB_He_4 * 100) / 100;
		return roundOff;
	}

	public int getSoTinChiDaDat(String ID_Student, String ID_Semester) {
		int tinChi = 0;
		try {
			pstmt = conn.prepareStatement(
					"select SUM(gr.Course_certificate) so_TC from get_Semester_Reuslt(?,?) gr where gr.Score >= 4.0");
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
	public boolean checkExistResult(String ID_Student,String ID_Semester) {
		boolean exist = false;
		try {
			pstmt = conn.prepareStatement(
					"select sp.gradeAv from semester_Result sp where sp.ID_Student = ? and sp.ID_Semester = ?");
			pstmt.setString(1, ID_Student);
			
			pstmt.setString(2, ID_Semester);
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
public ArrayList<Semester> getIDsemester(String ID_user){
	ArrayList<Semester> list=new ArrayList<Semester>();

	try {
		pstmt=conn.prepareStatement("select se.ID_Semester from semester_Result se where ID_Student=? order by  se.ID_Semester;");
		pstmt.setString(1, ID_user);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			String ID_Semester=rs.getString("ID_Semester");
			
			Semester result=new SemesterDAO().getByKey(ID_Semester); 
			
			list.add(result);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(pstmt!=null) {
				pstmt.close();
				
			}if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
return list;
}
	public static void main(String[] args) {
		Semester_ResultDAO semester_ResultDAO = new Semester_ResultDAO();
//		System.out.println(semester_ResultDAO.getDiemTBHe4("18130005", "2_2018"));
		System.out.println(semester_ResultDAO.getSoTinChiDaDat("18130005", "2020_2"));
//	ArrayList<Semester>list=semester_ResultDAO.getIDsemester("18130005");
//	for (int i = 0; i < list.size(); i++) {
//		System.out.println(list.get(i));
		
//	}
//	System.out.println(semester_ResultDAO.checkExistResult("18130006", "2020_2"));
//		System.out.println(semester_ResultDAO.getDiemTB("18130005", "2020_2"));
	}
}