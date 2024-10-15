package stream;

import compare.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alex");
        //Filter and collect names starting with a specific letter
        List<String> finalList =names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        System.out.println(finalList);

        List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> finIntegers = integers.stream().filter(num -> num%2==0).findFirst();
//        System.out.println(finIntegers.orElse(-1));

        names.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());

        //find sum
        integers.stream().mapToInt(Integer::intValue).sum();

        //5. Group a list of strings by their length
        Map<Integer,List<String>> map = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);


        //count occurance of each word
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");

        Map<String, Long> wordCount = words.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


        //Flatten a list of lists into a single list
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        List<Integer> finalListign = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());



       // Task: Use Stream API to find the maximum value in the list.
        List<Integer> numbers = Arrays.asList(10, 20, 30, 5, 15);

        Optional<Integer> maxValue = numbers.stream()
                .max(Comparator.naturalOrder());

        System.out.println(maxValue.orElse(-1));  // Output: 30



        // Task: Use Stream API to check if all numbers are even.
        List<Integer> nums = Arrays.asList(2, 4, 6, 8, 10);

        boolean allEven = nums.stream()
                .allMatch(num -> num % 2 == 0);

        System.out.println(allEven);  // Output: true



//        //1. Filter employees with salary greater than 50,000 and group by department
//        List<Employee> employees = Arrays.asList(
//                new Employee( "John", "HR", 35, 60000),
//                new Employee( "Sarah", "IT", 28, 50000),
//                new Employee( "Mike", "IT", 25, 55000),
//                new Employee( "Anna", "Finance", 30, 40000),
//                new Employee( "Tom", "Finance", 45, 70000)
//        );

//        Map<Department,List<Employee>> employeeList = employees.stream().filter(employee -> employee.getSalary()>50000)
//                .collect(Collectors.groupingBy(Employee::getDepartment));
//
//        employeeList.forEach((dept,emps) -> {
//            System.out.println(dept + ":" + emps.stream().map(employee -> employee.getName()).collect(Collectors.toList()));
//        });



//        //Filter employees in the "IT" department and group by salary range (above and below 55,000)
//        Map<String,List<Employee>> employeeList = employees.stream().filter(employee -> employee.getDepartMent().equals("IT"))
//                .collect(Collectors.groupingBy(employee -> employee.getSalary()>50000 ? "Above 55K":"Below 55k"));
//
//
//        //Group employees by department and count the number of employees in each department
//        Map<String, Long> result = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));




    }
}
