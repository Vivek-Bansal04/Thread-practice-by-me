package compare;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        Employee a = new Employee("hari", 20000);
        Employee b = new Employee("vivek", 10000);
        Employee c = new Employee("nakul", 30000);
        Employee d = new Employee("raman", 50000);

        Child e = new Child("hari", 20000);
        Child h = new Child("vivek", 10000);
        Child g = new Child("nakul", 30000);
        Child f = new Child("raman", 50000);
        List<Employee> employees = List.of(a,b,c,d);
        List<Child> child = List.of(e,f,g,h);
        Collections.sort(child,new EmployeeComparator());

        employees.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));

        employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary))
                .forEach(System.out::println);
    }
}


