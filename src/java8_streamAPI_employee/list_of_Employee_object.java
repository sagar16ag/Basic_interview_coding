package java8_streamAPI_employee;

import java.util.ArrayList;
import java.util.List;

public class list_of_Employee_object {

    List<employee_entity> empList = new ArrayList<>();

    public list_of_Employee_object() {
        empList.add(new employee_entity(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new employee_entity(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new employee_entity(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new employee_entity(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));
        empList.add(new employee_entity(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new employee_entity(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new employee_entity(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new employee_entity(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new employee_entity(9, "Ram", 25, 160, "M", "IT", "Blore", 2010));
        empList.add(new employee_entity(10, "binnu", 25, 160, "M", "IT", "Blore", 2010));
    }
}

