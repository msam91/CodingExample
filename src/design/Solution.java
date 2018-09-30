package design;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class named Solution.
 * 
 * If you need more classes, simply define them inline.
 */

/**
 * Goal is to create a in-memory data store For an Organization.
 * 
 * 1. Organization consists of Employee, Manager, Department 2. Each Employee
 * belongs to one Department and reports to one Manager 3. Employee and Manager
 * may not be from the same department 4. Employee has attributes name, age,
 * salary, manager, department 5. Manager has attributes list of direct reports,
 * name, age, salary, department 6. Execute queries on the Data Store created
 * above
 **/

class Solution {
    public static void main(String[] args) {
        Organization OrgDS = new Organization();

        Department Engineer = OrgDS.addDepartment("Engineering Department");
        Department SWTesting = OrgDS.addDepartment("Software Testing");
        Department HWTesting = OrgDS.addDepartment("Hardware  Testing");

        Manager Manager1 = OrgDS.addManager("Manager1", Engineer, 25, 120040); //
        Manager Manager2 = OrgDS.addManager("Manager2", SWTesting, 29, 120500);
        Manager Manager3 = OrgDS.addManager("Manager3", SWTesting, 27, 110000);

        OrgDS.addEmployee("Employee1", Engineer, Manager1, 29, 80672); //
        OrgDS.addEmployee("Employee2", Engineer, Manager2, 23, 70224);
        OrgDS.addEmployee("Employee3", HWTesting, Manager3, 22, 60534);
        OrgDS.addEmployee("Employee4", HWTesting, Manager3, 22, 40234);
        OrgDS.addEmployee("Employee5", Engineer, Manager2, 24, 60234);
        OrgDS.addEmployee("Employee6", SWTesting, Manager1, 25, 90234); //
        OrgDS.addEmployee("Employee7", HWTesting, Manager3, 28, 70234);

        System.out.println("Employees by Department");

        List<Employee> employeesByDept = OrgDS.findEmployeeByDepartmentName("software testing");

        for (Employee e : employeesByDept) {
            System.out.println(e.name);
        }

        System.out.println("Employees by Salary and Manager");
        List<Employee> employeesBySalary =
                OrgDS.findEmployeeByManagerAndSalaryGreaterThan(Manager1, 90000);

        for (Employee e : employeesBySalary) {
            System.out.println(e.name +
                    " -- " + e.salary);
        }

    }
}

class Employee {

    public UUID id;
    public String name;
    public int age;
    public int salary;
    public Manager manager;
    public Department department;

    public Employee(UUID id, String name, Department d, Manager manager, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.manager = manager;
        this.department = d;
    }

}

class Manager {
    public UUID id;
    public String name;
    public int age;
    public int salary;
    public Department department;

    public Manager(UUID id, String name, Department department, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

}

class Department {
    public String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName.toLowerCase();
    }

}

class Organization {

    Map<String, List<Employee>> departmentMap = new HashMap<String, List<Employee>>();
    Map<String, List<Employee>> managerMap = new HashMap<String, List<Employee>>();

    public Department addDepartment(String departmentName) {
        Department d = new Department(departmentName);
        return d;
    }

    public Manager addManager(String name, Department d, int age, int salary) {
        UUID id = UUID.randomUUID();
        Manager m = new Manager(id, name, d, age, salary);
        return m;
    }

    public void addEmployee(String name, Department d, Manager manager, int age, int salary) {
        UUID id = UUID.randomUUID();
        Employee employee = new Employee(id, name, d, manager, age, salary);
        constructDepartmentMap(employee, d);
        constructManagerMap(employee, manager);
    }

    public void constructDepartmentMap(Employee employee, Department d) {
        List<Employee> employeeList = null;
        if (departmentMap.containsKey(d.departmentName)) {
            employeeList = departmentMap.get(d.departmentName);
        }
        else {
            employeeList = new ArrayList<Employee>();
        }
        employeeList.add(employee);
        departmentMap.put(d.departmentName, employeeList);
    }

    public void constructManagerMap(Employee employee, Manager manager) {
        List<Employee> employeeList = null;
        if (managerMap.containsKey(manager.id.toString())) {
            employeeList = managerMap.get(manager.id.toString());
        }
        else {
            employeeList = new ArrayList<Employee>();
        }
        employeeList.add(employee);
        managerMap.put(manager.id.toString(), employeeList);
    }

    public List<Employee> findEmployeeByDepartmentName(String departmentName) {
        if (!departmentMap.containsKey(departmentName)) {
            return Collections.EMPTY_LIST;
        }
        return departmentMap.get(departmentName);
    }

    public List<Employee> findEmployeeByManagerAndSalaryGreaterThan(Manager m1, int salary) {

        if (!managerMap.containsKey(m1.id.toString())) {
            return Collections.EMPTY_LIST;
        }
        else {
            List<Employee> empList = managerMap.get(m1.id.toString());
            for (Employee e : empList) {
                if (e.salary < salary) {
                    empList.remove(e);
                }

            }
            return empList;
        }
    }
}
