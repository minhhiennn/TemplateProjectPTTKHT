package httt.DoAnHTTT.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import httt.DoAnHTTT.model.Class;
import httt.DoAnHTTT.model.Faculty;

public class ClassDAO implements IDAO<Class> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ClassDAO() {
		conn = Connect.getConnection();
	}

	@Override
	public Class getByKey(String key) {
		Class class1 = null;
		try {
			pstmt = conn.prepareStatement("select * from Class where Class_code = ?");
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int max_Size = rs.getInt("Max_Size");
				int current_Size = rs.getInt("Current_Size");
				FacultyDAO dao = new FacultyDAO();
				Faculty faculty = dao.getByKey(rs.getString("ID_Faculty"));
				class1 = new Class(key, faculty, max_Size, current_Size);

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
		return class1;
	}

	@Override
	public Class getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Class key) {
		try {
			pstmt = conn.prepareStatement("insert into Class Values(?,?,?,?)");
			pstmt.setString(1, key.getClass_Code());
			pstmt.setString(2, key.getFaculty().getiD_Faculty());
			pstmt.setInt(3, key.getMax_Size());
			pstmt.setInt(4, key.getCurrent_Size());
			pstmt.executeUpdate();
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
		return true;

	}

	@Override
	public boolean update(Class key) {
		try {
			pstmt = conn.prepareStatement(
					"UPDATE dbo.Class SET ID_Faculty = ?, Max_Size = ?, Current_Size = ? WHERE Class_code = ?");
			pstmt.setString(1, key.getFaculty().getiD_Faculty());
			pstmt.setInt(2, key.getMax_Size());
			pstmt.setInt(3, key.getCurrent_Size());
			pstmt.setString(4, key.getClass_Code());
			int bb = pstmt.executeUpdate();
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
		return true;
	}

	@Override
	public boolean delete(Class key) {
		// TODO Auto-generated method stub
		return false;
	}

	public Class getByForNStudent(int khoa, String maNganh) {
		List<Class> classes = new ArrayList<Class>();
		try {
			pstmt = conn.prepareStatement(
					"select * from class where SUBSTRING(Class_code,3,2) = ? and ID_Faculty = ? order by Class_code asc ");
			String khoaHoc = khoa + "";
			pstmt.setString(1, khoaHoc.trim());
			pstmt.setString(2, maNganh);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ClassDAO classDAO = new ClassDAO();
				classes.add(classDAO.getByKey(rs.getString("class_Code")));

			}
			int min = classes.get(0).getCurrent_Size();

			for (Class class2 : classes) {
				if (class2.getCurrent_Size() < min && min <= class2.getMax_Size()) {
					return class2;
				} else {
					min = class2.getCurrent_Size();
				}
			}
			if (min >= classes.get(0).getMax_Size()) {
				return classes.get(classes.size() - 1);
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
		return classes.get(0);
	}

	public static void main(String[] args) {
		ClassDAO classDAO = new ClassDAO();
		FacultyDAO dao = new FacultyDAO();
		Class class1 = new Class("DH18DT", dao.getByKey("DT"), 0, 0);
		classDAO.insert(class1);
		class1.setCurrent_Size(99);
		classDAO.update(class1);
	}

	public void createClass(Map<String, Integer> studentCount) {
		Set<String> set = studentCount.keySet();

		for (String key : set) {
			String iD_Faculty = key.substring(key.length() - 2);
			FacultyDAO dao = new FacultyDAO();
			Faculty faculty = dao.getByKey(iD_Faculty);
			if (faculty != null) {

				char code = 'a';
				int quantity = studentCount.get(key);
				if (quantity >= 100) {
					for (int i = 0; i <= quantity / 100; i++) {
						int maxsize = 0;
						String class_Code = "DH" + key + Character.toUpperCase(code++);
						if (i == (quantity / 100)) {
							maxsize = (quantity / ((quantity / 100) + 1)) + (quantity % ((quantity / 100) + 1));
						} else {
							maxsize = quantity / ((quantity / 100) + 1);
						}
						Class class1 = new Class(class_Code, faculty, maxsize, 0);
						insert(class1);
					}
				} else {
					Class class1 = new Class("DH" + key, faculty, quantity, 0);
					insert(class1);
				}
			} else {
				System.out.println("chua co fac nay");
			}
		}
	}

	public void updateFullClassUpdate(Map<String, Integer> studentCount) {
		Set<String> set = studentCount.keySet();

		try {
			for (String key : set) {
				pstmt = conn.prepareStatement("UPDATE dbo.Class SET  Max_Size = 100 WHERE Class_code like ?");
				pstmt.setString(1, "%"+key+"%");
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
