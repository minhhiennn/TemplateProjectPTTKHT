package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.User;

public class UserDAO implements IDAO<User> {
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
		return user;
	}

	public void InsertUserStudent(String ID_User) {
		try {
			pstmt = conn.prepareStatement("insert into USERS Values(?,'st',?,'123456')");
			pstmt.setString(1, ID_User);
			pstmt.setString(2, ID_User + "@st.hcmuaf.edu.vn");
			int row = pstmt.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getByKey(String key) {
		User user = null;
		try {
			pstmt = conn.prepareStatement("select * from User where ID_User = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_User = rs.getString("ID_User");
				String ID_UserKind = rs.getString("ID_UserKind");
				String email = rs.getString("email");
				String password = rs.getString("password");
				user = new User(ID_User, ID_UserKind, email, password);

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
		return user;
	}

	@Override
	public User getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(User key) {
		String ID_User = key.getiD_User();
		String ID_UserKind = key.getiD_UserKind();
		String email = key.getEmail();
		String password = key.getPassword();
		try {
			pstmt = conn.prepareStatement("insert into USERS Values(?,?,?,?)");
			pstmt.setString(1, ID_User);
			pstmt.setString(2, ID_UserKind);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
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
	public boolean update(User key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User key) {
		// TODO Auto-generated method stub
		return false;
	}
}
