package Apple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
class OrganizationStruct {
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

    class Organization {

        Map<String, List<Employee>> depMap = new HashMap<String, List<Employee>>();
        Map<String, List<Employee>> mMap = new HashMap<String, List<Employee>>();

        public Department addDepartment(String depName) {
            Department d = new Department(depName);
            return d;
        }

        public Manager addManager(String managerName, Department d, int age, int salary) {
            Manager m = new Manager(managerName, d, age, salary);
            return m;
        }

        public void addEmployee(String eName, Department d, Manager m, int age, int salary) {
            Employee e = new Employee(eName, d, m, age, salary);
            constructDeptMap(d.depName.toLowerCase(), e);
            constructManagerMap(m.id, e);

        }

        public void constructDeptMap(String depName, Employee e) {
            List<Employee> empList = null;
            if (depMap.containsKey(depName)) {
                empList = depMap.get(depName);
            }
            else {
                empList = new ArrayList<Employee>();
            }
            empList.add(e);
            depMap.put(depName, empList);

        }

        public void constructManagerMap(String id, Employee e) {
            List<Employee> empList = null;
            if (mMap.containsKey(id)) {
                empList = mMap.get(id);
            }
            else {
                empList = new ArrayList<Employee>();
            }
            empList.add(e);
            mMap.put(id, empList);

        }

        public List<Employee> findEmployeeByDepartmentName(String depName) {
            if (depMap.containsKey(depName)) {
                return depMap.get(depName);
            }

            return Collections.EMPTY_LIST;
        }

        public List<Employee> findEmployeeByManagerAndSalaryGreaterThan(Manager m, int salary) {
            List<Employee> eList = null;
            if (mMap.containsKey(m.id)) {
                eList = mMap.get(m.id);
                for (Employee e : eList) {
                    if (e.salary < 90000) {
                        eList.remove(e);
                    }
                }
                return eList;
            }

            return Collections.EMPTY_LIST;
        }

    }

    class Department {
        public String depName;

        public Department(String depName) {
            this.depName = depName;
        }
    }

    class Manager {
        public String managerName;
        public Department d;
        public int age;
        public int salary;
        public String id;

        public Manager(String managerName, Department d, int age, int salary) {
            this.managerName = managerName;
            this.d = d;
            this.age = age;
            this.salary = salary;
            this.id = UUID.randomUUID().toString();
        }
    }

    class Employee {
        public String name;
        public Department d;
        public Manager m;
        public int age;
        public int salary;

        public Employee(String eName, Department d, Manager m, int age, int salary) {
            this.name = eName;
            this.d = d;
            this.m = m;
            this.age = age;
            this.salary = salary;
        }
    }


