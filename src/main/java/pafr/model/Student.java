package pafr.model;

public class Student {
	private int id;
	private String number;
	private String name;
	private String email;
	private StudentGroup studentGroup;
	public Student(){};
	public Student(int id, String name, String number, StudentGroup studentGroup) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.setStudentGroup(studentGroup);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StudentGroup getStudentGroup() {
		return studentGroup;
	}
	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", number=" + number + ", name=" + name + "]";
	}

}