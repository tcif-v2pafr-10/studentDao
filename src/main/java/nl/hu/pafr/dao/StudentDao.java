package nl.hu.pafr.dao;

import java.util.List;

import nl.hu.pafr.model.Student;
import nl.hu.pafr.model.StudentGroup;

public interface StudentDao {
	public List<Student> getAll();

	public List<Student> getByGroup(StudentGroup studentGroup);

	public Student get(int id);

	public void update(Student student);

	public void insert(Student student);

	public void delete(Student student);

	public Student getByNumber(String string);
}
