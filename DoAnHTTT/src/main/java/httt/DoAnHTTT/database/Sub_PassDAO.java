package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sub_PassDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Sub_PassDAO() {
		conn = Connect.getConnection();
	}

	public void Test() {
		try {
			pstmt = conn
					.prepareStatement("insert into Sub_Pass values('1_2022',N'213603',N'18130003',11.0,N'Trung Bình')");
			int row = pstmt.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			System.out.println("nhu cc");
			String s = e.toString();
			System.out.println(s);
			String[] s2 = s.split("'");
			System.out.println(s2[1]);
		} catch (Exception e) {
			e.printStackTrace();			
	       
		}
	}

	public static void main(String[] args) {
		Sub_PassDAO sub_PassDAO = new Sub_PassDAO();
		sub_PassDAO.Test();
	}
}
