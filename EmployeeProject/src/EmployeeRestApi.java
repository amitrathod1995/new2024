
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeRestApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee(1, "Mayur", "Pune", 89484, 26, 60000, "male", "Sales");
		Employee emp2 = new Employee(2, "Rakhi", "Mumbai", 45454, 21, 45000, "female", "IT");
		Employee emp3 = new Employee(3, "Punit", "Nashik", 32323, 30, 78000, "male", "Banking");
		Employee emp4 = new Employee(4, "Ram", "Banglore", 34343, 43, 80000, "male", "Production");
		Employee emp5 = new Employee(5, "John", "Pune", 45454, 35, 100000, "male", "Sales");

		List<Employee> list = Arrays.asList(emp1, emp2, emp3, emp4, emp5);
		 
	
		//	increase salary of each employee by 1000
		//List<Double> updatedSalaries =list.stream().map(employee->employee.getSalary()+1000).collect(Collectors.toList());
		//System.out.println(updatedSalaries);	
	//	output:-[61000.0, 46000.0, 79000.0, 81000.0, 101000.0]
		
	
		//list.stream() .filter(employee -> employee.getAge() < 22).map(Employee::getName).forEach(System.out::println);  
		//	 Output:-Rakhi
			   
		//list.stream() .filter(employee -> employee.getAge() > 20).map(Employee::getName).forEach(System.out::println); 
//		 Output:-Mayur
//		         Rakhi
//		         Punit
//		         Ram
//		         John
//			        
			                   		    
		//Sort employees by name
		//List<Employee>sortemp=list.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
		//sortemp.forEach(System.out::println);
		
		//sort the list by name
	     //List<Employee> empname=list.stream().sorted((l1,l2)->l1.getName().compareTo(l2.getName())).collect(Collectors.toList());
	     //empname.forEach(System.out::println);
		
		//sort employee by age
		//List<Employee> empbyage= list.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).collect(Collectors.toList());
		//empbyage.forEach(System.out::println);
		
		//sort employee by salary
		//List<Employee> sortempbysalary=list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());
		//sortempbysalary.forEach(System.out::println);
		
		
		
		//count length of each name from list
		//Map<String, Long> name = list.stream().collect(Collectors.toMap(Employee::getName, emp -> (long) emp.getName().length()));         
		//System.out.println(name);
		//output:-{Mayur=5, John=4, Punit=5, Rakhi=5, Ram=3}

		
		//Group employees by city
		//Map<String,List<Employee>>li=list.stream().collect(Collectors.groupingBy(Employee:: getCity));
		//System.out.println(li);
		//li.forEach((key,value)->System.out.println(key+"="+value));
				 
		
		//Find employee from pune
		
		  //list.stream().filter(emp->emp.getCity().equals("Pune")).map(Employee::
		 // getName) .forEach(System.out::println);
		 

	     //Find the highest salary of employee
		 //list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(emp->emp.getName()).limit(1).forEach(System.out::println);
		  //output:-Employee [id=5, name=John, city=Pune, mobno=45454, age=35, salary=100000.0, gender=male, department=Sales]
		
		
		// Find second highest salary of employee
//		Optional<Employee> li = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1)
//				.findFirst();
//
//		System.out.println(li);

		// Find no of genders in company
		/*
		 * Map<String,Long>map=
		 * list.stream().collect(Collectors.groupingBy(Employee::getGender,
		 * Collectors.counting())); System.out.println(map);
		 */

    //Print name of all departments in the organization

		// list.stream().map(name->name.getDepartment()).collect(Collectors.toList())
		//.forEach(System.out::println);

		
		/*
		 * //Average age of male and female in the company
		 * 
		 * Map<String, Double> collect =
		 * list.stream().collect(Collectors.groupingBy(Employee::getGender,
		 * Collectors.averagingInt(Employee::getAge)));
		 * 
		 * System.out.println(collect); //{female=21.0, male=33.5}
		 */

		
		// Get the details of highest paid employee in the organization

		/*
		 * Object collect2 =
		 * list.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::
		 * getSalary)));
		 * 
		 * System.out.println(collect2); //Optional[Employee [id=5, name=John,
		 * city=Pune, mobno=45454, age=35, salary=100000.0, gender=male,
		 * department=Sales]]
		 * 
		 * Object collect =
		 * list.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::
		 * getSalary))).get().getName();
		 * 
		 * 
		 * System.out.println(collect); //John
		 */
		
		
	 // Count the number of employees in each department
