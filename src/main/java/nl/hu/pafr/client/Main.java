package nl.hu.pafr.client;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import nl.hu.pafr.dao.StudentDao;
import nl.hu.pafr.dao.StudentGroupDao;
import nl.hu.pafr.dao.jpa.HibernateUtil;
import nl.hu.pafr.dao.jpa.StudentDaoJpaImpl;
import nl.hu.pafr.dao.jpa.StudentGroupDaoJpaImpl;
import nl.hu.pafr.model.Student;
import nl.hu.pafr.model.StudentGroup;

public class Main {

	private static EntityManagerFactory entityManagerFactory;
	private static String getNum(){
		return String.valueOf(new Random().nextInt(90000) + 1650000);
	}
	
	public static void main(String[] args) {
		// get the Hibernate - JPA entityManager
		EntityManager em = null;
		try {
			entityManagerFactory = HibernateUtil.getEntityManagerFactory();
			em = entityManagerFactory.createEntityManager();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		StudentDao studentDao = new StudentDaoJpaImpl(em);
		StudentGroupDao groupDao = new StudentGroupDaoJpaImpl(em);

		/*
		 * Aanmaken van de domein objecten
		 */
		StudentGroup group = new StudentGroup();
		group.setCode("TICT-SIE-V2A-17");
		
		group.addStudent(new Student("Joost", getNum(), "joost@hu.nl", group));
		group.addStudent(new Student("Rik", getNum(), "rik@hu.nl", group));
		group.addStudent(new Student("Jeroen", getNum(), "jeroen@hu.nl", group));
		group.addStudent(new Student("Berend", getNum(), "berend@hu.nl", group));

		/*
		 * Opslaan van de data in de domein objecten
		 * Wie is verantwoordelijk voor het opslaan van de studenten binnen de groep?
		 */
		StudentGroup group1 = new StudentGroup();
		em.getTransaction().begin();
		group1.setCode("TICT-SIE-V2A-17");
		groupDao.insert(group);
		for (Student student : group.getStudents()){
			studentDao.insert(student);
		}
		em.getTransaction().commit();
		System.out.println("-- midden --");
		List<StudentGroup> studentGroups = groupDao.getAll();
		for (StudentGroup sg: studentGroups) {
			System.out.println("StudentGroup: "+sg);
			for (Student s: sg.getStudents()) {
				System.out.println("Student: "+s);
			}
		}
		em.close();
		System.out.println("-- einde --");
	}
}
