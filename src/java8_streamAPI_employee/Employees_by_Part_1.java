package java8_streamAPI_employee;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Employees_by_Part_1 {

    public static void main(String[] args) {

        List<employee_entity> empList = new list_of_Employee_object().empList;

        // Group the Employees by city.

        Map<String, List<employee_entity>> empByCity = empList.stream().collect(Collectors.groupingBy(employee_entity::getCity));
        empByCity.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Group the Employees by age.

        Map<Integer, List<employee_entity>> empByAge = empList.stream().collect(Collectors.groupingBy(employee_entity::getAge));
        empByAge.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Find the count of male and female employees present in the organization.

        Map<String,Long> noOfMaleAndFemaleEmployees = empList.stream().collect(Collectors.groupingBy(employee_entity::getGender, Collectors.counting()));
        noOfMaleAndFemaleEmployees.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Group the Employees by dept.

        Map<String, List<employee_entity>> empbydept = empList.stream().collect(Collectors.groupingBy(employee_entity::getDeptName));
        empbydept.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // "ONLY" Print the names of all departments in the organization.

        empList.stream().map(employee_entity::getDeptName).distinct().forEach(System.out::println);

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Print employee details whose age is greater than 28

        Map<Integer, List<employee_entity>> agegraterthan28 = empList.stream().filter(e -> e.getAge() > 28)
                .collect(Collectors.groupingBy(employee_entity::getAge));
        agegraterthan28.forEach((k,v) -> System.out.println(k+ " : " +v));

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Find maximum age of employee.

        OptionalInt maxage = empList.stream().mapToInt(employee_entity::getAge).max();
        System.out.println(maxage.getAsInt());

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Print Average age of Male and Female Employees.

        Map<String, Double> avgAge = empList.stream().collect(Collectors.groupingBy
                (employee_entity::getGender,Collectors.averagingInt(
                        employee_entity::getAge)));
        avgAge.forEach((k,v) -> System.out.println(k+ " : " +v));

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Print the number of employees in each department.

        Map<String,Long> pp = empList.stream().collect(Collectors.groupingBy(employee_entity::getDeptName, Collectors.counting()));
        pp.forEach((k,v) -> System.out.println(k+ " : " +v));
    }
}
