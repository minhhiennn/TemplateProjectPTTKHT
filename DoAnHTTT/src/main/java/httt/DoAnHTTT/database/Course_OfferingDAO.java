package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import httt.DoAnHTTT.model.Course;
import httt.DoAnHTTT.model.Course_Offering;

public class Course_OfferingDAO implements IDAO<Course_Offering> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Course_OfferingDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Course_Offering getByKey(List<String> key) {
		Course_Offering course_Offering = null;
		try {
			pstmt = conn.prepareStatement(
					"Select co.* , sc.Start_Day,sc.End_Day,sc.Study_place,sc.Start_Slot,sc.End_Slot,sc.Theoretical,sc.Teaching_Day "
							+ "                    from Course_Offering co inner join Schedule sc on co.ID_Course_Offering = sc.ID_Course_Offering where co.ID_Course_Offering = ?");
			pstmt.setString(1, key.get(0));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String iD_Course_Offering = rs.getString("ID_Course_Offering");
				String ID_Course = rs.getString("ID_Course");
				ArrayList<String> list = new ArrayList<String>();
				list.add(ID_Course);
				Course course = new CourseDAO().getByKey(list);
				String Class_code = rs.getString("Class_code");
				int Max_Size = rs.getInt("Max_Size");
				int Current_Size = rs.getInt("Current_Size");
				Date Start_Day = rs.getDate("Start_Day");
				Date End_Day = rs.getDate("End_Day");
				String Study_place = rs.getString("Study_place");
				int Start_Slot = rs.getInt("Start_Slot");
				int End_Slot = rs.getInt("End_Slot");
				int Teaching_Day = rs.getInt("Teaching_Day");
				String Theoretical = rs.getString("Theoretical");
				course_Offering = new Course_Offering(iD_Course_Offering, course, Class_code, Max_Size, Current_Size,
						Start_Day, End_Day, Study_place, Start_Slot, End_Slot, Teaching_Day, Theoretical);

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
		return course_Offering;
	}

	public void Test() {
		try {
			pstmt = conn.prepareStatement("insert into Course_Offering Values(N'21',N'202622','DH18DTA',80,100)");
			int row = pstmt.executeUpdate();
			System.out.println(row);
		} catch(Exception e)  {
			System.out.println("Catch trigger exception");
		} 
	}

	public static void main(String[] args) {
		Course_OfferingDAO course_OfferingDAO = new Course_OfferingDAO();
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		Course_Offering course_Offering = course_OfferingDAO.getByKey(list);
		System.out.println(course_Offering);
	}
}
