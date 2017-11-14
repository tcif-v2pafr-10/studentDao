package nl.hu.pafr.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.pafr.dao.StudentDao;
import nl.hu.pafr.model.Student;
import nl.hu.pafr.model.StudentGroup;

public class StudentDaoMySQLImpl implements StudentDao {

	private static final String MYSQL_DB_DRIV = "com.mysql.jdbc.Driver";
	private static final String MYSQL_DB_CONN = "jdbc:mysql://localhost/pafr";
	private static final String MYSQL_DB_USER = "root";
	private static final String MYSQL_DB_PASS = "";

	public List<Student> getAll() {
		List<Student> students = new ArrayList<Student>();
		try {
			Class.forName(MYSQL_DB_DRIV).newInstance();
			Connection con = DriverManager.getConnection(MYSQL_DB_CONN,
					MYSQL_DB_USER, MYSQL_DB_PASS);
			Statement stmt = con.createStatement();
			String strQuery = "select * from student order by number";
			ResultSet rs = stmt.executeQuery(strQuery);
			while (rs.next()) {
				Student s = new Student(rs.getInt("id"), rs.getString("number"), rs.getString("name"), null);
				students.add(s);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Cannot retrieve: " + e.getMessage());
			e.printStackTrace();
		}
		return students;
	}

	public List<Student> getStudentsByGroup(StudentGroup group) {
		List<Student> students = new ArrayList<Student>();
		try {
			Class.forName(MYSQL_DB_DRIV).newInstance();
			Connection con = DriverManager.getConnection(MYSQL_DB_CONN,
					MYSQL_DB_USER, MYSQL_DB_PASS);
			Statement stmt = con.createStatement();
			String strQuery = "select * from student where student_group_id = "+group.getId()+" order by number";
			ResultSet rs = stmt.executeQuery(strQuery);
			while (rs.next()) {
				Student s = new Student(rs.getInt("id"), rs.getString("number"), rs.getString("name"), group);
				students.add(s);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Cannot retrieve: " + e.getMessage());
			e.printStackTrace();
		}
		return students;
	}

	public Student get(int id) {
		Student student = null;
		try {
			Class.forName(MYSQL_DB_DRIV).newInstance();
			Connection con = DriverManager.getConnection(MYSQL_DB_CONN,
					MYSQL_DB_USER, MYSQL_DB_PASS);
			Statement stmt = con.createStatement();
			String strQuery = "select * from student where id = " + id;
			ResultSet rs = stmt.executeQuery(strQuery);
			if (rs.next()) {
				student = new Student(rs.getInt("id"), rs.getString("number"), rs.getString("name"), null);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Cannot retrieve: " + e.getMessage());
			e.printStackTrace();
		}
		return student;
	}

	public void update(Student student) {
		try {
			Class.forName(MYSQL_DB_DRIV).newInstance();
			Connection con = DriverManager.getConnection(MYSQL_DB_CONN,
					MYSQL_DB_USER, MYSQL_DB_PASS);
			Statement stmt = con.createStatement();

			// create a SQL query
			
			String strQuery = "UPDATE student SET name = '"+ student.getName() +"' WHERE number = "+ student.getId();
			stmt.executeUpdate(strQuery);
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Cannot update: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void insert(Student student) {
		try {
			Class.forName(MYSQL_DB_DRIV).newInstance();
			Connection con = DriverManager.getConnection(MYSQL_DB_CONN,
					MYSQL_DB_USER, MYSQL_DB_PASS);
			Statement stmt = con.createStatement();
			System.out.println("insertStudent: "+student);
			// create a SQL query
			String strQuery = "INSERT INTO student " + " (id, number, name, group_id) "
					+ " VALUES (" + (student.getId()) + "," 
					+ " '" + student.getNumber() + "'," 
					+ " '" + student.getName() + "', "+student.getStudentGroup().getId()+" ) ";
			stmt.executeUpdate(strQuery);
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Cannot insert: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void delete(Student student) {
		try {
			Class.forName(MYSQL_DB_DRIV).newInstance();
			Connection con = DriverManager.getConnection(MYSQL_DB_CONN,
					MYSQL_DB_USER, MYSQL_DB_PASS);
			Statement stmt = con.createStatement();

			
			// create a SQL query
			String strQuery = "DELETE FROM student where rollNo = "
					+ student.getId();
			stmt.executeUpdate(strQuery);
			stmt.close();
			con.close();
			System.out.println("Student: number " + student.getId()
					+ ", deleted from database");
		} catch (Exception e) {
			System.out.println("Cannot insert: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudentByNumber(String number) {
		Student student = null;
		try {
			Class.forName(MYSQL_DB_DRIV).newInstance();
			Connection con = DriverManager.getConnection(MYSQL_DB_CONN,
					MYSQL_DB_USER, MYSQL_DB_PASS);
			Statement stmt = con.createStatement();
			String strQuery = "select * from student where number = '" + number+"'";
			ResultSet rs = stmt.executeQuery(strQuery);
			if (rs.next()) {
				student = new Student(rs.getInt("id"), rs.getString("number"), rs.getString("name"), null);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Cannot retrieve: " + e.getMessage());
			e.printStackTrace();
		}
		return student;
	}

}
