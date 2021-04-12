package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import httt.DoAnHTTT.model.User;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public UserDAO() {
		// super();
		conn = Connect.getConnection();
	}

	public User check(String ID_User, String password) {
		User user = null;
		try {
			pstmt = conn.prepareStatement("select * from USERS where ID_User = ? and password = ?");
			pstmt.setString(1, ID_User);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_UserKind = rs.getString("ID_UserKind");
				String email = rs.getString("email");
				user = new User(ID_User, ID_UserKind, email, password);

			}
		} catch (Exception e) {

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
		System.out.println(user);
		return user;

	}

}
