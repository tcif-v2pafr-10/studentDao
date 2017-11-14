package nl.hu.pafr.dao.memory;

import java.util.List;

import nl.hu.pafr.dao.StudentGroupDao;
import nl.hu.pafr.model.StudentGroup;

public class StudentGroupDaoImpl implements StudentGroupDao {
	private DataStore dataStore;


	public StudentGroupDaoImpl() {
	}

	
	public StudentGroupDaoImpl(DataStore dataStore) {
		super();
		this.dataStore = dataStore;
	}


	public void delete(StudentGroup studentGroup) {
		StudentGroup g = get(studentGroup.getId());
		if (g != null) {
			dataStore.getStudentGroups().remove(g);
			System.out.println("Group: number " + g.getId()
					+ ", deleted from database");
		}
	}

	// retrieve list of students from the database
	public List<StudentGroup> getAll() {
		return dataStore.getStudentGroups();
	}

	public StudentGroup get(int id) {
		for (StudentGroup g : dataStore.getStudentGroups()) {
			if (g.getId() == id) {
				return g;
			}
		}
		return null;
	}

	public void update(StudentGroup group) {
		StudentGroup g = get(group.getId());
		if (g != null) {
			g.setCode(group.getCode());
		}
	}

	public void insert(StudentGroup group) {
		if (get(group.getId()) == null){
			dataStore.getStudentGroups().add(group);
		} else {
			System.out.println("StudentGroup already exists.");
		}
	}

	public List<StudentGroup> getAll(StudentGroup group) {
		return dataStore.getStudentGroups();
	}

	@Override
	public StudentGroup getGroupByCode(String code) {
		for (StudentGroup g : dataStore.getStudentGroups()) {
			if (g.getCode() == code) {
				return g;
			}
		}
		return null;
	}

}
