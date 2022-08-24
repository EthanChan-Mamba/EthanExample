package com.chen.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Demeter1.java
 * @Description TODO
 * @createTime 2022-04-19 13:28
 */
public class Demeter1 {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

class Employee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class CollegeManager{
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> collegeEmployees = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee collegeEmployee = new CollegeEmployee();
            collegeEmployee.setId("i");
            collegeEmployees.add(collegeEmployee);
        }
        return collegeEmployees;
    }

    public void printEmployee() {
        List<CollegeEmployee> allEmployee = this.getAllEmployee();
        for (CollegeEmployee e : allEmployee
        ) {
            System.out.println(e.getId());
        }
    }
}

// 直接朋友：Employee、CollegeManager
// 不是直接朋友：CollegeEmployee是局部变量，违反了demeter法则
class SchoolManager{
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<Employee>();
        for (int i = 0; i < 5; i++) {
            Employee employee = new Employee();
            employee.setId("i");
            employees.add(employee);
        }
        return employees;
    }

    // 将输出学院的方法，封装到CollegeManager
    void printAllEmployee(CollegeManager sub) {
        sub.printEmployee();

        List<Employee> allEmployee1 = this.getAllEmployee();
        for (Employee e :
                allEmployee1) {
            System.out.println(e.getId());
        }
    }
}
