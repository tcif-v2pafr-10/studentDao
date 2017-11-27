package nl.hu.pafr.client;

import java.util.List;
import java.util.Random;

import nl.hu.pafr.dao.StudentDao;
import nl.hu.pafr.dao.StudentGroupDao;
import nl.hu.pafr.dao.memory.DataStore;
import nl.hu.pafr.dao.memory.StudentDaoImpl;
import nl.hu.pafr.dao.memory.StudentGroupDaoImpl;
import nl.hu.pafr.model.Student;
import nl.hu.pafr.model.StudentGroup;

public class Main {

	private static int getNum(){
		return new Random().nextInt(9000) + 1000;
	}
	
	public static void main(String[] args) {
		DataStore dataStore = new DataStore();
		StudentDao studentDao = new StudentDaoImpl(dataStore);
		StudentGroupDao groupDao = new StudentGroupDaoImpl(dataStore);
		/*
		 * Aanmaken van de domein objecten
		 */
		StudentGroup group = new StudentGroup(getNum(),"TICT-SIE-V2A-17");
		group.addStudent(new Student(getNum(), "Joost", "1638483", group));
		group.addStudent(new Student(getNum(), "Rik", "1600234", group));
		group.addStudent(new Student(getNum(), "Jeroen", "1649323", group));
		group.addStudent(new Student(getNum(), "Berend", "1737273", group));

		/*
		 * Opslaan van de data in de domein objecten
		 */
		groupDao.insert(group);
		for (Student student : group.getStudents()) {
			studentDao.insert(student);
		}
		
		/*
		 * Queries op de domein objecten
		 */
		List<StudentGroup> groups = groupDao.getAll();
		for (StudentGroup g : groups) {
			System.out.println("StudentGroups 1: "+g);
			StudentGroup g1 = groupDao.get(g.getId());
			System.out.println("StudentGroups 2: "+g1);
		}
		StudentGroup group1 = groupDao.getByCode("TICT-SIE-V2A-17");
		System.out.println("StudentGroups 3: "+group1);
		Student student1  = studentDao.getByNumber("1737273");
		System.out.println("Student: "+ student1);
	}
}