//		Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Employee:: getDepartment, Collectors.counting()));
//		
//		System.out.println(collect); //{Sales=2, Production=1, Banking=1, IT=1}

		// what is the average salary of each department

		/*
		 * Map<String, Double> collect =
		 * list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
		 * Collectors.averagingDouble(Employee::getSalary)));
		 * 
		 * System.out.println(collect); //{Sales=80000.0, Production=80000.0,
		 * Banking=78000.0, IT=45000.0}
		 */

		// Get the details of youngest male employee from sales department

//		Optional<Employee> min = list.stream().filter(e -> e.getGender().equalsIgnoreCase("male") && e.getDepartment().equalsIgnoreCase("sales"))
//				.min(Comparator.comparingInt(Employee::getAge)); //

//		System.out.println(min); // Optional[Employee [id=1, name=Mayur, city=Pune, mobno=89484, age=26,
//									// salary=60000.0, gender=male, department=Sales]]

		
		  //Highest salary of employee
		  
		//  Optional<Employee> first =
		//list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst(); 
		//System.out.println(first); //Optional[Employee [id=5,name=John, city=Pune, mobno=45454, age=35, salary=100000.0, gender=male, department=Sales]]
		 

//		// Lowest salary of employee
//
		//Optional<Employee> first = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary))
		//		.findFirst();
		//System.out.println(first); //Optional[Employee [id=2, name=Rakhi, city=Mumbai, mobno=45454, age=21, salary=45000.0, gender=female, department=IT]]
		
		
		
		//Find employee by name
		//list.stream().filter(name->name.getName().equals("Punit")).forEach(System.out::println);
//		Optional<Employee> name = list.stream().filter(e->e.getName().equalsIgnoreCase("ss")).findAny();
//		if(name.isPresent()) {
//			System.out.println(name);
//		}
//		else {
//			System.out.println("Record not found with this name");
//		} //Record not found with this name
		
		
		
		
		
		
		//Find employees from banking department
		//List<String> collect = list.stream().filter(emp->emp.getDepartment().equals("Banking")).map(emp->emp.getName()).collect(Collectors.toList());
		//System.out.println(collect);
		
		
		
		//Find employees whose name starts with"R"		
	     //List<String>count=
		//list.stream().filter(emp->emp.getName().startsWith("R")).map(emp->emp.getName()).collect(Collectors.toList()).forEach(a->System.out.println(a));
	     //System.out.println(count);
		
	     
	 
		//Find employees whose name  not starts with"R"			
	    // List<Employee>count=list.stream().filter(emp->!emp.getName().startsWith("R")).map(emp->emp.getName()).collect(Collectors.toList());     
	    // System.out.println(count);
	     
	  
	     
		//Find the employees whose salary is less then 50k and add 5 thousand into it
		
//		List<Employee> max = 
//				list.stream().filter(salary->salary.getSalary()<50000).peek(employee->employee.setSalary(employee.getSalary()+5000))
//				.collect(Collectors.toList());
//		System.out.println(max);

	  
		//Change emloyee city from Pune to Nashik
//		 list.stream().filter(city->city.getCity().equals("Pune")).forEach(city->city.setCity("Nashik"));
//		 
		 //list.forEach(obj->{System.out.println(obj); });
	 
		
	
		//check the city of punit from pune to nasik
		
//		 list = list.stream()
//	                .map(employee -> {
//	                    if ("Punit".equals(employee.getName())) {
//	                        employee.setCity("Pune");
//	                    }
//	                    return employee;
//	                })
//	                .toList();
//	    list.forEach(employee -> System.out.println(employee.getName() + ": " + employee.getCity()));
		
		 
	
		//Find employee by name
	    //	list.stream().filter(name->name.getName().equalsIgnoreCase("Mayur")).forEach(name->System.out.println(name));
		
	
		//find the employee whose age is maximum and salary is sell?
		//Optional<Employee>employee=list.stream()
//				 .filter(e->e.getAge()==list.stream()
//			 .max(Comparator.comparingInt(Employee::getAge)).get().getAge())
//				 .min(Comparator.comparingDouble(Employee::getSalary));
	}

}