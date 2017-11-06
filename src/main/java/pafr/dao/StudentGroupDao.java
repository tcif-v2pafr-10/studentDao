package pafr.dao;

import java.util.List;

import pafr.model.StudentGroup;

public interface StudentGroupDao {
	public List<StudentGroup> getAll();

	public StudentGroup get(int id);

	public void update(StudentGroup group);

	public void insert(StudentGroup group);

	public void delete(StudentGroup group);
	
	public StudentGroup getGroupByCode(String code);
}
