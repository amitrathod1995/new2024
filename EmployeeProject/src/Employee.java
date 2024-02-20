
public class Employee {
 
	private int id;
    private String name;
    private String city;
    private long mobno;
    private int age;
    private double salary;
    private String gender;
    private String department;
	 
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getMobno() {
		return mobno;
	}
	public void setMobno(long mobno) {
		this.mobno = mobno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, String city, long mobno, int age, double salary, String gender,
			String department) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.mobno = mobno;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + ", mobno=" + mobno + ", age=" + age
				+ ", salary=" + salary + ", gender=" + gender + ", department=" + department + "]";
	}
	
 }

