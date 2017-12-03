package nl.hu.pafr.client;

import java.util.List;
import java.util.Random;

import nl.hu.pafr.dao.StudentDao;
import nl.hu.pafr.dao.StudentGroupDao;
import nl.hu.pafr.dao.jdbc.StudentDaoJdbcImpl;
import nl.hu.pafr.dao.jdbc.StudentGroupDaoJdbcImpl;
import nl.hu.pafr.model.Student;
import nl.hu.pafr.model.StudentGroup;

public class Main {

	private static int getNum(){
		return new Random().nextInt(9000) + 1000;
	}
	
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDaoJdbcImpl();
		StudentGroupDao groupDao = new StudentGroupDaoJdbcImpl(studentDao);

		/*
		 * Aanmaken van de domein objecten
		 */
		StudentGroup group = new StudentGroup(getNum(),"TICT-SIE-V2A-17");
		group.addStudent(new Student(getNum(), "Joost", "1638483", "joost@hu.nl", group));
		group.addStudent(new Student(getNum(), "Rik", "1600234", "rik@hu.nl", group));
		group.addStudent(new Student(getNum(), "Jeroen", "1649323", "jeroen@hu.nl", group));
		group.addStudent(new Student(getNum(), "Berend", "1737273", "berend@hu.nl", group));

		/*
		 * Opslaan van de data in de domein objecten
		 * Wie is verantwoordelijk voor het opslaan van de studenten binnen de groep?
		 */
		groupDao.insert(group);
//		for (Student student : group.getStudents()) {
//			studentDao.insert(student);
//		}
		
		/*
		 * Queries op de domein objecten
		 */
		List<StudentGroup> groups = groupDao.getAll();
		for (StudentGroup g : groups) {
			/*
			 * Wie is verantwoordelijk voor het ophalen van de studenten binnen de groep?
			 */
			System.out.println("StudentGroups: "+g);
		}
		StudentGroup groupByCode = groupDao.getByCode("TICT-SIE-V2A-17");
		System.out.println("StudentGroup: "+groupByCode);
		Student student1  = studentDao.getByNumber("1737273");
		System.out.println("Student: "+ student1);
	}
}
