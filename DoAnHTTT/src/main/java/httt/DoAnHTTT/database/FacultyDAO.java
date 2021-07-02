package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Professor;

public class FacultyDAO implements IDAO<Faculty>{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public FacultyDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Faculty getByKeyS(List<String> key) {
		return null;
	}

	public List<Faculty> getAll() {
		List<Faculty> facultys = new ArrayList<Faculty>();
		try {
			pstmt = conn.prepareStatement("select * from Faculty");
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Faculty = rs.getString("ID_Faculty");
				String Name_Faculty = rs.getString("Name_Faculty");
				int ID_FacultyN = rs.getInt("ID_FacultyN");
				facultys.add(new Faculty(ID_Faculty, Name_Faculty,ID_FacultyN));

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
		return facultys;
	}
	
	@Override
	public Faculty getByKey(String key) {
		Faculty faculty = null;
		try {
			pstmt = conn.prepareStatement("select * from Faculty where ID_Faculty = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String Name_Faculty = rs.getString("Name_Faculty");
				int ID_FacultyN = rs.getInt("ID_FacultyN");
				faculty = new Faculty(key, Name_Faculty,ID_FacultyN);

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
		return faculty;
	}


	@Override
	public boolean insert(Faculty key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Faculty key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Faculty key) {
		// TODO Auto-generated method stub
		return false;
	}
	public static void main(String[] args) {
		FacultyDAO facultyDAO = new FacultyDAO();
		Faculty faculty = facultyDAO.getByKey("BV");
		System.out.println(faculty);
	}

	
}
