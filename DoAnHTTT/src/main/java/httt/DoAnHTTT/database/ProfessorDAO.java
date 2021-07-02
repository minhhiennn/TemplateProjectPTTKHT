package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import httt.DoAnHTTT.model.Faculty;
import httt.DoAnHTTT.model.Professor;
import httt.DoAnHTTT.model.User;

public class ProfessorDAO implements IDAO<Professor> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ProfessorDAO() {
		conn = Connect.getConnection();
	}

	public int selectTop1ID_Professor() {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("select top 1 ID_Professor from Professor order by ID_Professor DESC");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = Integer.parseInt(rs.getString("ID_Professor"));
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
		return result + 1;
	}

	public List<Professor> getAll() {
		
		List<Professor> professors = new ArrayList<Professor>();
		try {
			pstmt = conn.prepareStatement("select * from Professor");
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Professor = rs.getString("ID_Professor");
				UserDAO dao1 = new UserDAO();
				User user = dao1.getByKey(ID_Professor);
				String Professor_Name = rs.getString("Professor_Name");
				String ID_Faculty = rs.getString("ID_Faculty");
				FacultyDAO dao2 = new FacultyDAO();
				Faculty faculty = dao2.getByKey(ID_Faculty);
				Date create_date = new Date(rs.getDate("Create_date").getTime());
				String Degree = rs.getString("Degree");
				professors.add(new Professor(user, Professor_Name, faculty, create_date, Degree));

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
		return professors;
	}
	
	@Override
	public Professor getByKey(String key) {
		Professor professor = null;
		try {
			pstmt = conn.prepareStatement("select * from Professor where ID_Professor = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDAO dao1 = new UserDAO();
				User user = dao1.getByKey(key);
				String Professor_Name = rs.getString("Professor_Name");
				String ID_Faculty = rs.getString("ID_Faculty");
				FacultyDAO dao2 = new FacultyDAO();
				Faculty faculty = dao2.getByKey(ID_Faculty);
				Date create_date = new Date(rs.getDate("Create_date").getTime());
				String Degree = rs.getString("Degree");
				professor = new Professor(user, Professor_Name, faculty, create_date, Degree);

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
		return professor;
	}

	@Override
	public Professor getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Professor key) {
		String ID_Professor = key.getUser().getiD_User();
		String Professor_Name = key.getProfessor_Name();
		String ID_Faculty = key.getFaculty().getiD_Faculty();
		Date date = (Date) key.getCreate_date();
		String Degree = key.getDegree();
		try {
			pstmt = conn.prepareStatement("insert into Professor Values(?,?,?,?,?)");
			pstmt.setString(1, ID_Professor);
			pstmt.setString(2, Professor_Name);
			pstmt.setString(3, ID_Faculty);
			pstmt.setDate(4, date);
			pstmt.setString(5, Degree);
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
	public boolean update(Professor key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Professor key) {
		// TODO Auto-generated method stub
		return false;
	}

	// Get All Professor
	public HashMap<String, ArrayList<String>> getAllProfessor() {
		HashMap<String, ArrayList<String>> hashMap = new LinkedHashMap<String, ArrayList<String>>();
		hashMap.put("ID_Professor", new ArrayList<>());
		hashMap.put("Professor_Name", new ArrayList<>());
		hashMap.put("ID_Faculty", new ArrayList<>());
		hashMap.put("Create_date", new ArrayList<>());
		hashMap.put("Degree", new ArrayList<>());
		try {
			pstmt = conn.prepareStatement("select * from Professor");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID_Professor = rs.getString("ID_Professor");
				hashMap.get("ID_Professor").add(ID_Professor);
				String Professor_Name = rs.getString("Professor_Name");
				hashMap.get("Professor_Name").add(Professor_Name);
				String ID_Faculty = rs.getString("ID_Faculty");
				hashMap.get("ID_Faculty").add(ID_Faculty);
				Date create_date = rs.getDate("Create_date");
				hashMap.get("Create_date").add(create_date.toString());
				String Degree = rs.getString("Degree");
				hashMap.get("Degree").add(Degree);
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
		return hashMap;
	}

	public void insertN(String ID_Faculty, String Professor_Name, String Degree) {
		UserDAO userDAO = new UserDAO();
		FacultyDAO facultyDAO = new FacultyDAO();
		String ID_Professor = String.valueOf(selectTop1ID_Professor());
		User user = new User(ID_Professor, "pr", ID_Professor + "@st.hcmuaf.edu.vn", "123456");
		userDAO.insert(user);
		Faculty faculty = facultyDAO.getByKey(ID_Faculty);
		Professor professor = new Professor(user, Professor_Name, faculty, new java.util.Date(), Degree);
		insert(professor);
	}

	public static void main(String[] args) {
		ProfessorDAO professorDAO = new ProfessorDAO();
		System.out.println(professorDAO.selectTop1ID_Professor());
	}

	
}
