package java8_streamAPI_employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
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
    }

}
