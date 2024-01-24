package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee implements Comparable<Employee> {
    private Integer empId;
    private String name;
    private Integer salary;

    public Employee(Integer empId, String name, Integer salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee emp) {
        // Handle null values for names
        if (this.name == null && emp.name == null) {
            return 0;
        } else if (this.name == null) {
            return -1;
        } else if (emp.name == null) {
            return 1;
        }
        return this.name.compareTo(emp.name);
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(8, "Raju", 5000));
        empList.add(new Employee(2, "Ramu", 7000));
        empList.add(new Employee(7, "Rani", 3000));
        empList.add(new Employee(3, null, 1000));

        System.out.println("Original list:");
        displayEmployeeList(empList);

        // Sorting in ascending order based on employee ID
        Collections.sort(empList);
        System.out.println("\nSorted by Employee ID (ascending):");
        displayEmployeeList(empList);

        // Sorting in ascending order based on employee name (handling null values)
        Collections.sort(empList, Comparator.comparing(Employee::getName, Comparator.nullsFirst(String::compareTo)));
        System.out.println("\nSorted by Employee Name (ascending with nulls first):");
        displayEmployeeList(empList);

        // Sorting in ascending order based on employee salary
        Collections.sort(empList, Comparator.comparing(Employee::getSalary));
        System.out.println("\nSorted by Employee Salary (ascending):");
        displayEmployeeList(empList);
    }

    private static void displayEmployeeList(List<Employee> empList) {
        for (Employee emp : empList) {
            System.out.println(emp.getEmpId() + " " + emp.getName() + " " + emp.getSalary());
        }
    }
}
