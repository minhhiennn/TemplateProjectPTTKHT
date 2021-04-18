package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	private Sub_Pass semester;

	public Sub_PassDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Sub_Pass getByKey(String key) {
		// TODO Auto-generated method stub
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
				float Score = rs.getFloat("Score");
				String Rated = rs.getString("Rated");
				sub_Pass = new Sub_Pass(semester, course, student, Score, Rated);

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
		String ID_Semester=key.getSemester().getiD_Semester();
		String ID_Course=key.getCourse().getiD_Course();
		String ID_Student=key.getStudent().getUser().getiD_User();
		float Score=key.getScore();
		String Rated=key.getRated();
		try {
			pstmt=conn.prepareStatement("insert into Sub_Pass values(?,?,?,?,?)");
			pstmt.setString(1, ID_Semester);
			pstmt.setString(2, ID_Course);
			pstmt.setString(3, ID_Student);
			pstmt.setFloat(4, Score);
			pstmt.setString(5, Rated);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			
				try {
					if(pstmt!=null) {
					pstmt.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			}
		}
		return false;
	}

	@Override
	public boolean update(Sub_Pass key) {
		String ID_Semester=key.getSemester().getiD_Semester();
		String ID_Course=key.getCourse().getiD_Course();
		String ID_Student=key.getStudent().getUser().getiD_User();
		float Score=key.getScore();
		String Rated=key.getRated();
		try {
			pstmt=conn.prepareStatement("UPDATE Sub_Pass SET Score = ?,Rated=? WHERE ID_Semester=? and ID_Course=? and ID_Student=?");
			
			pstmt.setFloat(1, Score);
			pstmt.setString(2, Rated);
			pstmt.setString(3, ID_Semester);
			pstmt.setString(4, ID_Course);
			pstmt.setString(5, ID_Student);
		
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			
				try {
					if(pstmt!=null) {
					pstmt.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			}
		}
		return false;

	}

	@Override
	public boolean delete(Sub_Pass key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String checkRated(float Score ) {
		String check="";
		if(Score>=9) {
			 check="xuất xắc";
			
		}if(Score>=8 && Score<9) {
			check="giỏi"; 
		}if(Score>=6.5 && Score<8) {
			check="khá"; 
		}if(Score>=4 && Score<6.5) {
			check="giỏi"; 
		}if(Score<4) {
			check="yếu"; 
		}
		return check;
	}
//	public float sumCreditGet(String ID_Semester) {
//		float sum=0;
//		int sumCre=0;
//		semester = null;
//		if(semester.getSemester().getiD_Semester().equalsIgnoreCase(ID_Semester)) {
//			sum=sum+(semester.getScore()*semester.getCourse().getCourse_certificate());
//			sumCre=+semester.getCourse().getCourse_certificate();
//		}
//		return sum/sumCre;
//	}
	
public static void main(String[] args) {
	SemesterDAO dao=new SemesterDAO();
	StudentDAO dao2=new StudentDAO();
	CourseDAO courseDAO=new CourseDAO();
	Sub_Pass pass=new Sub_Pass(dao.getByKey("1_2021"),courseDAO.getByKey("213603") , dao2.getByKey("18130003"), 8.0f, "giỏi");
	Sub_PassDAO dao3=new Sub_PassDAO();
	dao3.insert(pass);
	
}
}
