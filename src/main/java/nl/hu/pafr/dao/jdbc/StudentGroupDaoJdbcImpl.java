package nl.hu.pafr.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.pafr.dao.StudentDao;
import nl.hu.pafr.dao.StudentGroupDao;
import nl.hu.pafr.model.Student;
import nl.hu.pafr.model.StudentGroup;

public class StudentGroupDaoJdbcImpl implements StudentGroupDao {
	private static final String MYSQL_DB_DRIV = "com.mysql.jdbc.Driver";
	private static final String MYSQL_DB_CONN = "jdbc:mysql://localhost/pafr";
	private static final String MYSQL_DB_USER = "root";
	private static final String MYSQL_DB_PASS = "";

	StudentDao studentDao;

	public List<StudentGroup> getAll() {
		List<StudentGroup> groups = new ArrayList<StudentGroup>();
		try {
			Class.forName(MYSQL_DB_DRIV).newInstance();
			Connection con = DriverManager.getConnection(MYSQL_DB_CONN,
					MYSQL_DB_USER, MYSQL_DB_PASS);
			Statement stmt = con.createStatement();
			String strQuery = "select * from student_group order by name";
			ResultSet rs = stmt.executeQuery(strQuery);
			while (rs.next()) {
				StudentGroup g = new StudentGroup(rs.getInt("id"), rs.getString("name"));
				groups.add(g);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Cannot retrieve: " + e.getMessage());
			e.printStackTrace();
		}
		return groups;
	}

	public StudentGroup get(int number) {
		StudentGroup group = null;
		try {
			Class.forName(MYSQL_DB_DRIV).newInstance();
			Connection con = DriverManager.getConnection(MYSQL_DB_CONN,
					MYSQL_DB_USER, MYSQL_DB_PASS);
			Statement stmt = con.createStatement();
			String strQuery = "select * from student_group where id = " + number;
			ResultSet rs = stmt.executeQuery(strQuery);
			if (rs.next()) {
				group = new StudentGroup(rs.getInt("id"), rs.getString("name"));
				List<Student> students = studentDao.getByGroup(group);
				for (Student s : students){
					group.addStudent(s);
				}
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Cannot retrieve: " + e.getMessage());
			e.printStackTrace();
		}
		return group;
	}

	public void update(StudentGroup group) {
		// TODO Auto-generated method stub

	}

	public void insert(StudentGroup group) {
		try {
			Class.forName(MYSQL_DB_DRIV).newInstance();
			Connection con = DriverManager.getConnection(MYSQL_DB_CONN,
					MYSQL_DB_USER, MYSQL_DB_PASS);
			Statement stmt = con.createStatement();
			System.out.println("group.getStudents() "+group.getStudents());

			// create a SQL query
			String strQuery = "INSERT INTO student_group " + " (id, code) "
					+ " VALUES (" + (group.getId()) + "," + "'"
					+ group.getCode() + "') ";
			stmt.executeUpdate(strQuery);
			for (Student student : group.getStudents()) {
				studentDao.insert(student);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Cannot insert: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void delete(StudentGroup group) {
		// TODO Auto-generated method stub
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public StudentGroup getByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
