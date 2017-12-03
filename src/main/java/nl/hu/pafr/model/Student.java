package nl.hu.pafr.model;

public class Student {
	private int id;
	private String number;
	private String name;
	private String email;

	public Student() {
	};

	public Student(int id, String name, String number, String email) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", number=" + number + ", name=" + name+ ", email=" + email + "]";
	}

}