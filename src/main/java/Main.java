import java.util.List;
import java.util.Random;

import pafr.dao.StudentDao;
import pafr.dao.StudentGroupDao;
import pafr.dao.memory.DataStore;
import pafr.dao.memory.StudentDaoImpl;
import pafr.dao.memory.StudentGroupDaoImpl;
import pafr.model.Student;
import pafr.model.StudentGroup;

public class Main {

	private static int getNum(){
		return new Random().nextInt(9000) + 1000;
	}
	
	public static void main(String[] args) {
		DataStore dataStore = new DataStore();
		StudentDao studentDao = new StudentDaoImpl(dataStore);
		StudentGroupDao groupDao = new StudentGroupDaoImpl(dataStore);
		StudentGroup group = new StudentGroup(getNum(),"TICT-SIE-V2A-17");
		group.addStudent(new Student(getNum(), "Joost", "1638483", group));
		group.addStudent(new Student(getNum(), "Ellen", "1600234", group));
		group.addStudent(new Student(getNum(), "Jeroen", "1649323", group));
		group.addStudent(new Student(getNum(), "Berend", "1737273", group));
		
		groupDao.insert(group);
		
		List<StudentGroup> groups = groupDao.getAll();
		for (StudentGroup g : groups) {
			System.out.println("StudentGroups 1: "+g);
			StudentGroup g1 = groupDao.get(g.getId());
			System.out.println("StudentGroups 2: "+g1);
		}
		StudentGroup group1 = groupDao.getGroupByCode("TICT-SIE-V2A-17");
		System.out.println("StudentGroups 3: "+group1);
		Student student1  = studentDao.getStudentByNumber("1737273");
		System.out.println("Student: "+ student1);
	}
}
