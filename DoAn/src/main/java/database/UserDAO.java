package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.User;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public UserDAO() {
		// super();
		conn = Connect.getConnection();
	}

	public User check(String idU, String password) {
		User user = null;
		try {
			int id = Integer.parseInt(idU);
			pstmt = conn.prepareStatement("select * from USER_KIND where ID = ? and password = ? ");
			pstmt.setString(1, idU);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String kind = rs.getString("Name_UserKind");
				String email = rs.getString("email");
				user = new User(id, password, email, kind);
			}

		} catch (Exception e) {
			return null;
		}
		return user;

	}

}
