package pafr.dao;

import java.util.List;

import pafr.model.Student;
import pafr.model.StudentGroup;

public interface StudentDao {
	public List<Student> getAll();

	public List<Student> getStudentsByGroup(StudentGroup studentGroup);

	public Student get(int id);

	public void update(Student student);

	public void insert(Student student);

	public void delete(Student student);

	public Student getStudentByNumber(String string);
}
