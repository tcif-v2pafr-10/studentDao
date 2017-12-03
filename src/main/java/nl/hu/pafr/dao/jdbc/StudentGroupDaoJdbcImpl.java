package nl.hu.pafr.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.pafr.dao.StudentDao;
import nl.hu.pafr.dao.StudentGroupDao;
import nl.hu.pafr.model.Student;
import nl.hu.pafr.model.StudentGroup;

public class StudentGroupDaoJdbcImpl extends AbstractDaoJdbcImpl implements StudentGroupDao {
	StudentDao studentDao;

	public StudentGroupDaoJdbcImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public List<StudentGroup> getAll() {
		List<StudentGroup> groups = new ArrayList<StudentGroup>();
		try {
			Connection con = open();
			Statement stmt = con.createStatement();
			String strQuery = "select * from student_group order by code";
			ResultSet rs = stmt.executeQuery(strQuery);
			while (rs.next()) {
				StudentGroup g = new StudentGroup(rs.getInt("id"), rs.getString("code"));
				groups.add(g);
			}
			stmt.close();
			close(con);
		} catch (Exception e) {
			System.out.println("Cannot retrieve: " + e.getMessage());
			e.printStackTrace();
		}
		return groups;
	}

	public StudentGroup get(int id) {
		StudentGroup group = null;
		try {
			Connection con = open();
			Statement stmt = con.createStatement();
			String strQuery = "select * from student_group where id = " + id;
			ResultSet rs = stmt.executeQuery(strQuery);
			if (rs.next()) {
				group = new StudentGroup(rs.getInt("id"), rs.getString("code"));
				List<Student> students = studentDao.getByGroup(group);
				for (Student s : students){
					group.addStudent(s);
				}
			}
			stmt.close();
			close(con);
		} catch (Exception e) {
			System.out.println("Cannot retrieve: " + e.getMessage());
			e.printStackTrace();
		}
		return group;
	}

	public void update(StudentGroup group) {
		Connection con = open();
		close(con);
	}

	public void insert(StudentGroup group) {
		try {
			Connection con = open();
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
			close(con);
		} catch (Exception e) {
			System.out.println("Cannot insert: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void delete(StudentGroup group) {
		Connection con = open();
		close(con);
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public StudentGroup getByCode(String code) {
		StudentGroup group = null;
		try {
			Connection con = open();
			Statement stmt = con.createStatement();
			String strQuery = "select * from student_group where code = '" + code +"'";
			ResultSet rs = stmt.executeQuery(strQuery);
			if (rs.next()) {
				group = new StudentGroup(rs.getInt("id"), rs.getString("code"));
				List<Student> students = studentDao.getByGroup(group);
				for (Student s : students){
					group.addStudent(s);
				}
			}
			stmt.close();
			close(con);
		} catch (Exception e) {
			System.out.println("Cannot retrieve: " + e.getMessage());
			e.printStackTrace();
		}
		return group;
	}

}
