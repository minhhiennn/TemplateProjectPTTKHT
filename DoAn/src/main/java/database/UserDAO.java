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
		// TODO Auto-generated method stub
		return null;
	}

	
}
