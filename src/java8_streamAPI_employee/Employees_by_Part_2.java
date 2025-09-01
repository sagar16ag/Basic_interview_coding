package java8_streamAPI_employee;

import java.util.*;
import java.util.stream.Collectors;

public class Employees_by_Part_2 {

    public static void main(String[] args) {

        List<employee_entity> empList = new list_of_Employee_object().empList;

        // Find oldest employee by age

        Optional<employee_entity> maxageofemp =empList.stream().max(Comparator.comparing(employee_entity::getAge));
        System.out.println("Max age of employee is : " + maxageofemp.get());

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Find longest serving employees in the organization.

        Optional<employee_entity> seniorEmp = empList.stream().sorted(Comparator
                .comparingInt(employee_entity::getYearOfJoining)).findFirst();
        System.out.println("Longest-serving employee: " + seniorEmp.get());

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Find longest serving employee in each department

        empList.stream().collect(Collectors.groupingBy(employee_entity::getDeptName,
                        Collectors.minBy(Comparator.comparing(employee_entity::getYearOfJoining))))
                .forEach((dept, empOpt) -> empOpt.
                        ifPresent(emp -> System.out.println(dept + " -> " + emp.getName()
                                + " (DOJ: " + emp.getYearOfJoining() + ")")));


        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Find youngest serving employee in each department

        empList.stream().collect(Collectors.groupingBy(employee_entity::getDeptName,
                Collectors.maxBy(Comparator.comparing(employee_entity::getYearOfJoining))))
                .forEach((dept, empOpt) -> empOpt
                        .ifPresent(emp -> System.out.println(dept + " -> " + emp.getName()
                                + " (DOJ: " + emp.getYearOfJoining() + ")")));

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Find the youngest female employee.

        Optional<employee_entity> youngestfemaleEmp = empList.stream().filter(e -> e.getGender() == "F")
                .min(Comparator.comparing(employee_entity::getAge));
        System.out.println("Youngest Female employee details:: " + youngestfemaleEmp.get());

        // Find the youngest male employee.

        Optional<employee_entity> youngestmaleEmp = empList.stream().filter(e -> e.getGender() == "M")
                .min(Comparator.comparing(employee_entity::getAge));
        System.out.println("Youngest Male employee details:: " + youngestmaleEmp.get());

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Find employees whose age is greater than 30 and less than 30.

        Map<Boolean, List<employee_entity>> partitionEmployeesByAge = empList.stream().collect(Collectors.partitioningBy(e->e.getAge() > 30));
        Set<Map.Entry<Boolean, List<employee_entity>>> empSet = partitionEmployeesByAge.entrySet();
        System.out.println(empSet);
        System.out.println("////////////////////////////////////////////////////////");

        for (Map.Entry<Boolean, List<employee_entity>> entry : empSet) {
            if (Boolean.TRUE.equals(entry.getKey())) {
                System.out.println("Employees greater than 30 years ::" + entry.getValue());
            } else {
                System.out.println("Employees less than 30 years ::" + entry.getValue());
            }
        }

        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");

        // Find the department name which has the highest number of employees.
        Optional<Map.Entry<String, Long>> maxNoOfEmployeesInDept  = empList.stream()
                .collect(Collectors.groupingBy(employee_entity::getDeptName, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        System.out.println("Department with the highest number of employees: " + maxNoOfEmployeesInDept.get());

    }

}
