package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TimeForCourseRegisterDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public TimeForCourseRegisterDao() {
		conn = Connect.getConnection();
	}
    
	// Kiểm tra có phải thời gian đăng ký môn học hay ko
	public boolean checkTime() {
		boolean bool = false;
		try {
			pstmt = conn.prepareStatement("select * from TimeForCourseRegister tf join Semester se on tf.ID_Semester = se.ID_Semester where GETDATE() between tf.startDate and tf.endDate");
			rs = pstmt.executeQuery();
			bool = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return bool;
	}

	public static void main(String[] args) {
		TimeForCourseRegisterDao timeForCourseRegisterDao  = new TimeForCourseRegisterDao();
		System.out.println(timeForCourseRegisterDao.checkTime());
	}
}
