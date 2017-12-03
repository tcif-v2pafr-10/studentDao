package nl.hu.pafr.client;

import java.util.List;
import java.util.Random;

import nl.hu.pafr.dao.StudentDao;
import nl.hu.pafr.dao.mysql.StudentDaoJdbcImpl;
import nl.hu.pafr.model.Student;

public class Main {

	private static int getNum(){
		return new Random().nextInt(9000) + 1000;
	}
	
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDaoJdbcImpl();
		/*
		 * Aanmaken van de domein objecten
		 */
		studentDao.insert(new Student(getNum(), "Joost", "1638483", "joost@hu.nl"));
		studentDao.insert(new Student(getNum(), "Rik", "1600234", "rik@hu.nl"));
		studentDao.insert(new Student(getNum(), "Jeroen", "1649323", "jeroen@hu.nl"));
		studentDao.insert(new Student(getNum(), "Berend", "1737273", "berend@hu.nl"));

		/*
		 * Queries op de domein objecten
		 */
		List<Student> students = studentDao.getAll();
		for (Student s : students) {
			System.out.println("Student: "+s);
		}
		Student student1  = studentDao.getByNumber("1737273");
		System.out.println("Student: "+ student1);
	}
}
